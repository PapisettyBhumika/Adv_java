var massRatan=parseInt(prompt("enter the mass of   ratan"));
var heightRatan=parseFloat(prompt("enter the height of the ratan"));
var massAnu=parseInt(prompt("enter the mass of anu"));
var heightAnu=parseInt(prompt("enter the height of anu"));
const BMIRatan=massRatan/(height*height);
const BMIAnu=massAnu/(height*height);
var result;
result=BMIRatan+BMIAnu;
console.log('ratan bmi${BMIRatan}');
console.log('anu ami${BMIAnu}');
document.write("value of ratan.."+BMIRatan);
document.erite("value of anu.."+BMIAnu);
if(heightRatan>heightAnu)
{
	document.write("ratan is gretaer than anu");
	
}
else
{
	document.write("anu is greater than ratan");
}