function setHeight(){
	var gHeight = 50 + 20 + 90 + 10;
	var bHeight = document.body.clientHeight;
	var cHeight = bHeight-gHeight;
	$("section[class=content]").attr("style","overflow-x: hidden; overflow-y: auto; height:"+cHeight+"px");
}