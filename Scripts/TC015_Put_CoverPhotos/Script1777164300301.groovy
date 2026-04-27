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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static org.assertj.core.api.Assertions.assertThat

def response = WS.sendRequest(findTestObject('CoverPhotos/PUT'))

// 1. Verifikasi status code
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
assertThat(jsonResponse.url).isNotNull()

// 5. Verifikasi tipe data
assertThat(jsonResponse.id).isInstanceOf(Integer)
assertThat(jsonResponse.idBook).isInstanceOf(Integer)
assertThat(jsonResponse.url).isInstanceOf(String)

// 6. Verifikasi nilai yang diupdate
assertThat(jsonResponse.id).isEqualTo(1)
assertThat(jsonResponse.idBook).isEqualTo(3)
assertThat(jsonResponse.url).isEqualTo("https://example.com/covers/mystery-night-updated.jpg")

// 7. Verifikasi field tidak kosong
assertThat(jsonResponse.url.toString()).isNotEmpty()

// 8. Verifikasi elapsed time
assertThat(response.getElapsedTime()).isGreaterThan(0L)
assertThat(response.getElapsedTime()).isLessThan(5000L)

// 9. Verifikasi content type
def contentType = response.getHeaderFields().get("Content-Type")
assertThat(contentType.toString()).contains("application/json")
