package ontology;

import java.io.InputStream;
import java.util.ArrayList;
import com.hp.hpl.jena.rdf.model.*;

/**
 *
 * @author nkak
 */
public class OntologyManager 
{
    boolean printDebugInfo;
    
    public static final int DTVDevices_ID = 1;
    public static final int GamingConsoleDevices_ID = 2;
    public static final int ATMDevices_ID = 3;
    public static final int InfokioskDevices_ID = 4;
    public static final int SmartHomeDevices_ID = 5;
    public static final int MSSurfaceDevices_ID = 6;
    public static final int SimpleMobilePhoneDevices_ID = 7;
    public static final int SmartMobilePhoneDevices_ID = 8;
    public static final int PDADevices_ID = 9;
    public static final int AtDriving_ID = 10;
    public static final int AtEntertainment_ID = 11;
    public static final int AtHome_ID = 12;
    public static final int AtWork_ID = 13;
    public static final int HoursOfTheDay_ID = 14;
    public static final int LinuxOSPlatforms_ID = 15;
    public static final int SUNOSOSPlatforms_ID = 16;
    public static final int Windows7OSPlatforms_ID = 17;
    public static final int WES2007_ID = 18;
    public static final int WES2009_ID = 19;
    public static final int WindowsVistaOSPlatform_ID = 20;
    public static final int WindowsXPOSPlatform_ID = 21;
    public static final int BrowserWithJava_ID = 22;
    public static final int Services_ID = 23;
    public static final int AccessSettings_ID = 24;
    public static final int AudioNotificationsGeneralSettings_ID = 25;
    public static final int AudioNotificationsLinkSettings_ID = 26;
    public static final int AudioVolumeSettings_ID = 27;
    public static final int SpeechRecognitionSettings_ID = 28;
    public static final int EchoOptionsSettings_ID = 29;
    public static final int TextToSpeechEngineSettings_ID = 30;
    public static final int TextToSpeechLanguageSettings_ID = 31;
    public static final int PunctuationSettings_ID = 32;
    public static final int ReadingCapitalsSettings_ID = 33;
    public static final int SpeakingRateSettings_ID = 34;
    public static final int SpeekingPitchSettings_ID = 35;
    public static final int VoiceSettings_ID = 36;
    public static final int VoiceVolume_ID = 37;
    public static final int EasyOneCommunicatorSeetings_ID = 38;
    public static final int LanguageSettings_ID = 39;
    public static final int MsSurfaceSettings_ID = 40;
    public static final int SAToGoSettings_ID = 41;
    public static final int SmartHouseSettings_ID = 42;
    public static final int BrailleDisplaySettings_ID = 43;
    public static final int GestureSettings_ID = 44;
    public static final int UsersAssistantsIDSettings_ID = 45;
    public static final int UsersContactsSettings_ID = 46;
    public static final int Gmail_ID = 47;
    public static final int UsersIDSettings_ID = 48;
    public static final int UsersLanguageSettings_ID = 49;
    public static final int UsersXMPPChatIDSettings_ID = 50;
    public static final int UsersXMPPPasswordSettings_ID = 51;
    public static final int ColorSettings_ID = 52;
    public static final int ButtonSettings_ID = 53;
    public static final int InterfaceSettings_ID = 54;
    public static final int KeyboardLayoutSettings_ID = 55;
    public static final int MagnifierSettings_ID = 56;
    public static final int SubtitleSettings_ID = 57;
    public static final int TextSizeSettings_ID = 58;
    public static final int TextStyleSettings_ID = 59;
    public static final int VisualNotificationsSettings_ID = 60;
    public static final int VisualResponseSettings_ID = 61;
    public static final int WebAnywhereSettings_ID = 62;
    public static final int SystemsToTransformImagesIntoSoundOrVoice_ID = 63;
    public static final int SatelliteNavigationSystem_ID = 64;
    public static final int WordProcessingSoftware_ID = 65;
    public static final int EasyOneCommunicator_ID = 66;
    public static final int SocialNetworkApp_ID = 67;
    public static final int SoftwareForSoundOrSpeechAmplification_ID = 68;
    public static final int PaperDocumentsReadingSystemOCR_ID = 69;
    public static final int SAToGo_ID = 70;
    public static final int SpeechStreamTextHelp_ID = 71;
    public static final int WebAnywhere_ID = 72;
    public static final int VideoMagnifier_ID = 73;
    public static final int DelayedCaptioningSystem_ID = 74;
    public static final int RealTimeCaptioningSystem_ID = 75;
    public static final int SoftwareInterfaceForComputer_ID = 76;
    public static final int eKiosk_ID = 77;
    public static final int AlternativeInputDeviceForComputer_ID = 78;
    public static final int EyegazeSystem_ID = 79;
    public static final int MsSurface_ID = 80;
    public static final int VoiceRecognitionSystem_ID = 81;
    public static final int PointingDevice_ID = 82;
    public static final int SwitchInterface_ID = 83;
    public static final int MouseControlSoftware_ID = 84;
    public static final int OnScreenKeyboard_ID = 85;
    public static final int SoftwareForAdjustingInoutDevicesResponse_ID = 86;
    public static final int WordPredictionSoftware_ID = 87;
    public static final int SpeechSynthesis_ID = 88;
    public static final int MagnifyingSoftware_ID = 89;
    public static final int ScreenReader_ID = 90;
    public static final int SoftwareForAdjustingColorCombinationAndTextSize_ID = 91;
    public static final int SoftwareToModifyThePointerAppearance_ID = 92;
    public static final int SmartHouse_ID = 93;
    public static final int DeviceVendors_ID = 94;
    public static final int PlatformVendors_ID = 95;
    public static final int SolutionVendors_ID = 96;
    
    private Model model;
    
    private static OntologyManager instance = null;
    
    
    private OntologyManager() 
    {
        printDebugInfo = false;
        
        // create an empty model
        model = ModelFactory.createDefaultModel();
        
        InputStream in = this.getClass().getResourceAsStream("/ontology/ontologies/semantincFrameworkOfContentAndSolutions.owl");
        if (in == null) {
            throw new IllegalArgumentException( "File: /ontology/ontologies/semantincFrameworkOfContentAndSolutions.owl not found!");
        }
        
        // read the RDF/XML file
        model.read(in, "");
    }
    
    public static OntologyManager getInstance() 
    {
        if(instance == null) 
            instance = new OntologyManager();
        return instance;
    }
    
    public void init()
    {
        StmtIterator iter = model.listStatements();
        
        while (iter.hasNext()) {
            Statement stmt      = iter.nextStatement();  // get next statement
            Resource  subject   = stmt.getSubject();     // get the subject
            Property  predicate = stmt.getPredicate();   // get the predicate
            RDFNode   object    = stmt.getObject();      // get the object

            if(object instanceof Resource) 
            {
                //System.out.println("SUBJECT:" + subject.toString() + ", PREDICATE:" + predicate.toString() + ", OBJECT:" + object.toString());
            } 
            else 
            {
                // object is a literal
                //System.out.println("---LITERAL---> SUBJECT:" + subject.toString() + ", PREDICATE:" + predicate.toString() + ", OBJECT:" + object.toString());
            }

        } 

//--------------------------      
//TESTING...
//getting class instances...
//--------------------------        
        //-------
        //DEVICES
        //-------
        
        //get DTVDevices
        ArrayList<Device> allInstances_DTVDevice = getInstances(DTVDevices_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_DTVDevice.size(); i++)
                System.out.println(allInstances_DTVDevice.get(i).toString());
        }
        
        //get GamingConsoleDevices
        ArrayList<Device> allInstances_GamingConsoleDevice = getInstances(GamingConsoleDevices_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_GamingConsoleDevice.size(); i++)
                System.out.println(allInstances_GamingConsoleDevice.get(i).toString());
        }
        
        //get ATMDevices
        ArrayList<Device> allInstances_ATMDevice = getInstances(ATMDevices_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_ATMDevice.size(); i++)
                System.out.println(allInstances_ATMDevice.get(i).toString());
        }
        
        //get InfokioskDevices
        ArrayList<Device> allInstances_InfokioskDevice = getInstances(InfokioskDevices_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_InfokioskDevice.size(); i++)
                System.out.println(allInstances_InfokioskDevice.get(i).toString());
        }
        
        //get SmartHomeDevices
        ArrayList<Device> allInstances_SmartHomeDevice = getInstances(SmartHomeDevices_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_SmartHomeDevice.size(); i++)
                System.out.println(allInstances_SmartHomeDevice.get(i).toString());
        }
        
        //get MSSurfaceDevices
        ArrayList<Device> allInstances_MSSurfaceDevice = getInstances(MSSurfaceDevices_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_MSSurfaceDevice.size(); i++)
                System.out.println(allInstances_MSSurfaceDevice.get(i).toString());
        }
        
        //get SimpleMobilePhoneDevices
        ArrayList<Device> allInstances_SimpleMobilePhoneDevice = getInstances(SimpleMobilePhoneDevices_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_SimpleMobilePhoneDevice.size(); i++)
                System.out.println(allInstances_SimpleMobilePhoneDevice.get(i).toString());
        }
        
        //get SmartMobilePhoneDevices
        ArrayList<Device> allInstances_SmartMobilePhoneDevice = getInstances(SmartMobilePhoneDevices_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_SmartMobilePhoneDevice.size(); i++)
                System.out.println(allInstances_SmartMobilePhoneDevice.get(i).toString());
        }
        
        //get PDADevices
        ArrayList<Device> allInstances_PDADevice = getInstances(PDADevices_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_PDADevice.size(); i++)
                System.out.println(allInstances_PDADevice.get(i).toString());
        }
        
        //------------
        //ENVIRONMENTS
        //------------
        
        //get AtDriving
        ArrayList<Environment> allInstances_AtDriving = getInstances(AtDriving_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_AtDriving.size(); i++)
                System.out.println(allInstances_AtDriving.get(i).toString());
        }
        
        //get AtEntertainment
        ArrayList<Environment> allInstances_AtEntertainment = getInstances(AtEntertainment_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_AtEntertainment.size(); i++)
                System.out.println(allInstances_AtEntertainment.get(i).toString());
        }
        
        //get AtHome
        ArrayList<Environment> allInstances_AtHome = getInstances(AtHome_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_AtHome.size(); i++)
                System.out.println(allInstances_AtHome.get(i).toString());
        }
        
        //get AtWork
        ArrayList<Environment> allInstances_AtWork = getInstances(AtWork_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_AtWork.size(); i++)
                System.out.println(allInstances_AtWork.get(i).toString());
        }
        
        //get HoursOfTheDay
        ArrayList<Environment> allInstances_HoursOfTheDay = getInstances(HoursOfTheDay_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_HoursOfTheDay.size(); i++)
                System.out.println(allInstances_HoursOfTheDay.get(i).toString());
        }
        
        //---------
        //PLATFORMS
        //---------
        
        //get LinuxOSPlatforms_ID
        ArrayList<Platform> allInstances_LinuxOSPlatforms = getInstances(LinuxOSPlatforms_ID);
        if(printDebugInfo)
        {
            for(int i=0; i<allInstances_LinuxOSPlatforms.size(); i++)
                System.out.println(allInstances_LinuxOSPlatforms.get(i).toString());
        }
        
        //get SUNOSOSPlatforms_ID
        ArrayList<Platform> allInstances_SUNOSOSPlatforms = getInstances(SUNOSOSPlatforms_ID);
        if(allInstances_SUNOSOSPlatforms != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SUNOSOSPlatforms.size(); i++)
                    System.out.println(allInstances_SUNOSOSPlatforms.get(i).toString());
            }
        }
        
        //get Windows7OSPlatforms_ID
        ArrayList<Platform> allInstances_Windows7OSPlatforms = getInstances(Windows7OSPlatforms_ID);
        if(allInstances_Windows7OSPlatforms != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_Windows7OSPlatforms.size(); i++)
                    System.out.println(allInstances_Windows7OSPlatforms.get(i).toString());
            }
        }
        
        //get WES2007_ID
        ArrayList<Platform> allInstances_WES2007 = getInstances(WES2007_ID);
        if(allInstances_WES2007 !=null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_WES2007.size(); i++)
                    System.out.println(allInstances_WES2007.get(i).toString());
            }
        }
        
        //get WES2009_ID
        ArrayList<Platform> allInstances_WES2009 = getInstances(WES2009_ID);
        if(allInstances_WES2009 != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_WES2009.size(); i++)
                    System.out.println(allInstances_WES2009.get(i).toString());
            }
        }
        
        //get WindowsVistaOSPlatform_ID
        ArrayList<Platform> allInstances_WindowsVistaOSPlatform = getInstances(WindowsVistaOSPlatform_ID);
        if(allInstances_WindowsVistaOSPlatform != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_WindowsVistaOSPlatform.size(); i++)
                    System.out.println(allInstances_WindowsVistaOSPlatform.get(i).toString());
            }
        }
        
        //get WindowsXPOSPlatform_ID
        ArrayList<Platform> allInstances_WindowsXPOSPlatform = getInstances(WindowsXPOSPlatform_ID);
        if(allInstances_WindowsXPOSPlatform != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_WindowsXPOSPlatform.size(); i++)
                    System.out.println(allInstances_WindowsXPOSPlatform.get(i).toString());
            }
        }
        
        //get BrowserWithJava_ID
        ArrayList<Platform> allInstances_BrowserWithJava = getInstances(BrowserWithJava_ID);
        if(allInstances_BrowserWithJava != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_BrowserWithJava.size(); i++)
                    System.out.println(allInstances_BrowserWithJava.get(i).toString());
            }
        }
        
        //get Services_ID
        ArrayList<Platform> allInstances_Service = getInstances(Services_ID);
        if(allInstances_Service != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_Service.size(); i++)
                    System.out.println(allInstances_Service.get(i).toString());
            }
        }
        
        //--------
        //Settings
        //--------
        
        //get AccessSettings_ID
        ArrayList<Setting> allInstances_AccessSettings = getInstances(AccessSettings_ID);
        if(allInstances_AccessSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_AccessSettings.size(); i++)
                    System.out.println(allInstances_AccessSettings.get(i).toString());
            }
        }
        
        //get AudioNotificationsGeneralSettings_ID
        ArrayList<Setting> allInstances_AudioNotificationsGeneralSettings = getInstances(AudioNotificationsGeneralSettings_ID);
        if(allInstances_AudioNotificationsGeneralSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_AudioNotificationsGeneralSettings.size(); i++)
                    System.out.println(allInstances_AudioNotificationsGeneralSettings.get(i).toString());
            }
        }
        
        //get AudioNotificationsLinkSettings_ID
        ArrayList<Setting> allInstances_AudioNotificationsLinkSettings = getInstances(AudioNotificationsLinkSettings_ID);
        if(allInstances_AudioNotificationsLinkSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_AudioNotificationsLinkSettings.size(); i++)
                    System.out.println(allInstances_AudioNotificationsLinkSettings.get(i).toString());
            }
        }
        
        //get AudioVolumeSettings_ID
        ArrayList<Setting> allInstances_AudioVolumeSettings = getInstances(AudioVolumeSettings_ID);
        if(allInstances_AudioVolumeSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_AudioVolumeSettings.size(); i++)
                    System.out.println(allInstances_AudioVolumeSettings.get(i).toString());
            }
        }
        
        //get SpeechRecognitionSettings_ID
        ArrayList<Setting> allInstances_SpeechRecognitionSettings = getInstances(SpeechRecognitionSettings_ID);
        if(allInstances_SpeechRecognitionSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SpeechRecognitionSettings.size(); i++)
                    System.out.println(allInstances_SpeechRecognitionSettings.get(i).toString());
            }
        }
        
        //get EchoOptionsSettings_ID
        ArrayList<Setting> allInstances_EchoOptionsSettings = getInstances(EchoOptionsSettings_ID);
        if(allInstances_EchoOptionsSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_EchoOptionsSettings.size(); i++)
                    System.out.println(allInstances_EchoOptionsSettings.get(i).toString());
            }
        }
        
        //get TextToSpeechEngineSettings_ID
        ArrayList<Setting> allInstances_TextToSpeechEngineSettings = getInstances(TextToSpeechEngineSettings_ID);
        if(allInstances_TextToSpeechEngineSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_TextToSpeechEngineSettings.size(); i++)
                    System.out.println(allInstances_TextToSpeechEngineSettings.get(i).toString());
            }
        }
        
        //get TextToSpeechLanguageSettings_ID
        ArrayList<Setting> allInstances_TextToSpeechLanguageSettings = getInstances(TextToSpeechLanguageSettings_ID);
        if(allInstances_TextToSpeechLanguageSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_TextToSpeechLanguageSettings.size(); i++)
                    System.out.println(allInstances_TextToSpeechLanguageSettings.get(i).toString());
            }
        }
        
        //get PunctuationSettings_ID
        ArrayList<Setting> allInstances_PunctuationSettings = getInstances(PunctuationSettings_ID);
        if(allInstances_PunctuationSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_PunctuationSettings.size(); i++)
                    System.out.println(allInstances_PunctuationSettings.get(i).toString());
            }
        }
        
        //get ReadingCapitalsSettings_ID
        ArrayList<Setting> allInstances_ReadingCapitalsSettings = getInstances(ReadingCapitalsSettings_ID);
        if(allInstances_ReadingCapitalsSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_ReadingCapitalsSettings.size(); i++)
                    System.out.println(allInstances_ReadingCapitalsSettings.get(i).toString());
            }
        }
        
        //get SpeakingRateSettings_ID
        ArrayList<Setting> allInstances_SpeakingRateSettings = getInstances(SpeakingRateSettings_ID);
        if(allInstances_SpeakingRateSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SpeakingRateSettings.size(); i++)
                    System.out.println(allInstances_SpeakingRateSettings.get(i).toString());
            }
        }
        
        //get SpeekingPitchSettings_ID
        ArrayList<Setting> allInstances_SpeekingPitchSettings = getInstances(SpeekingPitchSettings_ID);
        if(allInstances_SpeekingPitchSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SpeekingPitchSettings.size(); i++)
                    System.out.println(allInstances_SpeekingPitchSettings.get(i).toString());
            }
        }
        
        //get VoiceSettings_ID
        ArrayList<Setting> allInstances_VoiceSettings = getInstances(VoiceSettings_ID);
        if(allInstances_VoiceSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_VoiceSettings.size(); i++)
                    System.out.println(allInstances_VoiceSettings.get(i).toString());
            }
        }
        
        //get VoiceVolume_ID
        ArrayList<Setting> allInstances_VoiceVolume = getInstances(VoiceVolume_ID);
        if(allInstances_VoiceVolume != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_VoiceVolume.size(); i++)
                    System.out.println(allInstances_VoiceVolume.get(i).toString()); 
            }
        }
        
        //get EasyOneCommunicatorSeetings_ID
        ArrayList<Setting> allInstances_EasyOneCommunicatorSeetings = getInstances(EasyOneCommunicatorSeetings_ID);
        if(allInstances_EasyOneCommunicatorSeetings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_EasyOneCommunicatorSeetings.size(); i++)
                    System.out.println(allInstances_EasyOneCommunicatorSeetings.get(i).toString());
            }
        }
        
        //get LanguageSettings_ID
        ArrayList<Setting> allInstances_LanguageSettings = getInstances(LanguageSettings_ID);
        if(allInstances_LanguageSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_LanguageSettings.size(); i++)
                    System.out.println(allInstances_LanguageSettings.get(i).toString());
            }
        }
        
        //get MsSurfaceSettings_ID
        ArrayList<Setting> allInstances_MsSurfaceSettings = getInstances(MsSurfaceSettings_ID);
        if(allInstances_MsSurfaceSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_MsSurfaceSettings.size(); i++)
                    System.out.println(allInstances_MsSurfaceSettings.get(i).toString());
            }
        }
        
        //get SAToGoSettings_ID
        ArrayList<Setting> allInstances_SAToGoSettings = getInstances(SAToGoSettings_ID);
        if(allInstances_SAToGoSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SAToGoSettings.size(); i++)
                    System.out.println(allInstances_SAToGoSettings.get(i).toString());
            }
        }
        
        //get SmartHouseSettings_ID
        ArrayList<Setting> allInstances_SmartHouseSettings = getInstances(SmartHouseSettings_ID);
        if(allInstances_SmartHouseSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SmartHouseSettings.size(); i++)
                    System.out.println(allInstances_SmartHouseSettings.get(i).toString());
            }
        }
        
        //get BrailleDisplaySettings_ID
        ArrayList<Setting> allInstances_BrailleDisplaySettings = getInstances(BrailleDisplaySettings_ID);
        if(allInstances_BrailleDisplaySettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_BrailleDisplaySettings.size(); i++)
                    System.out.println(allInstances_BrailleDisplaySettings.get(i).toString());
            }
        }
        
        //get GestureSettings_ID
        ArrayList<Setting> allInstances_GestureSettings = getInstances(GestureSettings_ID);
        if(allInstances_GestureSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_GestureSettings.size(); i++)
                    System.out.println(allInstances_GestureSettings.get(i).toString());
            }
        }
        
        //get UsersAssistantsIDSettings_ID
        ArrayList<Setting> allInstances_UsersAssistantsIDSettings = getInstances(UsersAssistantsIDSettings_ID);
        if(allInstances_UsersAssistantsIDSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_UsersAssistantsIDSettings.size(); i++)
                    System.out.println(allInstances_UsersAssistantsIDSettings.get(i).toString());
            }
        }
        
        //get UsersContactsSettings_ID
        ArrayList<Setting> allInstances_UsersContactsSettings = getInstances(UsersContactsSettings_ID);
        if(allInstances_UsersContactsSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_UsersContactsSettings.size(); i++)
                    System.out.println(allInstances_UsersContactsSettings.get(i).toString());
            }
        }
        
        //get Gmail_ID
        ArrayList<Setting> allInstances_Gmail = getInstances(Gmail_ID);
        if(allInstances_Gmail != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_Gmail.size(); i++)
                    System.out.println(allInstances_Gmail.get(i).toString());
            }
        }
        
        //get UsersIDSettings_ID
        ArrayList<Setting> allInstances_UsersIDSettings = getInstances(UsersIDSettings_ID);
        if(allInstances_UsersIDSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_UsersIDSettings.size(); i++)
                    System.out.println(allInstances_UsersIDSettings.get(i).toString());
            }
        }
        
        //get UsersLanguageSettings_ID
        ArrayList<Setting> allInstances_UsersLanguageSettings = getInstances(UsersLanguageSettings_ID);
        if(allInstances_UsersLanguageSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_UsersLanguageSettings.size(); i++)
                    System.out.println(allInstances_UsersLanguageSettings.get(i).toString());
            }
        }
        
        //get UsersXMPPChatIDSettings_ID
        ArrayList<Setting> allInstances_UsersXMPPChatIDSettings = getInstances(UsersXMPPChatIDSettings_ID);
        if(allInstances_UsersXMPPChatIDSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_UsersXMPPChatIDSettings.size(); i++)
                    System.out.println(allInstances_UsersXMPPChatIDSettings.get(i).toString());
            }
        }
        
        //get UsersXMPPPasswordSettings_ID
        ArrayList<Setting> allInstances_UsersXMPPPasswordSettings = getInstances(UsersXMPPPasswordSettings_ID);
        if(allInstances_UsersXMPPPasswordSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_UsersXMPPPasswordSettings.size(); i++)
                    System.out.println(allInstances_UsersXMPPPasswordSettings.get(i).toString());
            }
        }
        
        //get ColorSettings_ID
        ArrayList<Setting> allInstances_ColorSettings = getInstances(ColorSettings_ID);
        if(allInstances_ColorSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_ColorSettings.size(); i++)
                    System.out.println(allInstances_ColorSettings.get(i).toString());
            }
        }
        
        //get ButtonSettings_ID
        ArrayList<Setting> allInstances_ButtonSettings = getInstances(ButtonSettings_ID);
        if(allInstances_ButtonSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_ButtonSettings.size(); i++)
                    System.out.println(allInstances_ButtonSettings.get(i).toString());
            }
        }
        
        //get InterfaceSettings_ID
        ArrayList<Setting> allInstances_InterfaceSettings = getInstances(InterfaceSettings_ID);
        if(allInstances_InterfaceSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_InterfaceSettings.size(); i++)
                    System.out.println(allInstances_InterfaceSettings.get(i).toString());
            }
        }
        
        //get KeyboardLayoutSettings_ID
        ArrayList<Setting> allInstances_KeyboardLayoutSettings = getInstances(KeyboardLayoutSettings_ID);
        if(allInstances_KeyboardLayoutSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_KeyboardLayoutSettings.size(); i++)
                    System.out.println(allInstances_KeyboardLayoutSettings.get(i).toString());
            }
        }
        
        //get MagnifierSettings_ID
        ArrayList<Setting> allInstances_MagnifierSettings = getInstances(MagnifierSettings_ID);
        if(allInstances_MagnifierSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_MagnifierSettings.size(); i++)
                    System.out.println(allInstances_MagnifierSettings.get(i).toString());
            }
        }
        
        //get SubtitleSettings_ID
        ArrayList<Setting> allInstances_SubtitleSettings = getInstances(SubtitleSettings_ID);
        if(allInstances_SubtitleSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SubtitleSettings.size(); i++)
                    System.out.println(allInstances_SubtitleSettings.get(i).toString());
            }
        }
        
        //get TextSizeSettings_ID
        ArrayList<Setting> allInstances_TextSizeSettings = getInstances(TextSizeSettings_ID);
        if(allInstances_TextSizeSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_TextSizeSettings.size(); i++)
                    System.out.println(allInstances_TextSizeSettings.get(i).toString());
            }
        }
        
        //get TextStyleSettings_ID
        ArrayList<Setting> allInstances_TextStyleSettings = getInstances(TextStyleSettings_ID);
        if(allInstances_TextStyleSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_TextStyleSettings.size(); i++)
                    System.out.println(allInstances_TextStyleSettings.get(i).toString());
            }
        }
        
        //get VisualNotificationsSettings_ID
        ArrayList<Setting> allInstances_VisualNotificationsSettings = getInstances(VisualNotificationsSettings_ID);
        if(allInstances_VisualNotificationsSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_VisualNotificationsSettings.size(); i++)
                    System.out.println(allInstances_VisualNotificationsSettings.get(i).toString());
            }
        }
        
        //get VisualResponseSettings_ID
        ArrayList<Setting> allInstances_VisualResponseSettings = getInstances(VisualResponseSettings_ID);
        if(allInstances_VisualResponseSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_VisualResponseSettings.size(); i++)
                    System.out.println(allInstances_VisualResponseSettings.get(i).toString());
            }
        }
        
        //get WebAnywhereSettings_ID
        ArrayList<Setting> allInstances_WebAnywhereSettings = getInstances(WebAnywhereSettings_ID);
        if(allInstances_WebAnywhereSettings != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_WebAnywhereSettings.size(); i++)
                    System.out.println(allInstances_WebAnywhereSettings.get(i).toString());
            }
        }
        
        //---------
        //SOLUTIONS
        //---------
        
        //get SystemsToTransformImagesIntoSoundOrVoice_ID
        ArrayList<Solution> allInstances_SystemsToTransformImagesIntoSoundOrVoice = getInstances(SystemsToTransformImagesIntoSoundOrVoice_ID);
        if(allInstances_SystemsToTransformImagesIntoSoundOrVoice != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SystemsToTransformImagesIntoSoundOrVoice.size(); i++)
                    System.out.println(allInstances_SystemsToTransformImagesIntoSoundOrVoice.get(i).toString());
            }
        }
        
        //get SatelliteNavigationSystem_ID
        ArrayList<Solution> allInstances_SatelliteNavigationSystem = getInstances(SatelliteNavigationSystem_ID);
        if(allInstances_SatelliteNavigationSystem != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SatelliteNavigationSystem.size(); i++)
                    System.out.println(allInstances_SatelliteNavigationSystem.get(i).toString());
            }
        }
        
        //get WordProcessingSoftware_ID
        ArrayList<Solution> allInstances_WordProcessingSoftware = getInstances(WordProcessingSoftware_ID);
        if(allInstances_WordProcessingSoftware != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_WordProcessingSoftware.size(); i++)
                    System.out.println(allInstances_WordProcessingSoftware.get(i).toString());
            }
        }
        
        //get EasyOneCommunicator_ID
        ArrayList<Solution> allInstances_EasyOneCommunicator = getInstances(EasyOneCommunicator_ID);
        if(allInstances_EasyOneCommunicator != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_EasyOneCommunicator.size(); i++)
                    System.out.println(allInstances_EasyOneCommunicator.get(i).toString());
            }
        }
        
        //get SocialNetworkApp_ID
        ArrayList<Solution> allInstances_SocialNetworkApp = getInstances(SocialNetworkApp_ID);
        if(allInstances_SocialNetworkApp != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SocialNetworkApp.size(); i++)
                    System.out.println(allInstances_SocialNetworkApp.get(i).toString());
            }
        }
        
        //get SoftwareForSoundOrSpeechAmplification_ID
        ArrayList<Solution> allInstances_SoftwareForSoundOrSpeechAmplification = getInstances(SoftwareForSoundOrSpeechAmplification_ID);
        if(allInstances_SoftwareForSoundOrSpeechAmplification != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SoftwareForSoundOrSpeechAmplification.size(); i++)
                    System.out.println(allInstances_SoftwareForSoundOrSpeechAmplification.get(i).toString());
            }
        }
        
        //get PaperDocumentsReadingSystemOCR_ID
        ArrayList<Solution> allInstances_PaperDocumentsReadingSystemOCR = getInstances(PaperDocumentsReadingSystemOCR_ID);
        if(allInstances_PaperDocumentsReadingSystemOCR != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_PaperDocumentsReadingSystemOCR.size(); i++)
                    System.out.println(allInstances_PaperDocumentsReadingSystemOCR.get(i).toString());
            }
        }
        
        //get SAToGo_ID
        ArrayList<Solution> allInstances_SAToGo = getInstances(SAToGo_ID);
        if(allInstances_SAToGo != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SAToGo.size(); i++)
                    System.out.println(allInstances_SAToGo.get(i).toString());
            }
        }
        
        //get SpeechStreamTextHelp_ID
        ArrayList<Solution> allInstances_SpeechStreamTextHelp = getInstances(SpeechStreamTextHelp_ID);
        if(allInstances_SpeechStreamTextHelp != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SpeechStreamTextHelp.size(); i++)
                    System.out.println(allInstances_SpeechStreamTextHelp.get(i).toString());
            }
        }
        
        //get WebAnywhere_ID
        ArrayList<Solution> allInstances_WebAnywhere = getInstances(WebAnywhere_ID);
        if(allInstances_WebAnywhere != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_WebAnywhere.size(); i++)
                    System.out.println(allInstances_WebAnywhere.get(i).toString());
            }
        }
        
        //get VideoMagnifier_ID
        ArrayList<Solution> allInstances_VideoMagnifier = getInstances(VideoMagnifier_ID);
        if(allInstances_VideoMagnifier != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_VideoMagnifier.size(); i++)
                    System.out.println(allInstances_VideoMagnifier.get(i).toString());
            }
        }
        
        //get DelayedCaptioningSystem_ID
        ArrayList<Solution> allInstances_DelayedCaptioningSystem = getInstances(DelayedCaptioningSystem_ID);
        if(allInstances_DelayedCaptioningSystem != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_DelayedCaptioningSystem.size(); i++)
                    System.out.println(allInstances_DelayedCaptioningSystem.get(i).toString());
            }
        }
        
        //get RealTimeCaptioningSystem_ID
        ArrayList<Solution> allInstances_RealTimeCaptioningSystem = getInstances(RealTimeCaptioningSystem_ID);
        if(allInstances_RealTimeCaptioningSystem != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_RealTimeCaptioningSystem.size(); i++)
                    System.out.println(allInstances_RealTimeCaptioningSystem.get(i).toString());
            }
        }
        
        //get SoftwareInterfaceForComputer_ID
        ArrayList<Solution> allInstances_SoftwareInterfaceForComputer = getInstances(SoftwareInterfaceForComputer_ID);
        if(allInstances_SoftwareInterfaceForComputer != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SoftwareInterfaceForComputer.size(); i++)
                    System.out.println(allInstances_SoftwareInterfaceForComputer.get(i).toString());
            }
        }
        
        //get eKiosk_ID
        ArrayList<Solution> allInstances_eKiosk = getInstances(eKiosk_ID);
        if(allInstances_eKiosk != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_eKiosk.size(); i++)
                    System.out.println(allInstances_eKiosk.get(i).toString());
            }
        }
        
        //get AlternativeInputDeviceForComputer_ID
        ArrayList<Solution> allInstances_AlternativeInputDeviceForComputer = getInstances(AlternativeInputDeviceForComputer_ID);
        if(allInstances_AlternativeInputDeviceForComputer != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_AlternativeInputDeviceForComputer.size(); i++)
                    System.out.println(allInstances_AlternativeInputDeviceForComputer.get(i).toString());
            }
        }
        
        //get EyegazeSystem_ID
        ArrayList<Solution> allInstances_EyegazeSystem = getInstances(EyegazeSystem_ID);
        if(allInstances_EyegazeSystem != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_EyegazeSystem.size(); i++)
                    System.out.println(allInstances_EyegazeSystem.get(i).toString());
            }
        }
        
        //get MsSurface_ID
        ArrayList<Solution> allInstances_MsSurface = getInstances(MsSurface_ID);
        if(allInstances_MsSurface != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_MsSurface.size(); i++)
                    System.out.println(allInstances_MsSurface.get(i).toString());
            }
        }
        
        //get VoiceRecognitionSystem_ID
        ArrayList<Solution> allInstances_VoiceRecognitionSystem = getInstances(VoiceRecognitionSystem_ID);
        if(allInstances_VoiceRecognitionSystem != null)
        {
            if(printDebugInfo)
            {   
                for(int i=0; i<allInstances_VoiceRecognitionSystem.size(); i++)
                    System.out.println(allInstances_VoiceRecognitionSystem.get(i).toString());
            }
        }
        
        //get PointingDevice_ID
        ArrayList<Solution> allInstances_PointingDevice = getInstances(PointingDevice_ID);
        if(allInstances_PointingDevice != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_PointingDevice.size(); i++)
                    System.out.println(allInstances_PointingDevice.get(i).toString());
            }
        }
        
        //get SwitchInterface_ID
        ArrayList<Solution> allInstances_SwitchInterface = getInstances(SwitchInterface_ID);
        if(allInstances_SwitchInterface != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SwitchInterface.size(); i++)
                    System.out.println(allInstances_SwitchInterface.get(i).toString());
            }
        }
        
        //get MouseControlSoftware_ID
        ArrayList<Solution> allInstances_MouseControlSoftware = getInstances(MouseControlSoftware_ID);
        if(allInstances_MouseControlSoftware != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_MouseControlSoftware.size(); i++)
                    System.out.println(allInstances_MouseControlSoftware.get(i).toString());
            }
        }
        
        //get OnScreenKeyboard_ID
        ArrayList<Solution> allInstances_OnScreenKeyboard = getInstances(OnScreenKeyboard_ID);
        if(allInstances_OnScreenKeyboard != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_OnScreenKeyboard.size(); i++)
                    System.out.println(allInstances_OnScreenKeyboard.get(i).toString());
            }
        }
        
        //get SoftwareForAdjustingInoutDevicesResponse_ID
        ArrayList<Solution> allInstances_SoftwareForAdjustingInoutDevicesResponse = getInstances(SoftwareForAdjustingInoutDevicesResponse_ID);
        if(allInstances_SoftwareForAdjustingInoutDevicesResponse != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SoftwareForAdjustingInoutDevicesResponse.size(); i++)
                    System.out.println(allInstances_SoftwareForAdjustingInoutDevicesResponse.get(i).toString());
            }
        }
        
        //get WordPredictionSoftware_ID
        ArrayList<Solution> allInstances_WordPredictionSoftware = getInstances(WordPredictionSoftware_ID);
        if(allInstances_WordPredictionSoftware != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_WordPredictionSoftware.size(); i++)
                    System.out.println(allInstances_WordPredictionSoftware.get(i).toString());
            }
        }
        
        //get SpeechSynthesis_ID
        ArrayList<Solution> allInstances_SpeechSynthesis = getInstances(SpeechSynthesis_ID);
        if(allInstances_SpeechSynthesis != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SpeechSynthesis.size(); i++)
                    System.out.println(allInstances_SpeechSynthesis.get(i).toString());
            }
        }
        
        //get MagnifyingSoftware_ID
        ArrayList<Solution> allInstances_MagnifyingSoftware = getInstances(MagnifyingSoftware_ID);
        if(allInstances_MagnifyingSoftware != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_MagnifyingSoftware.size(); i++)
                    System.out.println(allInstances_MagnifyingSoftware.get(i).toString());
            }
        }
        
        //get ScreenReader_ID
        ArrayList<Solution> allInstances_ScreenReader = getInstances(ScreenReader_ID);
        if(allInstances_ScreenReader != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_ScreenReader.size(); i++)
                    System.out.println(allInstances_ScreenReader.get(i).toString());
            }
        }
        
        //get SoftwareForAdjustingColorCombinationAndTextSize_ID
        ArrayList<Solution> allInstances_SoftwareForAdjustingColorCombinationAndTextSize = getInstances(SoftwareForAdjustingColorCombinationAndTextSize_ID);
        if(allInstances_SoftwareForAdjustingColorCombinationAndTextSize != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SoftwareForAdjustingColorCombinationAndTextSize.size(); i++)
                    System.out.println(allInstances_SoftwareForAdjustingColorCombinationAndTextSize.get(i).toString());
            }
        }
        
        //get SoftwareToModifyThePointerAppearance_ID
        ArrayList<Solution> allInstances_SoftwareToModifyThePointerAppearance = getInstances(SoftwareToModifyThePointerAppearance_ID);
        if(allInstances_SoftwareToModifyThePointerAppearance != null)
        {
            if(printDebugInfo)
            {   
                for(int i=0; i<allInstances_SoftwareToModifyThePointerAppearance.size(); i++)
                    System.out.println(allInstances_SoftwareToModifyThePointerAppearance.get(i).toString());
            }
        }
        
        //get SmartHouse_ID
        ArrayList<Solution> allInstances_SmartHouse = getInstances(SmartHouse_ID);
        if(allInstances_SmartHouse != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SmartHouse.size(); i++)
                    System.out.println(allInstances_SmartHouse.get(i).toString());
            }
        }
        
        //-------
        //VENDORS
        //-------
        
        //get DeviceVendors_ID
        ArrayList<DeviceVendor> allInstances_DeviceVendors = getInstances(DeviceVendors_ID);
        if(allInstances_DeviceVendors != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_DeviceVendors.size(); i++)
                    System.out.println(allInstances_DeviceVendors.get(i).toString());
            }
        }
        
        //get PlatformVendors_ID
        ArrayList<PlatformVendor> allInstances_PlatformVendors = getInstances(PlatformVendors_ID);
        if(allInstances_PlatformVendors != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_PlatformVendors.size(); i++)
                    System.out.println(allInstances_PlatformVendors.get(i).toString());
            }
        }
        
        //get SolutionVendors_ID
        ArrayList<SolutionVendor> allInstances_SolutionVendors = getInstances(SolutionVendors_ID);
        if(allInstances_SolutionVendors != null)
        {
            if(printDebugInfo)
            {
                for(int i=0; i<allInstances_SolutionVendors.size(); i++)
                    System.out.println(allInstances_SolutionVendors.get(i).toString());
            }
        }
        
//TESTING...
//Getting solution running on a specific platform (e.g., WindowsXP)...
        ArrayList<Solution> screenReadersRunningOnWindowsXP = getSolutionsRunningOnSpecificPlatform(ScreenReader_ID, "WindowsXP");
        ArrayList<Solution> screenReadersRunningOnLinuxDebian6 = getSolutionsRunningOnSpecificPlatform(ScreenReader_ID, "Linux Debian 6");
//Getting solutions running on a specific platform type (e.g., linux)...
        ArrayList<Solution> screenReadersRunningOnLinux = getSolutionsRunningOnSpecificPlatformType(ScreenReader_ID, "linux");
        ArrayList<Solution> screenReadersRunningOnWindows = getSolutionsRunningOnSpecificPlatformType(ScreenReader_ID, "windows");
//Getting solutions running on a specific device (device name) (e.g., DTV)...
        ArrayList<Solution> screenReadersRunningOnDTV = getSolutionsRunningOnSpecificDevice(ScreenReader_ID, "DTV");        
    }
    
    public String getClassNameByID(int tmpClassID)
    {
        if(tmpClassID == DTVDevices_ID)
            return "DTVDevices";
        else if(tmpClassID == GamingConsoleDevices_ID)
            return "GamingConsoleDevices";
        else if(tmpClassID == ATMDevices_ID)
            return "ATMDevices";
        else if(tmpClassID == InfokioskDevices_ID)
            return "InfokioskDevices";
        else if(tmpClassID == SmartHomeDevices_ID)
            return "SmartHomeDevices";
        else if(tmpClassID == MSSurfaceDevices_ID)
            return "MSSurfaceDevices";
        else if(tmpClassID == SimpleMobilePhoneDevices_ID)
            return "SimpleMobilePhoneDevices";
        else if(tmpClassID == SmartMobilePhoneDevices_ID)
            return "SmartMobilePhoneDevices";
        else if(tmpClassID == PDADevices_ID)
            return "PDADevices";
        else if(tmpClassID == AtDriving_ID)
            return "AtDriving";
        else if(tmpClassID == AtEntertainment_ID)
            return "AtEntertainment";
        else if(tmpClassID == AtHome_ID)
            return "AtHome";
        else if(tmpClassID == AtWork_ID)
            return "AtWork";
        else if(tmpClassID == HoursOfTheDay_ID)
            return "HoursOfTheDay";
        else if(tmpClassID == LinuxOSPlatforms_ID)
            return "LinuxOSPlatforms";
        else if(tmpClassID == SUNOSOSPlatforms_ID)
            return "SUNOSOSPlatforms";
        else if(tmpClassID == Windows7OSPlatforms_ID)
            return "Windows7OSPlatforms";
        else if(tmpClassID == WES2007_ID)
            return "WES2007";
        else if(tmpClassID == WES2009_ID)
            return "WES2009";
        else if(tmpClassID == WindowsVistaOSPlatform_ID)
            return "WindowsVistaOSPlatform";
        else if(tmpClassID == WindowsXPOSPlatform_ID)
            return "WindowsXPOSPlatform";
        else if(tmpClassID == BrowserWithJava_ID)
            return "BrowserWithJava";
        else if(tmpClassID == Services_ID)
            return "Services";
        else if(tmpClassID == AccessSettings_ID)
            return "AccessSettings";
        else if(tmpClassID == AudioNotificationsGeneralSettings_ID)
            return "AudioNotificationsGeneralSettings";
        else if(tmpClassID == AudioNotificationsLinkSettings_ID)
            return "AudioNotificationsLinkSettings";
        else if(tmpClassID == AudioVolumeSettings_ID)
            return "AudioVolumeSettings";
        else if(tmpClassID == SpeechRecognitionSettings_ID)
            return "SpeechRecognitionSettings";
        else if(tmpClassID == EchoOptionsSettings_ID)
            return "EchoOptionsSettings";
        else if(tmpClassID == TextToSpeechEngineSettings_ID)
            return "TextToSpeechEngineSettings";
        else if(tmpClassID == TextToSpeechLanguageSettings_ID)
            return "TextToSpeechLanguageSettings";
        else if(tmpClassID == PunctuationSettings_ID)
            return "PunctuationSettings";
        else if(tmpClassID == ReadingCapitalsSettings_ID)
            return "ReadingCapitalsSettings";
        else if(tmpClassID == SpeakingRateSettings_ID)
            return "SpeakingRateSettings";
        else if(tmpClassID == SpeekingPitchSettings_ID)
            return "SpeekingPitchSettings";
        else if(tmpClassID == VoiceSettings_ID)
            return "VoiceSettings";
        else if(tmpClassID == VoiceVolume_ID)
            return "VoiceVolume";
        else if(tmpClassID == EasyOneCommunicatorSeetings_ID)
            return "EasyOneCommunicatorSeetings";
        else if(tmpClassID == LanguageSettings_ID)
            return "LanguageSettings";
        else if(tmpClassID == MsSurfaceSettings_ID)
            return "MsSurfaceSettings";
        else if(tmpClassID == SAToGoSettings_ID)
            return "SAToGoSettings";
        else if(tmpClassID == SmartHouseSettings_ID)
            return "SmartHouseSettings";
        else if(tmpClassID == BrailleDisplaySettings_ID)
            return "BrailleDisplaySettings";
        else if(tmpClassID == GestureSettings_ID)
            return "GestureSettings";
        else if(tmpClassID == UsersAssistantsIDSettings_ID)
            return "UsersAssistantsIDSettings";
        else if(tmpClassID == UsersContactsSettings_ID)
            return "UsersContactsSettings";
        else if(tmpClassID == Gmail_ID)
            return "Gmail";
        else if(tmpClassID == UsersIDSettings_ID)
            return "UsersIDSettings";
        else if(tmpClassID == UsersLanguageSettings_ID)
            return "UsersLanguageSettings";
        else if(tmpClassID == UsersXMPPChatIDSettings_ID)
            return "UsersXMPPChatIDSettings";
        else if(tmpClassID == UsersXMPPPasswordSettings_ID)
            return "UsersXMPPPasswordSettings";
        else if(tmpClassID == ColorSettings_ID)
            return "ColorSettings";
        else if(tmpClassID == ButtonSettings_ID)
            return "ButtonSettings";
        else if(tmpClassID == InterfaceSettings_ID)
            return "InterfaceSettings";
        else if(tmpClassID == KeyboardLayoutSettings_ID)
            return "KeyboardLayoutSettings";
        else if(tmpClassID == MagnifierSettings_ID)
            return "MagnifierSettings";
        else if(tmpClassID == SubtitleSettings_ID)
            return "SubtitleSettings";
        else if(tmpClassID == TextSizeSettings_ID)
            return "TextSizeSettings";
        else if(tmpClassID == TextStyleSettings_ID)
            return "TextStyleSettings";
        else if(tmpClassID == VisualNotificationsSettings_ID)
            return "VisualNotificationsSettings";
        else if(tmpClassID == VisualResponseSettings_ID)
            return "VisualResponseSettings";
        else if(tmpClassID == WebAnywhereSettings_ID)
            return "WebAnywhereSettings";
        else if(tmpClassID == SystemsToTransformImagesIntoSoundOrVoice_ID)
            return "SystemsToTransformImagesIntoSoundOrVoice";
        else if(tmpClassID == SatelliteNavigationSystem_ID)
            return "SatelliteNavigationSystem";
        else if(tmpClassID == WordProcessingSoftware_ID)
            return "WordProcessingSoftware";
        else if(tmpClassID == EasyOneCommunicator_ID)
            return "EasyOneCommunicator";
        else if(tmpClassID == SocialNetworkApp_ID)
            return "SocialNetworkApp";
        else if(tmpClassID == SoftwareForSoundOrSpeechAmplification_ID)
            return "SoftwareForSoundOrSpeechAmplification";
        else if(tmpClassID == PaperDocumentsReadingSystemOCR_ID)
            return "PaperDocumentsReadingSystemOCR";
        else if(tmpClassID == SAToGo_ID)
            return "SAToGo";
        else if(tmpClassID == SpeechStreamTextHelp_ID)
            return "SpeechStreamTextHelp";
        else if(tmpClassID == WebAnywhere_ID)
            return "WebAnywhere";
        else if(tmpClassID == VideoMagnifier_ID)
            return "VideoMagnifier";
        else if(tmpClassID == DelayedCaptioningSystem_ID)
            return "DelayedCaptioningSystem";
        else if(tmpClassID == RealTimeCaptioningSystem_ID)
            return "RealTimeCaptioningSystem";
        else if(tmpClassID == SoftwareInterfaceForComputer_ID)
            return "SoftwareInterfaceForComputer";
        else if(tmpClassID == eKiosk_ID)
            return "eKiosk";
        else if(tmpClassID == AlternativeInputDeviceForComputer_ID)
            return "AlternativeInputDeviceForComputer";
        else if(tmpClassID == EyegazeSystem_ID)
            return "EyegazeSystem";
        else if(tmpClassID == MsSurface_ID)
            return "MsSurface";
        else if(tmpClassID == VoiceRecognitionSystem_ID)
            return "VoiceRecognitionSystem";
        else if(tmpClassID == PointingDevice_ID)
            return "PointingDevice";
        else if(tmpClassID == SwitchInterface_ID)
            return "SwitchInterface";
        else if(tmpClassID == MouseControlSoftware_ID)
            return "MouseControlSoftware";
        else if(tmpClassID == OnScreenKeyboard_ID)
            return "OnScreenKeyboard";
        else if(tmpClassID == SoftwareForAdjustingInoutDevicesResponse_ID)
            return "SoftwareForAdjustingInoutDevicesResponse";
        else if(tmpClassID == WordPredictionSoftware_ID)
            return "WordPredictionSoftware";
        else if(tmpClassID == SpeechSynthesis_ID)
            return "SpeechSynthesis";
        else if(tmpClassID == MagnifyingSoftware_ID)
            return "MagnifyingSoftware";
        else if(tmpClassID == ScreenReader_ID)
            return "ScreenReader";
        else if(tmpClassID == SoftwareForAdjustingColorCombinationAndTextSize_ID)
            return "SoftwareForAdjustingColorCombinationAndTextSize";
        else if(tmpClassID == SoftwareToModifyThePointerAppearance_ID)
            return "SoftwareToModifyThePointerAppearance";
        else if(tmpClassID == SmartHouse_ID)
            return "SmartHouse";
        else if(tmpClassID == DeviceVendors_ID)
            return "DeviceVendors";
        else if(tmpClassID == PlatformVendors_ID)
            return "PlatformVendors";
        else if(tmpClassID == SolutionVendors_ID)
            return "SolutionVendors";
        return "UNKNOWN CLASS ID!";
    }
    
    public ArrayList getInstances(int tmpClassID)
    {
        //System.out.println("...getInstances -> " + getClassNameByID(tmpClassID) + " - START");
        ArrayList result = null;
        
        StmtIterator iter = model.listStatements();
        
        while (iter.hasNext()) 
        {
            Statement stmt      = iter.nextStatement();  // get next statement
            Resource  subject   = stmt.getSubject();     // get the subject
            Property  predicate = stmt.getPredicate();   // get the predicate
            RDFNode   object    = stmt.getObject();      // get the object

            if(object instanceof Resource) 
            {
                if(predicate.toString().equals("http://www.w3.org/1999/02/22-rdf-syntax-ns#type")
                        && object.toString().endsWith(getClassNameByID(tmpClassID)))
                {
                    //-------
                    //Devices
                    //-------
                    if(tmpClassID == DTVDevices_ID
                            || tmpClassID == GamingConsoleDevices_ID
                            || tmpClassID == ATMDevices_ID
                            || tmpClassID == InfokioskDevices_ID
                            || tmpClassID == SmartHomeDevices_ID
                            || tmpClassID == MSSurfaceDevices_ID
                            || tmpClassID == SimpleMobilePhoneDevices_ID
                            || tmpClassID == SmartMobilePhoneDevices_ID
                            || tmpClassID == PDADevices_ID)
                    {
                        if(result == null)
                            result = new ArrayList<Device>();
                        Device tmpDevice = new Device();
                        
                        if(tmpClassID == DTVDevices_ID)
                            tmpDevice.classID = DTVDevices_ID;
                        else if(tmpClassID == GamingConsoleDevices_ID)
                            tmpDevice.classID = GamingConsoleDevices_ID;
                        else if(tmpClassID == ATMDevices_ID)
                            tmpDevice.classID = ATMDevices_ID;
                        else if(tmpClassID == InfokioskDevices_ID)
                            tmpDevice.classID = InfokioskDevices_ID;
                        else if(tmpClassID == SmartHomeDevices_ID)
                            tmpDevice.classID = SmartHomeDevices_ID;
                        else if(tmpClassID == MSSurfaceDevices_ID)
                            tmpDevice.classID = MSSurfaceDevices_ID;
                        else if(tmpClassID == SimpleMobilePhoneDevices_ID)
                            tmpDevice.classID = SimpleMobilePhoneDevices_ID;
                        else if(tmpClassID == SmartMobilePhoneDevices_ID)
                            tmpDevice.classID = SmartMobilePhoneDevices_ID;
                        else if(tmpClassID == PDADevices_ID)
                            tmpDevice.classID = PDADevices_ID;
                        
                        tmpDevice.hasDeviceName = getPropertyValue(subject.toString(), "hasDeviceName");
                        tmpDevice.hasDeviceDescription = getPropertyValue(subject.toString(), "hasDeviceDescription");
                        tmpDevice.hasDeviceSpecificSetting = getPropertyValue(subject.toString(), "hasDeviceSpecificSetting");
                        tmpDevice.hasDeviceVendor = getPropertyValue(subject.toString(), "hasDeviceVendor");
                        tmpDevice.isSupportingDeviceOf = getPropertyValue(subject.toString(), "isSupportingDeviceOf");
                        
                        result.add(tmpDevice);
                    }                    
                    //-----------
                    //Environment
                    //-----------
                    else if(tmpClassID == AtDriving_ID
                        || tmpClassID == AtEntertainment_ID
                        || tmpClassID == AtHome_ID
                        || tmpClassID == AtWork_ID
                        || tmpClassID == HoursOfTheDay_ID)
                    {   
                        if(result == null)
                            result = new ArrayList<Environment>();
                        Environment tmpEnvironment = new Environment();
                        
                        if(tmpClassID == AtDriving_ID)
                            tmpEnvironment.classID = AtDriving_ID;
                        else if(tmpClassID == AtEntertainment_ID)
                            tmpEnvironment.classID = AtEntertainment_ID;
                        else if(tmpClassID == AtHome_ID)
                            tmpEnvironment.classID = AtHome_ID;
                        else if(tmpClassID == AtWork_ID)
                            tmpEnvironment.classID = AtWork_ID;
                        else if(tmpClassID == HoursOfTheDay_ID)
                            tmpEnvironment.classID = HoursOfTheDay_ID;
                        
                        tmpEnvironment.hasEnvironmentName = getPropertyValue(subject.toString(), "hasEnvironmentName");
                        
                        result.add(tmpEnvironment);
                    }
                    //---------
                    //Platforms
                    //---------
                    else if(tmpClassID == LinuxOSPlatforms_ID
                        || tmpClassID == SUNOSOSPlatforms_ID
                        || tmpClassID == Windows7OSPlatforms_ID
                        || tmpClassID == WES2007_ID
                        || tmpClassID == WES2009_ID
                        || tmpClassID == WindowsVistaOSPlatform_ID
                        || tmpClassID == WindowsXPOSPlatform_ID
                        || tmpClassID == BrowserWithJava_ID
                        || tmpClassID == Services_ID)
                    {
                        if(result == null)
                            result = new ArrayList<Platform>();
                        Platform tmpPlatform = new Platform();
                    
                        if(tmpClassID == LinuxOSPlatforms_ID)
                            tmpPlatform.classID = LinuxOSPlatforms_ID;
                        else if(tmpClassID == SUNOSOSPlatforms_ID)
                            tmpPlatform.classID = SUNOSOSPlatforms_ID;
                        else if(tmpClassID == Windows7OSPlatforms_ID)
                            tmpPlatform.classID = Windows7OSPlatforms_ID;
                        else if(tmpClassID == WES2007_ID)
                            tmpPlatform.classID = WES2007_ID;
                        else if(tmpClassID == WES2009_ID)
                            tmpPlatform.classID = WES2009_ID;
                        else if(tmpClassID == WindowsVistaOSPlatform_ID)
                            tmpPlatform.classID = WindowsVistaOSPlatform_ID;
                        else if(tmpClassID == WindowsXPOSPlatform_ID)
                            tmpPlatform.classID = WindowsXPOSPlatform_ID;
                        else if(tmpClassID == BrowserWithJava_ID)
                            tmpPlatform.classID = BrowserWithJava_ID;
                        else if(tmpClassID == Services_ID)
                            tmpPlatform.classID = Services_ID;
                        
                        tmpPlatform.hasPlatformName = getPropertyValue(subject.toString(), "hasPlatformName");
                        tmpPlatform.hasPlatformDescription = getPropertyValue(subject.toString(), "hasPlatformDescription");
                        tmpPlatform.platformType = getPropertyValue(subject.toString(), "platformType");
                        tmpPlatform.platformSubtype = getPropertyValue(subject.toString(), "platformSubtype");
                        tmpPlatform.hasPlatformSpecificSetting = getPropertyValue(subject.toString(), "hasPlatformSpecificSetting");
                        tmpPlatform.hasPlatformVendor = getPropertyValue(subject.toString(), "hasPlatformVendor");
                        tmpPlatform.platformSupports = getPropertyValue(subject.toString(), "platformSupports");
                        tmpPlatform.hasPlatformVersion = getPropertyValue(subject.toString(), "hasPlatformVersion");
                        
                        result.add(tmpPlatform);
                    }
                    //--------
                    //Settings
                    //--------                    
                    else if(tmpClassID == AccessSettings_ID
                        || tmpClassID == AudioNotificationsGeneralSettings_ID
                        || tmpClassID == AudioNotificationsLinkSettings_ID
                        || tmpClassID == AudioVolumeSettings_ID
                        || tmpClassID == SpeechRecognitionSettings_ID
                        || tmpClassID == EchoOptionsSettings_ID
                        || tmpClassID == TextToSpeechEngineSettings_ID
                        || tmpClassID == TextToSpeechLanguageSettings_ID
                        || tmpClassID == PunctuationSettings_ID
                        || tmpClassID == ReadingCapitalsSettings_ID
                        || tmpClassID == SpeakingRateSettings_ID
                        || tmpClassID == SpeekingPitchSettings_ID
                        || tmpClassID == VoiceSettings_ID
                        || tmpClassID == VoiceVolume_ID
                        || tmpClassID == EasyOneCommunicatorSeetings_ID
                        || tmpClassID == LanguageSettings_ID
                        || tmpClassID == MsSurfaceSettings_ID
                        || tmpClassID == SAToGoSettings_ID
                        || tmpClassID == SmartHouseSettings_ID
                        || tmpClassID == BrailleDisplaySettings_ID
                        || tmpClassID == GestureSettings_ID
                        || tmpClassID == UsersAssistantsIDSettings_ID
                        || tmpClassID == UsersContactsSettings_ID
                        || tmpClassID == Gmail_ID
                        || tmpClassID == UsersIDSettings_ID
                        || tmpClassID == UsersLanguageSettings_ID
                        || tmpClassID == UsersXMPPChatIDSettings_ID
                        || tmpClassID == UsersXMPPPasswordSettings_ID
                        || tmpClassID == ColorSettings_ID
                        || tmpClassID == ButtonSettings_ID
                        || tmpClassID == InterfaceSettings_ID
                        || tmpClassID == KeyboardLayoutSettings_ID
                        || tmpClassID == MagnifierSettings_ID
                        || tmpClassID == SubtitleSettings_ID
                        || tmpClassID == TextSizeSettings_ID
                        || tmpClassID == TextStyleSettings_ID
                        || tmpClassID == VisualNotificationsSettings_ID
                        || tmpClassID == VisualResponseSettings_ID
                        || tmpClassID == WebAnywhereSettings_ID)                    
                    {
                        if(result == null)
                            result = new ArrayList<Setting>();
                        Setting tmpSetting = new Setting();
                        
                        if(tmpClassID == AccessSettings_ID)
                            tmpSetting.classID = AccessSettings_ID;
                        else if(tmpClassID == AudioNotificationsGeneralSettings_ID)
                            tmpSetting.classID = AudioNotificationsGeneralSettings_ID;
                        else if(tmpClassID == AudioNotificationsLinkSettings_ID)
                            tmpSetting.classID = AudioNotificationsLinkSettings_ID;
                        else if(tmpClassID == AudioVolumeSettings_ID)
                            tmpSetting.classID = AudioVolumeSettings_ID;
                        else if(tmpClassID == SpeechRecognitionSettings_ID)
                            tmpSetting.classID = SpeechRecognitionSettings_ID;
                        else if(tmpClassID == EchoOptionsSettings_ID)
                            tmpSetting.classID = EchoOptionsSettings_ID;
                        else if(tmpClassID == TextToSpeechEngineSettings_ID)
                            tmpSetting.classID = TextToSpeechEngineSettings_ID;
                        else if(tmpClassID == TextToSpeechLanguageSettings_ID)
                            tmpSetting.classID = TextToSpeechLanguageSettings_ID;
                        else if(tmpClassID == PunctuationSettings_ID)
                            tmpSetting.classID = PunctuationSettings_ID;
                        else if(tmpClassID == ReadingCapitalsSettings_ID)
                            tmpSetting.classID = ReadingCapitalsSettings_ID;
                        else if(tmpClassID == SpeakingRateSettings_ID)
                            tmpSetting.classID = SpeakingRateSettings_ID;
                        else if(tmpClassID == SpeekingPitchSettings_ID)
                            tmpSetting.classID = SpeekingPitchSettings_ID;
                        else if(tmpClassID == VoiceSettings_ID)
                            tmpSetting.classID = VoiceSettings_ID;
                        else if(tmpClassID == VoiceVolume_ID)
                            tmpSetting.classID = VoiceVolume_ID;
                        else if(tmpClassID == EasyOneCommunicatorSeetings_ID)
                            tmpSetting.classID = EasyOneCommunicatorSeetings_ID;
                        else if(tmpClassID == LanguageSettings_ID)
                            tmpSetting.classID = LanguageSettings_ID;
                        else if(tmpClassID == MsSurfaceSettings_ID)
                            tmpSetting.classID = MsSurfaceSettings_ID;
                        else if(tmpClassID == SAToGoSettings_ID)
                            tmpSetting.classID = SAToGoSettings_ID;
                        else if(tmpClassID == SmartHouseSettings_ID)
                            tmpSetting.classID = SmartHouseSettings_ID;
                        else if(tmpClassID == BrailleDisplaySettings_ID)
                            tmpSetting.classID = BrailleDisplaySettings_ID;
                        else if(tmpClassID == GestureSettings_ID)
                            tmpSetting.classID = GestureSettings_ID;
                        else if(tmpClassID == UsersAssistantsIDSettings_ID)
                            tmpSetting.classID = UsersAssistantsIDSettings_ID;
                        else if(tmpClassID == UsersContactsSettings_ID)
                            tmpSetting.classID = UsersContactsSettings_ID;
                        else if(tmpClassID == Gmail_ID)
                            tmpSetting.classID = Gmail_ID;
                        else if(tmpClassID == UsersIDSettings_ID)
                            tmpSetting.classID = UsersIDSettings_ID;
                        else if(tmpClassID == UsersLanguageSettings_ID)
                            tmpSetting.classID = UsersLanguageSettings_ID;
                        else if(tmpClassID == UsersXMPPChatIDSettings_ID)
                            tmpSetting.classID = UsersXMPPChatIDSettings_ID;
                        else if(tmpClassID == UsersXMPPPasswordSettings_ID)
                            tmpSetting.classID = UsersXMPPPasswordSettings_ID;
                        else if(tmpClassID == ColorSettings_ID)
                            tmpSetting.classID = ColorSettings_ID;
                        else if(tmpClassID == ButtonSettings_ID)
                            tmpSetting.classID = ButtonSettings_ID;
                        else if(tmpClassID == InterfaceSettings_ID)
                            tmpSetting.classID = InterfaceSettings_ID;
                        else if(tmpClassID == KeyboardLayoutSettings_ID)
                            tmpSetting.classID = KeyboardLayoutSettings_ID;
                        else if(tmpClassID == MagnifierSettings_ID)
                            tmpSetting.classID = MagnifierSettings_ID;
                        else if(tmpClassID == SubtitleSettings_ID)
                            tmpSetting.classID = SubtitleSettings_ID;
                        else if(tmpClassID == TextSizeSettings_ID)
                            tmpSetting.classID = TextSizeSettings_ID;
                        else if(tmpClassID == TextStyleSettings_ID)
                            tmpSetting.classID = TextStyleSettings_ID;
                        else if(tmpClassID == VisualNotificationsSettings_ID)
                            tmpSetting.classID = VisualNotificationsSettings_ID;
                        else if(tmpClassID == VisualResponseSettings_ID)
                            tmpSetting.classID = VisualResponseSettings_ID;
                        else if(tmpClassID == WebAnywhereSettings_ID)
                            tmpSetting.classID = WebAnywhereSettings_ID;
                        
                        tmpSetting.hasSettingName = getPropertyValue(subject.toString(), "hasSettingName");
                        tmpSetting.hasSettingDescription = getPropertyValue(subject.toString(), "hasSettingDescription");
                        tmpSetting.allowCascading = getPropertyValue(subject.toString(), "allowCascading");
                        tmpSetting.allowedSolutionsForCascading = getPropertyValue(subject.toString(), "allowedSolutionsForCascading");
                        tmpSetting.freeAllowedDaysOfInvocation = getPropertyValue(subject.toString(), "freeAllowedDaysOfInvocation");
                        tmpSetting.hasCostForCascading = getPropertyValue(subject.toString(), "hasCostForCascading");
                        tmpSetting.adaptingDevice = getPropertyValue(subject.toString(), "adaptingDevice");
                        tmpSetting.adaptingPlatform = getPropertyValue(subject.toString(), "adaptingPlatform");
                        tmpSetting.adaptingSolution = getPropertyValue(subject.toString(), "adaptingSolution");
                        tmpSetting.hasCostCurrencyForCascading = getPropertyValue(subject.toString(), "hasCostCurrencyForCascading");
                        tmpSetting.hasCostForCascadingPaymentCharge = getPropertyValue(subject.toString(), "hasCostForCascadingPaymentCharge");
                        tmpSetting.hasSettingDefaultValue = getPropertyValue(subject.toString(), "hasSettingDefaultValue");
                        tmpSetting.hasSettingRange = getPropertyValue(subject.toString(), "hasSettingRange");
                        tmpSetting.hasSettingValue = getPropertyValue(subject.toString(), "hasSettingValue");
                        
                        result.add(tmpSetting);
                    }
                    //---------
                    //Solutions
                    //---------
                    else if(tmpClassID == SystemsToTransformImagesIntoSoundOrVoice_ID
                            || tmpClassID == SatelliteNavigationSystem_ID
                            || tmpClassID == WordProcessingSoftware_ID
                            || tmpClassID == EasyOneCommunicator_ID
                            || tmpClassID == SocialNetworkApp_ID
                            || tmpClassID == SoftwareForSoundOrSpeechAmplification_ID
                            || tmpClassID == PaperDocumentsReadingSystemOCR_ID
                            || tmpClassID == SAToGo_ID
                            || tmpClassID == SpeechStreamTextHelp_ID
                            || tmpClassID == WebAnywhere_ID
                            || tmpClassID == VideoMagnifier_ID
                            || tmpClassID == DelayedCaptioningSystem_ID
                            || tmpClassID == RealTimeCaptioningSystem_ID
                            || tmpClassID == SoftwareInterfaceForComputer_ID
                            || tmpClassID == eKiosk_ID
                            || tmpClassID == AlternativeInputDeviceForComputer_ID
                            || tmpClassID == EyegazeSystem_ID
                            || tmpClassID == MsSurface_ID
                            || tmpClassID == VoiceRecognitionSystem_ID
                            || tmpClassID == PointingDevice_ID
                            || tmpClassID == SwitchInterface_ID
                            || tmpClassID == MouseControlSoftware_ID
                            || tmpClassID == OnScreenKeyboard_ID
                            || tmpClassID == SoftwareForAdjustingInoutDevicesResponse_ID
                            || tmpClassID == WordPredictionSoftware_ID
                            || tmpClassID == SpeechSynthesis_ID
                            || tmpClassID == MagnifyingSoftware_ID
                            || tmpClassID == ScreenReader_ID
                            || tmpClassID == SoftwareForAdjustingColorCombinationAndTextSize_ID
                            || tmpClassID == SoftwareToModifyThePointerAppearance_ID
                            || tmpClassID == SmartHouse_ID)
                    {
                        if(result == null)
                            result = new ArrayList<Solution>();
                        Solution tmpSolution = new Solution();
                        
                        if(tmpClassID == SystemsToTransformImagesIntoSoundOrVoice_ID)
                            tmpSolution.classID = SystemsToTransformImagesIntoSoundOrVoice_ID;
                        else if(tmpClassID == SatelliteNavigationSystem_ID)
                            tmpSolution.classID = SatelliteNavigationSystem_ID;
                        else if(tmpClassID == WordProcessingSoftware_ID)
                            tmpSolution.classID = WordProcessingSoftware_ID;
                        else if(tmpClassID == EasyOneCommunicator_ID)
                            tmpSolution.classID = EasyOneCommunicator_ID;
                        else if(tmpClassID == SocialNetworkApp_ID)
                            tmpSolution.classID = SocialNetworkApp_ID;
                        else if(tmpClassID == SoftwareForSoundOrSpeechAmplification_ID)
                            tmpSolution.classID = SoftwareForSoundOrSpeechAmplification_ID;
                        else if(tmpClassID == PaperDocumentsReadingSystemOCR_ID)
                            tmpSolution.classID = PaperDocumentsReadingSystemOCR_ID;
                        else if(tmpClassID == SAToGo_ID)
                            tmpSolution.classID = SAToGo_ID;
                        else if(tmpClassID == SpeechStreamTextHelp_ID)
                            tmpSolution.classID = SpeechStreamTextHelp_ID;
                        else if(tmpClassID == WebAnywhere_ID)
                            tmpSolution.classID = WebAnywhere_ID;
                        else if(tmpClassID == VideoMagnifier_ID)
                            tmpSolution.classID = VideoMagnifier_ID;
                        else if(tmpClassID == DelayedCaptioningSystem_ID)
                            tmpSolution.classID = DelayedCaptioningSystem_ID;
                        else if(tmpClassID == RealTimeCaptioningSystem_ID)
                            tmpSolution.classID = RealTimeCaptioningSystem_ID;
                        else if(tmpClassID == SoftwareInterfaceForComputer_ID)
                            tmpSolution.classID = SoftwareInterfaceForComputer_ID;
                        else if(tmpClassID == eKiosk_ID)
                            tmpSolution.classID = eKiosk_ID;
                        else if(tmpClassID == AlternativeInputDeviceForComputer_ID)
                            tmpSolution.classID = AlternativeInputDeviceForComputer_ID;
                        else if(tmpClassID == EyegazeSystem_ID)
                            tmpSolution.classID = EyegazeSystem_ID;
                        else if(tmpClassID == MsSurface_ID)
                            tmpSolution.classID = MsSurface_ID;
                        else if(tmpClassID == VoiceRecognitionSystem_ID)
                            tmpSolution.classID = VoiceRecognitionSystem_ID;
                        else if(tmpClassID == PointingDevice_ID)
                            tmpSolution.classID = PointingDevice_ID;
                        else if(tmpClassID == SwitchInterface_ID)
                            tmpSolution.classID = SwitchInterface_ID;
                        else if(tmpClassID == MouseControlSoftware_ID)
                            tmpSolution.classID = MouseControlSoftware_ID;
                        else if(tmpClassID == OnScreenKeyboard_ID)
                            tmpSolution.classID = OnScreenKeyboard_ID;
                        else if(tmpClassID == SoftwareForAdjustingInoutDevicesResponse_ID)
                            tmpSolution.classID = SoftwareForAdjustingInoutDevicesResponse_ID;
                        else if(tmpClassID == WordPredictionSoftware_ID)
                            tmpSolution.classID = WordPredictionSoftware_ID;
                        else if(tmpClassID == SpeechSynthesis_ID)
                            tmpSolution.classID = SpeechSynthesis_ID;
                        else if(tmpClassID == MagnifyingSoftware_ID)
                            tmpSolution.classID = MagnifyingSoftware_ID;
                        else if(tmpClassID == ScreenReader_ID)
                            tmpSolution.classID = ScreenReader_ID;
                        else if(tmpClassID == SoftwareForAdjustingColorCombinationAndTextSize_ID)
                            tmpSolution.classID = SoftwareForAdjustingColorCombinationAndTextSize_ID;
                        else if(tmpClassID == SoftwareToModifyThePointerAppearance_ID)
                            tmpSolution.classID = SoftwareToModifyThePointerAppearance_ID;
                        else if(tmpClassID == SmartHouse_ID)
                            tmpSolution.classID = SmartHouse_ID;
                        
                        tmpSolution.hasSolutionName = getPropertyValue(subject.toString(), "hasSolutionName");
                        tmpSolution.hasSolutionDescription = getPropertyValue(subject.toString(), "hasSolutionDescription");
                        String tmpFreeAllowedNrOfInvocations = getPropertyValue(subject.toString(), "freeAllowedNrOfInvocations");
                        if(tmpFreeAllowedNrOfInvocations.length() > 0)
                            tmpSolution.freeAllowedNrOfInvocations = Integer.parseInt(tmpFreeAllowedNrOfInvocations);
                        String tmpHasCost = getPropertyValue(subject.toString(), "hasCost");
                        if(tmpHasCost.length() > 0)
                            tmpSolution.hasCost = Double.parseDouble(tmpHasCost);
                        tmpSolution.preferredLang = getPropertyValue(subject.toString(), "preferredLang");
                        tmpSolution.speechRate = getPropertyValue(subject.toString(), "speechRate");
                        tmpSolution.hasSolutionSpecificSetting = getPropertyValue(subject.toString(), "hasSolutionSpecificSetting");
                        tmpSolution.hasSolutionVendor = getPropertyValue(subject.toString(), "hasSolutionVendor");
                        tmpSolution.runsOnDevice = getPropertyValue(subject.toString(), "runsOnDevice");
                        tmpSolution.runsOnPlatform = getPropertyValue(subject.toString(), "runsOnPlatform");
                        tmpSolution.hasCostCurrency = getPropertyValue(subject.toString(), "hasCostCurrency");
                        tmpSolution.hasSolutionVersion = getPropertyValue(subject.toString(), "hasSolutionVersion");

                        result.add(tmpSolution);
                    }
                    //-------
                    //Vendors
                    //-------
                    else if(tmpClassID == DeviceVendors_ID)
                    {
                        if(result == null)
                            result = new ArrayList<DeviceVendor>();
                        DeviceVendor tmpDeviceVendor = new DeviceVendor();
                        
                        tmpDeviceVendor.classID = DeviceVendors_ID;
                        
                        tmpDeviceVendor.hasDeviceVendorName = getPropertyValue(subject.toString(), "hasDeviceVendorName");
                        tmpDeviceVendor.isDeviceVendorOf = getPropertyValue(subject.toString(), "isDeviceVendorOf");
                        
                        result.add(tmpDeviceVendor);
                    }
                    else if(tmpClassID == PlatformVendors_ID)
                    {
                        if(result == null)
                            result = new ArrayList<PlatformVendor>();
                        PlatformVendor tmpPlatformVendor = new PlatformVendor();
                        
                        tmpPlatformVendor.classID = PlatformVendors_ID;
                        
                        tmpPlatformVendor.hasPlatformVendorName = getPropertyValue(subject.toString(), "hasPlatformVendorName");
                        tmpPlatformVendor.isPlatformVendorOf = getPropertyValue(subject.toString(), "isPlatformVendorOf");
                        
                        result.add(tmpPlatformVendor);
                    }
                    else if(tmpClassID == SolutionVendors_ID)
                    {
                        if(result == null)
                            result = new ArrayList<SolutionVendor>();
                        SolutionVendor tmpSolutionVendor = new SolutionVendor();
                        
                        tmpSolutionVendor.classID = SolutionVendors_ID;
                        
                        tmpSolutionVendor.hasSolutionVendorName = getPropertyValue(subject.toString(), "hasSolutionVendorName");
                        tmpSolutionVendor.isSolutionVendorOf = getPropertyValue(subject.toString(), "isSolutionVendorOf");
                        
                        result.add(tmpSolutionVendor);
                    }
                }
            } 
            
        } 
        //System.out.println("...getInstances -> " + getClassNameByID(tmpClassID) + " - END");
        return result;
    }
    
    public String getPropertyValue(String tmpSubject, String tmpPropertyName)
    {
        //System.out.println("\n\n\n...getPropertyValue -> tmpSubject:" + tmpSubject + ", tmpPropertyName:" + tmpPropertyName + " - START");
        
        String result = "";
        
        StmtIterator iter = model.listStatements();
        
        while(iter.hasNext()) 
        {
            Statement stmt      = iter.nextStatement();  // get next statement
            Resource  subject   = stmt.getSubject();     // get the subject
            Property  predicate = stmt.getPredicate();   // get the predicate
            RDFNode   object    = stmt.getObject();      // get the object

            if(object instanceof Resource) 
            {
                if(subject.toString().equals(tmpSubject)
                        && predicate.toString().endsWith(tmpPropertyName))
                {
                    String tmpInstanceName = object.toString();
                    String tempPropertyName = "";
                    if(tmpPropertyName.equals("runsOnPlatform"))
                        tempPropertyName = "hasPlatformName";
                    else if(tmpPropertyName.equals("hasSolutionVendor"))
                        tempPropertyName = "hasSolutionVendorName";
                    else if(tmpPropertyName.equals("runsOnDevice"))
                        tempPropertyName = "hasDeviceName";
                    else if(tmpPropertyName.equals("hasDeviceSpecificSetting"))
                        tempPropertyName = "hasSettingsName";
                    else if(tmpPropertyName.equals("hasDeviceVendor"))
                        tempPropertyName = "hasDeviceVendorName";
                    else if(tmpPropertyName.equals("isSupportingDeviceOf"))
                        tempPropertyName = "hasSolutionName";
                    else if(tmpPropertyName.equals("hasPlatformSpecificSetting"))
                        tempPropertyName = "hasSettingsName";
                    else if(tmpPropertyName.equals("hasPlatformVendor"))
                        tempPropertyName = "hasPlatformVendorName";
                    else if(tmpPropertyName.equals("platformSupports"))
                        tempPropertyName = "hasSolutionName";
                    else if(tmpPropertyName.equals("adaptingDevice"))
                        tempPropertyName = "hasDeviceName";
                    else if(tmpPropertyName.equals("adaptingPlatform"))
                        tempPropertyName = "hasPlatformName";
                    else if(tmpPropertyName.equals("adaptingSolution"))
                        tempPropertyName = "hasSolutionName";
                    else if(tmpPropertyName.equals("hasSolutionSpecificSetting"))
                        tempPropertyName = "hasSettingsName";
                    else if(tmpPropertyName.equals("isDeviceVendorOf"))
                        tempPropertyName = "hasDeviceName";
                    else if(tmpPropertyName.equals("isPlatformVendorOf"))
                        tempPropertyName = "hasPlatformName";
                    else if(tmpPropertyName.equals("isSolutionVendorOf"))
                        tempPropertyName = "hasSolutionName";
                    
                    result = result + getPropertyValue(tmpInstanceName, tempPropertyName) + ", ";
                }
            } 
            else //object is a literal
            {
                if(subject.toString().equals(tmpSubject)
                        && predicate.toString().endsWith(tmpPropertyName))
                    //System.out.println("tmpPropertyName: " + tmpPropertyName + ", value:" + object.toString().substring(0, object.toString().indexOf("^^")));
                    result = object.toString().substring(0, object.toString().indexOf("^^"));
            }
            
        } 
        //System.out.println("...getPropertyValue -> tmpSubject:" + tmpSubject + ", tmpPropertyName:" + tmpPropertyName + " - END");
        return result;
    }
    
    public ArrayList getSolutionsRunningOnSpecificPlatform(int tmpClassID, String tmpPlatformName)
    {
        System.out.println("\ngetSolutionsRunningOnSpecificPlatform --- START");
        System.out.println("\t" + getClassNameByID(tmpClassID) + "(s) running on " + tmpPlatformName + ":");
        ArrayList result = new ArrayList<Solution>();
        int tmpCounter = 0;
        
        ArrayList<Solution> allSolutionInstances = getInstances(tmpClassID);
        if(allSolutionInstances != null)
        {
            for(int i=0; i<allSolutionInstances.size(); i++)
            {
                Solution tmpSolution = allSolutionInstances.get(i);
                if(tmpSolution.runsOnPlatform != null
                        && tmpSolution.runsOnPlatform.toLowerCase().indexOf(tmpPlatformName.toLowerCase()) != -1)
                {
                    result.add(tmpSolution);
                    tmpCounter++;
                    System.out.println("\t\t" + Integer.toString(tmpCounter) + ") " + tmpSolution.hasSolutionName);
                }
            }
        }
        System.out.println("getSolutionsRunningOnSpecificPlatform --- END");
        return result;
    }
    
    public ArrayList getSolutionsRunningOnSpecificPlatformType(int tmpClassID, String tmpPlatformType)
    {
        if(printDebugInfo)
            System.out.println("\ngetSolutionsRunningOnSpecificPlatformType --- START");
        
        ArrayList<Platform> allPlatforms = new ArrayList<Platform>();        
        ArrayList<Platform> allInstances_LinuxOSPlatforms = getInstances(LinuxOSPlatforms_ID);
        if(allInstances_LinuxOSPlatforms != null)
            allPlatforms.addAll(allInstances_LinuxOSPlatforms);
        ArrayList<Platform> allInstances_SUNOSOSPlatforms = getInstances(SUNOSOSPlatforms_ID);
        if(allInstances_SUNOSOSPlatforms != null)
            allPlatforms.addAll(allInstances_SUNOSOSPlatforms);
        ArrayList<Platform> allInstances_Windows7OSPlatforms = getInstances(Windows7OSPlatforms_ID);
        if(allInstances_Windows7OSPlatforms != null)
            allPlatforms.addAll(allInstances_Windows7OSPlatforms);
        ArrayList<Platform> allInstances_WES2007 = getInstances(WES2007_ID);
        if(allInstances_WES2007 != null)
            allPlatforms.addAll(allInstances_WES2007);
        ArrayList<Platform> allInstances_WES2009 = getInstances(WES2009_ID);
        if(allInstances_WES2009 != null)
            allPlatforms.addAll(allInstances_WES2009);
        ArrayList<Platform> allInstances_WindowsVistaOSPlatform = getInstances(WindowsVistaOSPlatform_ID);
        if(allInstances_WindowsVistaOSPlatform != null)
            allPlatforms.addAll(allInstances_WindowsVistaOSPlatform);
        ArrayList<Platform> allInstances_WindowsXPOSPlatform = getInstances(WindowsXPOSPlatform_ID);
        if(allInstances_WindowsXPOSPlatform != null)
            allPlatforms.addAll(allInstances_WindowsXPOSPlatform);
        ArrayList<Platform> allInstances_BrowserWithJava = getInstances(BrowserWithJava_ID);
        if(allInstances_BrowserWithJava != null)
            allPlatforms.addAll(allInstances_BrowserWithJava);
        ArrayList<Platform> allInstances_Service = getInstances(Services_ID);
        if(allInstances_Service != null)
            allPlatforms.addAll(allInstances_Service);
        
        if(printDebugInfo)
            System.out.println("\t" + getClassNameByID(tmpClassID) + "(s) running on " + tmpPlatformType + ":");
        ArrayList result = new ArrayList<Solution>();
        int tmpCounter = 0;
        
        ArrayList<Solution> allSolutionInstances = getInstances(tmpClassID);
        if(allSolutionInstances != null)
        {
            for(int i=0; i<allSolutionInstances.size(); i++)
            {
                Solution tmpSolution = allSolutionInstances.get(i);
                String tmpSolution_runsOnPlatform = new String(tmpSolution.runsOnPlatform);
                String[] tmpSolution_runsOnPlatform_tokens = tmpSolution_runsOnPlatform.split(",");
                boolean addIt = false;
                for(int tokensCnt = 0; tokensCnt<tmpSolution_runsOnPlatform_tokens.length; tokensCnt++)
                {
                    for(int platformCnt=0; platformCnt<allPlatforms.size(); platformCnt++)
                    {
                        Platform tempPlatform = allPlatforms.get(platformCnt);
                        if(tmpSolution_runsOnPlatform_tokens[tokensCnt] != null
                                && tempPlatform.hasPlatformName != null
                                && tempPlatform.hasPlatformName.toLowerCase().equals(tmpSolution_runsOnPlatform_tokens[tokensCnt].toLowerCase()))
                        {
                            if(tempPlatform.platformType != null
                                    && tempPlatform.platformType.toLowerCase().equals(tmpPlatformType.toLowerCase()))
                                addIt = true;
                        }
                    }
                    
                }
                if(addIt == true)
                {
                    result.add(tmpSolution);
                    tmpCounter++;
                    if(printDebugInfo)
                        System.out.println("\t\t" + Integer.toString(tmpCounter) + ") " + tmpSolution.hasSolutionName);
                }
            }
        }
        if(printDebugInfo)
            System.out.println("getSolutionsRunningOnSpecificPlatformType --- END");
        return result;
    }
    
    public ArrayList getSolutionsRunningOnSpecificDevice(int tmpClassID, String tmpDeviceName)
    {
        if(printDebugInfo)
        {
            System.out.println("\ngetSolutionsRunningOnSpecificDevice --- START");
            System.out.println("\t" + getClassNameByID(tmpClassID) + "(s) running on " + tmpDeviceName + ":");
        }
        ArrayList result = new ArrayList<Solution>();
        int tmpCounter = 0;
        
        ArrayList<Solution> allSolutionInstances = getInstances(tmpClassID);
        if(allSolutionInstances != null)
        {
            for(int i=0; i<allSolutionInstances.size(); i++)
            {
                Solution tmpSolution = allSolutionInstances.get(i);
                if(tmpSolution.runsOnDevice != null
                        && tmpSolution.runsOnDevice.toLowerCase().indexOf(tmpDeviceName.toLowerCase()) != -1)
                {
                    result.add(tmpSolution);
                    tmpCounter++;
                    if(printDebugInfo)
                        System.out.println("\t\t" + Integer.toString(tmpCounter) + ") " + tmpSolution.hasSolutionName);
                }
            }
        }
        if(printDebugInfo)
            System.out.println("getSolutionsRunningOnSpecificDevice --- END");
        return result;
    }
}
