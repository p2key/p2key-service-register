SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


--
-- Veritabaný: `serviceregister`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapýsý `owners`
--

CREATE TABLE `owners` (
  `ID` bigint(11) NOT NULL,
  `NAME` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `CREATED_BY` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(200) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `owners`
--

INSERT INTO `owners` (`ID`, `NAME`, `CREATE_DATE`, `CREATED_BY`, `UPDATE_DATE`, `UPDATED_BY`) VALUES
(2, 'Mobil Ekip', '2020-10-24 12:14:04', 'Mesut', NULL, NULL);

-- --------------------------------------------------------

--
-- Tablo için tablo yapýsý `promotions`
--

CREATE TABLE `promotions` (
  `ID` bigint(20) NOT NULL,
  `OPERATION` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `ENDPOINT` varchar(500) COLLATE utf8_turkish_ci NOT NULL,
  `ENVIRONMENT` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `TIMEOUT` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `promotions`
--

INSERT INTO `promotions` (`ID`, `OPERATION`, `ENDPOINT`, `ENVIRONMENT`, `TIMEOUT`) VALUES
(1, 'INSERT', 'http://localhost:8080/service/insert', 'TEST', 5);

-- --------------------------------------------------------

--
-- Tablo için tablo yapýsý `services`
--

CREATE TABLE `services` (
  `ID` bigint(20) NOT NULL,
  `OWNER_ID` bigint(20) NOT NULL,
  `NAME` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `TYPE` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `VERSION` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `CONTENT` text COLLATE utf8_turkish_ci NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `CREATED_BY` varchar(200) COLLATE utf8_turkish_ci NOT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(200) COLLATE utf8_turkish_ci DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `services`
--

INSERT INTO `services` (`ID`, `OWNER_ID`, `NAME`, `TYPE`, `VERSION`, `CONTENT`, `CREATE_DATE`, `CREATED_BY`, `UPDATE_DATE`, `UPDATED_BY`, `IS_ACTIVE`) VALUES
(3, 2, 'DemoService', 'SOAP', '1', 'PHNvYXBlbnY6RW52ZWxvcGUgeG1sbnM6c29hcGVudj0iaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvc29hcC9lbnZlbG9wZS8iIHhtbG5zOmx0bT0iaHR0cDovL2V4dGVybmFsc2l0ZS5jb20vbHRtLyI+Cjxzb2FwZW52OkhlYWRlci8+Cjxzb2FwZW52OkJvZHk+Cjwvc29hcGVudjpCb2R5Pg==', '2020-10-24 14:35:29', 'Mesut', NULL, NULL, 1),
(4, 2, 'PassiveService', 'REST', '1', 'ewogICJkZW5lbWUiOiAiZGVuZW1lIgp9', '2020-10-24 10:34:26', 'Mesut', NULL, NULL, 0),
(5, 2, 'NewService', 'SOAP', '1', 'deneme', '2020-11-13 01:24:41', 'Mesut', NULL, NULL, 0);

--
-- Dökümü yapýlmýþ tablolar için indeksler
--

--
-- Tablo için indeksler `owners`
--
ALTER TABLE `owners`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `promotions`
--
ALTER TABLE `promotions`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `NAME` (`NAME`),
  ADD KEY `OWNER_ID` (`OWNER_ID`);

--
-- Dökümü yapýlmýþ tablolar için AUTO_INCREMENT deðeri
--

--
-- Tablo için AUTO_INCREMENT deðeri `owners`
--
ALTER TABLE `owners`
  MODIFY `ID` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Tablo için AUTO_INCREMENT deðeri `promotions`
--
ALTER TABLE `promotions`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Tablo için AUTO_INCREMENT deðeri `services`
--
ALTER TABLE `services`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Dökümü yapýlmýþ tablolar için kýsýtlamalar
--

--
-- Tablo kýsýtlamalarý `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `services_ibfk_1` FOREIGN KEY (`OWNER_ID`) REFERENCES `owners` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
