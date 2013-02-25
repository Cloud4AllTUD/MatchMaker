package ontology;

/**
 *
 * @author nkak
 */
public class TempHandicapSituation 
{
    public Boolean problemWithFontSize;
    public Boolean problemWithMagnification;
    public Boolean problemWithForegroundAndBackgroundColor;
    public Boolean problemWithScreenReaderAndGnome;
    
    public TempHandicapSituation()
    {
        problemWithFontSize = false;
        problemWithMagnification = false;
        problemWithForegroundAndBackgroundColor = false;
        problemWithScreenReaderAndGnome = false;
    }
    
    @Override
    public String toString()
    {
        String result = "\tHandicap Situation:";//OntologyManager.getInstance().getClassNameByID(OntologyManager.TempHandicapSituations_ID);
        
        if(problemWithFontSize)
            result = result + "\n\t\tPROBLEM WITH FONT SIZE!";
        if(problemWithMagnification)
            result = result + "\n\t\tPROBLEM WITH MAGNIFICATION!";
        if(problemWithForegroundAndBackgroundColor)
            result = result + "\n\t\tPROBLEM WITH FOREGROUND AND BACKGROUND COLOR!";
        if(problemWithScreenReaderAndGnome)
            result = result + "\n\t\tPROBLEM WITH SCREEN READER AND GNOME!";
       
        return result;
    }
}