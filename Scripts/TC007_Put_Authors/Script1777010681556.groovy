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

def response = WS.sendRequest(findTestObject('Authors/PUT'))

// 1. Status code
WS.verifyResponseStatusCode(response, 200)
assertThat(response.getStatusCode()).isEqualTo(200)

// 2. Bukan error
assertThat(response.getStatusCode()).isLessThan(400)
assertThat(response.getStatusCode()).isNotEqualTo(404)
assertThat(response.getStatusCode()).isNotEqualTo(500)

// 3. Parse response
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// 4. Verifikasi field tidak null
assertThat(jsonResponse.id).isNotNull()
assertThat(jsonResponse.idBook).isNotNull()
assertThat(jsonResponse.firstName).isNotNull()
assertThat(jsonResponse.lastName).isNotNull()

// 5. Verifikasi tipe data
assertThat(jsonResponse.id).isInstanceOf(Integer)
assertThat(jsonResponse.idBook).isInstanceOf(Integer)
assertThat(jsonResponse.firstName).isInstanceOf(String)
assertThat(jsonResponse.lastName).isInstanceOf(String)

// 6. Verifikasi nilai yang diupdate
assertThat(jsonResponse.id).isEqualTo(1)
assertThat(jsonResponse.idBook).isEqualTo(5)
assertThat(jsonResponse.firstName).isEqualTo("Nurlaily Updated")
assertThat(jsonResponse.lastName).isEqualTo("Asrobika Updated")

// 7. Verifikasi field tidak kosong
assertThat(jsonResponse.firstName.toString()).isNotEmpty()
assertThat(jsonResponse.lastName.toString()).isNotEmpty()

// 8. Verifikasi performa
assertThat(response.getElapsedTime()).isGreaterThan(0L)
assertThat(response.getElapsedTime()).isLessThan(5000L)

// 10. Verifikasi response size
assertThat(response.getResponseBodySize()).isGreaterThan(0L)
