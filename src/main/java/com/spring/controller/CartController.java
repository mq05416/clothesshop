package com.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.ejb.HibernateEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.helper.HelperImpl;
import com.spring.model.Order;
import com.spring.model.Orderdetail;
import com.spring.model.Product;
import com.spring.model.Role;
import com.spring.model.User;
import com.spring.modelVO.Cart;
import com.spring.modelVO.JsonObject;
import com.spring.service.MailService;
import com.spring.service.OrderDetailService;
import com.spring.service.OrderService;
import com.spring.service.ProductService;
import com.spring.service.ProducttypeService;
import com.spring.service.RoleService;
import com.spring.service.UserService;

@Controller
@RequestMapping("/shopping/*")
public class CartController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProducttypeService producttypeService;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private MailService mailService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private HelperImpl helperImpl;

	private List<Cart> carts = new ArrayList<>();

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkoutPageView(ModelMap model) {
		/*model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));*/
		return "checkout";
		/* return "test"; */
	}

	@RequestMapping(value = "/checkout/{id}", method = RequestMethod.GET)
	public String registerPage(@PathVariable String id, ModelMap model, HttpServletRequest request) {

		Product product = productService.getProductById(Integer.parseInt(id));

		/*
		 * Load session Kiem tra xem session co chua cart attribute ko neu ko
		 * thi tao moi carts, sau do addToCart (product) Con co roi thi cu thuc
		 * hien addToCart(product)
		 */

		HttpSession session = request.getSession();
		carts = (List<Cart>) session.getAttribute("cartsSession");
		if (carts == null)
			carts = new ArrayList<>();
		addToCart(product);
		session.setAttribute("cartsSession", carts);

		System.out.println(carts);

		/*model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));*/
		return "checkout";
		/* return "test"; */
	}

	private void addToCart(Product product) {

		for (Cart item : carts) {
			if (item.getProduct().getId() == product.getId()) {
				item.setQuantity(item.getQuantity() + 1);
				return;
			}
		}
		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setQuantity(1);
		carts.add(cart);

	}

	@RequestMapping(value = "/updatecart", method = RequestMethod.POST)
	public String updateCart(ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		carts = (List<Cart>) session.getAttribute("cartsSession");
		String[] quantity = request.getParameterValues("quantity");

		if (quantity != null) {
			for (String string : quantity) {
				System.out.println(string);
			}
			for (int i = 0; i < carts.size(); i++) {
				carts.get(i).setQuantity(Integer.parseInt(quantity[i]));
			}
		}

		

		session.setAttribute("cartsSession", carts);

		/*model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));*/
		return "checkout";
	}

	@ResponseBody
	@RequestMapping(value = "/deleteitemnumberajax/{itemid}", method = RequestMethod.GET)
	public JsonObject deleteitemid(@PathVariable String itemid, ModelMap model, HttpServletRequest request) {

		/*
		 * Load cartsSession Duyet phan tu tu 0 den size-1 Kiem tra neu
		 * productid = itemid thi remove o phan tu do Gan lai bien session
		 */

		HttpSession session = request.getSession();
		carts = (List<Cart>) session.getAttribute("cartsSession");

		for (int i = 0; i < carts.size(); i++) {
			if (carts.get(i).getProduct().getId() == Integer.parseInt(itemid)) {
				carts.remove(i);
				break;
			}
		}

		/* carts.remove(Integer.parseInt(itemnumber)-1) */;
		session.setAttribute("cartsSession", carts);

		System.out.println(carts);

		JsonObject jsonObject = new JsonObject();
		jsonObject.setJsonFunction("jsonfunction_deleteitem");
		jsonObject.setJsonObject(carts);

		return jsonObject;

		/* return "test"; */
	}

	@ResponseBody
	@RequestMapping(value = "/additemtocartajax/{itemid}", method = RequestMethod.GET)
	public JsonObject additemtocart(@PathVariable String itemid, ModelMap model, HttpServletRequest request) {
		Product product = productService.getProductById(Integer.parseInt(itemid));

		/*
		 * Load session Kiem tra xem session co chua cart attribute ko neu ko
		 * thi tao moi carts, sau do addToCart (product) Con co roi thi cu thuc
		 * hien addToCart(product)
		 */

		HttpSession session = request.getSession();
		carts = (List<Cart>) session.getAttribute("cartsSession");
		if (carts == null)
			carts = new ArrayList<>();
		addToCart(product);
		session.setAttribute("cartsSession", carts);

		System.out.println(carts);

		JsonObject jsonObject = new JsonObject();
		jsonObject.setJsonFunction("jsonfunction_addtocart");
		jsonObject.setJsonObject(carts);

		return jsonObject;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteallitemajax", method = RequestMethod.GET)
	public JsonObject deleteallitem(HttpServletRequest request) {

		/*
		 * Load session Kiem tra xem session co chua cart attribute ko neu ko
		 * thi tao moi carts, sau do addToCart (product) Con co roi thi cu thuc
		 * hien addToCart(product)
		 */

		HttpSession session = request.getSession();
		carts = (List<Cart>) session.getAttribute("cartsSession");
		JsonObject jsonObject = null;
		if (carts != null && carts.size() >= 1) {
			carts.clear();
			session.setAttribute("cartsSession", carts);

			jsonObject = new JsonObject();
			jsonObject.setJsonFunction("jsonfunction_deleteall");
			jsonObject.setJsonObject(carts);
		}

		return jsonObject;

	}

	@RequestMapping(value = "/confirmorder", method = RequestMethod.GET)
	public String confirmOrderView(ModelMap model, HttpServletRequest request) {

		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		return "orderconfirm";
	}

	@RequestMapping(value = "/confirmorder", method = RequestMethod.POST)
	public String confirmOrderProcess(@RequestParam("country") String country,
			@RequestParam("first_name") String firstname, @RequestParam("last_name") String lastname,
			@RequestParam("address") String address, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("zip_code") String zipcode,
			@RequestParam("phone_number") String phonenumber, @RequestParam("email_address") String email,
			/* @RequestParam("payment") String payment */ ModelMap model, HttpServletRequest request) {

		

		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setAddress(address + " - " + city + " - " + state + " - " + zipcode);
		user.setEmail(email);
		user.setPhone(phonenumber);

		HttpSession session = request.getSession();
		session.setAttribute("userInfoOrder", user);

		
		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		return "orderreview";
	}

	@RequestMapping(value = "/orderreviewconfirm", method = RequestMethod.GET)
	public String orderReviewConfirm(ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();

		User user1 = (User) session.getAttribute("userInfoOrder");

		Order order = new Order();
		order.setOrderDate(new Date());
		order.setAddress(user1.getAddress());

		if (userService.getUserByEmail(user1.getEmail()) == null) {
			User user = new User();
			user.setEmail(user1.getEmail());
			userService.saveUser(user);

			order.setUser(user);
		} else {
			User user = userService.getUserByEmail(user1.getEmail());
			order.setUser(user);
		}

		Date todayDate = new Date();

		carts = (List<Cart>) session.getAttribute("cartsSession");

		double amount = 0;
		for (Cart cart : carts) {
			if (cart.getProduct().getDiscountStartDate() != null && cart.getProduct().getDiscountEndDate() != null
					&& cart.getProduct().getDiscount() != null
					&& cart.getProduct().getDiscountStartDate().compareTo(todayDate) == -1
					&& cart.getProduct().getDiscountEndDate().compareTo(todayDate) == 1) {
				amount = amount
						+ cart.getProduct().getPrice() * cart.getQuantity() * (1 - cart.getProduct().getDiscount());
				continue;
			} else
				amount = amount + cart.getProduct().getPrice() * cart.getQuantity();
		}

		order.setAmount(amount);
		order.setIsProcessing(true);
		orderService.saveOrder(order);

		for (Cart cart : carts) {
			System.out.println("cart: " + cart);
			Orderdetail orderdetail = new Orderdetail();
			orderdetail.setOrder(order);
			orderdetail.setProduct(cart.getProduct());
			orderdetail.setPrice(cart.getProduct().getPrice());
			orderdetail.setQuantity(cart.getQuantity());

			if (cart.getProduct().getDiscountStartDate() != null && cart.getProduct().getDiscountEndDate() != null
					&& cart.getProduct().getDiscount() != null
					&& cart.getProduct().getDiscountStartDate().compareTo(todayDate) == -1
					&& cart.getProduct().getDiscountEndDate().compareTo(todayDate) == 1) {
				System.out.println(
						cart.getProduct().getDiscountStartDate() + "===" + cart.getProduct().getDiscountEndDate()
								+ "===" + cart.getProduct().getDiscountStartDate().compareTo(todayDate) + "==="
								+ cart.getProduct().getDiscountEndDate().compareTo(todayDate));

				System.out.println("discount: " + cart.getProduct().getDiscount());
				orderdetail.setDiscount(cart.getProduct().getDiscount());
			}

			orderDetailService.saveOrderDetail(orderdetail);

		}

		Set<Orderdetail> orderdetails = orderDetailService.getOrderdetailListByOrderId(order.getId());
		mailService.sendEmail(orderdetails);

		session.removeAttribute("cartsSession");
		session.removeAttribute("userInfoOrder");

		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		return "successorder";
	}
}
