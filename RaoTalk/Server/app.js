const express = require('express');
const morgan = require('morgan');
const router = require('./router');
const app = express();

app.use(morgan('dev'));
app.use('/qgis2web1', express.static(__dirname + '/qgis2web_oneThousand'));
app.use('/qgis2web2', express.static(__dirname + '/qgis2web_twoThousand/index.html'));
app.use('/qgis2web3', express.static(__dirname + '/qgis2web_threeThousand/index.html'));
app.use('/qgis2web4', express.static(__dirname + '/qgis2web_fourThousand/index.html'));
app.use('/qgis2web5', express.static(__dirname + '/qgis2web_fiveThousand/index.html'));
app.use(router);

app.listen(5000);