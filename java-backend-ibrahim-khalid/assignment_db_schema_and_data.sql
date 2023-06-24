--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_type` varchar(45) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `account`
--

INSERT INTO `account` VALUES (1,'current','0012250016001'),(2,'saving','0012250016002'),(3,'current','0012250016003'),(4,'current','0012250016004'),(5,'saving','0012250016005');


--
-- Table structure for table `statement`
--

CREATE TABLE `statement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `amount` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_account_id_idx` (`account_id`),
  CONSTRAINT `fk_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

--
-- Dumping data for table `statement`
--
INSERT INTO `statement` VALUES (1,3,'06.04.2021','535.197875027054'),(2,4,'14.05.2021','967.410308637791'),(3,3,'20.05.2021','623.461804295262'),(4,3,'26.05.2021','330.455004587924'),(5,3,'01.06.2021','125.51573044332'),(6,4,'02.06.2021','256.292396032404'),(7,3,'09.06.2021','87.8901139771573'),(8,4,'17.07.2021','386.908121686113'),(9,1,'01.08.2021','196.801905945903'),(10,5,'08.08.2021','997.740129408144'),(11,5,'09.08.2021','292.451273402434'),(12,5,'11.08.2021','909.756451622344'),(13,1,'29.08.2021','869.966470373683'),(14,1,'03.09.2021','578.931756366243'),(15,4,'09.09.2021','798.090576128434'),(16,3,'12.09.2021','760.885124474776'),(17,2,'26.09.2021','841.608978747379'),(18,5,'27.09.2021','332.660036781236'),(19,5,'30.09.2021','809.629016115109'),(20,2,'01.10.2021','724.478364643263'),(21,2,'02.10.2021','59.0315005915503'),(22,4,'05.10.2021','501.921910891848'),(23,3,'10.10.2021','320.113318991709'),(24,3,'11.10.2021','564.982890505824'),(25,3,'13.10.2021','350.793682741483'),(26,2,'21.10.2021','565.393814545184'),(27,4,'01.11.2021','841.608978747379'),(28,2,'02.11.2021','203.481930294487'),(29,1,'03.11.2021','191.608098447429'),(30,4,'04.11.2021','704.496796898777'),(31,4,'15.11.2021','45.2525260642709'),(32,2,'17.11.2021','166.470541608144'),(33,2,'21.11.2021','590.976648547384'),(34,5,'29.11.2021','43.6814104471397'),(35,4,'13.10.2021','506.220599737549'),(36,3,'21.10.2021','971.65314918067'),(37,5,'09.12.2021','120.960701706629'),(38,5,'12.12.2021','75.6675618542309'),(39,1,'18.12.2021','304.375774283414'),(40,3,'20.12.2021','369.407670060882');