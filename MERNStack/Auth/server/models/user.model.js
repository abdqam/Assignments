const mongoose = require('mongoose');
const bcrypt = require('bcrypt');

const UserSchema = new mongoose.Schema(
    {
    firstName: {
        type: String,
        required: [true, "First name is required"],
    },
    lastName: {
        type: String,
        required: [true, "Last name is required"],
    },
    email: {
        type: String,
        required: [true, "Email is required"],
        validate: {
        validator: (val) => /^([\w-\.]+@([\w-]+\.)+[\w-]+)?$/.test(val),
        message: "Please enter a valid email",
        },
    },
    country:{ type: mongoose.Schema.Types.ObjectId, ref: 'Country' },
    books:[{ type:mongoose.Schema.Types.ObjectId, ref: 'Book' }],
    password: {
        type: String,
        required: [true, "Password is required"],
        minlength: [8, "Password must be 8 characters or longer"],
    },
    },{ timestamps: true }
);
UserSchema.pre('save', function(next) {
    bcrypt.hash(this.password, 10)
    .then(hash => {
        this.password = hash;
        next();
    });
});
module.exports.User = mongoose.model('User', UserSchema);

const CountrySchema = new mongoose.Schema({
    name: {
        type: String,
        required: [true, "Country name is required"],
    }
},{ timestamps: true }
);
module.exports.Country = mongoose.model('Country', CountrySchema);
const BookSchema = new mongoose.Schema({
    name: {
        type: String,
        required: [true, "Book Name is required"],
    }
},{ timestamps: true });
module.exports.Book = mongoose.model('Book', BookSchema);