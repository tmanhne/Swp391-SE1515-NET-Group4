<div class="modal fade" id="Modal-NewPass" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><i class="ion-android-close"></i></span></button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-6">
                            <h4 class="modal-title">Set Your New Password</h4>
                            <br/>

                            <form class="join" action="recovery" method="post">
                                <input type="password" name="password" value="" placeholder="Password" required="" class="form-control" />
                                <br/>
                                <input type="password" name="confirm" value="" placeholder="Re-password" required="" class="form-control" />
                                <br/>

                                <button type="submit" class="btn btn-primary btn-sm">Confirm</button>
                            </form>
                        </div>
                        <div class="col-sm-6">
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