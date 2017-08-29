// Get today's date
var todaysDate = new Date();

if (arr[i].discountStartDate != null && arr[i].discountEndDate != null
		&& arr[i].discount != null) {
	// Create date from input value
	var discountStartDate = new Date(arr[i].discountStartDate);
	var discountEndDate = new Date(arr[i].discountEndDate);
	// call setHours to take the time out of the comparison
	if (discountStartDate.setHours(0, 0, 0, 0) < todaysDate
			.setHours(0, 0, 0, 0)
			&& todaysDate.setHours(0, 0, 0, 0) < discountEndDate.setHours(0, 0,
					0, 0)) {

		// discount
		out += '									<i>' + arr[i].price + 'đ</i>'
				+ '									<span class="item_price">' + arr[i].price
				* (1 - arr[i].discount) + 'đ									</span>';

	} else {
		// ko discount

		out += '									<span class="item_price">' + arr[i].price
				+ 'đ									</span>';
	}
} else {
	// ko discount
	out += '									<span class="item_price">' + arr[i].price
			+ 'đ									</span>';
}