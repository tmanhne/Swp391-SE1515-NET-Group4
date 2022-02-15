<div class="toplinks">
    <c:if test="${sessionScope.account eq null}">
        <a data-toggle="modal" data-target="#Modal-Registration"> <i class="ion-person"></i> Registration</a>
        <a data-toggle="modal" data-target="#Modal-SignIn"> <i class="ion-person"></i> Sign In</a>
    </c:if>
    <c:if test="${sessionScope.account != null}">
        <a href="profile"> <i class="ion-person"></i> ${sessionScope.account.name}</a>
        <a href="logout"> <i class="ion-unlocked"></i> Log Out</a>
    </c:if>
    <a href="#" class="hidden-xs"> <i class="ion-android-call"></i> (123) 456-7890 </a>
</div>