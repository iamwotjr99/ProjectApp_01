const express = require('express');
const morgan = require('morgan');
const router = require('./router');
const app = express();

app.use(morgan('dev'));
app.use('/qgis2web1', express.static(__dirname + '/qgis2web_oneThousand'));
app.use(router);

app.listen(5000);