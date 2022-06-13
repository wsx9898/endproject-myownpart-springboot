<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Cart DIY</title>


<meta http-equiv="x-ua-compatible" content="ie=edge">

<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="images/favicon.ico" type="image/x-icon" />
<!-- Mobile Specific -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- CSS Style -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.css"
	media="all">
<link rel="stylesheet" type="text/css" href="css/font-face-css.css">
<link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="css/jquery.mobile-menu.css">
<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="css/revslider.css">
<!-- Google Fonts -->
<!-- Kevin CSS -->
<link rel="stylesheet" type="text/css" href="./css/kevin.css">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="./jq/jquery-3.6.0.js"></script>
<script src="./jq/jquery-migrate-1.4.1.js"></script>


</head>
<body>
	<div class="container">
		<div class="cart">
			<div class="page-title">
				<h2>Shopping Cart</h2>
			</div>
			<div class="table-responsive">
				<!-- 這邊應該是form交給後端處理 -->
				<form>
					<!-- <form method="post" action="#updatePost/"> -->
					<fieldset>
						<table class="data-table cart-table" id="shopping-cart-table">
							<thead>
								<tr class="first last">
									<th rowspan="1"></th>
									<th rowspan="1"><span class="nobr">產品名稱</span></th>
									<th rowspan="1"></th>
									<th colspan="1" class="a-center"><span class="nobr">價格</span>
									</th>
									<th class="a-center qty-middle" rowspan="1">數量</th>
									<th colspan="1" class="a-center">總價</th>
									<th class="a-center" rowspan="1"></th>
								</tr>
							</thead>
							<tfoot>
								<tr class="first last">
									<td class="a-right last" colspan="50">
										<button onclick="setLocation('#')" class="button btn-continue"
											title="Continue Shopping" type="button">
											<span>繼續購物</span>
										</button>
										<button class="button btn-update" title="Update Cart"
											value="update_qty" name="update_cart_action" type="submit">
											<span>更新購物車</span>
										</button>
										<button id="empty_cart_button" class="button btn-empty"
											title="Clear Cart" value="empty_cart"
											name="update_cart_action" type="submit">
											<span>清空購物車</span>
										</button>
									</td>
								</tr>
							</tfoot>
							<tbody id="putHere">
								<div id="jspPutHere"></div>



							</tbody>

						</table>
					</fieldset>
				</form>
			</div>
			<tr>
				<button class="appendItem btn btn-warning" id="here">測試新增商品</button>
			</tr>
		</div>




	</div>
	</div>
	<!-- JavaScript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/revslider.js"></script>
	<script src="js/common.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.mobile-menu.min.js"></script>
	<!-- JavaScript DIY-->
	<script src="./js/QtyButton.js"></script>
	<script src="./js/removeItem.js"></script>
	<script src="./js/appendItem.js"></script>



	<script type="text/javascript">
		var data;
		var ItemCnt = 1;
		CartCheckOut();

		//一開始就跟servlet要求新增的購物車了
	    function CartCheckOut() {
	        $.ajax({
	            url: "http://localhost:8080/labweb_register_0605_test_war/CartServlet",
	            method: "post",
	            data: {
	                pdaction: "cartCheckOut2",
	            },
	            success: function (res) {
	                if(res==="CharIsEmpty"){
	                    alert("目前購物車內沒有商品")
	                }else{
						console.log("res = " + res);
						alert("res = " + res);
						data = JSON.parse(res);


						data.forEach(function (e) {
							console.log("forEachWork");
							appendItem123();
						})
	                }
	            },
	            error: function () {
	                alert("cart error");
	            }
	        });
	    }

		function appendItem123(){
			console.log("ItemCnt = " + ItemCnt);
			//用這個到時候可以判斷是哪個物品要新增
			$("#putHere").append(
					`<tr class="classItem${ItemCnt}" id="item${ItemCnt}"><td class="image"><a class="product-image" title="Sample Product"
        href="#/women-s-crepe-printed-black/"><img width="75" alt="Sample Product" src="products-images/product1.jpg"></a></td></tr>`
			);
			console.log(`<tr class="classItem${ItemCnt}" id="item${ItemCnt}"><td class="image"><a class="product-image" title="Sample Product"
        href="#/women-s-crepe-printed-black/"><img width="75" alt="Sample Product" src="products-images/product1.jpg"></a></td></tr>`);

			//表示id是有加上去成功的
			$(`#item${ItemCnt}`).append(
					'<td><h2 class="product-name"><a href="#/women-s-crepe-printed-black/">測試產品</a></h2></td>'
			);

			$(`#item${ItemCnt}`).append(
					`<td class="a-center"><a title="Edit item parameters" class="edit-bnt"
         href="#configure/id/15945/"></a></td><td class="a-right"><span class="cart-price">
         <span class="price" id="price${ItemCnt}">$70.00</span></span></td>`
			);

			$(`#item${ItemCnt}`).append(
					`<td class="a-center movewishlist qty-middle">
            <form id='myform' method='POST' action='#'>
              <input type='button'value='-' class='qtyminus btn btn-success' field='quantity${ItemCnt}' onclick='minus("quantity${ItemCnt}")' />
              <input type='text' name='quantity${ItemCnt}' value='0' class=' qty' id='quantity${ItemCnt}' />
              <input type='button' value='+' class='qtyplus btn btn-success' field='quantity${ItemCnt}' onclick='plus("quantity${ItemCnt}")' />
            </form>
        </td>`
			);

			//
			$(`#item${ItemCnt}`).append(
					`<td class="a-right movewishlist"><span class="cart-price"><span class="price"id="totalPrice${ItemCnt}">$0</span></span></td>`
			);

			$(`#item${ItemCnt}`).append(
					`<td class="a-center last"><a id="remove1" class="button remove" title="Remove item" href="#">
        <span><span>Remove item</span></span></a></td>`
			);
			ItemCnt++;
		}



		//之後要塞資料
		// data[0].productName;
		// data[0].qty;
		// data[0].productImg;
		// data[0].productPrice;
		// $("#headReplace1").html(data[0].productName);
		// $("#price1").html(data[0].productPrice);
		// $('#picture1').attr("src", data[0].productImg1);
		//之後要塞資料

		//Ted產生購物欄位
		// $(function () {
		// 	$.ajax({
		// 		url: "CartServlet",
		// 		method: "get",
		// 		data: {
		// 			pdaction: "cartCheckOut2"
		// 		},
		// 		success: function (resp) {
		// 			productList = JSON.parse(resp);
		// 			let str = '';
		// 			let totalprice = 0;
		// 			productList.forEach(function (e) {
		// 				totalprice = totalprice + e.單項總額
		// 				str = str +
		// 						`<tr>
		//                 <td>` + e.productName + `</td>
		//                 <td><img src="` + e.productImg + `" width="120" /></td>
		//                 <td>` + e.productPrice + `</td>
		//                 <td>` + <button onclick="return addProductToCart(
		//                       + e.productId + );">+</button>
		// 						+ e.qty + <button onclick="return addProductToCart(
		//                       + e.productId + );">-</button> + `</td>
		//                 <td>` + e.單項總額 + `</td>
		//                 <td><button onclick="return deleteProductItemConfirm(` + e.productId + `);">刪除品項</button></td>
		//                 </tr>`
		// 			})
		// 			$('#test0608').html(str);
		// 			$('#totalpricehtml').text(totalprice);
		// 		},
		// 		error: function (resp) {
		// 			console.log(resp);
		// 		}
		// 	})
		// })
		//Ted產生購物欄位
    </script>




</body>
</html>