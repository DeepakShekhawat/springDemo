$(function (){
	
	//solving the active menu problem
	switch(menu){
	case 'About Us' :
		$('#about').addClass('active');
		break;
	
	case 'Contact Us' :
		$('#contact').addClass('active');
		break;
		
	case 'All Products' :
		$('#productLists').addClass('active');
		break;
		
	default :
		$('#productLists').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
})