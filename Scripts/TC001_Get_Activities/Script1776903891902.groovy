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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import static org.assertj.core.api.Assertions.*

def response = WS.sendRequest(findTestObject('Activities/GET'))

WS.verifyResponseStatusCode(response, 200)
WS.verifyElementPropertyValue(response, '[3].title', "Activity 4")
WS.verifyElementPropertyValue(response, '[4].title', "Activity 5")
WS.verifyElementPropertyValue(response, '[6].id', 7)
WS.verifyElementPropertyValue(response, '[6].title', "Activity 7")
WS.verifyElementPropertyValue(response, '[6].completed', false)
WS.verifyElementPropertyValue(response, '[9].completed', true)

def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// Verifikasi dueDate tidak kosong
assertThat(jsonResponse[6].dueDate.toString()).isNotEmpty()

// Verifikasi jumlah data = 30
assertThat(jsonResponse.size()).isEqualTo(30)

// Verifikasi tipe data
assertThat(jsonResponse[0].id).isInstanceOf(Integer)
assertThat(jsonResponse[0].completed).isInstanceOf(Boolean)

// Verifikasi Content-Type
def contentType = response.getHeaderFields().get("Content-Type")
assertThat(contentType.toString()).contains("application/json")