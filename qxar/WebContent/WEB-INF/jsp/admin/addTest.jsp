<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@include file="/adminCommon/header.jsp"%>
<div class="main-container" id="main-container">
	<div class="main-container-inner">
		<!-- 左边菜单栏 -->
		<%@include file="/adminCommon/nav.jsp"%>
		<!-- HTML主页 -->
		<div class="main-content">
			<!-- 头部提示 -->
			<div class="breadcrumbs" id="breadcrumbs">
				<ul class="breadcrumb">
					<li>
						<i class="icon-home home-icon"></i>
						<a href="#">企秀AR管理平台</a>
					</li>
					<li>
						<a href="#">发现管理</a>
					</li>
					<li class="active">发现列表</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<!-- 列表主页 -->
			<div class="page-content">
				<!-- 虚线分割 -->
				<div class="hr hr-18 dotted hr-double"></div>
				<!-- PAGE CONTENT BEGINS -->
				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<!-- 添加的form表单 -->


						<form class="form-horizontal" id="validation-form" method="get">
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="email">Email Address:</label>
								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="email" name="email" id="email" class="col-xs-12 col-sm-6" />
									</div>
								</div>
							</div>

							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="password">Password:</label>

								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="password" name="password" id="password" class="col-xs-12 col-sm-4" />
									</div>
								</div>
							</div>

							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="password2">Confirm Password:</label>

								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="password" name="password2" id="password2" class="col-xs-12 col-sm-4" />
									</div>
								</div>
							</div>

							<div class="hr hr-dotted"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="name">Company Name:</label>

								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="text" id="name" name="name" class="col-xs-12 col-sm-5" />
									</div>
								</div>
							</div>

							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="phone">Phone Number:</label>

								<div class="col-xs-12 col-sm-9">
									<div class="input-group">
										<span class="input-group-addon">
											<i class="icon-phone"></i>
										</span>

										<input type="tel" id="phone" name="phone" />
									</div>
								</div>
							</div>

							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="url">Company URL:</label>

								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<input type="url" id="url" name="url" class="col-xs-12 col-sm-8" />
									</div>
								</div>
							</div>

							<div class="hr hr-dotted"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right">Subscribe to</label>

								<div class="col-xs-12 col-sm-9">
									<div>
										<label>
											<input name="subscription" value="1" type="checkbox" class="ace" />
											<span class="lbl"> Latest news and announcements</span>
										</label>
									</div>

									<div>
										<label>
											<input name="subscription" value="2" type="checkbox" class="ace" />
											<span class="lbl"> Product offers and discounts</span>
										</label>
									</div>
								</div>
							</div>

							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right">Gender</label>

								<div class="col-xs-12 col-sm-9">
									<div>
										<label class="blue">
											<input name="gender" value="1" type="radio" class="ace" />
											<span class="lbl"> Male</span>
										</label>
									</div>

									<div>
										<label class="blue">
											<input name="gender" value="2" type="radio" class="ace" />
											<span class="lbl"> Female</span>
										</label>
									</div>
								</div>
							</div>

							<div class="hr hr-dotted"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="state">State</label>
								<div class="col-xs-12 col-sm-9">
									<select id="state" name="state" class="select2" data-placeholder="Click to Choose...">
										<option value="">&nbsp;</option>
										<option value="AL">Alabama</option>
										<option value="AK">Alaska</option>
										<option value="AZ">Arizona</option>
										<option value="AR">Arkansas</option>
										<option value="CA">California</option>
										<option value="CO">Colorado</option>
										<option value="CT">Connecticut</option>
										<option value="DE">Delaware</option>
										<option value="FL">Florida</option>
										<option value="GA">Georgia</option>
										<option value="HI">Hawaii</option>
										<option value="ID">Idaho</option>
										<option value="IL">Illinois</option>
										<option value="IN">Indiana</option>
										<option value="IA">Iowa</option>
										<option value="KS">Kansas</option>
										<option value="KY">Kentucky</option>
										<option value="LA">Louisiana</option>
										<option value="ME">Maine</option>
										<option value="MD">Maryland</option>
										<option value="MA">Massachusetts</option>
										<option value="MI">Michigan</option>
										<option value="MN">Minnesota</option>
										<option value="MS">Mississippi</option>
										<option value="MO">Missouri</option>
										<option value="MT">Montana</option>
										<option value="NE">Nebraska</option>
										<option value="NV">Nevada</option>
										<option value="NH">New Hampshire</option>
										<option value="NJ">New Jersey</option>
										<option value="NM">New Mexico</option>
										<option value="NY">New York</option>
										<option value="NC">North Carolina</option>
										<option value="ND">North Dakota</option>
										<option value="OH">Ohio</option>
										<option value="OK">Oklahoma</option>
										<option value="OR">Oregon</option>
										<option value="PA">Pennsylvania</option>
										<option value="RI">Rhode Island</option>
										<option value="SC">South Carolina</option>
										<option value="SD">South Dakota</option>
										<option value="TN">Tennessee</option>
										<option value="TX">Texas</option>
										<option value="UT">Utah</option>
										<option value="VT">Vermont</option>
										<option value="VA">Virginia</option>
										<option value="WA">Washington</option>
										<option value="WV">West Virginia</option>
										<option value="WI">Wisconsin</option>
										<option value="WY">Wyoming</option>
									</select>
								</div>
							</div>

							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="platform">Platform</label>

								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<select class="input-medium" id="platform" name="platform">
											<option value="">------------------</option>
											<option value="linux">Linux</option>
											<option value="windows">Windows</option>
											<option value="mac">Mac OS</option>
											<option value="ios">iOS</option>
											<option value="android">Android</option>
										</select>
									</div>
								</div>
							</div>

							<div class="space-2"></div>

							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right" for="comment">Comment</label>

								<div class="col-xs-12 col-sm-9">
									<div class="clearfix">
										<textarea class="input-xlarge" name="comment" id="comment"></textarea>
									</div>
								</div>
							</div>

							<div class="space-8"></div>

							<div class="form-group">
								<div class="col-xs-12 col-sm-4 col-sm-offset-3">
									<label>
										<input name="agree" id="agree" type="checkbox" class="ace" />
										<span class="lbl"> I accept the policy</span>
									</label>
								</div>
							</div>
							<button class="btn btn-success btn-sm btn-next" data-last="Finish ">
								Next
								<i class="icon-arrow-right icon-on-right"></i>
							</button>
						</form>
						<!-- PAGE CONTENT ENDS -->


					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
		</div>
		<!-- /.page-content -->
	</div>
	<!-- /.main-container-inner -->
</div>
<!-- /.main-container -->
<script type="text/javascript">
	$(document).ready(function() {
		$.mask.definitions['~'] = '[+-]';
		 $(".select2").css('width', '200px').select2({allowClear: true})
         .on('change', function () {
             $(this).closest('form').validate().element($(this));
         });
		$('#phone').mask('(999) 999-9999');
		jQuery.validator.addMethod("phone", function(value, element) {
			return this.optional(element) || /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
		}, "Enter a valid phone number.");
		$('#validation-form').validate({
			errorElement : 'div',
			errorClass : 'help-block',
			focusInvalid : false,
			rules : {
				email : {
					required : true,
					email : true
				},
				password : {
					required : true,
					minlength : 5
				},
				password2 : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				},
				name : {
					required : true
				},
				phone : {
					required : true,
					phone : 'required'
				},
				url : {
					required : true,
					url : true
				},
				comment : {
					required : true
				},
				state : {
					required : true
				},
				platform : {
					required : true
				},
				subscription : {
					required : true
				},
				gender : 'required',
				agree : 'required'
			},

			messages : {
				email : {
					required : "请输入正确的邮箱",
					email : "Please provide a valid email."
				},
				password : {
					required : "Please specify a password.",
					minlength : "Please specify a secure password."
				},
				subscription : "Please choose at least one option",
				gender : "Please choose gender",
				agree : "Please accept our policy"
			},

			invalidHandler : function(event, validator) { //display error alert on form submit   
				$('.alert-danger', $('.login-form')).show();
			},

			highlight : function(e) {
				$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
			},

			success : function(e) {
				$(e).closest('.form-group').removeClass('has-error').addClass('has-info');
				$(e).remove();
			},

			errorPlacement : function(error, element) {
				if (element.is(':checkbox') || element.is(':radio')) {
					var controls = element.closest('div[class*="col-"]');
					if (controls.find(':checkbox,:radio').length > 1)
						controls.append(error);
					else
						error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
				} else if (element.is('.select2')) {
					error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
				} else if (element.is('.chosen-select')) {
					error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
				} else
					error.insertAfter(element.parent());
			},
			submitHandler : function(form) {
				
			}
		});

	});
</script>
 <script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.maskedinput.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/ace/js/select2.min.js"></script>
<%@include file="/adminCommon/footer.jsp"%>