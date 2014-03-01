<html><head><body>
<?php include "admin_insert.html";
?>
<script language="javascript" >
function fun3()
{
	
	var lname=document.forms.frm.lname.value;
	var fname=document.forms.frm.fname.value;
	


	


	
	
	if(lname=="")
	{
		alert("Enter your User Name ");
		return false;
	}


	if(fname=="")
	{
		alert("Enter  Password ");
		return false;
	}





	if(gender=="")
	{
		alert("Please Select Gender");
		return false;
	}
	if(email=="")
	{
		alert("Enter Email Address");
		return false;
	}




	if(mob=="")
	{
		alert("Enter Mobile Number");
		return false;
	}

}
</script>



<center>

<br><br>


<form  method="post" action="conn2.php" onSubmit="return fun3()" name="frm">



<table border="0">

<tbody>

<tr>
<td><label for="name"> <h5 class="tw_bullet">First Name<font color="red">*</font>  </label> </td>
<td><input id="name" maxlength="45" name="fname" type="text" /> </td>
</tr>
<tr>
<td><label for="name"> <h5 class="tw_bullet">Last Name<font color="red">*</font>  </label> </td>
<td><input id="name" maxlength="45" name="lname" type="text" /> </td>
</tr>
<tr>
<td><label for="name"> <h5 class="tw_bullet">Address<font color="red">*</font>  </label> </td>
<td><textarea id="name" maxlength="100" name="address" >Enter Your Address...</textarea> </td>
</tr>

<tr>
<td><label for="name"> <h5 class="tw_bullet">City<font color="red">*</font>  </label> </td>
<td><input id="name" maxlength="45" name="city" type="text"  /> </td>
</tr>

<tr>
<td><label for="name"> <h5 class="tw_bullet">State<font color="red">*</font>  </label> </td>
<td><input id="name" maxlength="45" name="state" type="text" /> </td>
</tr>

<tr>
<td><label for="name"> <h5 class="tw_bullet">Postal Code<font color="red">*</font>  </label> </td>
<td><input id="name" maxlength="45" name="pcode" type="text"  /> </td>
</tr>

<tr>
<td><label for="name"> <h5 class="tw_bullet">Country<font color="red">*</font>  </label> </td>
<td><input id="name" maxlength="45" name="country" type="text"  /> </td>
</tr>
<tr>
<td><label for="name"><h5 class="tw_bullet">Email<font color="red">*</font>  </label> </td>
<td><input id="name" maxlength="45" name="email" type="text" /> </td>
</tr>

<tr>
<td><label for="name"><h5 class="tw_bullet">Mobile NO<font color="red"></font>  </label> </td>
<td>+91<input id="name" maxlength="10" size="10" name="mob" type="text" /> </td>
</tr>



<tr>
<td><label for="name"> <h5 class="tw_bullet">Donation Type<font color="red">*</font> </label> </td>
<td><input type="radio" name="dtype" value="regular">Regular
<input type="radio" name="dtype" value="single">Single
</td>
</tr>

<tr>
<td><label for="name"><h5 class="tw_bullet">Amount To Donate<font color="red">*</font>  </label> </td>
<td><input id="name" maxlength="45" name="amt" type="text" /> </td>
</tr>

<tr>
<td align="right"><input type="submit" name="Submit" value="Submit" /> </td>

<td><input type="reset" value="Reset" /></td>


</tr>

</tbody></table>
</form>


<?php include "foot.html"?>

</body>
</html>
