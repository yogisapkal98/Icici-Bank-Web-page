var popup = new Popup();

function Popup()
{
	this.hidePopup=hidePopup;
	this.loginshow=loginshow;
	this.loginoff=loginoff;
	this.regshow=regshow;
	this.regoff=regoff;


	function loginshow()
	{
		console.log(" In js login show");
		//$(".error").css("display","block");
		$("#popup").show();
		$("#reg").hide();
		$("#login").show();
	}

	function loginoff()
	{
		console.log(" In js login off");
		$("#popup").hide();
		$("#login").hide();
		$("#loginform").trigger('reset');
		$(".error").text("");
		//$("input-box.error").remove();
		//$(".error").removeClass("error");
	}

	function regshow()
	{
		datacall.getstate();
		//datacall.getcity();
		//datacall.getcity();
		console.log(" In js reg show");
		$("#popup").show();
		$("#reg").show();
		$("#login").hide();
		//$(".error").css("display","none");
	}

	function regoff()
	{
		console.log(" In js reg off");
		$("#popup").hide();
		$("#reg").hide();
		$("#regform").trigger('reset');
		$(".error").text("");
	}



	function hidePopup()
	{
		$("#popup").hide();
		$("#login").hide();
		$("#reg").hide();
		$("#regform").trigger('reset');
		$("#loginform").trigger('reset');
		$(".error").text("");
	}

}


var datacall=new Datacall();
function Datacall()
{
	this.getstate=getstate;
	this.getcity=getcity;
	this.createAc=createAc;
	this.getbalance=getbalance;
	this.deposite=deposite;
	this.withdraw=withdraw;
	
	function getstate()
	{
		var contextpath=$("#contextpath").val();
		
		$.post(contextpath+"/ajax/ajaxcontroller.jsp",
				{
					action : "getstate",
				},
				function(tempdata)
				{
					console.log(tempdata);
					//alert(tempdata);
					var parsedata=JSON.parse(tempdata);
					var statedata=parsedata[0];
					var statedetails = '';
					
					for(var i=0;i<parsedata.length;i++)
					{
						var statedata = parsedata[i];
						statedetails+='<option value='+statedata[0]+'>';
						statedetails+=statedata[1];
						statedetails+='</option>';
					}
					$("#sid_fk").html(statedetails);
				}
		);
	}
	
	function getcity()
	{
		var contextpath=$("#contextpath").val();
		var sid_fk=$("#sid_fk").val();
		$.post(contextpath+"/ajax/ajaxcontroller.jsp",
				{
					action : "getcity",
					sid_fk : sid_fk
				},
				function(tempdata)
				{
					console.log(tempdata);
					//alert(tempdata);
					var parsedata=JSON.parse(tempdata);
					var citydata=parsedata[0];
					var citydetails = '';
					
					for(var i=0;i<parsedata.length;i++)
					{
						var citydata = parsedata[i];
						citydetails+='<option value='+citydata[0]+'>';
						citydetails+=citydata[1];
						citydetails+='</option>';
					}
					$("#cid_fk").html(citydetails);
				}
		);
	}
	
	function createAc()
	{
		var contextpath=$("#contextpath").val();
		var Uid=$("#Uid").val();
		$.post(contextpath+"/ajax/ajaxcontroller.jsp",
				{
					action : "createAc",
					Uid : Uid
				},
				function(tempdata)
				{
					console.log(tempdata);
					location.reload(true);
				}
		);
		
	}
	
	function getbalance()
	{
		var ac_no=$("#balance2").val();
		var contextpath=$("#contextpath").val();
		$.post(contextpath+"/ajax/ajaxcontroller.jsp",
				{
					action : "getbalance",
					ac_no : ac_no
				},
				function(tempdata)
				{
					console.log(tempdata);
					//alert(tempdata);
					var parsedata=JSON.parse(tempdata);
					
					
					$("#bal").html("<b>"+parsedata[0]+"</b>");
				}
		);
	}
	
	function deposite()
	{
		var ac_no=$("#balance2").val();
		var amount=$("#deposit2").val();
		var contextpath=$("#contextpath").val();
		$.post(contextpath+"/ajax/ajaxcontroller.jsp",
				{
					action : "deposite",
					ac_no : ac_no,
					amount : amount
				},
				function(tempdata)
				{
					console.log(tempdata);
					//var parsedata=JSON.parse(tempdata);
					$("#deposite").html("<b>Deposited successful</b>");
					
				}
		);
	}
	function withdraw()
	{
		var ac_no=$("#balance2").val();
		var amount=$("#withdraw2").val();
		var contextpath=$("#contextpath").val();
		$.post(contextpath+"/ajax/ajaxcontroller.jsp",
				{
					action : "withdraw",
					ac_no : ac_no,
					amount : amount
				},
				function(tempdata)
				{
					console.log(tempdata);
					//var parsedata=JSON.parse(tempdata);
					$("#withdraw").html("<b>Withdraw successful</b>");
				}
		);
	}
	
}

//Registration Form Validation
var validation = new Validation();

function Validation()
{
	this.fnamevalid=fnamevalid;
	this.lnamevalid=lnamevalid;
	this.pancardvalid=pancardvalid;
	this.aadharvalid=aadharvalid;
	this.numbervalid=numbervalid;
	this.emailvalid=emailvalid;
	this.pwdvalid=pwdvalid;
	this.formvalid=formvalid;
	this.restrictalphabets=restrictalphabets;
	this.restrict_number=restrict_number;
	this.checkTrueOnButton=checkTrueOnButton;
	this.eachtrue=eachtrue;
	this.avoidSpace=avoidSpace;

	function fnamevalid()
	{
		var name=$("#fname").val();
		var namept=/^([a-zA-Z]){3,10}$/;

		if (name==null || name==undefined || name=='')
		{
			$("#fname-error").text("*Required Field");
			return false;
		}

		else if(namept.test(name))
		{
			$("#fname-error").text("");
			return name;
		}
		else
		{
			$("#fname-error").text("First name should be 3 to 10 character");
			return false;
		}

	}
	
	function lnamevalid()
	{
		var name=$("#lname").val();
		var namept=/^([a-zA-Z]){3,10}$/;

		if (name==null || name==undefined || name=='')
		{
			$("#uname-error").text("*Required Field");
			return false;
		}

		else if(namept.test(name))
		{
			$("#uname-error").text("");
			return name;
		}
		else
		{
			$("#uname-error").text("Last name should be 3 to 10 character");
			return false;
		}

	}
	function pancardvalid()
	{
		var name=$("#pancard").val();
		var namept=/[A-Z]{5}[0-9]{2}[A-Z]{1}/;

		if (name==null || name==undefined || name=='')
		{
			$("#pancard-error").text("*Required Field");
			return false;
		}

		else if(namept.test(name))
		{
			$("#pancard-error").text("");
			return name;
		}
		else
		{
			$("#pancard-error").text("eg.Uppercase 5 character 2 digit 1 char");
			return false;
		}

	}
	
	function aadharvalid()
	{
		var name=$("#aadhar").val();
		var namept=/^[0-9]{4}[0-9]{4}[0-9]{4}$/;

		if (name==null || name==undefined || name=='')
		{
			$("#aadhar-error").text("*Required Field");
			return false;
		}

		else if(namept.test(name))
		{
			$("#aadhar-error").text("");
			return name;
		}
		else
		{
			$("#aadhar-error").text("Aadhar number should be 12 character");
			return false;
		}

	}


	function numbervalid()
	{ 
		var num=$("#number").val();
		let numpt=/^(^[789])([0-9]){9}$/;
		if (num==null || num==undefined || num=='')
		{
			$("#number-error").text("*Required Field");
			return false;
		}
		else if (numpt.test(num))
		{
			$("#number-error").text("");
			return num;
		}
		else
		{
			$("#number-error").text("*Mobile Number Must Be 10 digit eg: 789*******");
			return false;
		}
	}

	function emailvalid()
	{ 
		var email=$("#email").val();
		let regex=/^([_\-\.0-9a-zA-Z]+)@([_\-\.0-9a-zA-Z]+)\.([a-z]{2,3})$/;
		if (email==null || email==undefined || email=='')
		{
			$("#email-error").text("*Required Field");
			return false;
		}
		else if (regex.test(email))
		{
			$("#email-error").text("");
			return email;
		}
		else
		{
			$("#email-error").text("*invalid Email id");
			return false;
		}
	}


	function pwdvalid()
	{ 
		var name=$("#password").val();
		let regex=/(?=^.{6,}$)((?=.*\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))^.*/;

		if (name==null || name==undefined || name=='')
		{
			$("#pwd-error").text("*Required Field");
			return false;
		}
		else if(regex.test(name))
		{
			$("#pwd-error").text("");
			return name;
		}
		else
		{ 
			$("#pwd-error").text("Password Must contain Upper case and Special characters");
			return false;
		}
	}

	function restrictalphabets(e)
	{
		var x=e.which||e.keycode;
		if((x>=48 && x<=57)|| x==8 || (x>= 35 && x<=40) || x==47)
		{
			return true;
		}
		else
			return false;
	}

	function restrict_number(key) 
	{
		var keycode = (key.which) ? key.which : key.keyCode;

		if ((keycode > 64 && keycode < 91) || (keycode > 96 && keycode < 123))  
		{     
			return true;    
		}
		else
		{
			return false;
		}  
	}

	function checkTrueOnButton()
	{
		if(fnamevalid() || lnamevalid || pancardvalid || aadharvalid || numbervalid()|| emailvalid() || pwdvalid() )
		{
			return true;
		}
		else
		{
			return false;
		}    
	}

	function eachtrue()
    {
        if(fnamevalid() && lnamevalid() && pancardvalid() && aadharvalid() && numbervalid() && emailvalid() && pwdvalid())
        {
            return true;   
        }
        else
        {
            return false;
        }    
    }
	
	function avoidSpace(event)
	{
		var key = event.charCode;
		if(key==32)
		{
			return false;
		}
		else
		{
			return true;
		}

	}

	function formvalid(event)
	{
		var fname=$("#fname").val();
		var num=$("#number").val();
		var email=$("#email").val();
		var password=$("#password").val();

		if(validation.fnamevalid()==null && validation.fnamevalid()==undefined && validation.fnamevalid()=='')
		{
			$("#uname-error").text("*Required Field");
			return false;

		}
		else if(validation.numbervalid()==null && validation.numbervalid()==undefined && validation.numbervalid()=='')
		{
			$("#number-error").text("*Required Field");
			return false;
		}
		else if(validation.emailvalid()==null && validation.emailvalid()==undefined && validation.emailvalid()=='')
		{
			$("#email-error").text("*Required Field");
			return false;
		}
		else if(validation.pwdvalid()==null && validation.pwdvalid()==undefined && validation.pwdvalid()=='')
		{
			$("#pwd-error").text("*Required Field");
			return false;
		}
		else if(validation.fnamevalid() || validation.numbervalid() || validation.emailvalid() || validation.pwdvalid())
		{
			//$("#regform").trigger('reset');
			return true;
			$("#regform").trigger('reset');
		}
		else
		{
			return false;
			$("#regform").trigger('reset');
			event.preventDefault();
		}
	}
}


//LOGIN page validation


var loginvalidation = new LoginValidation();

function LoginValidation()
{
	this.unamevalid=unamevalid;
	this.passvalid=passvalid;
	this.Loginformvalid=Loginformvalid;

	function unamevalid()
	{
		var uname = $("#loginname").val();
		console.log("entered");
		var unamept = /^([_\-\.0-9a-zA-Z]+)@([_\-\.0-9a-zA-Z]+)\.([a-z]{2,3})$/;
		if (uname==null || uname==undefined || uname=='')
		{
			$("#unameerror").text("*Required Field");
			return false;
		}
		else if (unamept.test(uname))
		{
			$("#unameerror").text("");
			return uname;

		}
		else
		{
			$("#unameerror").text("*Enter valid Email");
			return false;
		}
	}


	function passvalid()
	{
		var uname = $("#loginpass").val();
		var passpt = /(?=^.{6,}$)((?=.*\d)(?=.*[A-Z])(?=.*[a-z])|(?=.*\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|(?=.*\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))^.*/;
		if (uname==null || uname==undefined || uname=='')
		{
			$("#passerror").text("*Required Field");
			return false;
		}
		else if (passpt.test(uname))
		{
			$("#passerror").text("");
			return uname;

		}
		else
		{
			$("#passerror").text("*Enter valid Password");
			return false;

		}
	}

	function Loginformvalid()
	{
		var fname=$("#loginname").val();
		var lname=$("#loginpass").val();

		if(loginvalidation.unamevalid()==null && loginvalidation.unamevalid()==undefined && loginvalidation.unamevalid()=='')
		{
			$("#unameerror").text("*Required");
		}
		else if(loginvalidation.passvalid()==null && loginvalidation.passvalid()==undefined && loginvalidation.passvalid()=='')
		{
			$("#passerror").text("*Required");
		}
		else if( loginvalidation.unamevalid() || loginvalidation.passvalid() )
		{
			return true;
		}
		else
		{
			$("#loginform").trigger('reset');
			event.preventDefault();
		}
	}
}

var citiesByState = {2: ["Ahmedabad","Surat","Rajkot"],1: ["Mumbai","Pune","Nashik"],4: ["kochi","Kanpur"]}
function makeSubmenu(id) {
	if(id.length==0) document.getElementById("citySelect").innerHTML = "<option></option>";
	else {
		var citiesOptions = "";
		var value = $('#'+id+' :selected').val();
		for(cityId in citiesByState[value])
		{
			citiesOptions+="<option>"+citiesByState[value][cityId]+"</option>";
		}
		document.getElementById("citySelect").innerHTML = citiesOptions;
	}
}
function displaySelected() { 
	var country = document.getElementById("countrySelect").value;
	var city = document.getElementById("citySelect").value;
	//alert(country+"\n"+city);
}
function resetSelection() {
	document.getElementById("countrySelect").selectedIndex = 0;
	document.getElementById("citySelect").selectedIndex = 0;
}


var validate = new Validate();

function Validate()
{
	this.setInfo = setInfo;

	function setInfo ()
	{
		var username =$("#email").val();

		if(username.length >= 3)
		{
			$.ajax({
				url:"check.jsp",
				type:"post",
				data:"email="+username,
				dataType:"text",
				success:function(data)
				{
					$("#email-error").html(data);
				}
			});
		}
		else
		{
			$("#email-error").html(" ");
		}

	}
}
