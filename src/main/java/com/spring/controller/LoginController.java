package com.spring.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.helper.HelperImpl;
import com.spring.helper.MailHelper;
import com.spring.helper.StringHelper;
import com.spring.helper.TimeHelper;
import com.spring.model.Role;
import com.spring.model.User;
import com.spring.modelVO.Cart;
import com.spring.service.AgesexService;
import com.spring.service.ProductService;
import com.spring.service.ProducttypeService;
import com.spring.service.RoleService;
import com.spring.service.UserService;

@Controller

public class LoginController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProducttypeService producttypeService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	@Autowired
	private HelperImpl helperImpl;

	@Autowired
	private AgesexService agesexService;

	@Autowired
	private TimeHelper timeHelper;

	private List<Cart> carts = new ArrayList<>();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView(ModelMap model) {
		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		return "login";

	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String login403(ModelMap model) {
		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		return "403";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPageView(ModelMap model) {
		/*model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));*/
		return "register";
		/* return "test"; */
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPage(@RequestParam("email") String email, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("username") String username,
			@RequestParam("password1") String password1, @RequestParam("password2") String password2,
			/*
			 * @RequestParam(value = "checkbox1", required = false) String
			 * checkbox1,
			 */
			@RequestParam(value = "checkbox2", required = false) String checkbox2, ModelMap model,
			HttpServletRequest request) {
		System.out.println("email: " + email);
		System.out.println("firstname: " + firstname);
		System.out.println("lastname: " + lastname);
		System.out.println("username: " + username);
		System.out.println("password1: " + password1);
		System.out.println("password2: " + password2);
		/* System.out.println("checkbox1: " + checkbox1); */
		System.out.println("checkbox2: " + checkbox2);

		if ((checkbox2 == null)) {
			model.put("error", "You must check all checkboxs before proceeding");
			model.put("men", producttypeService.getProducttypeListByAgesexId(1));
			model.put("women", producttypeService.getProducttypeListByAgesexId(2));
			model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
			return "register";
		}

		if (!password1.equals(password2)) {
			model.put("error", "Passwords don't match");
			model.put("men", producttypeService.getProducttypeListByAgesexId(1));
			model.put("women", producttypeService.getProducttypeListByAgesexId(2));
			model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
			return "register";
		}

		User user = new User();
		user.setUsername(username);
		user.setPassword(password1);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);

		/* tam thoi cho khoa tai khoan */
		user.setIsEnabled(false);

		/*
		 * User user = new User(username, password1, firstname, lastname,
		 * email);
		 */

		Set<Role> roles = new HashSet<>();
		Role role1 = roleService.listRoles().get(2);
		roles.add(role1);
		user.setRoles(roles);

		if (userService.checkUser(user) == false && userService.getUserByEmail(email) == null) {
			// generate UUID code
			final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			user.setUuid(uuid);
			user.setIsEnabled(false);
			userService.saveUserWithRoles(user, roles);
			/* Luu vao session */
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", user);

			String subject = "Mail Verification";
			String message = "Thanks for signing up!"
					+ "Your account has been created, you can login with the following credentials after you have activated your account by pressing the url below."
					+ "\n" + "------------------------\n" + "Username: " + user.getUsername() + "\n" + "Password: "
					+ user.getPassword() + "\n" + "------------------------\n"

					+ "Please click this link to activate your account: \n"
					+ "http://test111-luannvaptech2015.rhcloud.com/verify?email=" + user.getEmail() + "&uuid=" + uuid;

			;

			MailHelper.sendMail(user.getEmail(), subject, message);
			model.put("men", producttypeService.getProducttypeListByAgesexId(1));
			model.put("women", producttypeService.getProducttypeListByAgesexId(2));
			model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
			return "successregister";
		} else {
			model.put("error", "User or email exists in database, choose another username and email");
			model.put("men", producttypeService.getProducttypeListByAgesexId(1));
			model.put("women", producttypeService.getProducttypeListByAgesexId(2));
			model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
			return "register";
		}

		/*
		 * Kiem tra xem password ca 2 truong co trung nhau khong
		 * 
		 * 
		 * Neu khong trung nhau tra ve trang register voi thuoc tinh error Khong
		 * thi kiem tra xem username co trong co so du lieu chua, neu trung thi
		 * cung tra ve trang error Kiem tra luon co checkbox chua, neu chua cung
		 * tra ve trang register voi thuoc tinh error
		 * 
		 * Neu moi thu on thoa, thi ta luu du lieu vao db, voi role la user, set
		 * vao session, dong thoi hien thi trang redirect toi trang home
		 */

		/* return "test"; */
	}

	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public String verifyAccount(@RequestParam("email") String email, @RequestParam("uuid") String uuid, ModelMap model,
			HttpServletRequest request) {
		User user = new User();
		user = userService.getUserByEmail(email);
		System.out.println("User Verify: " + user);
		if (user != null && user.getUuid().equalsIgnoreCase(uuid)) {
			user.setIsEnabled(true);
			userService.updateUser(user);
			model.put("men", producttypeService.getProducttypeListByAgesexId(1));
			model.put("women", producttypeService.getProducttypeListByAgesexId(2));
			model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
			return "verifysuccess";
		} else {
			model.put("men", producttypeService.getProducttypeListByAgesexId(1));
			model.put("women", producttypeService.getProducttypeListByAgesexId(2));
			model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
			return "verifyerror";
		}
	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
	public String resetPasswordView(ModelMap model) {
		model.put("men", producttypeService.getProducttypeListByAgesexId(1));
		model.put("women", producttypeService.getProducttypeListByAgesexId(2));
		model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
		return "resetpassword";
	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	public String resetPassword(@RequestParam("email") String email, ModelMap model, HttpServletRequest request) {

		if (userService.getUserByEmail(email) == null) {
			model.put("error", "This email does not exist in DB");
			model.put("men", producttypeService.getProducttypeListByAgesexId(1));
			model.put("women", producttypeService.getProducttypeListByAgesexId(2));
			model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
			return "resetpassword";
		} else {
			User user = new User();
			user = userService.getUserByEmail(email);
			user.setPassword(StringHelper.randomString());
			user.setIsEnabled(false);
			final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			user.setUuid(uuid);
			userService.updateUser(user);
			String subject = "Reset Password";
			String message = "Your account has been reseted, you can login with the following credentials after you have activated your account by pressing the url below, you can change password later"
					+ "\n" + "------------------------\n" + "Username: " + user.getUsername() + "\n" + "Password: "
					+ user.getPassword() + "\n" + "------------------------\n"

					+ "Please click this link to activate your account again: \n"
					+ "http://test111-luannvaptech2015.rhcloud.com/verify?email=" + user.getEmail() + "&uuid=" + uuid;

			;

			MailHelper.sendMail(user.getEmail(), subject, message);
			model.put("men", producttypeService.getProducttypeListByAgesexId(1));
			model.put("women", producttypeService.getProducttypeListByAgesexId(2));
			model.put("kids", producttypeService.getProducttypeListByAgesexId(3));
			return "resetpasswordinfo";

		}

	}

}
