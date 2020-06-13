var receiverAddressObj;
var receiverNameObj;
var receiverEmailObj;

window.onload = function() {	// 页面加载之后, 获取页面中的对象
	receiverAddressObj = document.getElementById("receiverAddress");
	receiverNameObj = document.getElementById("receiverName");
	receiverEmailObj = document.getElementById("receiverEmail");
};

function checkOnSubmit() {			// 验证整个表单
	var receiverAddress = checkReceiverAddress();
	var receiverName = checkReceiverName();
	var receiverEmail = checkReceiverEmail();
	if(receiverAddress && receiverName && receiverEmail){
		document.getElementById("orderForm").submit();
	}else{
	   return "";
	}
}

function checkReceiverAddress() {			// 验证收获地址
	var value =receiverAddressObj.value;
	var msg = "";
	if (!value)
		msg = "*";	
	receiverAddressMsg.innerHTML = msg;
	receiverAddressObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

function checkReceiverName() {		// 验证收货人
	var value =receiverNameObj.value;
	var msg = "";
	if (!value)
		msg = "*";	
	receiverNameMsg.innerHTML = msg;
	receiverNameObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}

function checkReceiverEmail() {		// 验证联系方式
	var regex = /^[\w-]+@([\w-]+\.)+[a-zA-Z]{2,4}$/;
	var value = receiverEmailObj.value;
	var msg = "";
	if (!value)
		msg = "*";
	else if (!regex.test(value))
		msg = "*";
	receiverEmailMsg.innerHTML = msg;
	receiverEmailObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg == "";
}
