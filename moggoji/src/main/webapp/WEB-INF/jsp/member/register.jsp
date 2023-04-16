<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
	<head>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<!------ Include the above in your HEAD tag ---------->
		
		<!--
		    Realised by Thibault Leveau
		    https://www.linkedin.com/in/thibault-leveau-a76923ba/
		-->
		<link rel="stylesheet" type="text/css" href="css/register.css">
	</head>

<body>
<div class="container" style="margin-top: 1em;">
    <!-- Sign up form -->
    <form>
        <!-- Sign up card -->
        <div class="card person-card">
            <div class="card-body">
                <!-- Sex image -->
                <img id="img_sex" class="person-img"
                    src="https://visualpharm.com/assets/217/Life%20Cycle-595b40b75ba036ed117d9ef0.svg">
                <h2 id="who_message" class="card-title">Who are you ?</h2>
                <!-- First row (on medium screen) -->
                <div class="row">
                    <div class="form-group col-md-2">
                        <select id="input_sex" class="form-control">
                            <option value="Mr.">Mr.</option>
                            <option value="Ms.">Ms.</option>
                        </select>
                    </div>
                    <div class="form-group col-md-5">
                        <input id="first_name" type="text" class="form-control" placeholder="First name">
                        <div id="first_name_feedback" class="invalid-feedback">
                            
                        </div>
                    </div>
                    <div class="form-group col-md-5">
                        <input id="last_name" type="text" class="form-control" placeholder="Last name">
                        <div id="last_name_feedback" class="invalid-feedback">
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-6" style="padding=0.5em;">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title">How to contact you ?</h2>
                        <div class="form-group">
                            <label for="email" class="col-form-label">Email</label>
                            <input type="email" class="form-control" id="email" placeholder="example@gmail.com" required>
                            <div class="email-feedback">
                            
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="tel" class="col-form-label">Phone number</label>
                            <input type="text" class="form-control" id="tel" placeholder="+33 6 99 99 99 99" required>
                            <div class="phone-feedback">
                            
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                
            <div class="col-md-6">
                <div class="card"> 
                    <div class="card-body">
                        <h2 class="card-title">Securize your account !</h2>
                        <div class="form-group">
                            <label for="password" class="col-form-label">Pasword</label>
                            <input type="password" class="form-control" id="password" placeholder="Type your password" required>
                            <div class="password-feedback">
                            
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password_conf" class="col-form-label">Pasword (confirm)</label>
                            <input type="password" class="form-control" id="password_conf" placeholder="Type your password again" required>
                            <div class="password_conf-feedback">
                            
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="margin-top: 1em;">
            <button type="button" class="btn btn-primary btn-lg btn-block">Sign up !</button>
        </div>
        </form>
</div>

</body>
</html>