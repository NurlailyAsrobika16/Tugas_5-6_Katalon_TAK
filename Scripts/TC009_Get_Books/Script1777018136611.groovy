import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static org.assertj.core.api.Assertions.*
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

def response = WS.sendRequest(findTestObject('Books/GET'))

WS.verifyResponseStatusCode(response, 200)
assertThat(response.getStatusCode()).isEqualTo(200)

// Bukan error
assertThat(response.getStatusCode()).isLessThan(400)

// Ukuran array = 200
def json = new JsonSlurper().parseText(response.getResponseBodyContent())
assertThat(json.size()).isEqualTo(200)

// Struktur field index[0]
assertThat(json[0].id).isNotNull()
assertThat(json[0].title).isNotNull()
assertThat(json[0].description).isNotNull()
assertThat(json[0].pageCount).isNotNull()
assertThat(json[0].excerpt).isNotNull()
assertThat(json[0].publishDate).isNotNull()

// Tipe data
assertThat(json[0].id).isInstanceOf(Integer)
assertThat(json[0].pageCount).isInstanceOf(Integer)
assertThat(json[0].title).isInstanceOf(String)

// Nilai spesifik
assertThat(json[0].id).isEqualTo(1)
assertThat(json[0].title).isEqualTo("Book 1")
assertThat(json[0].pageCount).isEqualTo(100)

// title tidak kosong
assertThat(json[0].title.toString()).isNotEmpty()

// pageCount bertambah per buku (100 * id)
assertThat(json[4].pageCount).isEqualTo(500)

// Performa
assertThat(response.getElapsedTime()).isGreaterThan(0L)
assertThat(response.getElapsedTime()).isLessThan(5000L)

// Content-Type
def contentType = response.getHeaderFields().get("Content-Type")
assertThat(contentType.toString()).contains("application/json")
