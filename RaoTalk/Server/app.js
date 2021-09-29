const express = require('express');
const morgan = require('morgan');
const router = require('./router');
const app = express();

app.use(morgan('dev'));
<<<<<<< HEAD
app.use('/qgis2web1', express.static(__dirname + '/qgis2web_oneThousand'));
=======
app.use('/qgis2web0', express.static(__dirname + '/qgis2web_total'));
app.use('/qgis2web1', express.static(__dirname + '/qgis2web_oneThousand'));
app.use('/qgis2web2', express.static(__dirname + '/qgis2web_twoThousand'));
app.use('/qgis2web3', express.static(__dirname + '/qgis2web_threeThousand'));
app.use('/qgis2web4', express.static(__dirname + '/qgis2web_fourThousand'));
app.use('/qgis2web5', express.static(__dirname + '/qgis2web_fiveThousand'));
>>>>>>> 96c478fcbced409d31dc112b8a15843456f79f8b
app.use(router);

app.listen(3000);