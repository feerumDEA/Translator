package com.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Inwentura {
	public static void traslateInwentura(String pathToFile) throws IOException {
		Workbook workbook = null;
		workbook = WorkbookFactory.create(new File(pathToFile));
		workbook.cloneSheet(0);
		Sheet sheet = workbook.getSheetAt(1);
		sheet.forEach(row -> {
			row.forEach(cell -> {
				if (cell.getCellType() == CellType.STRING) {
					String input = cell.getStringCellValue();
					if (input.contains("SZAFKA SOND TEMP. Z MODUŁEM"))
						cell.setCellValue(cell.getStringCellValue().replace("SZAFKA SOND TEMP. Z MODUŁEM", "Шкаф ЗОНД ТЕМП. С МОДУЛЕМ"));
					if (input.contains("Kaseta sterujaca"))
						cell.setCellValue(cell.getStringCellValue().replace("Kaseta sterujaca", "Управляющая касета"));
					if (input.contains("PUSZKA INSTALACYJNA"))
						cell.setCellValue(cell.getStringCellValue().replace("PUSZKA INSTALACYJNA", " электрическая коробка ИНСТ."));
					if (input.contains("PUSZKA INST."))
						cell.setCellValue(cell.getStringCellValue().replace("PUSZKA INST.", " электрическая коробка ИНСТ."));
					if (input.contains("indeks"))
						cell.setCellValue(cell.getStringCellValue().replace("indeks", "Индекс"));
					if (input.contains("nazwa"))
						cell.setCellValue(cell.getStringCellValue().replace("nazwa", "Название"));
					if (input.contains("ilość"))
						cell.setCellValue(cell.getStringCellValue().replace("ilość", "количество"));
					if (input.contains("jm."))
						cell.setCellValue(cell.getStringCellValue().replace("jm.", "Единица"));
					if (input.contains("obiekt"))
						cell.setCellValue(cell.getStringCellValue().replace("obiekt", "объект"));
					if (input.contains("paleta"))
						cell.setCellValue(cell.getStringCellValue().replace("paleta", "поддон"));
					if (input.contains("waga"))
						cell.setCellValue(cell.getStringCellValue().replace("waga", "вес"));
					if (input.contains("Data wysyłki"))
						cell.setCellValue(cell.getStringCellValue().replace("Data wysyłki", "Дата отправки"));
					
					if (input.contains("uwagi"))
						cell.setCellValue(cell.getStringCellValue().replace("uwagi", "Примечания"));
					if (input.contains("Auto"))
						cell.setCellValue(cell.getStringCellValue().replace("Auto", "Авто"));
					if (input.contains("KABEL"))
						cell.setCellValue(cell.getStringCellValue().replace("KABEL", "КАБЕЛЬ"));
					if (input.contains("OPASKA KABLOWA"))
						cell.setCellValue(cell.getStringCellValue().replace("OPASKA KABLOWA", "КАБЕЛЬНАЯ СТЯЖКА"));
					if (input.contains("Skrzynka sygnałowa typu"))
						cell.setCellValue(cell.getStringCellValue().replace("Skrzynka sygnałowa typu", "Тип сигнальной коробки"));
					if (input.contains("złączki"))
						cell.setCellValue(cell.getStringCellValue().replace("złączki", "фитинги"));
					if (input.contains("ZŁĄCZKA"))
						cell.setCellValue(cell.getStringCellValue().replace("ZŁĄCZKA", "соединительный зажим "));
					if (input.contains("POMARAŃCZOWA"))
						cell.setCellValue(cell.getStringCellValue().replace("POMARAŃCZOWA", "ОРАНЖЕВАЯ"));
					
					if (input.contains("LISTWA"))
						cell.setCellValue(cell.getStringCellValue().replace("LISTWA", "КОЛОДКА"));
					if (input.contains("POMAR. ZACISK GWINTOWANY"))
						cell.setCellValue(cell.getStringCellValue().replace("POMAR. ZACISK GWINTOWANY", "ОРАНЖ. РЕЗЬБОВОЙ ЗАЖИМ"));
					if (input.contains("PUSZKA ŁĄCZENIOWA"))
						cell.setCellValue(cell.getStringCellValue().replace("PUSZKA ŁĄCZENIOWA", "СОЕДИНИТЕЛЬНАЯ КОРОБКА"));
					if (input.contains("DLA SILNIKÓW do"))
						cell.setCellValue(cell.getStringCellValue().replace("DLA SILNIKÓW do", "ДЛЯ ДВИГАТЕЛЕЙ ДО"));
					if (input.contains("Wysięgnik wzmocniony"))
						cell.setCellValue(cell.getStringCellValue().replace("Wysięgnik wzmocniony", "Усиленная стрела"));
					if (input.contains("Korytko siatkowe"))
						cell.setCellValue(cell.getStringCellValue().replace("Korytko siatkowe", "Сет. лоток"));
					if (input.contains("ocynk"))
						cell.setCellValue(cell.getStringCellValue().replace("ocynk", "оцинк"));
					if (input.contains("PRZEWÓD W IZOLACJI GUMOWEJ"))
						cell.setCellValue(cell.getStringCellValue().replace("PRZEWÓD W IZOLACJI GUMOWEJ", "КАБЕЛЬ В РЕЗИНОВОЙ ИЗОЛЯЦИИ"));
					
					if (input.contains("PUSZKA ŁĄCZENIOWA"))
						cell.setCellValue(cell.getStringCellValue().replace("PUSZKA ŁĄCZENIOWA", "СОЕДИНИТЕЛЬНАЯ КОРОБКА"));
					if (input.contains("DLA SILNIKÓW OD"))
						cell.setCellValue(cell.getStringCellValue().replace("DLA SILNIKÓW OD", "ДЛЯ ДВИГАТЕЛЕЙ ОТ"));
					if (input.contains("KASETA"))
						cell.setCellValue(cell.getStringCellValue().replace("KASETA", "КАСЕТА"));
					if (input.contains("DLAWIK"))
						cell.setCellValue(cell.getStringCellValue().replace("DLAWIK", "ДРОССЕЛЬ"));
					if (input.contains("z nakretka"))
						cell.setCellValue(cell.getStringCellValue().replace("z nakretka", "с гайкой"));
					if (input.contains("BLACZA"))
						cell.setCellValue(cell.getStringCellValue().replace("BLACZA", "КОЗЫРЕК ЭЛЕКТРИЧЕСКОЙ КОРОБКИ"));
					if (input.contains("TULEJKA IZOLOWANA"))
						cell.setCellValue(cell.getStringCellValue().replace("TULEJKA IZOLOWANA", "ИЗОЛИРОВАННАЯ ВТУЛКА"));
					if (input.contains("SZT."))
						cell.setCellValue(cell.getStringCellValue().replace("SZT.", "ШТ."));
					
					if (input.contains("ZACISK"))
						cell.setCellValue(cell.getStringCellValue().replace("ZACISK", "ЗАЖИМ"));
					if (input.contains("PRZEWÓD"))
						cell.setCellValue(cell.getStringCellValue().replace("PRZEWÓD", "КАБЕЛЬ"));
					if (input.contains("Szafka"))
						cell.setCellValue(cell.getStringCellValue().replace("Szafka", "Шкаф"));
					if (input.contains("OBSŁUGA CZUJNIKÓW WILGOTNOŚCI"))
						cell.setCellValue(cell.getStringCellValue().replace("OBSŁUGA CZUJNIKÓW WILGOTNOŚCI", " ОБСЛУЖИВАНИЕ ДАТЧИКОВ ВЛАЖНОСТИ"));
					if (input.contains("Zacisk typ"))
						cell.setCellValue(cell.getStringCellValue().replace("Zacisk typ", "Зажим тип"));
					if (input.contains("DŁAWICA KABLOWA METRYCZNA"))
						cell.setCellValue(cell.getStringCellValue().replace("DŁAWICA KABLOWA METRYCZNA", "МЕТРИЧЕСКАЯ КАБЕЛЬНАЯ ДРОССЕЛЬНАЯ ЗАСЛОНКА"));
					if (input.contains("Przewód sterowniczy"))
						cell.setCellValue(cell.getStringCellValue().replace("Przewód sterowniczy", "Кабель управляющий"));
					if (input.contains("KOŁEK WBIJANY"))
						cell.setCellValue(cell.getStringCellValue().replace("KOŁEK WBIJANY", "КОЛЫШЕК"));
					
					if (input.contains("SZEŚCIO"))
						cell.setCellValue(cell.getStringCellValue().replace("SZEŚCIO", "ШЕСТИ"));
					if (input.contains("UCHWYT ŚRUBOWY"))
						cell.setCellValue(cell.getStringCellValue().replace("UCHWYT ŚRUBOWY", "ВИНТОВОЙ ДЕРЖАТЕЛЬ"));
					if (input.contains("SZARE"))
						cell.setCellValue(cell.getStringCellValue().replace("SZARE", "СЕРОЕ"));
					if (input.contains("ZŁĄCZE ŚRUBOWE"))
						cell.setCellValue(cell.getStringCellValue().replace("ZŁĄCZE ŚRUBOWE", " ВИНТОВОЙ РАЗЪЕМ"));
					if (input.contains("WYŁĄCZNIK STOPOWY- AWARYJNY"))
						cell.setCellValue(cell.getStringCellValue().replace("WYŁĄCZNIK STOPOWY- AWARYJNY", "ВЫКЛЮЧАТЕЛЬ СТОП АВАРИЙНЫЙ"));
					if (input.contains("CZARNY"))
						cell.setCellValue(cell.getStringCellValue().replace("CZARNY", "ЧЕРНЫЙ"));
					if (input.contains("Blacha uniwersalne"))
						cell.setCellValue(cell.getStringCellValue().replace("Blacha uniwersalne", "Универсальный лист"));
					if (input.contains("UKŁAD ROZRUCHU"))
						cell.setCellValue(cell.getStringCellValue().replace("UKŁAD ROZRUCHU", "ПУСКОВОЕ УСТРОЙСТВО"));
					
					if (input.contains("Szafa sterownicza automatyczna z komputerem z okablowaniem"))
						cell.setCellValue(cell.getStringCellValue().replace("Szafa sterownicza automatyczna z komputerem z okablowaniem", "Шкаф управлением автоматическим с компьютером и проводкой"));
					if (input.contains("CZUJNIK"))
						cell.setCellValue(cell.getStringCellValue().replace("CZUJNIK", "ДАТЧИК"));
					if (input.contains("MONITOR"))
						cell.setCellValue(cell.getStringCellValue().replace("MONITOR", "МОНИТОР"));
					if (input.contains("ZESTAW KOMPUTEROWY"))
						cell.setCellValue(cell.getStringCellValue().replace("ZESTAW KOMPUTEROWY", " КОМПЬЮТЕРНЫЙ КОМПЛЕКТ"));
					if (input.contains("PESZEL"))
						cell.setCellValue(cell.getStringCellValue().replace("PESZEL", "ПЕШЕЛЬ"));
					if (input.contains("NIEPALNY"))
						cell.setCellValue(cell.getStringCellValue().replace("NIEPALNY", "НЕГОРЮЧИЙ"));
					if (input.contains("Z PILOTEM"))
						cell.setCellValue(cell.getStringCellValue().replace("Z PILOTEM", "С ПРОВОДОМ"));
					if (input.contains("ZACISK GWINTOWANY"))
						cell.setCellValue(cell.getStringCellValue().replace("ZACISK GWINTOWANY", "РЕЗЬБОВОЙ ЗАЖИМ"));
					
					if (input.contains("Obudowa hermetyczna"))
						cell.setCellValue(cell.getStringCellValue().replace("Obudowa hermetyczna", "Герметиченый корпус"));
					if (input.contains("INDUKCYJNY"))
						cell.setCellValue(cell.getStringCellValue().replace("INDUKCYJNY", "ИНДУКТИВНЫЙ"));
					if (input.contains("PUSZKA"))
						cell.setCellValue(cell.getStringCellValue().replace("PUSZKA", "электрическая коробка"));
					if (input.contains("MAŁA;"))
						cell.setCellValue(cell.getStringCellValue().replace("MAŁA;", " МАЛАЯ"));
					if (input.contains("DŁAWIKI"))
						cell.setCellValue(cell.getStringCellValue().replace("DŁAWIKI", "ДРОССЕЛИ"));
					if (input.contains("TASMA KABLOWA"))
						cell.setCellValue(cell.getStringCellValue().replace("TASMA KABLOWA", "КАБЕЛЬНАЯ ЛЕНТА"));
					if (input.contains("KOŃCÓWKA RUROWA"))
						cell.setCellValue(cell.getStringCellValue().replace("KOŃCÓWKA RUROWA", "ТРУБЧАТЫЙ НАКОНЕЧНИК"));
					if (input.contains("KOŃCÓWKA OCZKOWA"))
						cell.setCellValue(cell.getStringCellValue().replace("KOŃCÓWKA OCZKOWA", "КЛЕМА"));
					
					if (input.contains("pod kasety ster."))
						cell.setCellValue(cell.getStringCellValue().replace("pod kasety ster.", "под касеты упр."));
					if (input.contains("STEROWNICZY"))
						cell.setCellValue(cell.getStringCellValue().replace("STEROWNICZY", "УПРАВЛЕНИЯ"));
					if (input.contains("Przewód sterowniczy"))
						cell.setCellValue(cell.getStringCellValue().replace("Przewód sterowniczy", "КАБЕЛЬ УПРАВЛЕНИЯ"));
					if (input.contains("do przetwornic"))
						cell.setCellValue(cell.getStringCellValue().replace("do przetwornic", "для преобразователей"));
					if (input.contains("Z NAKRETKA"))
						cell.setCellValue(cell.getStringCellValue().replace("Z NAKRETKA", "С ГАЙКОЙ"));
					if (input.contains("Dlawik"))
						cell.setCellValue(cell.getStringCellValue().replace("Dlawik", "Дроссель"));
					if (input.contains("GNIAZDO PRZENOŚNE"))
						cell.setCellValue(cell.getStringCellValue().replace("GNIAZDO PRZENOŚNE", "ПОРТАТИВНЫЙ РАЗЪЕМ"));
					if (input.contains("WTYCZKA"))
						cell.setCellValue(cell.getStringCellValue().replace("WTYCZKA", "ВИЛКА"));
					
					if (input.contains("OCZK."))
						cell.setCellValue(cell.getStringCellValue().replace("OCZK.", "КЛЕМ."));
					if (input.contains("NR ARTYKUŁU"))
						cell.setCellValue(cell.getStringCellValue().replace("NR ARTYKUŁU", "НР. ПРЕДМЕТА"));
					if (input.contains("SONDA DO CZUJNIKA WILGOTNOŚCI"))
						cell.setCellValue(cell.getStringCellValue().replace("SONDA DO CZUJNIKA WILGOTNOŚCI", "ЗОНДЫ ДО ДАТЧИКА ВЛАЖНОСТИ"));
					if (input.contains("KANAŁÓW"))
						cell.setCellValue(cell.getStringCellValue().replace("KANAŁÓW", "КАНАЛОВ"));

					if (input.contains("OBO KORYTO SIATKOWE"))
						cell.setCellValue(cell.getStringCellValue().replace("OBO KORYTO SIATKOWE", "OBO СЕТОЧНЫЙ ЛОТОК"));
					if (input.contains("WYSIĘGNIK WZMOCNIONY"))
						cell.setCellValue(cell.getStringCellValue().replace("WYSIĘGNIK WZMOCNIONY", "Усиленная стрела"));
					if (input.contains("Szafa sterownicza automatyczna z panelem dotykowym bez okablowania"))
						cell.setCellValue(cell.getStringCellValue().replace("Szafa sterownicza automatyczna z panelem dotykowym bez okablowania", "Шкаф автоматического управления с сенсорной панелью без проводки"));
					if (input.contains("IWANOWKA"))
						cell.setCellValue(cell.getStringCellValue().replace("IWANOWKA", "ИВАНОВКА"));
					if (input.contains("ŁĄCZNIK SPRZĘGAJĄCY"))
						cell.setCellValue(cell.getStringCellValue().replace("ŁĄCZNIK SPRZĘGAJĄCY", "СОЕДИНИТЕЛЬНАЯ МУФТА"));
					if (input.contains("PŁASKA"))
						cell.setCellValue(cell.getStringCellValue().replace("PŁASKA", "ПЛОСКАЯ"));
					if (input.contains("NIEBIESKIE"))
						cell.setCellValue(cell.getStringCellValue().replace("NIEBIESKIE", "ГОЛУБОЕ"));
					if (input.contains("POJEDYŃCZA LINKA"))
						cell.setCellValue(cell.getStringCellValue().replace("POJEDYŃCZA LINKA", "ОДИНОЧНЫЙ ТРОС"));
					
					if (input.contains("czarna"))
						cell.setCellValue(cell.getStringCellValue().replace("czarna", "черная"));
					if (input.contains("Wyłącznik  mocy"))
						cell.setCellValue(cell.getStringCellValue().replace("Wyłącznik  mocy", "Выключатель мощности"));
					if (input.contains("MODUŁ"))
						cell.setCellValue(cell.getStringCellValue().replace("MODUŁ", "Модуль"));
					if (input.contains("WEJŚĆ TEMPERTUROWYCH"))
						cell.setCellValue(cell.getStringCellValue().replace("WEJŚĆ TEMPERTUROWYCH", "входов температурных"));
					if (input.contains("URZĄDZENIA"))
						cell.setCellValue(cell.getStringCellValue().replace("URZĄDZENIA", "оборудования"));
					if (input.contains("TERMOSTAT BEZPIECZEŃSTWA SUSZARNI"))
						cell.setCellValue(cell.getStringCellValue().replace("TERMOSTAT BEZPIECZEŃSTWA SUSZARNI", "ТЕРМОСТАТ БЕЗОПАСНОСТИ ЗЕРНОСУШИЛКИ"));
					if (input.contains("WYŁ.NADPR.Z MOD.RÓŻNIC.,"))
						cell.setCellValue(cell.getStringCellValue().replace("WYŁ.NADPR.Z MOD.RÓŻNIC.,", "ПРЕДОХР. НАПРЯЖ. З МОД. РАЗНИЦЫ"));
					if (input.contains("Przekaźnikprzemysłowy"))
						cell.setCellValue(cell.getStringCellValue().replace("Przekaźnikprzemysłowy", "Реле промышленное"));
					
					if (input.contains("Gniazdo zacisku śrubowego "))
						cell.setCellValue(cell.getStringCellValue().replace("Gniazdo zacisku śrubowego ", "Розетка винтового разьема "));
					if (input.contains("Przekaźnik przemysłowy miniaturowy"))
						cell.setCellValue(cell.getStringCellValue().replace("Przekaźnik przemysłowy miniaturowy", "Реле промышленное миниатюрное"));
					if (input.contains("Miernik cyfrowy cęgowy"))
						cell.setCellValue(cell.getStringCellValue().replace("Miernik cyfrowy cęgowy", "Цифровой клещи"));
					if (input.contains("Zestaw  wkrętaków izolowanych "))
						cell.setCellValue(cell.getStringCellValue().replace("Zestaw  wkrętaków izolowanych ", "Набор изолированных отверток"));
					if (input.contains("Zestaw nożyków"))
						cell.setCellValue(cell.getStringCellValue().replace("Zestaw nożyków", "Комплект ножей"));
					if (input.contains("UCHWYT PASKOWY"))
						cell.setCellValue(cell.getStringCellValue().replace("UCHWYT PASKOWY", "ДЕРЖАТЕЛЬ РЕМНЕЙ"));
					if (input.contains("DO PROGRAM."))
						cell.setCellValue(cell.getStringCellValue().replace("DO PROGRAM.", "ДО ПРОГРАММ."));
					if (input.contains("TULEJKA"))
						cell.setCellValue(cell.getStringCellValue().replace("TULEJKA", "ВТУЛКА"));
					
					if (input.contains("KOŃCÓWKA"))
						cell.setCellValue(cell.getStringCellValue().replace("KOŃCÓWKA", "НАКОНЕЧНИК"));
					if (input.contains("WSTĘGA BUTYLOWA"))
						cell.setCellValue(cell.getStringCellValue().replace("WSTĘGA BUTYLOWA", "БУТИЛОВАЯ ЛЕНТА"));
					if (input.contains(" z granulatem PA, kolor szary, dwustronna, na folii"))
						cell.setCellValue(cell.getStringCellValue().replace(" z granulatem PA, kolor szary, dwustronna, na folii", "с гранул ПА, серый цвет, двухсторонний, на пленке"));
					if (input.contains("KONEKTOR INTERFEJSU "))
						cell.setCellValue(cell.getStringCellValue().replace("KONEKTOR INTERFEJSU ", "КОННЕКТОР ИНТЕРФЕЙСА"));
					if (input.contains("Zestaw nożyków"))
						cell.setCellValue(cell.getStringCellValue().replace("Zestaw nożyków", "Комплект ножей"));
					if (input.contains("MODUŁ"))
						cell.setCellValue(cell.getStringCellValue().replace("MODUŁ", "МОДУЛЬ"));
					if (input.contains("Wzmacniacz sieciowy"))
						cell.setCellValue(cell.getStringCellValue().replace("Wzmacniacz sieciowy", "Сетевой усилитель"));
					if (input.contains("TULEJKA"))
						cell.setCellValue(cell.getStringCellValue().replace("TULEJKA", "ВТУЛКА"));
					
					if (input.contains("Iwanowka"))
						cell.setCellValue(cell.getStringCellValue().replace("Iwanowka", "Ивановка"));
					if (input.contains("Zakupne"))
						cell.setCellValue(cell.getStringCellValue().replace("Zakupne","Закупне"));
					if (input.contains("Winnica"))
						cell.setCellValue(cell.getStringCellValue().replace("Winnica", "Винница"));
					if (input.contains("Oratow"))
						cell.setCellValue(cell.getStringCellValue().replace("Oratow", "Оратов"));
					if (input.contains("km"))
						cell.setCellValue(cell.getStringCellValue().replace("km", "км"));
					if (input.contains("szt"))
						cell.setCellValue(cell.getStringCellValue().replace("szt", "шт"));
					
					if (input.contains("op"))
						cell.setCellValue(cell.getStringCellValue().replace("op", "оп."));
					if (input.contains("ВИНТ САМОНАРЕЗАЮЩИЙ ШЕСТИУГОЛЬНЫЙ С ШАЙБОЙ"))
						cell.setCellValue(cell.getStringCellValue().replace("ВИНТ САМОНАРЕЗАЮЩИЙ ШЕСТИУГОЛЬНЫЙ С ШАЙБОЙ", "ВИНТ САМОНАРЕЗАЮЩИЙ ШЕСТИУГОЛЬНЫЙ С ШАЙБОЙ"));
					if (input.contains("WEJŚĆ"))
						cell.setCellValue(cell.getStringCellValue().replace("WEJŚĆ","ВХОД"));
					if (input.contains("ELEMENT STYKOWY"))
						cell.setCellValue(cell.getStringCellValue().replace("ELEMENT STYKOWY", "СОЕДЕНИТЕЛЬНЫЙ ЭЛЕМЕНТ"));
					if (input.contains("FARMERSKI"))
						cell.setCellValue(cell.getStringCellValue().replace("FARMERSKI", "ФЕРМЕРСКИЙ"));
					if (input.contains("WILGOTNOŚCI"))
						cell.setCellValue(cell.getStringCellValue().replace("WILGOTNOŚCI", "ВЛАЖНОСТИ"));
					if (input.contains("POMIAROWY"))
						cell.setCellValue(cell.getStringCellValue().replace("POMIAROWY", "ИЗМЕРЯЮЩИЙ"));
					
					if (input.contains("op"))
						cell.setCellValue(cell.getStringCellValue().replace("op", "оп."));
					
				}

			});

		});
		FileOutputStream outputStream;
		outputStream = new FileOutputStream("test2.xlsx");
		workbook.write(outputStream);
		workbook.close();

	}
	
	
}
