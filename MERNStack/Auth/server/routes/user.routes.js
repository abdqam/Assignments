const UserController = require("../controllers/user.controller");
const auth = require('../config/jwt.config')
module.exports = app => {
    app.post('/api/register',UserController.register);
    app.post('/api/login',UserController.login);
    app.get('/api/logout',UserController.logout);
    app.get('/api/tokenuser', auth.authenticate, UserController.findUser);
    app.post('/api/createcountry',UserController.createCountry);
    app.get('/api/allcountries',UserController.allCountries);
    app.post('/api/book/new',UserController.createBook);
    app.get('/api/allbooks',UserController.findAllBooks);
    app.put('/api/addtofav/:id',UserController.addfav);
    app.get('/api/book/:id',UserController.findBook);
}