package com.spring.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dao.TestBean;
import com.spring.helper.HelperImpl;
import com.spring.helper.TimeHelper;
import com.spring.model.Agesex;
import com.spring.model.Order;
import com.spring.model.Orderdetail;
import com.spring.model.Product;
import com.spring.model.Producttype;
import com.spring.model.Rating;
import com.spring.model.Role;
import com.spring.model.User;
import com.spring.service.AgesexService;
import com.spring.service.MailService;
import com.spring.service.OrderDetailService;
import com.spring.service.OrderService;
import com.spring.service.ProductService;
import com.spring.service.ProducttypeService;
import com.spring.service.RatingService;
import com.spring.service.RoleService;
import com.spring.service.UserService;

@Controller
public class TestController {

	@Autowired
	private TestBean testBean;

	@Autowired
	private HelperImpl helperImpl;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProducttypeService producttypeService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AgesexService agesexService;

	@Autowired
	private OrderDetailService orderdetailService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private RatingService ratingService;

	@Autowired
	private TimeHelper timeHelper;

	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	/* @ResponseBody */
	public String test(ModelMap model) {
		/*
		 * System.out.println(this.productService.getNumberOfRecordsOfProduct())
		 * ;
		 */
		/*
		 * System.out.println(this.productService.getProductListByProductTypeId(
		 * 1));
		 */

		/*
		 * ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		 * System.out.println(productDAOImpl.getNumberOfRecordsOfProduct());
		 */

		/*
		 * userService.saveUser(new User("asdg", "123", "luan nguyen", "nguyen",
		 * "asdg@gial.com"));
		 */
		/*
		 * User user = new User(); user.setUsername("lll");
		 * System.out.println("User exist: "+ userService.checkUser(user));
		 */

		/*
		 * System.out.println(roleService.listRoles());
		 * 
		 * 
		 * 
		 * User user = new User(); user.setUsername("luan1"); Set<Role> roles =
		 * new HashSet<>(); Role role1 = roleService.listRoles().get(0);
		 * System.out.println("Role1: "+role1); Role role2 =
		 * roleService.listRoles().get(1); System.out.println("Role2: "+role2);
		 * roles.add(role1); roles.add(role2);
		 * userService.saveUserWithRoles(user, roles);
		 * 
		 */

		/* System.out.println(userService.getUser("abcabc580")); */

		/* System.out.println(roleService.getRolesByUsername("abcabc580")); */

		/* System.out.println(agesexService.listAgeSex()); */

		/*
		 * System.out.println(producttypeService.getProducttypeListByAgesexId(2)
		 * );
		 */

		/*
		 * Producttype producttype = new Producttype();
		 * producttype.setName("chen thu");
		 * 
		 * Agesex agesex = new Agesex(); agesex.setId(2);
		 */

		/*
		 * Muon set agesex thi phai set id cho no de no ton tai, ko duoc set
		 * name, hoac ko thi dung co set, de no null
		 */
		/*
		 * producttype.setAgesex(agesex);
		 * 
		 * producttypeService.addProducttype(producttype);
		 * 
		 * model.put("categories", producttypeService.listProductType());
		 */
		/* System.out.println(agesexService.convertNameToId("Women")); */

		/* producttypeService.deleteProducttypeById(19); */

		/*
		 * Producttype producttype = new Producttype(); producttype.setId(13);
		 * producttype.setName("Nguyen Viet Luan");
		 * producttype.setDescription("Mot it mo ta");
		 * 
		 * 
		 * Agesex agesex = new Agesex(); agesex.setId(2);
		 * producttype.setAgesex(agesex);
		 * 
		 * producttypeService.updateProducttype(producttype);
		 */

		/* System.out.println(timeHelper.getCurrentTime()); */
		/*
		 * System.out.println(productService.
		 * listProductsPagingByProductTypeIdAndSort(1, 1, 9, "latest"));
		 */

		/*
		 * Product product = new Product(); product.setId(253);
		 * product.setName("hello"); productService.addProduct(product);
		 */

		/*
		 * User user = new User(); user.setUsername("fff");
		 * user.setPassword("fff"); user.setEmail("abcabc580@gmail.com");
		 * 
		 * userService.saveUser(user);
		 */

		/*
		 * System.out.println(userService.getUserByEmail("abcabc580@gmail.com"))
		 * ;
		 */
		/*
		 * try { productService.indexProducts();
		 * System.out.println(productService.search("�o")); } catch (Exception
		 * e) { // TODO: handle exception e.printStackTrace(); }
		 */

		/*
		 * model.put("products",
		 * this.productService.listProductsPagingByProductTypeId(1, 1, 9));
		 * model.put("numberOfPages",
		 * this.productService.getNumberOfPagesByProductTypeIdandPageSize(9,
		 * 1));
		 * 
		 * model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		 * model.put("women",
		 * producttypeService.getProducttypeListByAgesexId(2));
		 * model.put("kids",
		 * producttypeService.getProducttypeListByAgesexId(3));
		 */

		/*
		 * Product product = new Product(); product.setId(1212);
		 * 
		 * productService.addProduct(product);
		 */

		/*
		 * System.out.println(orderdetailService.getOrderdetailListByOrderId(11)
		 * );
		 */

		/*
		 * Order order = orderService.getOrderByOrderId(15); Set<Orderdetail>
		 * orderdetails = orderdetailService.getOrderdetailListByOrderId(15);
		 * Orderdetail orderdetail = new Orderdetail();
		 * mailService.sendEmail(orderdetails);
		 */

		/*
		 * Rating rating = new Rating(); rating.setId(1);
		 * rating.setProductId(1); rating.setRating(3);
		 * 
		 * ratingService.addRating(rating);
		 */

		String filepath = System.getenv("OPENSHIFT_DATA_DIR");
		System.out.println("File Path Openshift Data Dir: " + filepath);

		return
		/* this.personService.listPersons().toString(); */
		/* this.productService.listProducts().toString(); */
		/* this.productService.getProductListByProductTypeId(1).toString(); */
		/* this.productService.listProductsPaging(1, 9).toString(); */
		/* this.productService.getProductListByProductTypeId1(1).toString(); */
		/* Long.toString(this.productService.getNumberOfRecordsOfProduct()); */
		/*
		 * Long.toString(this.productService.getNumberOfProductByProductTypeId(1
		 * ));
		 */
		/*
		 * Integer.toString(this.productService.
		 * getNumberOfPagesByProductTypeIdandPageSize(9, 1));
		 */
		/*
		 * this.productService.listProductsPagingByProductTypeId(1, 2,
		 * 9).toString();
		 */
		/* this.productService.getProductById(2).toString(); */

		/* productService.listProducts().toString(); */
		/* producttypeService.listProductType().toString(); */

		/* testBean.testBean(); */

		/* "adminhome"; */

		/* "admincategory"; */

		/* "orderconfirm"; */
		/* "orderreview"; */

		/* "admin_report"; */
		"test";
		/* "mail"; */
		/* this.producttypeService.listProductType().toString(); */
		/* this.producttypeService.getProducttypeById(2).toString(); */

	}

}
