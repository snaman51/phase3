package com.phase3.StockExch;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@CrossOrigin
@RestController
@Transactional
@RequestMapping("/")
public class Maincontroller {
	@Autowired
	Companyrepository cmprep;
	@Autowired
	Stockrepository stkrep;
	@Autowired
	Companystockexchangemaprepository stkcmpmaprep;
	@Autowired
	EntityManager em;
	@Autowired
	IPODetailRepository iporep;
	@Autowired
	Stockpricerepository stkpricerepo;
	@Autowired
	Userrepository userrep;

	@RequestMapping(value = "/company", method = RequestMethod.POST,consumes="application/json")
	public ResponseEntity<Object> createcompany(@RequestBody Company cmp) {
//input with be json properties 
		cmprep.save(cmp);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cmp.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	
	
	@RequestMapping(value = "/mapcompanycode/{cmpname}/{exchname}", method = RequestMethod.POST)
	public void stockexchangecompanymap(@PathVariable String cmpname,@PathVariable String exchname)
	{
		Company c=cmprep.findBycompanyName(cmpname);
		Stockexchange s = stkrep.findByName(exchname);
		Companystockexchangemap sc=new Companystockexchangemap();
		sc.setCompany(c);
		sc.setStockexchange(s);
//		sc.CompanyCode();
		stkcmpmaprep.save(sc);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/login/{email}", method = RequestMethod.GET)
	public User1 login(@PathVariable String email)
	{
		User1 u=userrep.findByemail(email);
		return u;
	}
	
//	@RequestMapping(value = "/mapcompanycode", method = RequestMethod.POST)
////	 pass map of string in requestbody ,instead of pojo class to get
////	 non entity based params
////This method maps company to stockmarket	
//public String mapcode(@RequestBody Map<String, String> text) {
//		System.out.println("params100" + text.get("companyname"));
//		Query query = em.createNamedQuery("Company.findByname");
//		query.setParameter("name", text.get("companyname"));
//		Company c = (Company) query.getSingleResult();
//
//		Stockexchange e = stkrep.findByName(text.get("exchangename"));
//		Companystockexchangemap cse = new Companystockexchangemap();
//		cse.setCompany(c);
//		cse.setStockexchange(e);
//		stkcmpmaprep.save(cse);
//		return "Test";
//		// return companyname;
//	}
	
	
       // show all  records from companystockexchangemap entity
	
//	@RequestMapping(value = "/listall", method = RequestMethod.GET)	
//	public String listit() {
//		
//		String x = "";
//		List<Companystockexchangemap> csem = stkcmpmaprep.findAll();
//		for (Companystockexchangemap c:csem)  {
//		Optional<Stockexchange> s =	stkrep.findById(c.getStockexchange().getId()); 
//		Optional<Company> cc =cmprep.findById(c.getCompany().getId());
//			x= x + "   "+cc.get().getCompanyName() + "   "+s.get().getName(); //getcompany code can be added here
//		}
//		
//		return x;
//		// return companyname;
//	}
	
	@RequestMapping(value = "/listall", method = RequestMethod.GET, headers = "Accept=application/json" )	
	public List<Companystockexchangemap> listit() {
		
		List<Companystockexchangemap> csem = stkcmpmaprep.findAll();
		

		return csem;
	}
	
	
	
	
	@RequestMapping(value = "/company/{cmpname}", method = RequestMethod.GET)	
	public Company listit(@PathVariable String cmpname) {
		
		String x = "";
		Company c = cmprep.findBycompanyName(cmpname);
		
		
		return c;
	}
	
	
	
	
	@GetMapping("/test")
	public String test() {
		return "HI";
	}
	
	@RequestMapping(value = "/createexch", method = RequestMethod.POST)
    public Stockexchange createexch(@RequestBody Stockexchange stk) {
        Stockexchange s = new Stockexchange();
        s.setName(stk.getName());
        return stkrep.save(s);
	}
        
        
	@RequestMapping(value = "/createipo", method = RequestMethod.POST)
    public IPODetail createipo(@RequestBody IPODetail ipod) {
//        IPODetail ipo = new IPODetail();
//        ipod.setCompanyName(ipod.getCompanyName());
//        ipod.setCompany(cmprep.findBycompanyName(ipod.getCompanyName()));
        return iporep.save(ipod);
	}        
	
	@RequestMapping(value = "/createipolist", method = RequestMethod.POST)
    public String createipolist(@RequestBody List<IPODetail> ipod) {
		for(IPODetail ipo:ipod) {
//        IPODetail ipo = new IPODetail();
//        ipo.setCompanyName(ipo.getCompanyName());
			System.out.println("---------------"+ipo.getExchName());
//			Company c2;
//			c2=ipo.getCompany();
//			System.out.println("@@@@@@@@@@@@@@@@@@"+cmprep.findById(c2.getId()).get());
			ipo.setCompany(cmprep.findById(ipo.getCompanyCode()).get());
			iporep.save(ipo);
		}
        return "Successful";
	}
	
	
	@RequestMapping(value = "/addstockprices",method=RequestMethod.POST, headers = "Accept=application/json" )
	public  ResponseEntity<Object> stockpriceapi(@RequestBody StockPrice stockprice) throws ClassNotFoundException, IOException {
		
	    StockPrice stkprice= stkpricerepo.save(stockprice);
	   // make sure your entity class properties of price are in lower case and match the json,to avoid errors
	    System.out.println(stkprice +"check this " +stkprice.getCompanycode());

	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stkprice.getId())
	            .toUri();
	    
	    return ResponseEntity.created(location).build();
	}

	 

	@RequestMapping(value = "/getstockprices",method=RequestMethod.GET, headers = "Accept=application/json"  )
	public List<StockPrice> getstockprice() throws ClassNotFoundException, IOException {

	    List<StockPrice> stkprice= stkpricerepo.findAll();
	   // make sure your entity class properties of user are in lower case and match the json,to avoid errors
	    return stkprice;
	}
	
	@RequestMapping(value = "/getipos",method=RequestMethod.GET, headers = "Accept=application/json"  )
	public List<IPODetail> getipos() throws ClassNotFoundException, IOException {

	    List<IPODetail> stkprice= iporep.findAll();
	   // make sure your entity class properties of user are in lower case and match the json,to avoid errors
	    return stkprice;
	}
	
	@RequestMapping(value = "/getipo/{cmpID}",method=RequestMethod.GET, headers = "Accept=application/json"  )
	public List<IPODetail> getipos(@PathVariable Long cmpID) throws ClassNotFoundException, IOException {

	    List<IPODetail> stkprice= iporep.findByCompanyCode(cmpID);
	   // make sure your entity class properties of user are in lower case and match the json,to avoid errors
	    return stkprice;
	}

	
	
	
}
