<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="star-rating">
	<input type="radio" name="example" class="rating" value="1" />
	<input type="radio" name="example" class="rating" value="2" />
	<input type="radio" name="example" class="rating" value="3" />
	<input type="radio" name="example" class="rating" value="4" />
	<input type="radio" name="example" class="rating" value="5" />
</div>
<span class="stars">4.8618164</span>
<span class="stars">2.6545344</span>
<span class="stars">0.5355</span>
<span class="stars">8</span>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />


<script type="text/javascript">
	$(document).ready(function() {
		$('#star-rating').rating(function(vote, event) {

			sendvote(vote);
		});
		
		$(function() {
		    $('span.stars').stars();
		});
	});
	
	
	$.fn.stars = function() {
	    return $(this).each(function() {
	        // Get the value
	        var val = parseFloat($(this).html());
	        // Make sure that the value is in 0 - 5 range, multiply to get width
	        var size = Math.max(0, (Math.min(5, val))) * 16;
	        // Create stars holder
	        var $span = $('<span />').width(size);
	        // Replace the numerical value with stars
	        $(this).html($span);
	    });
	}

	function getXMLHttpRequest() {
		var xmlHttpReq = false;
		if (window.XMLHttpRequest) {
			xmlHttpReq = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			try {
				xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (exp1) {
				try {
					xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (exp2) {
					xmlHttpReq = false;
				}
			}
		}
		return xmlHttpReq;
	}

	function sendvote(vote) {
		var xmlHttpRequest = getXMLHttpRequest();
		xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);

		var queryString = "/" + vote;

		xmlHttpRequest.open("GET",
				"${pageContext.request.contextPath}/views/sendvote"
						+ queryString, true);
		xmlHttpRequest.send();
	}

	function getReadyStateHandler(xmlHttpRequest) {
		return function() {

			if (xmlHttpRequest.readyState == 4) {
				if (xmlHttpRequest.status == 200) {

					console.log(xmlHttpRequest.responseText);
					/* document.getElementById("productsajax").innerHTML = xmlHttpRequest.responseText; */

				} else {
					alert("HTTP error " + xmlHttpRequest.status + ": "
							+ xmlHttpRequest.statusText);
				}
			}
		};
	}
</script>