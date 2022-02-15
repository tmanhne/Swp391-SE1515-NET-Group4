<div class="cart" data-toggle="inactive">
    <div class="label">
        <i class="ion-bag">
        </i> 
    </div>

    <div class="overlay"></div>

    <div class="window">
        <div class="title">
            <button type="button" class="close"><i class="ion-android-close"></i></button>
            <h4>Shopping cart</h4>
        </div>

        <div class="content">
            <c:forEach var="o" items="${sessionScope.cart.items}">
                <div class="media">
                    <div class="media-left">
                        <a href="detailProduct?pid=${o.product.id}">
                            <img class="media-object" src="${o.product.firstImage.image}"/>
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">${o.product.name}</h4>
                        <p>${o.product.category.name}</p>
                        <label>$ ${o.price}</label>
                    </div>
                    <div class="controls">
                        <div class="input-group">
                            <span class="input-group-btn">
                                <a href="minus?pid=${o.product.id}">
                                    <button class="btn btn-default btn-sm" type="button" data-action="minus"><i class="ion-minus-round"></i></button>
                                </a>
                            </span>
                            <input type="text" class="form-control input-sm" name="quantity" value="${o.quantity}" readonly="">
                            <span class="input-group-btn">
                                <a href="plus?pid=${o.product.id}">
                                    <button class="btn btn-default btn-sm" type="button" data-action="plus"><i class="ion-plus-round"></i></button>
                                </a>
                            </span>
                        </div><!-- /input-group -->

                        <a href="removeProductFromCart?pid=${o.product.id}"> <i class="ion-trash-b"></i> Remove </a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="checkout container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-12 align-right">
                    <a class="btn btn-primary" href="checkOut"> Checkout order </a>
                </div>
            </div>
        </div>
    </div>
</div>