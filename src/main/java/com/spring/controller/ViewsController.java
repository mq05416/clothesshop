package com.spring.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.helper.HelperImpl;
import com.spring.model.Agesex;
import com.spring.model.Feedback;
import com.spring.model.Product;
import com.spring.model.Producttype;
import com.spring.model.Rating;
import com.spring.modelVO.JsonObject;
import com.spring.service.FeedbackService;
import com.spring.service.ProductService;
import com.spring.service.ProducttypeService;
import com.spring.service.RatingService;

@Controller
@RequestMapping("/views/*")
public class ViewsController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProducttypeService producttypeService;

	@Autowired
	private RatingService ratingService;
	@Autowired
	private HelperImpl helperImpl;
	
	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping(value = "/viewproductlist/{producttypeid}/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	public String showLoginPage(@PathVariable String producttypeid, @PathVariable String pageSize,
			@PathVariable String pageNumber, ModelMap model, HttpServletRequest request) {
		System.out.println(producttypeid + "===" + pageSize + "===" + pageNumber);
		HttpSession session = request.getSession();
		session.setAttribute("producttypeid", producttypeid);
		session.setAttribute("pageSize", pageSize);
		session.setAttribute("pageNumber", pageNumber);

		System.out.println("===producttype: " + producttypeid);

		/* truyen cac thuoc tinh products, numberOfPages, categoryMap */
		model.put("products", this.productService.listProductsPagingByProductTypeId(Integer.parseInt(producttypeid),
				Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
		model.put("numberOfPages", this.productService.getNumberOfPagesByProductTypeIdandPageSize(
				Integer.parseInt(pageSize), Integer.parseInt(producttypeid)));

		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		model.put("productslatest", productService.listProductsByLatest());

		/*
		 * model.put("producttypeVOs",
		 * helperImpl.calculateQuantityOfEachType());
		 */

		System.out.println(helperImpl.getNumberOfProduct(2));

		return "products";
		/* return "test"; */
	}

	@RequestMapping(value = "/viewproductnumberitem", method = RequestMethod.GET)
	public String viewproductNumberItem(ModelMap model, HttpServletRequest request) {

		System.out.println("Vao number item");
		String numberitem = request.getParameter("numberitem");

		HttpSession session = request.getSession();
		String producttypeid = (String) session.getAttribute("producttypeid");
		String pageNumber = (String) session.getAttribute("pageNumber");
		System.out.println("producttypeid: " + producttypeid);
		System.out.println("pageNumber: " + pageNumber);
		String pageSize = numberitem;
		System.out.println("pageSize: " + pageSize);

		/*model.put("products", this.productService.listProductsPagingByProductTypeId(Integer.parseInt(producttypeid),
				Integer.parseInt(pageNumber), Integer.parseInt(pageSize)));
		model.put("pageSize", pageSize);*/
		model.put("numberOfPages", this.productService.getNumberOfPagesByProductTypeIdandPageSize(
				Integer.parseInt(pageSize), Integer.parseInt(producttypeid)));
		/*model.put("producttypeVOs", helperImpl.calculateQuantityOfEachType());*/
		session.setAttribute("producttypeid", producttypeid);
		session.setAttribute("pageSize", pageSize);

		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		model.put("productslatest", productService.listProductsByLatest());
		return "products";
		/* return "test"; */
	}

	@RequestMapping(value = "/viewproductsortitem", method = RequestMethod.GET)
	public String viewproductSortItem(ModelMap model, HttpServletRequest request) {
		System.out.println("Vao sort item");

		String sort = request.getParameter("sort");
		System.out.println(sort);

		HttpSession session = request.getSession();
		String producttypeid = (String) session.getAttribute("producttypeid");
		String pageNumber = (String) session.getAttribute("pageNumber");
		System.out.println("producttypeid: " + producttypeid);
		System.out.println("pageNumber: " + pageNumber);
		String pageSize = (String) session.getAttribute("pageSize");
		
		System.out.println("pageSize: " + pageSize);

		/*model.put("products", this.productService.listProductsPagingByProductTypeIdAndSort(
				Integer.parseInt(producttypeid), Integer.parseInt(pageNumber), Integer.parseInt(pageSize), sort));*/

		/*model.put("pageSize", pageSize);*/
		model.put("numberOfPages", this.productService.getNumberOfPagesByProductTypeIdandPageSize(
				Integer.parseInt(pageSize), Integer.parseInt(producttypeid)));
		/*model.put("producttypeVOs", helperImpl.calculateQuantityOfEachType());*/
		session.setAttribute("producttypeid", producttypeid);
		session.setAttribute("pageSize", pageSize);
		session.setAttribute("sort", sort);

		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		model.put("productslatest", productService.listProductsByLatest());
		return "products";
		/* return "test"; */
	}

	@RequestMapping(value = "/viewproductdetails/{productid}", method = RequestMethod.GET)
	public String viewProductDetails(@PathVariable String productid, ModelMap model, HttpServletRequest request) {
		System.out.println("Product Id: " + productid);
		model.put("product", this.productService.getProductById(Integer.parseInt(productid)));
		/*
		 * model.put("producttypeVOs",
		 * helperImpl.calculateQuantityOfEachType());
		 */

		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		model.put("productslatest", productService.listProductsByLatest());
		return "single";
		/* return "test"; */
	}

	@ResponseBody
	@RequestMapping(value = "/viewproductpageajax", method = RequestMethod.GET)
	public JsonObject viewproductPageAjax(ModelMap model, HttpServletRequest request) {
		/*
		 * public List<Product> viewproductPageAjax(ModelMap model,
		 * HttpServletRequest request) {
		 */

		System.out.println("Vao ajax view product");
		String pageNumber = request.getParameter("pageNumber");

		HttpSession session = request.getSession();
		String producttypeid = (String) session.getAttribute("producttypeid");
		String sort = (String) session.getAttribute("sort");

		System.out.println("Vao ajax Sort: " + sort);
		if ((sort == null) || sort.equals(""))
			sort = "default";

		System.out.println("producttypeid: " + producttypeid);
		System.out.println("pageNumber: " + pageNumber);

		String pageSize = (String) session.getAttribute("pageSize");
		System.out.println("pageSize: " + pageSize);

		if (producttypeid == null || pageSize == null || sort == null) {
			producttypeid = "1";
			pageSize = "9";
			sort = "price";

		}

		List<Product> products = this.productService.listProductsPagingByProductTypeIdAndSort(
				Integer.parseInt(producttypeid), Integer.parseInt(pageNumber), Integer.parseInt(pageSize), sort);

		JsonObject jsonObject = new JsonObject();
		jsonObject.setJsonFunction("jsonfunction_products");
		jsonObject.setJsonObject(products);

		return jsonObject;
		/* return "test"; */
	}

	@RequestMapping(value = "/viewproductsearch", method = RequestMethod.GET)
	public String viewproductSearch(ModelMap model, HttpServletRequest request) {

		System.out.println("Vao search view product");
		String keyword = request.getParameter("keyword");

		System.out.println("Keyword: " + keyword);

		List<Product> products = this.productService.search(keyword);
		long numberOfPages;
		long numberOfRecords = products.size();
		if ((numberOfRecords % 18) != 0)
			numberOfPages = (numberOfRecords / 18) + 1;
		else
			numberOfPages = numberOfRecords / 18;

		model.put("numberOfPages", numberOfPages);

		HttpSession session = request.getSession();
		session.setAttribute("keyword", keyword);

		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		model.put("productslatest", productService.listProductsByLatest());

		return "productssearch";
		/* return "test"; */
	}

	@ResponseBody
	@RequestMapping(value = "/viewproductsearchpageajax", method = RequestMethod.GET)
	public JsonObject viewproductSearchPageAjax(ModelMap model, HttpServletRequest request) {

		System.out.println("Vao ajax view search product");
		try {
			productService.indexProducts();
			/* System.out.println(productService.search("�o")); */
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		String pageNumber = request.getParameter("pageNumber");

		HttpSession session = request.getSession();

		String keyword = (String) session.getAttribute("keyword");

		System.out.println("Pagenumber: " + pageNumber + "Keyword: " + keyword);

		List<Product> products = this.productService.searchPaging(keyword, Integer.parseInt(pageNumber), 18);

		System.out.println("Vo search product ajax: \n" + products);

		JsonObject jsonObject = new JsonObject();
		jsonObject.setJsonFunction("jsonfunction_products_search");
		jsonObject.setJsonObject(products);

		return jsonObject;
		/* return "test"; */
	}

	@ResponseBody
	@RequestMapping(value = "/sendvote/{vote}/{productid}", method = RequestMethod.GET)
	public String sendvote(@PathVariable String vote, @PathVariable String productid, ModelMap model,
			HttpServletRequest request) {
		System.out.println("Vote send: " + vote);
		System.out.println("Product ID: " + productid);
		/*
		 * model.put("producttypeVOs",
		 * helperImpl.calculateQuantityOfEachType());
		 */
		Rating rating = new Rating();
		rating.setProductId(Integer.parseInt(productid));
		rating.setRating(Integer.parseInt(vote));
		ratingService.addRating(rating);

		System.out.println(ratingService.getRatingListByProductId(Integer.parseInt(productid)));

		List<Rating> ratings = ratingService.getRatingListByProductId(Integer.parseInt(productid));

		double rating1 = 0;
		double total = ratings.size();
		double ratingcount = 0;
		for (Rating rating2 : ratings) {
			ratingcount += rating2.getRating();
		}

		rating1 = ratingcount / total;

		// cap nhat rating cho product
		Product product = productService.getProductById(Integer.parseInt(productid));
		product.setRating(rating1);
		productService.updateProduct(product);

		return vote;

	}

	
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public String feedbackForm(ModelMap model) {

		

		
		return "mail";

	}
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	public String sendFeedback(@RequestParam("name") String name, @RequestParam("comment") String comment,
			@RequestParam("email") String email, @RequestParam("subject") String subject,
			@RequestParam("phone") String phone, ModelMap model) {

		System.out.println(name + "===" + comment + "===" + email + "===" + subject + "===" + phone);
		
		Feedback feedback = new Feedback();
		feedback.setEmail(email);
		feedback.setContactNumber(phone);
		feedback.setMessage(comment);
		feedback.setSubject(subject);
		feedback.setName(name);
		Date todayDate = new Date();
		feedback.setCreatedDate(todayDate);

		feedbackService.addFeedback(feedback);
		return "successfeedback";

	}

}
