const productController=require("../controllers/product.controller");
module.exports=function(app){
    app.get('/api',productController.index);
    app.post('/api/products', productController.createProduct);
    app.get('/api/products', productController.allProducts);
    app.get('/api/products/:id', productController.getProduct);

}