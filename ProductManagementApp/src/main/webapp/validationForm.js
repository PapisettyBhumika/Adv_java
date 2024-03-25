function validationForm()
{
	// read the date
	var proId=documnet.getElementById("proId").value;
	var proName=documnet.getElementById("proName").value;
    var proPrice=documnet.getElementById("proPrice").value;
    var proBrand=documnet.getElementById("proBrand").value;
	var proMadeIn=documnet.getElementById("proMadeIn").value;
	 
    if(proId.trim() ==="" || proName.trim()=== ""|| proprice.trim()=== ""||proBrand.trim()===""|| proMadeIn.trim()===""){
		alert("All fields must be filled out");
		return flase
		}
		
		
		if(praseFloat(proprice)<0){
		alert("proprice must be a non-negative value");
		return false;
		}


    	if(proName.Length >50||proBrand.Lenghth >50){
		alert("Product name and ProBrand must be less than 50 characters");
		return false;
		}
		
       //get the mfg & exp dates
       var proMfgDate=document.getElementById("proMfgDate").value;
       var proExpDate=document.getElementById("proExpDate").value;
 
        //convert into date formate
        var manufacturingDateObj=new Date(proMfgDate);
        var ExpiryDateObj=new Date(proExpDate);

      //check  the validation of dates
      if(manufacturingDateObj>ExpiryDateObj)
        {
	      alert("Manufacturing date cannot be greater than expiry date.");
	      return false;
	    }
	 return true;





}