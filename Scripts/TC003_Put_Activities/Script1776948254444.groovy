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
import groovy.json.JsonSlurper
import static org.assertj.core.api.Assertions.*
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Kirim PUT request
def response = WS.sendRequest(findTestObject('Activities/PUT'))


WS.verifyResponseStatusCode(response, 200)

// Parse response
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

//Verifikasi field tidak null
assertThat(jsonResponse.id).isNotNull()
assertThat(jsonResponse.title).isNotNull()
assertThat(jsonResponse.dueDate).isNotNull()
assertThat(jsonResponse.completed).isNotNull()

// Verifikasi data yang diupdate
assertThat(jsonResponse.id).isEqualTo(3)
assertThat(jsonResponse.title).isEqualTo("Activity Updated")
assertThat(jsonResponse.completed).isEqualTo(true)
assertThat(jsonResponse.dueDate.toString()).isNotEmpty()

// Verifikasi dueDate format mengandung tahun
assertThat(jsonResponse.dueDate.toString()).contains("2026")
