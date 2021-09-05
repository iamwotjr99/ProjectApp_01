const express = require('express');
const morgan = require('morgan');
const router = require('./router');
const app = express();

app.use(morgan('dev'));
app.use('/wotjr', express.static(__dirname + '/qgis2web'));
app.use(router);

app.listen(3000);