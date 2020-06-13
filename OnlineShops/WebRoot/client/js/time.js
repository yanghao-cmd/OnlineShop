// 统计用户 访问网站步骤记录
var tjSecond = 0;
var tjRandom = 0;
window.setInterval(function () {
    tjSecond ++;
}, 1000);
// 随机数
tjRandom = (new Date()).valueOf();
// 用户第一次访问页面记录部分数据
window.onload = function () {
    var tjArr = localStorage.getItem("jsArr") ? localStorage.getItem("jsArr") : '[]';
    var dataArr = {
        'tjRd' : tjRandom,
        'url' : location.href,
        'refer' : getReferrer()
    };
    tjArr = eval('(' + tjArr + ')');
    tjArr.push(dataArr);
    var tjArr1= JSON.stringify(tjArr);
    localStorage.setItem("jsArr", tjArr1);
};
// 用户继续访问根据上面提供的key值补充数据
window.onbeforeunload = function() {
    var tjArrRd = eval('(' + localStorage.getItem("jsArr") + ')');
    var tjI = tjArrRd.length - 1;
    if(tjArrRd[tjI].tjRd == tjRandom){
        tjArrRd[tjI].time = tjSecond;
        tjArrRd[tjI].timeIn = Date.parse(new Date()) - (tjSecond * 1000);
        tjArrRd[tjI].timeOut = Date.parse(new Date());
        var tjArr1= JSON.stringify(tjArrRd);
        localStorage.setItem("jsArr", tjArr1);    
    }
};
function result(){
	var time = localStorage.getItem("jsArr");
    time = JSON.parse(time);
    return console.log(time);
}
 
function getReferrer() {
    var referrer = '';
    try {
        referrer = window.top.document.referrer;
    } catch(e) {
        if(window.parent) {
            try {
                referrer = window.parent.document.referrer;
            } catch(e2) {
                referrer = '';
            }
        }
    }
    if(referrer === '') {
        referrer = document.referrer;
    }
    return referrer;
}