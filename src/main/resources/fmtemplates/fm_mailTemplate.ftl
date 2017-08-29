<#ftl encoding='UTF-8'>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/resources/css/stylefreemarker.css" />
</head>

	Dear Customer,
	<br/>
	Total price of your order is: <b>${orderdetails[0].order.amount}</b> đ
	<br/> <br/> <br/>
    <body style="width:100%;height:100%">
      <table border="1" cellspacing="0" cellpadding="0" style="width:100%;height:100%; background-color: yellow">
      <tr>
      	<td><strong>Product Id</strong></td>
		<td><strong>Product Name</strong></td>
		<td><strong>Product Price</strong></td>
		<td><strong>Product Discount</strong></td>
		<td><strong>Quantity</strong></td>
      </tr>
      
      	<#list orderdetails as orderdetail>
        	
  			<tr>
          		<td>
            	${orderdetail.product.id}
          		</td>
          		
          		<td>
            	${orderdetail.product.name}
          		</td>
          		
          		<td>
            	${orderdetail.price} đ
          		</td>
          		
          		<td>
            	${(orderdetail.discount)!"0"}
          		</td>
          		
          		<td>
            	${orderdetail.quantity}
          		</td>
        	</tr>
		</#list>
      
        
        
      </table>
      
      <br/>
      
      Thank you for purchasing.
    </body>
  </html>