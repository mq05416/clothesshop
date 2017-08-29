package com.spring.controller;

import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.helper.CurrencyType;
import com.spring.helper.ExcelHelper;
import com.spring.helper.HelperImpl;
import com.spring.helper.TimeHelper;
import com.spring.model.Agesex;
import com.spring.model.Order;
import com.spring.model.Orderdetail;
import com.spring.model.Product;
import com.spring.model.Producttype;
import com.spring.modelVO.Cart;
import com.spring.service.AgesexService;
import com.spring.service.FeedbackService;
import com.spring.service.OrderDetailService;
import com.spring.service.OrderService;
import com.spring.service.ProductService;
import com.spring.service.ProducttypeService;
import com.spring.service.RoleService;
import com.spring.service.UserService;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

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
	private RoleService roleService;
	@Autowired
	private HelperImpl helperImpl;

	@Autowired
	private AgesexService agesexService;

	@Autowired
	private FeedbackService feedbackService;

	@Autowired
	private TimeHelper timeHelper;

	private List<Cart> carts = new ArrayList<>();

	@RequestMapping(value = "/home/view", method = RequestMethod.GET)
	public String homeView(ModelMap model) {

		return "adminhome";

	}

	@RequestMapping(value = "/category/view", method = RequestMethod.GET)
	public String categoryView(ModelMap model) {
		model.put("categories", producttypeService.listProductType());
		return "admincategory";

	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String categoryAdd(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("agesex") String agesex, ModelMap model) {

		System.out.println(id + "===" + name + "===" + description + "===" + agesex);
		Producttype producttype = new Producttype();
		producttype.setName(name);
		producttype.setDescription(description);

		int agesexid = agesexService.convertNameToId(agesex);
		Agesex agesex2 = new Agesex();
		agesex2.setId(agesexid);

		producttype.setAgesex(agesex2);

		producttypeService.addProducttype(producttype);
		model.put("categories", producttypeService.listProductType());
		return "admincategory";

	}

	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.GET)
	public String categoryDelete(@PathVariable String id, ModelMap model) {
		producttypeService.deleteProducttypeById(Integer.parseInt(id));
		model.put("categories", producttypeService.listProductType());
		return "admincategory";

	}

	@RequestMapping(value = "/category/edit/{id}", method = RequestMethod.GET)
	public String categoryEditView(@PathVariable String id, ModelMap model) {
		Producttype producttype = producttypeService.getProducttypeById(Integer.parseInt(id));

		model.put("producttype", producttype);

		return "admincategoryedit";

	}

	@RequestMapping(value = "/category/edit", method = RequestMethod.POST)
	public String categoryEdit(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("agesex") String agesex, ModelMap model) {
		Producttype producttype = new Producttype();
		producttype.setId(Integer.parseInt(id));
		producttype.setName(name);
		producttype.setDescription(description);

		int agesexid = agesexService.convertNameToId(agesex);
		Agesex agesex2 = new Agesex();
		agesex2.setId(agesexid);

		producttype.setAgesex(agesex2);

		producttypeService.updateProducttype(producttype);
		model.put("categories", producttypeService.listProductType());
		return "admincategory";
	}

	@RequestMapping(value = "/product/view", method = RequestMethod.GET)
	public String productView(ModelMap model) {
		model.put("products", productService.listProducts());
		model.put("producttypes", producttypeService.listProductType());
		return "adminproduct";

	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String productAdd(@RequestParam("id") String id, @RequestParam("description") String description,
			@RequestParam("name") String name, @RequestParam("price") String price,
			@RequestParam("discount") String discount, @RequestParam("producttype") String producttype,
			@RequestParam("file") MultipartFile file, ModelMap model) {
		System.out.println(id + "===" + name + "===" + price + "===" + discount + "===" + producttype);

		if ((name.equalsIgnoreCase("")) || id.equalsIgnoreCase("")) {
			System.out.println("Name: " + name);
			model.put("error", "Please enter values");
			model.put("products", productService.listProducts());
			model.put("producttypes", producttypeService.listProductType());
			return "adminproduct";
		}

		Product product = new Product();
		String imageName = null;

		if (!file.isEmpty()) {
			try {

				byte[] bytes = file.getBytes();
				String fileName = file.getOriginalFilename();
				String contentType = file.getContentType();
				System.out.println("File Name: " + fileName);
				System.out.println("Content Type: " + contentType);

				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "images");
				System.out.println(dir.getAbsolutePath());

				imageName = Long.toString(System.currentTimeMillis()) + "_" + fileName;

				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir.getAbsolutePath() + File.separator + imageName);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
				System.out.println("Loi upload");
				model.put("error", "Error upload!");
				model.put("products", productService.listProducts());
				model.put("producttypes", producttypeService.listProductType());
				e.printStackTrace();
				return "adminproduct";
			}
		} else {

			imageName = "no_image";
		}

		product = new Product();
		product.setId(Integer.parseInt(id));

		if (!name.equals(""))
			product.setName(name);
		if (!description.equals(""))
			product.setDescription(description);
		if (!imageName.equals(""))
			product.setImage(imageName);
		if (!price.equals(""))
			product.setPrice(Double.parseDouble(price));
		if (!discount.equals(""))
			product.setDiscount(Double.parseDouble(discount));

		int producttypeid = producttypeService.convertNameToId(producttype);
		Producttype producttype2 = new Producttype();
		producttype2.setId(producttypeid);

		product.setProducttype(producttype2);

		/* productService.addProduct(product); */

		try {
			productService.addProduct(product);
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", "You added unsuccessfully product!");

			model.put("products", productService.listProducts());
			model.put("producttypes", producttypeService.listProductType());
			return "adminproduct";
		}

		model.put("success", "You added successfully product!");

		model.put("products", productService.listProducts());
		model.put("producttypes", producttypeService.listProductType());
		return "adminproduct";

	}

	@RequestMapping(value = "/product/delete/{id}", method = RequestMethod.GET)
	public String productDelete(@PathVariable String id, ModelMap model) {

		productService.deleteProductById(Integer.parseInt(id));
		model.put("products", productService.listProducts());
		model.put("producttypes", producttypeService.listProductType());
		return "adminproduct";

	}

	@RequestMapping(value = "/product/deleteselected", method = RequestMethod.POST)
	public String productSelectedDelete(HttpServletRequest request, ModelMap model) {

		String[] ids = request.getParameterValues("list");
		for (String id : ids) {
			// do something with id, this is checkbox value
			System.out.println("Id: " + id);
			productService.deleteProductById(Integer.parseInt(id));
		}

		model.put("products", productService.listProducts());
		model.put("producttypes", producttypeService.listProductType());

		return "adminproduct";

	}

	@RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
	public String productEditView(@PathVariable String id, ModelMap model) {

		Product product = productService.getProductById(Integer.parseInt(id));

		model.put("product", product);
		model.put("producttypes", producttypeService.listProductType());

		return "adminproductedit";

	}

	@RequestMapping(value = "/product/edit", method = RequestMethod.POST)
	public String productEdit(@RequestParam("id") String id, @RequestParam("description") String description,
			@RequestParam("name") String name, @RequestParam("price") String price,
			@RequestParam("quantity") String quantity, @RequestParam("discount") String discount,
			@RequestParam("producttype") String producttype, @RequestParam("file") MultipartFile file, ModelMap model) {
		System.out.println(id + "===" + name + "===" + price + "===" + discount + "===" + producttype);

		if ((name.equalsIgnoreCase("")) || id.equalsIgnoreCase("")) {
			System.out.println("Name: " + name);
			model.put("error", "Please enter values");
			model.put("products", productService.listProducts());
			model.put("producttypes", producttypeService.listProductType());
			return "adminproductedit";
		}

		Product product = new Product();
		product = productService.getProductById(Integer.parseInt(id));
		String imageName = null;

		if (!file.isEmpty()) {
			try {

				byte[] bytes = file.getBytes();
				String fileName = file.getOriginalFilename();
				String contentType = file.getContentType();
				System.out.println("File Name: " + fileName);
				System.out.println("Content Type: " + contentType);

				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "images");
				System.out.println(dir.getAbsolutePath());

				imageName = Long.toString(System.currentTimeMillis()) + "_" + fileName;

				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir.getAbsolutePath() + File.separator + imageName);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
				System.out.println("Loi upload");
				model.put("error", "Error upload!");
				model.put("products", productService.listProducts());
				e.printStackTrace();
				return "adminproductedit";
			}
		} else {

			imageName = "no_image";
		}

		product.setId(Integer.parseInt(id));
		if (!name.equals(""))
			product.setName(name);
		if (!description.equals(""))
			product.setDescription(description);
		product.setImage(imageName);
		if (!price.equals(""))
			product.setPrice(Double.parseDouble(price));
		if (!quantity.equals(""))
			product.setQuantity(Integer.parseInt(quantity));
		if (!discount.equals(""))
			product.setDiscount(Double.parseDouble(discount));

		int producttypeid = producttypeService.convertNameToId(producttype);
		Producttype producttype2 = new Producttype();
		producttype2.setId(producttypeid);

		product.setProducttype(producttype2);

		productService.updateProduct(product);

		model.put("products", productService.listProducts());
		model.put("producttypes", producttypeService.listProductType());
		return "adminproduct";
	}

	@RequestMapping(value = "/product/importexcel", method = RequestMethod.POST)
	public String productImportExcel(@RequestParam("file") MultipartFile file, ModelMap model) {

		Product product = new Product();
		String imageName = null;
		File serverFile = null;
		if (!file.isEmpty()) {
			try {

				byte[] bytes = file.getBytes();
				String fileName = file.getOriginalFilename();
				String contentType = file.getContentType();
				System.out.println("File Name: " + fileName);
				System.out.println("Content Type: " + contentType);

				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "excels");
				System.out.println(dir.getAbsolutePath());

				imageName = Long.toString(System.currentTimeMillis()) + "_" + fileName;

				if (!dir.exists())
					dir.mkdirs();
				serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
				System.out.println("Full duong dan: " + serverFile.getAbsolutePath());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
				System.out.println("Loi upload");
				model.put("error", "Error upload!");
				model.put("products", productService.listProducts());
				model.put("producttypes", producttypeService.listProductType());
				e.printStackTrace();
				return "adminproduct";
			}
		} else {

			imageName = "no_image";
		}

		ExcelHelper excelHelper = new ExcelHelper();
		List<ArrayList<HSSFCell>> arrayListHolder = excelHelper.readExcelFile(serverFile.getAbsolutePath());
		System.out.println("ArrayListHolder: " + arrayListHolder);// se giu mang
																	// cac row,
																	// ta se
																	// duyet
		// cac row nay va insert

		ArrayList cellStoreArrayList = new ArrayList();
		System.out.println("ArrayListHolder Size: " + arrayListHolder.size());
		
		// luu giu cac product bi anh huong truoc khi import, de khoi phuc lai trang thai khi import ko thanh cong
		List<Product> products_beforeimport = new ArrayList<>();
		try {
			for (int i = 1; i < arrayListHolder.size(); i++) {
				cellStoreArrayList = (ArrayList) arrayListHolder.get(i);
				System.out.println("CellStoreArrayList: " + cellStoreArrayList);

				System.out.println((((HSSFCell) cellStoreArrayList.get(0)).toString()) + "---"
						+ (((HSSFCell) cellStoreArrayList.get(1)).toString()) + "---"
						+ (((HSSFCell) cellStoreArrayList.get(2)).toString()) + "---"
						+ (((HSSFCell) cellStoreArrayList.get(3)).toString()) + "---"
						+ (((HSSFCell) cellStoreArrayList.get(4)).toString()) + "---");
						/*+ (((HSSFCell) cellStoreArrayList.get(5)).toString()));*/

				Product product2 = new Product();

				float id = Float.parseFloat(((HSSFCell) cellStoreArrayList.get(0)).toString());
				float quantity = Float.parseFloat(((HSSFCell) cellStoreArrayList.get(4)).toString());
				int idi = (int) id;
				int quantityi = (int) quantity;

				if (productService.getProductById(idi) != null) {

					product2 = productService.getProductById(idi);
					Product product3 = new Product();
					product3 = productService.getProductById(idi);
					products_beforeimport.add(product3);
					System.out.println("Vo if  " + product2);
					/*
					 * set lai name va description neu can thiet, giu nguyen image
					 */
					product2.setName(((HSSFCell) cellStoreArrayList.get(1)).toString());
					product2.setDescription(((HSSFCell) cellStoreArrayList.get(2)).toString());

					if (productService.getProductById(idi).getQuantity() == null)
						product2.setQuantity(quantityi);
					else
						product2.setQuantity(quantityi + productService.getProductById(idi).getQuantity());
					productService.updateProduct(product2);

				} else {

					product2.setId(idi);
					product2.setName(((HSSFCell) cellStoreArrayList.get(1)).toString());
					product2.setDescription(((HSSFCell) cellStoreArrayList.get(2)).toString());
					product2.setQuantity(quantityi);
					System.out.println("Vo else" + product2);
					productService.addProduct(product2);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			recoverProductsImportUnsuccessful(products_beforeimport);
			model.put("import_error", "Import unsuccessfully!");
			model.put("products", productService.listProducts());
			model.put("producttypes", producttypeService.listProductType());
			return "adminproduct";
		}
		
		model.put("import_success", "Import successfully!");
		model.put("products", productService.listProducts());
		model.put("producttypes", producttypeService.listProductType());
		return "adminproduct";

	}

	public void recoverProductsImportUnsuccessful(List<Product> products) {
		for(Product product: products){
			productService.updateProduct(product);
		}
		
	}
	
	@RequestMapping(value = "/order/view", method = RequestMethod.GET)
	public String orderView(ModelMap model) {
		model.put("orders", orderService.listOrders());

		return "adminorder";

	}

	@RequestMapping(value = "/orderdetail/view/{id}", method = RequestMethod.GET)
	public String orderDetailView(@PathVariable String id, ModelMap model) {
		model.put("order", orderService.getOrderByOrderId(Integer.parseInt(id)));
		model.put("orderdetails", orderDetailService.getOrderdetailListByOrderId(Integer.parseInt(id)));

		return "adminorderdetail";

	}

	@RequestMapping(value = "/order/updatestatus/{id}", method = RequestMethod.POST)
	public String orderstatusUpdate(@RequestParam("status") String status, @PathVariable String id, ModelMap model) {

		System.out.println("Status: " + status);

		Order order = orderService.getOrderByOrderId(Integer.parseInt(id));

		if (status.equalsIgnoreCase("Processing")) {
			order.setIsProcessing(true);
			order.setIsShipped(false);
			order.setIsCompleted(false);
			order.setIsCancel(false);
		}
		if (status.equalsIgnoreCase("Shipped")) {
			order.setIsProcessing(false);
			order.setIsShipped(true);
			order.setIsCompleted(false);
			order.setIsCancel(false);
		}
		if (status.equalsIgnoreCase("Completed")) {
			order.setIsProcessing(false);
			order.setIsShipped(false);
			order.setIsCompleted(true);
			order.setIsCancel(false);
			// tru bot cac san pham ma order da duoc hoan tat
			subtractOrderdetails(orderDetailService.getOrderdetailListByOrderId(Integer.parseInt(id)));
		}
		if (status.equalsIgnoreCase("Canceled")) {
			order.setIsProcessing(false);
			order.setIsShipped(false);
			order.setIsCompleted(false);
			order.setIsCancel(true);
		}

		orderService.updateOrder(order);

		model.put("orders", orderService.listOrders());

		return "adminorder";

	}

	public void subtractOrderdetails(Set<Orderdetail> orderdetails) {
		for (Orderdetail orderdetail : orderdetails) {
			Product product = orderdetail.getProduct();
			int productId = product.getId();
			Product product2 = productService.getProductById(productId);
			product2.setQuantity(product2.getQuantity() - orderdetail.getQuantity());
			productService.updateProduct(product2);

		}
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String generateReportView(ModelMap model) {

		return "admin_report";

	}

	@RequestMapping(value = "/report", method = RequestMethod.POST)

	public void generateReport(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			HttpServletResponse response, ModelMap model) throws FileNotFoundException, IOException {

		System.out.println("Start Date: " + startDate);
		System.out.println("End Date: " + endDate);

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.11.61.2:3306/test111", "adminteZSTbr", "b_uADc_ct2ar");
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		CurrencyType currencyType = new CurrencyType();

		JasperReportBuilder report = DynamicReports.report();// a new report
		StyleBuilder boldStyle = stl.style().bold();
		StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
		StyleBuilder columnTitleStyle = stl.style(boldCenteredStyle)

				.setBorder(stl.pen1Point())

				.setBackgroundColor(Color.LIGHT_GRAY).setFontSize(10);
		StyleBuilder italicStyle = stl.style()

				.italic();
		report.columns(
				Columns.column("Order Id", "Id", DataTypes.integerType()).setHorizontalAlignment(
						HorizontalAlignment.LEFT),
				Columns.column("First Name", "FirstName", DataTypes.stringType()),
				Columns.column("Last Name", "LastName", DataTypes.stringType()),
				Columns.column("Amount", "Amount", currencyType),
				Columns.column("Address", "Address", DataTypes.stringType()),
				Columns.column("Email", "Email", DataTypes.stringType()),
				
				Columns.column("Order Date", "OrderDate", Timestamp.class).setPattern("yyyy-MM-dd HH:mm:ss.sss")
						.setHorizontalAlignment(HorizontalAlignment.LEFT))
				.title(// title of the report
						Components.text("Order Report").setHorizontalAlignment(HorizontalAlignment.CENTER)
								.setStyle(stl.style().setFontSize(20).bold().italic()))
				.pageFooter(Components.pageXofY())
				.setColumnTitleStyle(columnTitleStyle).highlightDetailEvenRows()
				
				.setDataSource("SELECT * FROM `order`, `user` where OrderDate >= '" + startDate + "' and OrderDate <='"
						+ endDate + "' and `order`.Id_User = `user`.Id"+ " and `order`.IsCompleted = 1", connection);

		String rootPath = System.getProperty("catalina.home");
		File dir = new File(rootPath + File.separator + "report");
		System.out.println(dir.getAbsolutePath());

		

		if (!dir.exists())
			dir.mkdirs();
		File reportFile = new File(dir.getAbsolutePath() + File.separator + "report.pdf");

		try {
			/* report.show();//show the report */
			report.toPdf(new FileOutputStream(reportFile));// export the
															// report to
															// a pdf
															// file
		} catch (DRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		org.apache.commons.io.IOUtils.copy(new FileInputStream(dir.getAbsolutePath() + File.separator + "report.pdf"),
				response.getOutputStream());
		response.setContentType("application/pdf");
		response.flushBuffer();

	}

	@RequestMapping(value = "/feedback/view", method = RequestMethod.GET)
	public String feedbackView(ModelMap model) {
		model.put("feedbacks", feedbackService.listFeedbacks());

		return "adminfeedback";

	}

	@RequestMapping(value = "/feedbackdetail/view/{id}", method = RequestMethod.GET)
	public String feedbackDetailView(@PathVariable String id, ModelMap model) {
		model.put("feedback", feedbackService.getFeedbackById(Integer.parseInt(id)));

		return "adminfeedbackview";

	}

	@RequestMapping(value = "/feedback/deleteselected", method = RequestMethod.POST)
	public String feedbackSelectedDelete(HttpServletRequest request, ModelMap model) {

		String[] ids = request.getParameterValues("list");
		for (String id : ids) {
			// do something with id, this is checkbox value
			System.out.println("Id: " + id);
			feedbackService.deleteFeedbackById(Integer.parseInt(id));
		}

		model.put("feedbacks", feedbackService.listFeedbacks());

		return "adminfeedback";

	}

}
