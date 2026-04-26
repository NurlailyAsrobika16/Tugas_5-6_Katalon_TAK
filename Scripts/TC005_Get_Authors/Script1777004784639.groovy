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

def response = WS.sendRequest(findTestObject('Authors/GET'))

WS.verifyResponseStatusCode(response, 200)
assertThat(response.getStatusCode()).isEqualTo(200)

// Verifikasi bukan error
assertThat(response.getStatusCode()).isLessThan(400)
assertThat(response.getStatusCode()).isNotEqualTo(404)
assertThat(response.getStatusCode()).isNotEqualTo(500)

// Verifikasi response size
assertThat(response.getResponseBodySize()).isGreaterThan(0L)

// Parse response
def jsonResponse = new JsonSlurper().parseText(response.getResponseBodyContent())

// Verifikasi data tidak kosong
assertThat(jsonResponse.size()).isGreaterThan(0)

// Verifikasi struktur field index [0]
assertThat(jsonResponse[0].id).isNotNull()
assertThat(jsonResponse[0].idBook).isNotNull()
assertThat(jsonResponse[0].firstName).isNotNull()
assertThat(jsonResponse[0].lastName).isNotNull()


// Verifikasi field tidak kosong index [0]
assertThat(jsonResponse[0].firstName.toString()).isNotEmpty()
assertThat(jsonResponse[0].lastName.toString()).isNotEmpty()


// Verifikasi format firstName mengandung "First Name"
assertThat(jsonResponse[0].firstName.toString()).contains("First Name")
assertThat(jsonResponse[1].firstName.toString()).contains("First Name")

// Verifikasi format lastName mengandung "Last Name"
assertThat(jsonResponse[0].lastName.toString()).contains("Last Name")
assertThat(jsonResponse[1].lastName.toString()).contains("Last Name")

// Verifikasi id data ke-100
assertThat(jsonResponse[99].id).isEqualTo(100)
assertThat(jsonResponse[99].firstName).isEqualTo("First Name 100")
assertThat(jsonResponse[99].lastName).isEqualTo("Last Name 100")
