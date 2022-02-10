<div class="modal fade" id="Modal-ForgotPassword" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="ion-android-close"></i></span></button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                            <h4 class="modal-title">Forgot Your Password?</h4>
                            <br/>

                            <form class="join" action="forgotpassword" method="post">
                                <input type="email" name="email" value="" placeholder="E-mail" required="" class="form-control" />
                                <br/>
                                <input type="text" name="name" value="" placeholder="Name" required="" class="form-control" />
                                <br/>

                                <button type="submit" class="btn btn-primary btn-sm">Continue</button>
                                <a href="#Modal-SignIn" data-action="Sign-In">Back ></a>
                            </form>
                        </div>
                        <div class="col-sm-6">
                            <br/>
                            <br/>
                            <p>
                                Enter the e-mail address associated with your account. Click submit to have your password e-mailed to you.
                            </p>
                            <br/>
                            <p style="color: red; font-size: 1.2em">${requestScope.error}</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>