package com.andrii;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel {
	Workbook translateExcel(String pathToExcel, LinkedHashMap<String, String> vocablurary)
			throws EncryptedDocumentException, IOException {
		Workbook workbook = null;
		workbook = WorkbookFactory.create(new File(pathToExcel));
//		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			workbook.setSheetName(i, workbook.getSheetName(i).replace("LISTWA", "КОЛОДКА"));
			workbook.setSheetName(i, workbook.getSheetName(i).replace("ZABEZPIECZENIA", "ПРЕДОХРАНИТЕЛИ"));
			workbook.setSheetName(i, workbook.getSheetName(i).replace("SYGNAŁÓWKI", "СИГНАЛЬНЫЕ КОРОБКИ"));
			workbook.setSheetName(i, workbook.getSheetName(i).replace("MIĘDZYSIL.", "МЕЖДУСИЛОС."));
			
		}
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			Sheet sheet = workbook.getSheetAt(i);
			sheet.forEach(row -> {
				row.forEach(cell -> {
					if (cell.getCellType() == CellType.STRING) {
						String input = cell.getStringCellValue();
						vocablurary.forEach((K, V) -> {
							if (input.contains(K)) {
								cell.setCellValue(cell.getStringCellValue().replace(K, V));
							}
						});
					}
				});
			});
		}
//		FileOutputStream outputStream;
//		outputStream = new FileOutputStream("test.xls");
//		workbook.write(outputStream);
//		workbook.close();
		return workbook;
	}
	
	static void translateListwa(String pathToExcel) throws EncryptedDocumentException, IOException {
		Workbook workbook = null;
		workbook = WorkbookFactory.create(new File(pathToExcel));
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			workbook.setSheetName(i, workbook.getSheetName(i).replace("LISTWA", "КОЛОДКА"));
			workbook.setSheetName(i, workbook.getSheetName(i).replace("ZABEZPIECZENIA", "ПРЕДОХРАНИТЕЛИ"));
			workbook.setSheetName(i, workbook.getSheetName(i).replace("SYGNAŁÓWKI", "СИГНАЛЬНЫЕ КОРОБКИ"));
			workbook.setSheetName(i, workbook.getSheetName(i).replace("MIĘDZYSIL.", "МЕЖДУСИЛОС."));
			
		}
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			Sheet sheet = workbook.getSheetAt(i);
			sheet.forEach(row -> {
				row.forEach(cell -> {
					if (cell.getCellType() == CellType.STRING) {
						String input = cell.getStringCellValue();
						if (input.contains("ANTONINY"))
							cell.setCellValue(cell.getStringCellValue().replace("ANTONINY", "АНТОНИНЫ"));
						
						if (input.contains("WSPÓŁCZYNNIK"))
							cell.setCellValue(cell.getStringCellValue().replace("WSPÓŁCZYNNIK", "КОЭФФИЦИЕНТ"));
						if (input.contains("PUNKTU ROSY"))
							cell.setCellValue(cell.getStringCellValue().replace("PUNKTU ROSY", "ТОЧКА РОСЫ."));
						if (input.contains("KIER."))
							cell.setCellValue(cell.getStringCellValue().replace("KIER.", "НАПР."));
						if (input.contains("WAPNIARKA"))
							cell.setCellValue(cell.getStringCellValue().replace("WAPNIARKA", "ВАПНЯРКА"));
						if (input.contains("ROZDZIELNICA SYGNALIZACYJNA"))
							cell.setCellValue(cell.getStringCellValue().replace("ROZDZIELNICA SYGNALIZACYJNA",
									"РАСПР. ЩИТ СИГНАЛИЗАЦИИ"));
						if (input.contains("ZAŁĄCZENIE PALNIKA"))
							cell.setCellValue(
									cell.getStringCellValue().replace("ZAŁĄCZENIE PALNIKA", "ВКЛЮЧЕНИЕ ГОРЕЛКИ"));
						if (input.contains("СИГНАЛИЗАЦИИ"))
							cell.setCellValue(
									cell.getStringCellValue().replace("SYGNALIZACYJNA", "СИГНАЛИЗАЦИИ"));
						if (input.contains("DACHOWY"))
							cell.setCellValue(cell.getStringCellValue().replace("DACHOWY", "КРЫШНЫЙ"));
						if (input.contains("BEZP."))
							cell.setCellValue(cell.getStringCellValue().replace("BEZP.", "БЕЗОП."));
						if (input.contains("WYŁĄCZNIK BEZPIECZEŃSTWA OBIEKT"))
							cell.setCellValue(cell.getStringCellValue().replace("WYŁĄCZNIK BEZPIECZEŃSTWA OBIEKT",
									"ПРЕДОХРАНИТЕЛЬ ОБЪЕКТ"));
						if (input.contains("NADMUCHOWY"))
							cell.setCellValue(cell.getStringCellValue().replace("NADMUCHOWY", "НИЖНИЙ"));
						if (input.contains("WINNICA"))
							cell.setCellValue(cell.getStringCellValue().replace("WINNICA", "ВИННИЦА"));
						if (input.contains("ZAS. ROZDZIELNICY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("ZAS. ROZDZIELNICY", "ПИТАНИЕ РАСПР. ЩИТА"));

						if (input.contains("PNEUMATYCZNY"))
							cell.setCellValue(cell.getStringCellValue().replace("PNEUMATYCZNY", "ПНЕВМАТИЧЕСКИЙ"));

						if (input.contains("WYŁĄCZNIK BEZPIECZEŃSTWA ROZDZIELNIC"))
							cell.setCellValue(
									cell.getStringCellValue().replace("WYŁĄCZNIK BEZPIECZEŃSTWA ROZDZIELNIC",
											"ПРЕДОХРАНИТЕЛЬ РАСПРЕДЕЛИТЕЛЬНЫХ ЩИТОВ"));
						if (input.contains("OBW."))
							cell.setCellValue(cell.getStringCellValue().replace("OBW.", "КОНТ."));
						if (input.contains("BUFOR"))
							cell.setCellValue(cell.getStringCellValue().replace("BUFOR", "БУФЕР"));
						if (input.contains("ODP."))
							cell.setCellValue(cell.getStringCellValue().replace("ODP.", "ОТХ."));
						if (input.contains("ASPIRACYJNA"))
							cell.setCellValue(cell.getStringCellValue().replace("ASPIRACYJNA", "АСПИРАЦИОННАЯ"));
						if (input.contains("WYŁĄCZNIK BEZPIECZEŃSTWA ROZDZIELNICA"))
							cell.setCellValue(cell.getStringCellValue().replace(
									"WYŁĄCZNIK BEZPIECZEŃSTWA ROZDZIELNICA", "ПРЕДОХРАНИТЕЛЬ РАСПР. ЩИТА"));
						if (input.contains("CZUJNIK"))
							cell.setCellValue(cell.getStringCellValue().replace("CZUJNIK", "ДАТЧИК"));
						if (input.contains("TEMPERATURY"))
							cell.setCellValue(cell.getStringCellValue().replace("TEMPERATURY", "ТЕМПЕРАТУРЫ"));
						if (input.contains("SUSZARNIA"))
							cell.setCellValue(cell.getStringCellValue().replace("SUSZARNIA", "ЗЕРНОСУШИЛКА"));
						if (input.contains("SEKCJA"))
							cell.setCellValue(cell.getStringCellValue().replace("SEKCJA", "СЕКЦИЯ"));
						if (input.contains("FUNKCJA"))
							cell.setCellValue(cell.getStringCellValue().replace("FUNKCJA", "ФУНКЦИЯ"));
						if (input.contains("ZASUWA"))
							cell.setCellValue(cell.getStringCellValue().replace("ZASUWA", "ЗАДВИЖКА"));
						if (input.contains(" (OTWARTA)"))
							cell.setCellValue(cell.getStringCellValue().replace(" (OTWARTA)", "(ОТКРЫТАЯ)"));
						if (input.contains(" (ZAMKNIĘTA)"))
							cell.setCellValue(cell.getStringCellValue().replace(" (ZAMKNIĘTA)", "(ЗАКРЫТАЯ)"));
						if (input.contains(" LISTWA ZACISKOWA"))
							cell.setCellValue(
									cell.getStringCellValue().replace(" LISTWA ZACISKOWA", "КЛЕМННАЯ КОЛОДКА"));
						if (input.contains("OB. UKRAINA"))
							cell.setCellValue(cell.getStringCellValue().replace("OB. UKRAINA", "ОБ. УКРАИНА"));
						if (input.contains("WYJ."))
							cell.setCellValue(cell.getStringCellValue().replace("WYJ.", "ВЫХ."));
						if (input.contains("WEJ."))
							cell.setCellValue(cell.getStringCellValue().replace("WEJ.", "ВХ."));
						if (input.contains("URZĄDZENIE"))
							cell.setCellValue(cell.getStringCellValue().replace("URZĄDZENIE", "ОБОРУДОВАНИЕ"));
						if (input.contains("KABEL"))
							cell.setCellValue(cell.getStringCellValue().replace("KABEL", "КАБЕЛЬ"));
						if (input.contains("FUNKCJA"))
							cell.setCellValue(cell.getStringCellValue().replace("FUNKCJA", "ФУНКЦИЯ"));
						if (input.contains("MODUŁ"))
							cell.setCellValue(cell.getStringCellValue().replace("MODUŁ", "МОДУЛЬ"));
						if (input.contains("SPIS WEJ/WYJ"))
							cell.setCellValue(cell.getStringCellValue().replace("SPIS WEJ/WYJ", "ТАБЛИЦА ВХ./ВЫХ"));
						if (input.contains("ZASILANIE"))
							cell.setCellValue(cell.getStringCellValue().replace("ZASILANIE", "ПИТАНИЕ"));
						if (input.contains("PRZEN."))
							cell.setCellValue(cell.getStringCellValue().replace("PRZEN.", "ТРАНСП."));
						if (input.contains("WYŁ. KRAŃCOWY"))
							cell.setCellValue(cell.getStringCellValue().replace("WYŁ. KRAŃCOWY", "КОНЦ. ВЫКЛ."));
						if (input.contains("CZ. INDUKCYJNY"))
							cell.setCellValue(cell.getStringCellValue().replace("CZ. INDUKCYJNY", "ДАТЧ. ИНДУКТ."));
						if (input.contains("PODNOŚNIK"))
							cell.setCellValue(cell.getStringCellValue().replace("PODNOŚNIK", "НОРИЯ"));
						if (input.contains("CZ. POZ."))
							cell.setCellValue(cell.getStringCellValue().replace("CZ. POZ.", "ДАТЧ. ПОЗ."));
						if (input.contains("ROZDZ. SYGN."))
							cell.setCellValue(
									cell.getStringCellValue().replace("ROZDZ. SYGN.", "РАСПР. ЩИТ СИГН."));
						if (input.contains("ROZDZ. SYGNAŁOWA"))
							cell.setCellValue(
									cell.getStringCellValue().replace("ROZDZ. SYGNAŁOWA", "РАСПР. ЩИТ СИГН."));
						if (input.contains("PRZENOŚNIK"))
							cell.setCellValue(cell.getStringCellValue().replace("PRZENOŚNIK", "ТРАНСПОРТЕР"));
						if (input.contains("ROZDZ. RE"))
							cell.setCellValue(
									cell.getStringCellValue().replace("ROZDZ. RE", "КЛАП. ПЕРЕК. ЭЛ. RE"));
						if (input.contains("KLAPA"))
							cell.setCellValue(cell.getStringCellValue().replace("KLAPA", "ШИБЕР"));
						if (input.contains("ŚRODEK"))
							cell.setCellValue(cell.getStringCellValue().replace("ŚRODEK", "СЕРЕДИНА"));
						if (input.contains("LEWO"))
							cell.setCellValue(cell.getStringCellValue().replace("LEWO", "ЛЕВО"));
						if (input.contains("PRAWO"))
							cell.setCellValue(cell.getStringCellValue().replace("PRAWO", "ПРАВО"));
						if (input.contains("POŁ. NA"))
							cell.setCellValue(cell.getStringCellValue().replace("POŁ. NA", "ПОЛ. НА"));
						if (input.contains("CZYSZCZ."))
							cell.setCellValue(cell.getStringCellValue().replace("CZYSZCZ.", "СЕПАР."));
						if (input.contains("WYŁ. KRAŃCOWE"))
							cell.setCellValue(cell.getStringCellValue().replace("WYŁ. KRAŃCOWE", "КОНЦ. ВЫКЛ."));
						if (input.contains("WYŁ. BEZPIECZEŃSTWA"))
							cell.setCellValue(
									cell.getStringCellValue().replace("WYŁ. BEZPIECZEŃSTWA", "ПРЕДОХРАНИТЕЛЬ"));
						if (input.contains("CZYSZCZALNIA"))
							cell.setCellValue(cell.getStringCellValue().replace("CZYSZCZALNIA", "ОЧИСТИТЕЛЬ"));
						if (input.contains("SONDY TEMPERATUROWE"))
							cell.setCellValue(cell.getStringCellValue().replace("SONDY TEMPERATUROWE",
									"ТЕМПЕРАТУРНЫЕ ЗОНДЫ"));
						if (input.contains("CZUJNIK WILGOTNOŚCI"))
							cell.setCellValue(
									cell.getStringCellValue().replace("CZUJNIK WILGOTNOŚCI", "ДАТЧИК ВЛАЖНОСТИ"));
						if (input.contains(
								"PRZENOŚNIK                                                                                   ŁAŃCUCHOWY"))
							cell.setCellValue(cell.getStringCellValue().replace(
									"PRZENOŚNIK                                                                                   ŁAŃCUCHOWY",
									"ЦЕПНОЙ ТРАНСПОРТЕР"));
						if (input.contains("SILNIK"))
							cell.setCellValue(cell.getStringCellValue().replace("SILNIK", "ДВИГАТЕЛЬ"));
						if (input.contains("kW"))
							cell.setCellValue(cell.getStringCellValue().replace("kW", "кВт"));
						if (input.contains(
								"WIALNIA                                                                                       ASPIRACYJNA"))
							cell.setCellValue(cell.getStringCellValue().replace(
									"WIALNIA                                                                                       ASPIRACYJNA",
									"ВЕЯЛКА АСПИРАЦИОННАЯ"));
						if (input.contains("PRZENOŚNIK"))
							cell.setCellValue(cell.getStringCellValue().replace("PRZENOŚNIK", "ТРАНСПОРТЕР"));
						if (input.contains("PRZEN."))
							cell.setCellValue(cell.getStringCellValue().replace("PRZEN.", "ТРАНСП."));
						if (input.contains(" WENT. ZEWN. ZAŁ."))
							cell.setCellValue(
									cell.getStringCellValue().replace(" WENT. ZEWN. ZAŁ.", "ВНЕШН. ВЕНТ. ВКЛ."));
						if (input.contains("WENT. ROZDZIELNICY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("WENT. ROZDZIELNICY", "ВЕНТ. РАСПР. ЩИТА"));
						if (input.contains("POTWIERDZENIE ZAŁĄCZENIA"))
							cell.setCellValue(cell.getStringCellValue().replace("POTWIERDZENIE ZAŁĄCZENIA",
									"ПОДТВЕРЖДЕНИЕ ВКЛЮЧЕНИЯ"));
						if (input.contains("TERMOSTAT"))
							cell.setCellValue(cell.getStringCellValue().replace("TERMOSTAT", "ТЕРМОСТАТ"));
						if (input.contains("CZ. INDUKCYJNY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("CZ. INDUKCYJNY", "ДАТЧ. ИНДУКТИВНЫЙ"));
						if (input.contains("PRZEKAŹNIKI"))
							cell.setCellValue(cell.getStringCellValue().replace("PRZEKAŹNIKI", "РЕЛЕ"));
						if (input.contains("WENT. ZEWN. - ZAŁĄCZENIE"))
							cell.setCellValue(cell.getStringCellValue().replace("WENT. ZEWN. - ZAŁĄCZENIE",
									"ВНЕШН. ВЕНТ. ВКЛЮЧЕНИЕ"));
						if (input.contains("ZAŁĄCZENIE URZĄDZENIA"))
							cell.setCellValue(cell.getStringCellValue().replace("ZAŁĄCZENIE URZĄDZENIA",
									"ВКЛЮЧЕНИЕ ОБОРУДОВАНИЯ"));
						if (input.contains("ROZDZIELNICA SYGNAŁOWA"))
							cell.setCellValue(cell.getStringCellValue().replace("ROZDZIELNICA SYGNAŁOWA",
									"РАСПРЕДЕЛИТЕЛЬНЫЙ ЩИТ СИГНАЛЬНЫЙ"));
						if (input.contains("PODAJNIK TAŚMOWY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("PODAJNIK TAŚMOWY", "ЛЕНТОЧНЫЙ ТРАНСПОРТЕР"));
						if (input.contains("CZ. NAPEŁNIENIA MAX"))
							cell.setCellValue(
									cell.getStringCellValue().replace("CZ. NAPEŁNIENIA MAX", "ДАТЧ. УРОВНЯ МАКС"));
						if (input.contains("SILOS"))
							cell.setCellValue(cell.getStringCellValue().replace("SILOS", "СИЛОС"));
						if (input.contains("ROLKA"))
							cell.setCellValue(cell.getStringCellValue().replace("ROLKA", "РОЛИК"));
						if (input.contains("NAPĘD SIT"))
							cell.setCellValue(cell.getStringCellValue().replace("NAPĘD SIT", "ПРИВОД РЕШЕТ"));
						if (input.contains("ŚLIMAK ODPADÓW"))
							cell.setCellValue(cell.getStringCellValue().replace("ŚLIMAK ODPADÓW", "ШНЕК ОТХОДОВ"));
						if (input.contains("CELKA KURZOWA "))
							cell.setCellValue(
									cell.getStringCellValue().replace("CELKA KURZOWA ", "ШЛЮЗОВОЙ ЗАТВОР"));
						if (input.contains("WENT. ASP."))
							cell.setCellValue(cell.getStringCellValue().replace("WENT. ASP.", "ВЕНТ. АСП."));
						if (input.contains("PRZEKAŹNIK BEZPIECZEŃSTWA"))
							cell.setCellValue(cell.getStringCellValue().replace("PRZEKAŹNIK BEZPIECZEŃSTWA",
									"РЕЛЕ БЕЗОПАСНОСТИ"));
						if (input.contains("POTW."))
							cell.setCellValue(cell.getStringCellValue().replace("POTW.", "ПОДТВ."));

						if (input.contains("WYŁĄCZNIK BEZPIECZEŃSTWA                               ROZDZIELNICA"))
							cell.setCellValue(cell.getStringCellValue().replace(
									"WYŁĄCZNIK BEZPIECZEŃSTWA                               ROZDZIELNICA",
									"ПРЕДОХРАНИТЕЛЬ РАСПРЕДЕЛИТЕЛЬНОГО ЩИТА"));
						if (input.contains("BUCZEK"))
							cell.setCellValue(cell.getStringCellValue().replace("BUCZEK", "ЗВУКОВАЯ СИГНАЛИЗАЦИЯ"));
						if (input.contains("OBIEKT"))
							cell.setCellValue(cell.getStringCellValue().replace("OBIEKT", "ОБЪЕКТ"));
						if (input.contains("ZAŁĄCZENIE"))
							cell.setCellValue(cell.getStringCellValue().replace("ZAŁĄCZENIE", "ВКЛЮЧЕНИЕ"));
						if (input.contains("TERMOSTAT"))
							cell.setCellValue(cell.getStringCellValue().replace("TERMOSTAT", "ТЕРМОСТАТ"));
						if (input.contains("POŁOŻENIE"))
							cell.setCellValue(cell.getStringCellValue().replace("POŁOŻENIE", "ПОЛОЖЕНИЕ"));
						if (input.contains("KLAPA"))
							cell.setCellValue(cell.getStringCellValue().replace("KLAPA", "ШИБЕР"));
						if (input.contains("CZ. NAPEŁNIENIA MIN"))
							cell.setCellValue(
									cell.getStringCellValue().replace("CZ. NAPEŁNIENIA MIN", "ДАТЧ. УРОВНЯ МИН"));
						if (input.contains("OTWÓRZ"))
							cell.setCellValue(cell.getStringCellValue().replace("OTWÓRZ", "ОТКРОЙ"));
						if (input.contains("ZAMKNIJ"))
							cell.setCellValue(cell.getStringCellValue().replace("ZAMKNIJ", "ЗАКРОЙ"));
						if (input.contains("ROZDZIELACZ"))
							cell.setCellValue(cell.getStringCellValue().replace("ROZDZIELACZ", "КЛАПАН ПЕРЕК."));
						if (input.contains("ELEKTRYCZNY"))
							cell.setCellValue(cell.getStringCellValue().replace("ELEKTRYCZNY", "ЭЛЕКТР."));
						if (input.contains("ELEKTRYCZNA"))
							cell.setCellValue(cell.getStringCellValue().replace("ELEKTRYCZNA", "ЭЛЕКТРИЧЕСКАЯ"));
						if (input.contains("ZAB. APARATOWE"))
							cell.setCellValue(
									cell.getStringCellValue().replace("ZAB. APARATOWE", "ПРЕДОХРАНИТЕЛЬ"));
						if (input.contains("ZAS. ZAB."))
							cell.setCellValue(cell.getStringCellValue().replace("ZAS. ZAB.", "ПИТ. ПРЕДОХР."));
						if (input.contains("ZABEZPIECZENIE"))
							cell.setCellValue(
									cell.getStringCellValue().replace("ZABEZPIECZENIE", "ПРЕДОХРАНИТЕЛЬ"));
						if (input.contains("OBWÓD"))
							cell.setCellValue(cell.getStringCellValue().replace("OBWÓD", "КОНТУР"));
						if (input.contains("MOC"))
							cell.setCellValue(cell.getStringCellValue().replace("MOC", "МОЩНОСТЬ"));
						if (input.contains("KONTROLA FAZ"))
							cell.setCellValue(cell.getStringCellValue().replace("KONTROLA FAZ", "КОНТРОЛЬ ФАЗ"));
						if (input.contains("GNIAZDO SERWISOWE"))
							cell.setCellValue(
									cell.getStringCellValue().replace("GNIAZDO SERWISOWE", "СЕРВИСНАЯ РОЗЕТКА"));
						if (input.contains("OCHRONA PRZECIWPRZEP."))
							cell.setCellValue(cell.getStringCellValue().replace("OCHRONA PRZECIWPRZEP.",
									"ЗАЩИТА ОТ ПЕРЕНАПРЯЖ."));
						if (input.contains("WYJŚCIE"))
							cell.setCellValue(cell.getStringCellValue().replace("WYJŚCIE", "ВЫХОД"));
						if (input.contains("WEJŚCIE"))
							cell.setCellValue(cell.getStringCellValue().replace("WEJŚCIE", "ВХОД"));
						if (input.contains("BEZPIECZEŃSTWA"))
							cell.setCellValue(cell.getStringCellValue().replace("BEZPIECZEŃSTWA", "БЕЗОПАСНОСТИ"));
						if (input.contains("PĘTLA"))
							cell.setCellValue(cell.getStringCellValue().replace("PĘTLA", "ПЕТЛЯ"));

						if (input.contains("PALNIK"))
							cell.setCellValue(cell.getStringCellValue().replace("PALNIK", "ГОРЕЛКА"));
						if (input.contains("MODULACJA"))
							cell.setCellValue(cell.getStringCellValue().replace("MODULACJA", "МОДУЛЯЦИЯ"));
						if (input.contains("AWARIA"))
							cell.setCellValue(cell.getStringCellValue().replace("AWARIA", "АВАРИЯ"));
						if (input.contains("PRACA"))
							cell.setCellValue(cell.getStringCellValue().replace("PRACA", "РАБОТА"));
						if (input.contains("SUSZARNIA"))
							cell.setCellValue(cell.getStringCellValue().replace("SUSZARNIA", "ЗЕРНОСУШИЛКА"));
						if (input.contains("STEROWANIE"))
							cell.setCellValue(cell.getStringCellValue().replace("STEROWANIE", "УПРАВЛЕНИЕ"));
						if (input.contains("MINIMALNA"))
							cell.setCellValue(cell.getStringCellValue().replace("MINIMALNA", "МИНИМАЛЬНАЯ"));
						if (input.contains("SEKCJA"))
							cell.setCellValue(cell.getStringCellValue().replace("SEKCJA", "СЕКЦИЯ"));
						if (input.contains("CZUJNIK"))
							cell.setCellValue(cell.getStringCellValue().replace("CZUJNIK", "ДАТЧИК"));
						if (input.contains("RECYRKULACJA"))
							cell.setCellValue(cell.getStringCellValue().replace("RECYRKULACJA", "РЕЦИРКУЛЯЦИЯ"));
						if (input.contains("CZ. NAPEŁNIENIA"))
							cell.setCellValue(cell.getStringCellValue().replace("CZ. NAPEŁNIENIA", "ДАТЧ. УРОВНЯ"));
						if (input.contains("KONTAKTRON"))
							cell.setCellValue(cell.getStringCellValue().replace("KONTAKTRON", "ГЕРКОН"));
						if (input.contains("ZASILANIE CEWKA"))
							cell.setCellValue(
									cell.getStringCellValue().replace("ZASILANIE CEWKA", "ПИТАНИЕ КАТ. ИНД."));
						if (input.contains("ŻALUZJA WENT."))
							cell.setCellValue(cell.getStringCellValue().replace("ŻALUZJA WENT.", "ЖАЛЮЗИ ВЕНТ."));
						if (input.contains("SIŁOWNIK UKŁ. WYSYPU"))
							cell.setCellValue(cell.getStringCellValue().replace("SIŁOWNIK UKŁ. WYSYPU",
									"ЦИЛИНДР СИСТ. ВЫСЫПА"));
						if (input.contains("WENTYLATOR GÓRNY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("WENTYLATOR GÓRNY", "ВЕНТИЛЯТОР ВЕРХНИЙ"));
						if (input.contains("ZASILANIE"))
							cell.setCellValue(cell.getStringCellValue().replace("ZASILANIE", "ПИТАНИЕ"));
						if (input.contains("GRZAŁKA ROZDZ."))
							cell.setCellValue(
									cell.getStringCellValue().replace("GRZAŁKA ROZDZ.", "ГРЕЛКА РАСПР. ЩИТА"));
						if (input.contains("WENTYLATOR DOLNY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("WENTYLATOR DOLNY", "ВЕНТИЛЯТОР НИЖНИЙ"));
						if (input.contains("SIL."))
							cell.setCellValue(cell.getStringCellValue().replace("SIL.", "СИЛ."));
						if (input.contains("PŁASKODENNY"))
							cell.setCellValue(cell.getStringCellValue().replace("PŁASKODENNY", "С ПЛОСКИМ ДНОМ"));
						if (input.contains("WYBIERAK ŚLIMAKOWY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("WYBIERAK ŚLIMAKOWY", "ЗАЧИСТНОЙ ШНЕК"));
						if (input.contains("ŚLIMAK WYG."))
							cell.setCellValue(cell.getStringCellValue().replace("ŚLIMAK WYG.", "ЗАЧ. ШНЕК"));
						if (input.contains("WENTYLATOR NADMUCHOWY"))
							cell.setCellValue(cell.getStringCellValue().replace("WENTYLATOR NADMUCHOWY",
									"ВЕНТИЛЯТОР НИЖНИЙ"));
						if (input.contains("WENTYLATOR DOLNY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("WENTYLATOR DOLNY", "ВЕНТИЛЯТОР НИЖНИЙ"));
						if (input.contains("WENTYLATOR GÓRNY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("WENTYLATOR GÓRNY", "ВЕНТИЛЯТОР ВЕРХНИЙ"));
						if (input.contains("ZASILACZ"))
							cell.setCellValue(cell.getStringCellValue().replace("ZASILACZ", "БЛОК ПИТАНИЯ"));
						if (input.contains("ZAKUPNE"))
							cell.setCellValue(cell.getStringCellValue().replace("ZAKUPNE", "ЗАКУПНЕ"));
						if (input.contains("LISTWA"))
							cell.setCellValue(cell.getStringCellValue().replace("LISTWA", "КОЛОДКА"));
						if (input.contains("WILGOTNOŚCI"))
							cell.setCellValue(cell.getStringCellValue().replace("WILGOTNOŚCI", "ВЛАЖНОСТИ"));
						if (input.contains("CZ. IND."))
							cell.setCellValue(cell.getStringCellValue().replace("CZ. IND.", "ДАТЧ. ИНД."));
						if (input.contains("ŁAŃCUCHOWY"))
							cell.setCellValue(cell.getStringCellValue().replace("ŁAŃCUCHOWY", "ЦЕПНОЙ"));
						if (input.contains("WENTYLATOR ROZDZ."))
							cell.setCellValue(cell.getStringCellValue().replace("WENTYLATOR ROZDZ.",
									"ВЕНТИЛЯТОР РАСПР. ЩИТА"));
						if (input.contains("WENTYLATOR ZEWNĘTRZNY"))
							cell.setCellValue(cell.getStringCellValue().replace("WENTYLATOR ZEWNĘTRZNY",
									"ВЕНТИЛЯТОР ВНЕШНИЙ"));
						if (input.contains("PRZYC."))
							cell.setCellValue(cell.getStringCellValue().replace("PRZYC.", "КЛАВИША"));
						if (input.contains("KOSZA"))
							cell.setCellValue(cell.getStringCellValue().replace("KOSZA", "ЗАВ. ЯМЫ"));
						if (input.contains("PODAJNIK"))
							cell.setCellValue(cell.getStringCellValue().replace("PODAJNIK", "ТРАНСПОРТЕР"));
						if (input.contains("WENTYLATOR DACHOWY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("WENTYLATOR DACHOWY", "ВЕНТИЛЯТОР ВЕРХНИЙ"));
						if (input.contains("WENT. DACHOWY"))
							cell.setCellValue(
									cell.getStringCellValue().replace("WENT. DACHOWY", "ВЕНТИЛЯТОР ВЕРХН."));
						if (input.contains("ROZDZIELNIC"))
							cell.setCellValue(cell.getStringCellValue().replace("ROZDZIELNIC", "РАСПР. ЩИТОВ"));
						if (input.contains("POTWIERDZENIE"))
							cell.setCellValue(cell.getStringCellValue().replace("POTWIERDZENIE", "ПОДТВЕРЖДЕНИЕ"));
						if (input.contains("KUBEŁKOWY"))
							cell.setCellValue(cell.getStringCellValue().replace("KUBEŁKOWY", ""));
						if (input.contains("ŚLIMAK"))
							cell.setCellValue(cell.getStringCellValue().replace("ŚLIMAK", "ШНЕК"));
						if (input.contains("WENTYLATOR ROZDZ."))
							cell.setCellValue(cell.getStringCellValue().replace("WENTYLATOR ROZDZ.",
									"ВЕНТИЛЯТОР РАСПР. ЩИТА"));
						if (input.contains("WENTYLATOR"))
							cell.setCellValue(cell.getStringCellValue().replace("WENTYLATOR", "ВЕНТИЛЯТОР"));
						if (input.contains("ROZDZ."))
							cell.setCellValue(cell.getStringCellValue().replace("ROZDZ.", "РАСПР. ЩИТ"));
						if (input.contains("ŚLIMAK ODP."))
							cell.setCellValue(cell.getStringCellValue().replace("ŚLIMAK ODP.", "ШНЕК ОТХОДОВ"));
						if (input.contains("CELKA KURZ."))
							cell.setCellValue(cell.getStringCellValue().replace("CELKA KURZ.", "ШЛЮЗ. ЗАТВ."));

						if (input.contains("WENT. ZEWN."))
							cell.setCellValue(cell.getStringCellValue().replace("WENT. ZEWN.", "ВЕНТ. ВНЕШН."));
						if (input.contains("NAZWA URZĄDZENIA"))
							cell.setCellValue(
									cell.getStringCellValue().replace("NAZWA URZĄDZENIA", "НАЗВАНИЕ ОБОРУДОВАНИЯ"));
						if (input.contains("OCHR. PRZECIWPRZEP."))
							cell.setCellValue(cell.getStringCellValue().replace("OCHR. PRZECIWPRZEP.",
									"ЗАЩИТА ОТ ПЕРЕНАПР."));
						if (input.contains("ŚLIMAK"))
							cell.setCellValue(cell.getStringCellValue().replace("ŚLIMAK", "ШНЕК"));
						if (input.contains("PODN."))
							cell.setCellValue(cell.getStringCellValue().replace("PODN.", "НОРИЯ"));
						if (input.contains("ŁAŃC."))
							cell.setCellValue(cell.getStringCellValue().replace("ŁAŃC.", "ЦЕПН."));
						if (input.contains("SUSZ."))
							cell.setCellValue(cell.getStringCellValue().replace("SUSZ.", "ЗЕРНОСУШ."));
						if (input.contains("SIŁOWNIK"))
							cell.setCellValue(cell.getStringCellValue().replace("SIŁOWNIK", "ЦИЛИНДР"));
						if (input.contains("CEWKA"))
							cell.setCellValue(cell.getStringCellValue().replace("CEWKA", "КАТ. ИНД."));
						if (input.contains("UKŁAD WYSYPU"))
							cell.setCellValue(cell.getStringCellValue().replace("UKŁAD WYSYPU", "СИСТ. ВЫСЫПА"));
						if (input.contains("KONTAKTR."))
							cell.setCellValue(cell.getStringCellValue().replace("KONTAKTR.", "ГЕРКОН"));

						if (input.contains("WENT."))
							cell.setCellValue(cell.getStringCellValue().replace("WENT.", "ВЕНТ."));
						if (input.contains("ŻALUZJA"))
							cell.setCellValue(cell.getStringCellValue().replace("ŻALUZJA", "ЖАЛЮЗИ"));
						if (input.contains("POŁ."))
							cell.setCellValue(cell.getStringCellValue().replace("POŁ.", "ПОЛ."));

						if (input.contains("WIALNIA"))
							cell.setCellValue(cell.getStringCellValue().replace("WIALNIA", "ВЕЯЛКА"));

						if (input.contains("ZAS."))
							cell.setCellValue(cell.getStringCellValue().replace("ZAS.", "ПИТ."));
						if (input.contains("PRĄD"))
							cell.setCellValue(cell.getStringCellValue().replace("PRĄD", "ТОК"));
						if (input.contains("KONSOLA"))
							cell.setCellValue(cell.getStringCellValue().replace("KONSOLA", "КОНСОЛЬ"));
						if (input.contains("MIN."))
							cell.setCellValue(cell.getStringCellValue().replace("MIN.", "МИН."));
						if (input.contains("MAX."))
							cell.setCellValue(cell.getStringCellValue().replace("MAX.", "МАКС."));
						if (input.contains("CZ. IND"))
							cell.setCellValue(cell.getStringCellValue().replace("CZ. IND", "ДАТЧ. ИНД."));

						if (input.contains("ROZ. SYGN."))
							cell.setCellValue(cell.getStringCellValue().replace("ROZ. SYGN.", "РАСПР. ЩИТ"));
						if (input.contains("WYGARNIAJĄCY"))
							cell.setCellValue(cell.getStringCellValue().replace("WYGARNIAJĄCY", "ЗАЧИСТНОЙ"));
						if (input.contains("IWANOWKA"))
							cell.setCellValue(cell.getStringCellValue().replace("IWANOWKA", "ИВАНОВКА"));
						if (input.contains("POM. WILG."))
							cell.setCellValue(cell.getStringCellValue().replace("POM. WILG.", "ИЗМ. ВЛАЖН."));

						if (input.contains("STER."))
							cell.setCellValue(cell.getStringCellValue().replace("STER.", "УПР."));

						if (input.contains("ZASYP"))
							cell.setCellValue(cell.getStringCellValue().replace("ZASYP", "ЗАСЫП"));
						if (input.contains("STOP"))
							cell.setCellValue(cell.getStringCellValue().replace("STOP", "СТОП"));
						if (input.contains("START"))
							cell.setCellValue(cell.getStringCellValue().replace("START", "СТАРТ"));

						if (input.contains("ASPIRACJI"))
							cell.setCellValue(cell.getStringCellValue().replace("ASPIRACJI", "АСПИРАЦИИ"));
						if (input.contains("GÓRNY"))
							cell.setCellValue(cell.getStringCellValue().replace("GÓRNY", "ВЕРХНИЙ"));

						if (input.contains("ODCZYT"))
							cell.setCellValue(cell.getStringCellValue().replace("ODCZYT", "СЧИТЫВАНИЕ"));

						if (input.contains("POD. TAŚMOWY"))
							cell.setCellValue(cell.getStringCellValue().replace("POD. TAŚMOWY", "ЛЕНТ. ТРАНСП."));
						if (input.contains("STERUJĄCY"))
							cell.setCellValue(cell.getStringCellValue().replace("STERUJĄCY", "УПРАВЛЕНИЕ"));
						if (input.contains("ASPIRACJA"))
							cell.setCellValue(cell.getStringCellValue().replace("ASPIRACJA", "АСПИРАЦИЯ"));

						if (input.contains("CELKA KURZOWA"))
							cell.setCellValue(
									cell.getStringCellValue().replace("CELKA KURZOWA", "ШЛЮЗОВОЙ ЗАТВОР"));

						if (input.contains("KASETA"))
							cell.setCellValue(cell.getStringCellValue().replace("KASETA", "КАСЕТА"));

						if (input.contains("NADM."))
							cell.setCellValue(cell.getStringCellValue().replace("NADM.", "НИЖН."));

						if (input.contains("DACH."))
							cell.setCellValue(cell.getStringCellValue().replace("DACH.", "ВЕРХН."));
						if (input.contains("NADM"))
							cell.setCellValue(cell.getStringCellValue().replace("NADM", "НИЖН."));

						if (input.contains("KOMPRESOR"))
							cell.setCellValue(cell.getStringCellValue().replace("KOMPRESOR", "КОМПРЕССОР"));

						if (input.contains("CZ. NAP."))
							cell.setCellValue(cell.getStringCellValue().replace("CZ. NAP.", "ДАТЧ. УР."));
						if (input.contains("NAP. MAX"))
							cell.setCellValue(cell.getStringCellValue().replace("NAP. MAX", "УР. МАКС."));
						if (input.contains("NAP. MIN"))
							cell.setCellValue(cell.getStringCellValue().replace("NAP. MIN", "УР. МИН."));
						if (input.contains("NAP."))
							cell.setCellValue(cell.getStringCellValue().replace("NAP.", "УР."));
						if (input.contains("DLA "))
							cell.setCellValue(cell.getStringCellValue().replace("DLA ", "ДЛЯ "));
						if (input.contains("ORATOV"))
							cell.setCellValue(cell.getStringCellValue().replace("ORATOV", "ОРАТОВ"));
						if (input.contains("ZADAWANIE"))
							cell.setCellValue(cell.getStringCellValue().replace("ZADAWANIE", "НАСТРОЙКА"));
						if (input.contains("CZĘSTOTLIWOŚCI"))
							cell.setCellValue(cell.getStringCellValue().replace("CZĘSTOTLIWOŚCI", "ЧАСТОТЫ"));
						if (input.contains("ŁAŃCUCHCOWY"))
							cell.setCellValue(cell.getStringCellValue().replace("ŁAŃCUCHCOWY", "ЦЕПНОЙ"));
						if (input.contains("PRZYCISK"))
							cell.setCellValue(cell.getStringCellValue().replace("PRZYCISK", "КЛАВИША"));
						if (input.contains("URZ."))
							cell.setCellValue(cell.getStringCellValue().replace("URZ.", "ОБОР."));
						if (input.contains("CZ."))
							cell.setCellValue(cell.getStringCellValue().replace("CZ.", "ДАТЧ."));
						if (input.contains("POD"))
							cell.setCellValue(cell.getStringCellValue().replace("POD", "ПОД."));						
						if (input.contains("RYGIEL WÓZKA"))
							cell.setCellValue(cell.getStringCellValue().replace("RYGIEL WÓZKA", "РИГЕЛЬ ТЕЛЕЖКИ"));
						if (input.contains("GÓRA"))
							cell.setCellValue(cell.getStringCellValue().replace("GÓRA", "ВВЕРХ."));
						
						if (input.contains("DÓŁ"))
							cell.setCellValue(cell.getStringCellValue().replace("DÓŁ", "ВНИЗ."));
						
						if (input.contains("MIN"))
							cell.setCellValue(cell.getStringCellValue().replace("MIN", "МИН"));
						
						if (input.contains("BĘBEN SITOWY"))
							cell.setCellValue(cell.getStringCellValue().replace("BĘBEN SITOWY", "СИТОВОЙ БАРАБАН"));
						
						if (input.contains("MAX"))
							cell.setCellValue(cell.getStringCellValue().replace("MAX", "МАКС"));
						
						
						
						if (input.contains("WÓZEK"))
							cell.setCellValue(cell.getStringCellValue().replace("WÓZEK", "ТЕЛЕЖК."));
						if (input.contains("RYGIEL"))
							cell.setCellValue(cell.getStringCellValue().replace("RYGIEL", "РИГЕЛЬ"));
						if (input.contains("ZAŁ."))
							cell.setCellValue(cell.getStringCellValue().replace("ZAŁ.", "ВКЛ."));
						if (input.contains("KIER"))
							cell.setCellValue(cell.getStringCellValue().replace("KIER", "НАПР"));
						
					}

				});

			});

		}
		FileOutputStream outputStream;
		outputStream = new FileOutputStream("test2.xls");
		workbook.write(outputStream);
		workbook.close();		
	}
}
