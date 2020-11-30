package com.andrii;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBElement;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Text;

public class Word {
	private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
		List<Object> result = new ArrayList<Object>();
		if (obj instanceof JAXBElement)
			obj = ((JAXBElement<?>) obj).getValue();

		if (obj.getClass().equals(toSearch))
			result.add(obj);
		else if (obj instanceof ContentAccessor) {
			List<?> children = ((ContentAccessor) obj).getContent();
			for (Object child : children) {
				result.addAll(getAllElementFromObject(child, toSearch));
			}
		}
		return result;
	}

	private static WordprocessingMLPackage replacePlaceholder(WordprocessingMLPackage template, String name,
			String placeholder) throws Docx4JException, FileNotFoundException {
		List<Object> texts = getAllElementFromObject(template.getMainDocumentPart(), Text.class);
		PrintWriter zapis = new PrintWriter("nazwa_plikuOratov.txt");
		for (Object text : texts) {
			Text textElement = (Text) text;
			zapis.println(textElement.getValue());
			if (textElement.getValue().contains(name)) {
				textElement.setValue(textElement.getValue().replace(name, placeholder));
			}
		}
		return template;

	}
	
	public static void translateProjekt(String pathToWord) throws FileNotFoundException, Docx4JException {
		WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
				.load(new FileInputStream(new File(pathToWord)));
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZAKRES OPRACOWANIA", "Сфера документации");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PODSTAWA OPRACOWANIA", "Основания документации");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ROZDZIELACZ EL.", "КЛАПАН ПЕРЕКИДНОЙ ЭЛ.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Podajnik taśmowy", "Ленточный транспортер");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Rys. wnętrza rozdzielnicy.", "Рис. середины распр. щита");
		wordMLPackage = replacePlaceholder(wordMLPackage, "GR. ODIORNIKÓW", "ГР. ПРИЕМНИКОВ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "szafowa", "щитовой");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WYGARNIAJĄCY", "ЗАЧИСТНОЙ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Winnica", "Винница");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Wapniarka", "Вапнярка");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Oratov", "Оратов");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Iwanowka", "Ивановка");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Zakupne", "Закупне");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Антонины", "Антонины");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ODPADÓW", "ОТХОДОВ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "BĘBEN SITOWY", "СИТОВОЙ БАРАБАН");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PODAJNIK ŚLIMAKOWY", "ШНЕКОВЫЙ ТРАНСПОРТЕР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZASUWA ELEKTRYCZNA", "ЗАДВИЖКА ЭЛЕКТРИЧЕСКАЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Sprawdził", "Проверил");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Data", "Дата");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Imię i nazwisko", "Имя и фамилия");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Uprawnienia", "Права");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Nr projektu", "Nr umowy");
		wordMLPackage = replacePlaceholder(wordMLPackage, "DOKUMENTACJA TECHNICZNA", "ТЕХНИЧЕСКАЯ ДОКУМЕНТАЦИЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PROJEKT TECHNICZNY", "ТЕХНИЧЕСКИЙ ПРОЕКТ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "BRANŻA ELEKTRYCZNA", "ЭЛЕКТРИЧЕСКАЯ ОТРАСЛЬ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Nr umowy", "Nr договора");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Temat", "Тема");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Obiekt magazynowo", "Объект хранения");
		wordMLPackage = replacePlaceholder(wordMLPackage, "suszarniczy", "и сушения");
		wordMLPackage = replacePlaceholder(wordMLPackage, " Winnica", "Винница");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Adres", "Адресс");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Rodzaj", "Тип");
		wordMLPackage = replacePlaceholder(wordMLPackage, "opracowania", "документации");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Projekt sieci nn, zasilani",
				"Проектирование низковольтных сетей, электропитани");
		wordMLPackage = replacePlaceholder(wordMLPackage, "i sterowani", "и управлени");
		wordMLPackage = replacePlaceholder(wordMLPackage, "urządzeniami technologicznymi",
				"технологическими устройствами");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Stadium", "Стадия");
		wordMLPackage = replacePlaceholder(wordMLPackage, "dokumentacji", "Документации");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Projekt budowlany i wykonawczy",
				"Проект строительный и исполнительный");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Zamawiający", "Заказчик");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Zawartość opracowania:", "Содержание документации");
		wordMLPackage = replacePlaceholder(wordMLPackage, "INFORMACJE WSTĘPNE", "ПРЕДВАРИТЕЛЬНАЯ ИНФОРМАЦИЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Przedmiot opracowania", "Предмет документаци");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Zakres opracowania", "Сфера документации");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Podstawa opracowania", "Основания для документации");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Opis techniczny", "ТЕХНИЧЕСКОЕ ОПИСАНИЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Charakterystyka techniczna zasilania",
				"Технические характеристики источника питания");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Bilans mocy", "Баланс мощности");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Instalacje projektowane", "Проектирование установок");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Rozdzielnice elektryczne",
				"ЭЛЕКТРИЧЕСКИЕ РАСПРЕДЕЛИТЕЛЬНЫЕ ЩИТЫ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Dodatkowa ochrona przeciwporażeniowa",
				"ДОПОЛНИТЕЛЬНАЯ ЗАЩИТА ОТ ПОРАЖЕНИЯ ЭЛЕКТРИЧЕСКИМ ТОКОМ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Uwagi końcowe opracowania technicznego",
				"ЗАКЛЮЧИТЕЛЬНЫЕ ЗАМЕЧАНИЯ ПО ТЕХНИЧЕСКОЙ ДОКУМЕНТАЦИИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Obliczenia", "КАЛЬКУЛЯЦИИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Moc całkowita obiektu", "Общая мощность объекта");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Dobór zabezpieczenia oraz kabla WLZ",
				"Выбор защиты и кабеля WLZ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Dobór kabla zasilającego i zabezpieczenia odbiornik",
				"Выбор кабеля питания и защиты");
		wordMLPackage = replacePlaceholder(wordMLPackage, "rzenośnik łańcuchowy", "ранспортер цепной");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Załącznik", "Приложение");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Proponowane trasy kablowe.",
				"Предлагаемые кабельные трассы.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Rozmieszczenie odbiorników 230/400V na obiekcie",
				"Размещение на объекте приемников напряжения 230/400В");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Rozmieszczenie czujników 24V",
				"Расположение датчиков постоянного тока 24 В");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Rozmieszczenie rozdzielnic sygnałowych",
				"Распределение сигнальных распределительных щитов");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Chojnów", "Хойнув");
		wordMLPackage = replacePlaceholder(wordMLPackage, "wrzesień", "сентябрь");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Podstawa opracowania", "ОСНОВАНИЯ ДЛЯ ДОКУМЕНТАЦИИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "OPIS TECHNICZNY", "ТЕХНИЧЕСКОЕ ОПИСАНИЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Charakterystyka techniczna zasilania",
				"Технические характеристики источника питания");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Podstawowe dane transformatora:",
				"Основные данные трансформатора:");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Nap. str. pierwotnej", "Первичное напряжение");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Nap. str. wtórnej", "Вторичное напряжение");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Klasa izolacji str. pierwotna",
				"Класс изоляции перв. напряжения ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Klasa izolacji str. wtórna",
				"Класс изоляции вт. напряжения");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Moc znamionowa", "Номинальная мощность ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Gr. połączeń", "Гр.подключений");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Napięcie zwarcia", "Напряжение короткого замыкания");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Waga ", "Вес");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Tabela", "Таблица");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Rozdzielnica", "Распределительный щит");
		wordMLPackage = replacePlaceholder(wordMLPackage, "NAZWA URZĄDZENIA", "НАЗВАНИЕ ОБОРУДОВАНИЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PRZENOŚNIK ŁAŃCUCHOWY", "ЦЕПНОЙ ТРАНСПОРТЕР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "SILNIK ", "ДВИГАТЕЛЬ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PODAJNIK TAŚMOWY", "ЛЕНТОЧНЫЙ ТРАНСПОРТЕР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WIALNIA ASPIRACYJNA", "ВЕЯЛКА АСПИРАЦИОННАЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WENTYLATOR DACHOWY", "ВЕНТИЛЯТОР ВЕРХНИЙ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "KOSZA", "ЗАВАЛЬНОЙ ЯМЫ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PRZENOŚNIK", "ТРАНСПОРТЕР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WENT.", "ВЕНТ.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "DACHOWY", "ВЕРХН.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZEWN.", " ВНЕШН.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZEWN", "ВНЕШН");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ĘTRZNY", "ИЙ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "SUSZARNIA", "ЗЕРНОСУШИЛКА");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WENTYLATOR GÓRNY", "ВЕРХНИЙ ВЕНТИЛЯТОР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PALNIK ", "ГОРЕЛКА");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZASILANIE", "ПИТАНИЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "- ZAS", "- ПИТ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ILANIE", "АНИЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WENTYLATOR DOLNY", "НИЖНИЙ ВЕНТИЛЯТОР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "[kW]", "[кВт]");
		wordMLPackage = replacePlaceholder(wordMLPackage, "CZYSZCZALNIA", "СЕПАРАТОР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ŚLIMAK", "ШНЕК");
		wordMLPackage = replacePlaceholder(wordMLPackage, "NAPĘD SIT", "ПРИВОД РЕШЕТ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "CELKA KURZOWA", "ШЛЮЗОВОЙ ЗАТВОР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "NADMUCHOWY ", "НИЖНИЙ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZASILANIE", "ПИТАНИЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PODNOŚNIK KUBEŁKOWY", "НОРИЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ROLKA  ", "РОЛИК ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ŚLIMAK ODP.", "ШНЕК ОТХОДОВ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "CELKA KURZ.", "ШЛЮЗОВОЙ ЗАТВОР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ROZDZIELACZ ELEKTRYCZNY", "КЛАПАН ПЕРЕКИДНОЙ ЭЛЕКТРИЧЕСКИЙ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZASUWA ELEKTRYCZNA", "ЗАДВИЖКА ЭЛЕКТРИЧЕСКАЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ŚLIMAK WYGARNIAJĄCY", "ЗАЧИСТНОЙ ШНЕК");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WENT. DACHOWY", "ВЕНТ. ВЕРХН.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "SILOS", "СИЛОС");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PODAJNIK ", "ТРАНСПОРТЕР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "CZYSZCZALNIA", "СЕПАРАТОР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "NADMUCHOWY ", "НИЖНИЙ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZASILANIE", "ПИТАНИЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PODNOŚNIK KUBEŁKOWY", "НОРИЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Dokumentację opracował:", "Документацию разработал");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Opracował:", "Разработал");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Zawartość", "Содержание");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Projekt sieci nn, zasilanie",
				"Проектирование низковольтных сетей, электропитание ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Projekt sieci", "Проектирование низковольтных сетей ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Przedmiot", "Предмет");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Zakres", "Сфера");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Podstawa", "Основания");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Uwagi końcowe", "Окончательные замечания");
		wordMLPackage = replacePlaceholder(wordMLPackage, "technicznego", "технического");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Projektowane rozdzielnice.",
				"Проектируемые распределительные щиты");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Rozmieszczenie czujników", "Расположение датчиков");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Przenośnik łańcuchowy kosza",
				"Цепной транспортер завальной ямы");
		wordMLPackage = replacePlaceholder(wordMLPackage, "czerwiec", "июнь");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WENTYLATOR ZEWN ", "ВЕНТИЛЯТОР ВНЕШН");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WENTYLATOR", "ВЕНТИЛЯТОР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "KRĄŻĄCY", "КРУТЯЩИЙСЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "SUMA", "СУММА");
		wordMLPackage = replacePlaceholder(wordMLPackage, "POTRZ. WŁASNE; OŚW.", "СОБСТВ. ТРЕБОВАНИЯ; СВЕТ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WIALNIA", "ВЕЯЛКА");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PODAJNIKI TAŚMOWE", "ЛЕНТОЧНЫЕ ТРАНСПОРТЕРЫ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PODN. KUBEŁKOWE", "НОРИИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ROZDZ. I ZASUWY EL.", "КЛАП. ПЕРЕК. И ЗАДВИЖКИ ЭЛ.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "MOC CAŁKOWITA", "ПОЛНАЯ МОЩНОСТЬ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "MOC PO KOREKCIE", "МОЩНОСТЬ ПОСЛЕ КОРЕКТЫ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "MOC POZORNA", "МОЩНОСТЬ АКТИВНАЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WSPÓŁCZ. MOCY", "КОЭФФ. МОЩНОСТИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Nazwa urządzenia", "Название оборудования");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Zabezpieczenie", "Предохранители");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Moc", "Мощность");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Stycznik/ Przekaźnik", "Контактор/Реле");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Urządzenie rozruchowe", "Пусковое устройство");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Długość", "Длина");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Kabel", "Кабель");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Typ", "Тип");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Dobór aparatury", "Выбор аппаратуры");
		wordMLPackage = replacePlaceholder(wordMLPackage, "i kabli", "и каблей");
		wordMLPackage = replacePlaceholder(wordMLPackage, "rozdzielnica", "распределительный щит");
		wordMLPackage = replacePlaceholder(wordMLPackage, "MOC", "МОЩНОСТЬ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "nn", "");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Opracował", "Разработал");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Projektowane rozdzielnice",
				"Проектируемые распределительные щиты");
		wordMLPackage = replacePlaceholder(wordMLPackage, "zasilani", "электропитани");
		wordMLPackage = replacePlaceholder(wordMLPackage, "bilans mocy", "баланс мощности");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WENT", "ВЕНТ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "YLATOR", "ИЛЯТОР");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ROZDZIELNICE ELEKTRYCZNE",
				"РАСПРЕДЕЛИТЕЛЬНЫЕ ЩИТЫ ЭЛЕКТРИЧЕСКИЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "DODATKOWA OCHRONA PRZECIWPORAŻENIOWA",
				"ДОПОЛНИТЕЛЬНАЯ ЗАЩИТА ОТ ПЕРЕНАПРЯЖЕНИЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "UWAGI KOŃCOWE OPRACOWANIA TECHNICZNEGO",
				"ЗАКЛЮЧИТЕЛЬНЫЕ ЗАМЕЧАНИЯ ПО ТЕХНИЧЕСКОМУ ИССЛЕДОВАНИЮ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "OBLICZENIA", "КАЛЬКУЛЯЦИИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "GRUPA ODBIORNIKÓW", "ГРУППА ПРИЕМНИКОВ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ТРАНСПОРТЕРI", "ТРАНСПОРТЕРЫ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ШНЕКI KRĄŻĄCE", "КРУТЯЩИЕСЯ ШНЕКИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WENTYLATORY DACH.", "ВЕРХН. ВЕНТИЛЯТОРЫ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "wyznaczenie mocy zapotrzebowanej",
				"определение нужной мощности");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Zalecany kabel i zabezpieczenie",
				"Рекомендуемый кабель и защита");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZASILANA ROZDZIELNICA", "ПИТАЕМЫЙ РАСПРЕДЕЛИТЕЛЬНЫЙ ЩИТ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "KABEL", "КАБЕЛЬ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZABEZPIECZENIE", "ПРЕДОХРАНИТЕЛИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Pранспортер", "Транспортер");
		wordMLPackage = replacePlaceholder(wordMLPackage, "kosza", "завальной ямы");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Zabezp", "Предохр");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ieczenie", "анители");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ARNIA", "СУШИЛКА");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ШНЕКOWY", "ШНЕКОВЫЙ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Dobór zabezpi", "Выбор предохр");
		wordMLPackage = replacePlaceholder(wordMLPackage, "eczenia oraz", "анителя и");
		wordMLPackage = replacePlaceholder(wordMLPackage, "kabla", "кабеля");
		wordMLPackage = replacePlaceholder(wordMLPackage, "NADM.", "НИЖН.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WYGСУШИЛКАJĄCY.", "ЗАЧИСТНОЙ.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "TAŚMOWE", "ЛЕНТОЧНЫЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "NADMUCHOWE", "НИЖНИЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "DACHOWE", "ВЕРХНИЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ROZDZ. I ZASUWY", "КЛАП. ПЕР. И ЗАДВИЖКИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "POD. KUBEŁKOWE", "НОРИИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "POD.", "НОРИИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "GÓRNY", "ВЕРХНИЙ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "DOLNY", "НИЖНИЙ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ROLKA", "РОЛИК");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ODP.", "ОТХ.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "CZYSZCZ.", "СЕПАРАТ.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "SUSZ.", "ЗЕРНОСУШ.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "SUSZ", "ЗЕРНО");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PODN", "НОРИИ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "POD", "ТРАНСП");
		wordMLPackage = replacePlaceholder(wordMLPackage, "AJNIKI", "ОРТЕРЫ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "KUBEŁK", "");
		wordMLPackage = replacePlaceholder(wordMLPackage, "OWE", "");
		wordMLPackage = replacePlaceholder(wordMLPackage, "całkowita", "полная");
		wordMLPackage = replacePlaceholder(wordMLPackage, "EL.", "ЭЛ.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ZABEZP.", "ПРЕДОХР.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "STYCZNIK/ PRZEKAŹNIK", "КОНТАКТОР/РЕЛЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "URZĄDZENIE ROZRUCH", "ПУСКОВОЕ УСТРОЙСТВО");
		wordMLPackage = replacePlaceholder(wordMLPackage, "DŁ. KABLA", "ДЛ. КАБЕЛЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "TYP KABLA", "ТИП КАБЕЛЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PRZEN. ŁAŃC.", "ЦЕПН. ТРАНСП.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PRZEN. ŁAŃCUCHOWY", "ЦЕПН. ТРАНСП.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Dobór zabezp", "Выбор предохр");
		wordMLPackage = replacePlaceholder(wordMLPackage, "ieczeń KABLA", "анителей кабеля");
		wordMLPackage = replacePlaceholder(wordMLPackage, "предохрeczeń", "предохранителей");
		wordMLPackage = replacePlaceholder(wordMLPackage, "NAZWA U", "НАЗВАНИЕ О");
		wordMLPackage = replacePlaceholder(wordMLPackage, "RZĄDZENIA", "БОРУДОВАНИЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "zasilającego i zabezpieczenia odbior",
				"питаемый и предохраняемый приемник ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Dobór", "Выбор");

		wordMLPackage = replacePlaceholder(wordMLPackage, "styczeń", "январь");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Modernizacja obiektu magazynowo",
				"Модернизация объекта складско");
		wordMLPackage = replacePlaceholder(wordMLPackage, "suszarniczego", "сушильного");
		wordMLPackage = replacePlaceholder(wordMLPackage, "GR. ODBIORNIKÓW", "Выбор предохр");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Podajniki taśmowe", "анителей кабеля");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Went. nadmuchowe", "предохранителей");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Went. dachowe", "НАЗВАНИЕ О");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Zasuwy i rozdz.", "БОРУДОВАНИЯ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Całkowita moc pozorna obiektu:",
				"питаемый и предохраняемый приемник ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Współczyik mocy obiektu:", "Выбор");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Podajnik taśmowy", "январь");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Prąd", "Модернизация объекта складско");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Prędkość", "сушильного");
		wordMLPackage = replacePlaceholder(wordMLPackage, "DACH.", "ВЕРХН.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "WYG.", "ЗАЧ.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PIS TECHNICZNY", "ПИСАНИЕ ТЕХНИЧЕСКОЕ");
		wordMLPackage = replacePlaceholder(wordMLPackage, "Rozmieszczenie aparatury wewnątrz", "Расположение аппаратуры внутри.");
		wordMLPackage = replacePlaceholder(wordMLPackage, "rozdzielnicy.", "распределительного щита");
		wordMLPackage = replacePlaceholder(wordMLPackage, "listopad.", "ноябрь");
		wordMLPackage = replacePlaceholder(wordMLPackage, "styczeń.", "январь");
		wordMLPackage = replacePlaceholder(wordMLPackage, "luty.", "февраль");
		wordMLPackage = replacePlaceholder(wordMLPackage, "marzec.", "март");
		wordMLPackage = replacePlaceholder(wordMLPackage, "kwiecień.", "апрель");
		wordMLPackage = replacePlaceholder(wordMLPackage, "maj.", "май");
		wordMLPackage = replacePlaceholder(wordMLPackage, "czerwiec.", "июнь");
		wordMLPackage = replacePlaceholder(wordMLPackage, "lipiec.", "июль");
		wordMLPackage = replacePlaceholder(wordMLPackage, "sierpień.", "август");
		wordMLPackage = replacePlaceholder(wordMLPackage, "wrzesień.", "сентябрь");
		wordMLPackage = replacePlaceholder(wordMLPackage, "październik.", "октябрь");
		wordMLPackage = replacePlaceholder(wordMLPackage, "grudzień.", "декабрь");
		wordMLPackage = replacePlaceholder(wordMLPackage, "PIS TECHNICZNY", "ПИСАНИЕ ТЕХНИЧЕСКОЕ");
		wordMLPackage.save(new File(pathToWord));
	}
}
