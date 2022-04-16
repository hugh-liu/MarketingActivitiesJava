const {
	ElMessage
} = ElementPlus;

/**
 * 获取url值
 * @param key
 * @returns
 */
getUrlValue = function(key) {
	var value = "";
	var values = window.location.href.slice(window.location.href.indexOf('?') + 1).split('#')[0].split('&');
	for (var i = 0; i < values.length; i++) {
		var v = values[i].split("=");
		if (v[0] === key) {
			value = v[1];
		}
	}
	return value;
}

/**
 * 获取当前时间，格式yyyy-MM-dd HH:mm:ss
 * @returns
 */
getDateTime = function() {
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = year + seperator1 + month + seperator1 + strDate + ' ' + fnW(hour) + seperator2 + fnW(minute) + seperator2 + fnW(second);
	return currentdate;
}

/**
 * 获取当前时间，格式yyyy-MM-dd HH:mm
 * @returns
 */
getDateTimeTwo = function() {
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	var currentdate = year + seperator1 + month + seperator1 + strDate + ' ' + fnW(hour) + seperator2 + fnW(minute);
	return currentdate;
}

/**
 * 转换日期时间选择器
 */
formatDate = function(date) {
	  const time = new Date(Date.parse(date));
	  time.setTime(time.setHours(time.getHours()));
	  const Y = time.getFullYear() + '-';
	  const M = time.getMonth() + 1 < 10 ? '0' + (time.getMonth() + 1) + '-' : (time.getMonth() + 1) + '-';
	  const D = time.getDate() < 10 ? '0' + time.getDate() + ' ' : time.getDate() + ' ';
	  const h = time.getHours() < 10 ? '0' + time.getHours() + ':' : time.getHours() + ':';
	  const m = time.getMinutes() < 10 ? '0' + time.getMinutes() + ':' : time.getMinutes() + ':';
	  const s = time.getSeconds() < 10 ? '0' + time.getSeconds() : time.getSeconds();
	  return Y + M + D + h + m + s;
}

/**
 * 转换日期时间选择器
 */
formatDatee = function(date) {
	  const time = new Date(Date.parse(date));
	  time.setTime(time.setHours(time.getHours()));
	  const Y = time.getFullYear() + '-';
	  const M = time.getMonth() + 1 < 10 ? '0' + (time.getMonth() + 1) + '-' : (time.getMonth() + 1) + '-';
	  const D = time.getDate() < 10 ? '0' + time.getDate() + ' ' : time.getDate() + ' ';
	  const h = time.getHours() < 10 ? '0' + time.getHours() + ':' : time.getHours() + ':';
	  const m = time.getMinutes() < 10 ? '0' + time.getMinutes() + ':' : time.getMinutes() + ':';
	  const s = time.getSeconds() < 10 ? '0' + time.getSeconds() : time.getSeconds();
	  return Y + M + D ;
}

/**
 * 补位 当某个字段不是两位数时补0
 * @param {Object} str
 */
function fnW(str) {
	var num;
	str >= 10 ? num = str : num = "0" + str;
	return num;
}

/**
 * 获取年份
 */
getYear = function() {
	var date = new Date();
	var year = date.getFullYear();
	return year;
}

/**
 * 获取月份
 */
getMonth = function() {
	var date = new Date();
	var month = date.getMonth();
	return month;
}

/**
 * 获取天
 */
getStrDate = function() {
	var date = new Date();
	var strDate = date.getDate();
	return strDate;
}

/**
 * 获取当前小时
 */
getHours = function() {
	var date = new Date();
	var hours = date.getHours();
	return hours;
}

/**
 * 获取当前分钟
 */
getMinutes = function() {
	var date = new Date();
	var minutes = date.getMinutes();
	return minutes;
}

/**
 * 获取当前秒
 */
getSeconds = function() {
	var date = new Date();
	var seconds = date.getSeconds();
	return seconds;
}