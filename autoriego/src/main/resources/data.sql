INSERT INTO CULTIVO(TIPO, AGUA) VALUES('Arroz',10);
INSERT INTO CULTIVO(TIPO, AGUA) VALUES('Tabaco',5);
INSERT INTO CULTIVO(TIPO, AGUA) VALUES('Cebada',20);

INSERT INTO MANGUERA(ID_MANGUERA,CAUDAL,EN_USO) VALUES (1,2,0);
INSERT INTO MANGUERA(ID_MANGUERA,CAUDAL,EN_USO) VALUES (2,10,0);

INSERT INTO PARCELA(ID_PARCELA, FIN_AGUA,CULTIVO_TIPO,EN_USO) VALUES(1, parsedatetime('15-09-2020 00:00:00.00', 'dd-MM-yyyy hh:mm:ss.SS') , 'Arroz',0);
INSERT INTO PARCELA(ID_PARCELA, FIN_AGUA,CULTIVO_TIPO,EN_USO) VALUES(2, parsedatetime('15-09-2020 00:00:00.00', 'dd-MM-yyyy hh:mm:ss.SS') , 'Tabaco',0);
INSERT INTO PARCELA(ID_PARCELA, FIN_AGUA,CULTIVO_TIPO,EN_USO) VALUES(3, parsedatetime('15-09-2020 00:00:00.00', 'dd-MM-yyyy hh:mm:ss.SS') , 'Cebada',0);
INSERT INTO PARCELA(ID_PARCELA, FIN_AGUA,CULTIVO_TIPO,EN_USO) VALUES(4, parsedatetime('15-09-2020 00:00:00.00', 'dd-MM-yyyy hh:mm:ss.SS') , 'Arroz',0);