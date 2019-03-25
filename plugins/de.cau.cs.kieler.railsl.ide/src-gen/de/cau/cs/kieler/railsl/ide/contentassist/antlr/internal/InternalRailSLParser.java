package de.cau.cs.kieler.railsl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.cau.cs.kieler.railsl.services.RailSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRailSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'stop'", "'Start:'", "'start:'", "'Set'", "'set'", "','", "'and'", "'Wait'", "'wait'", "'Turn'", "'turn'", "'on'", "'off'", "'Branch:'", "'branch:'", "'If'", "'if'", "'first'", "'first,'", "'Parallel:'", "'parallel:'", "'End.'", "'end.'", "'Loop.'", "'loop.'", "'full'", "'slow'", "'straight'", "'branch'", "'Reach'", "'reach'", "'Pass'", "'pass'", "'second'", "'Open'", "'open'", "'Close'", "'close'", "'KH_ST_0'", "'KH_ST_1'", "'KH_ST_2'", "'KH_ST_3'", "'KH_ST_4'", "'KH_ST_5'", "'KH_ST_6'", "'KH_LN_0'", "'KH_LN_1'", "'KH_LN_2'", "'KH_LN_3'", "'KH_LN_4'", "'KH_LN_5'", "'KH_LN_6'", "'KH_LN_7'", "'KH_LN_8'", "'KIO_LN_0'", "'KIO_LN_1'", "'OC_ST_0'", "'OC_ST_1'", "'OC_ST_2'", "'OC_ST_3'", "'OC_ST_4'", "'OC_LN_0'", "'OC_LN_1'", "'OC_LN_2'", "'OC_LN_3'", "'OC_LN_4'", "'OC_LN_5'", "'IC_ST_0'", "'IC_ST_1'", "'IC_ST_2'", "'IC_ST_3'", "'IC_ST_4'", "'IC_LN_0'", "'IC_LN_1'", "'IC_LN_2'", "'IC_LN_3'", "'IC_LN_4'", "'IC_LN_5'", "'OC_JCT_0'", "'IC_JCT_0'", "'OI_LN_0'", "'OI_LN_1'", "'OI_LN_2'", "'IO_LN_0'", "'IO_LN_1'", "'IO_LN_2'", "'track'", "'to'", "'.'", "'point'", "'for'", "'seconds.'", "'contact'", "'of'", "'crossing.'", "'light'", "'is'", "'reached'", "'do'", "'reverse'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=4;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalRailSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRailSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRailSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRailSL.g"; }


    	private RailSLGrammarAccess grammarAccess;

    	public void setGrammarAccess(RailSLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleRailProgram"
    // InternalRailSL.g:53:1: entryRuleRailProgram : ruleRailProgram EOF ;
    public final void entryRuleRailProgram() throws RecognitionException {
        try {
            // InternalRailSL.g:54:1: ( ruleRailProgram EOF )
            // InternalRailSL.g:55:1: ruleRailProgram EOF
            {
             before(grammarAccess.getRailProgramRule()); 
            pushFollow(FOLLOW_1);
            ruleRailProgram();

            state._fsp--;

             after(grammarAccess.getRailProgramRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRailProgram"


    // $ANTLR start "ruleRailProgram"
    // InternalRailSL.g:62:1: ruleRailProgram : ( ( rule__RailProgram__BlockAssignment ) ) ;
    public final void ruleRailProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:66:2: ( ( ( rule__RailProgram__BlockAssignment ) ) )
            // InternalRailSL.g:67:2: ( ( rule__RailProgram__BlockAssignment ) )
            {
            // InternalRailSL.g:67:2: ( ( rule__RailProgram__BlockAssignment ) )
            // InternalRailSL.g:68:3: ( rule__RailProgram__BlockAssignment )
            {
             before(grammarAccess.getRailProgramAccess().getBlockAssignment()); 
            // InternalRailSL.g:69:3: ( rule__RailProgram__BlockAssignment )
            // InternalRailSL.g:69:4: rule__RailProgram__BlockAssignment
            {
            pushFollow(FOLLOW_2);
            rule__RailProgram__BlockAssignment();

            state._fsp--;


            }

             after(grammarAccess.getRailProgramAccess().getBlockAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRailProgram"


    // $ANTLR start "entryRuleBlock"
    // InternalRailSL.g:78:1: entryRuleBlock : ruleBlock EOF ;
    public final void entryRuleBlock() throws RecognitionException {
        try {
            // InternalRailSL.g:79:1: ( ruleBlock EOF )
            // InternalRailSL.g:80:1: ruleBlock EOF
            {
             before(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getBlockRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalRailSL.g:87:1: ruleBlock : ( ( rule__Block__Group__0 ) ) ;
    public final void ruleBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:91:2: ( ( ( rule__Block__Group__0 ) ) )
            // InternalRailSL.g:92:2: ( ( rule__Block__Group__0 ) )
            {
            // InternalRailSL.g:92:2: ( ( rule__Block__Group__0 ) )
            // InternalRailSL.g:93:3: ( rule__Block__Group__0 )
            {
             before(grammarAccess.getBlockAccess().getGroup()); 
            // InternalRailSL.g:94:3: ( rule__Block__Group__0 )
            // InternalRailSL.g:94:4: rule__Block__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Block__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleStatement"
    // InternalRailSL.g:103:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:104:1: ( ruleStatement EOF )
            // InternalRailSL.g:105:1: ruleStatement EOF
            {
             before(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalRailSL.g:112:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:116:2: ( ( ( rule__Statement__Alternatives ) ) )
            // InternalRailSL.g:117:2: ( ( rule__Statement__Alternatives ) )
            {
            // InternalRailSL.g:117:2: ( ( rule__Statement__Alternatives ) )
            // InternalRailSL.g:118:3: ( rule__Statement__Alternatives )
            {
             before(grammarAccess.getStatementAccess().getAlternatives()); 
            // InternalRailSL.g:119:3: ( rule__Statement__Alternatives )
            // InternalRailSL.g:119:4: rule__Statement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStatementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleSetStatement"
    // InternalRailSL.g:128:1: entryRuleSetStatement : ruleSetStatement EOF ;
    public final void entryRuleSetStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:129:1: ( ruleSetStatement EOF )
            // InternalRailSL.g:130:1: ruleSetStatement EOF
            {
             before(grammarAccess.getSetStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleSetStatement();

            state._fsp--;

             after(grammarAccess.getSetStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSetStatement"


    // $ANTLR start "ruleSetStatement"
    // InternalRailSL.g:137:1: ruleSetStatement : ( ( rule__SetStatement__Alternatives ) ) ;
    public final void ruleSetStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:141:2: ( ( ( rule__SetStatement__Alternatives ) ) )
            // InternalRailSL.g:142:2: ( ( rule__SetStatement__Alternatives ) )
            {
            // InternalRailSL.g:142:2: ( ( rule__SetStatement__Alternatives ) )
            // InternalRailSL.g:143:3: ( rule__SetStatement__Alternatives )
            {
             before(grammarAccess.getSetStatementAccess().getAlternatives()); 
            // InternalRailSL.g:144:3: ( rule__SetStatement__Alternatives )
            // InternalRailSL.g:144:4: rule__SetStatement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SetStatement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSetStatementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSetStatement"


    // $ANTLR start "entryRuleTrackStatement"
    // InternalRailSL.g:153:1: entryRuleTrackStatement : ruleTrackStatement EOF ;
    public final void entryRuleTrackStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:154:1: ( ruleTrackStatement EOF )
            // InternalRailSL.g:155:1: ruleTrackStatement EOF
            {
             before(grammarAccess.getTrackStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleTrackStatement();

            state._fsp--;

             after(grammarAccess.getTrackStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrackStatement"


    // $ANTLR start "ruleTrackStatement"
    // InternalRailSL.g:162:1: ruleTrackStatement : ( ( rule__TrackStatement__Group__0 ) ) ;
    public final void ruleTrackStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:166:2: ( ( ( rule__TrackStatement__Group__0 ) ) )
            // InternalRailSL.g:167:2: ( ( rule__TrackStatement__Group__0 ) )
            {
            // InternalRailSL.g:167:2: ( ( rule__TrackStatement__Group__0 ) )
            // InternalRailSL.g:168:3: ( rule__TrackStatement__Group__0 )
            {
             before(grammarAccess.getTrackStatementAccess().getGroup()); 
            // InternalRailSL.g:169:3: ( rule__TrackStatement__Group__0 )
            // InternalRailSL.g:169:4: rule__TrackStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrackStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrackStatement"


    // $ANTLR start "entryRulePointStatement"
    // InternalRailSL.g:178:1: entryRulePointStatement : rulePointStatement EOF ;
    public final void entryRulePointStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:179:1: ( rulePointStatement EOF )
            // InternalRailSL.g:180:1: rulePointStatement EOF
            {
             before(grammarAccess.getPointStatementRule()); 
            pushFollow(FOLLOW_1);
            rulePointStatement();

            state._fsp--;

             after(grammarAccess.getPointStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePointStatement"


    // $ANTLR start "rulePointStatement"
    // InternalRailSL.g:187:1: rulePointStatement : ( ( rule__PointStatement__Group__0 ) ) ;
    public final void rulePointStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:191:2: ( ( ( rule__PointStatement__Group__0 ) ) )
            // InternalRailSL.g:192:2: ( ( rule__PointStatement__Group__0 ) )
            {
            // InternalRailSL.g:192:2: ( ( rule__PointStatement__Group__0 ) )
            // InternalRailSL.g:193:3: ( rule__PointStatement__Group__0 )
            {
             before(grammarAccess.getPointStatementAccess().getGroup()); 
            // InternalRailSL.g:194:3: ( rule__PointStatement__Group__0 )
            // InternalRailSL.g:194:4: rule__PointStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PointStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPointStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePointStatement"


    // $ANTLR start "entryRuleWaitStatement"
    // InternalRailSL.g:203:1: entryRuleWaitStatement : ruleWaitStatement EOF ;
    public final void entryRuleWaitStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:204:1: ( ruleWaitStatement EOF )
            // InternalRailSL.g:205:1: ruleWaitStatement EOF
            {
             before(grammarAccess.getWaitStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleWaitStatement();

            state._fsp--;

             after(grammarAccess.getWaitStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWaitStatement"


    // $ANTLR start "ruleWaitStatement"
    // InternalRailSL.g:212:1: ruleWaitStatement : ( ( rule__WaitStatement__Alternatives ) ) ;
    public final void ruleWaitStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:216:2: ( ( ( rule__WaitStatement__Alternatives ) ) )
            // InternalRailSL.g:217:2: ( ( rule__WaitStatement__Alternatives ) )
            {
            // InternalRailSL.g:217:2: ( ( rule__WaitStatement__Alternatives ) )
            // InternalRailSL.g:218:3: ( rule__WaitStatement__Alternatives )
            {
             before(grammarAccess.getWaitStatementAccess().getAlternatives()); 
            // InternalRailSL.g:219:3: ( rule__WaitStatement__Alternatives )
            // InternalRailSL.g:219:4: rule__WaitStatement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__WaitStatement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getWaitStatementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWaitStatement"


    // $ANTLR start "entryRuleTimeWaitStatement"
    // InternalRailSL.g:228:1: entryRuleTimeWaitStatement : ruleTimeWaitStatement EOF ;
    public final void entryRuleTimeWaitStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:229:1: ( ruleTimeWaitStatement EOF )
            // InternalRailSL.g:230:1: ruleTimeWaitStatement EOF
            {
             before(grammarAccess.getTimeWaitStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleTimeWaitStatement();

            state._fsp--;

             after(grammarAccess.getTimeWaitStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTimeWaitStatement"


    // $ANTLR start "ruleTimeWaitStatement"
    // InternalRailSL.g:237:1: ruleTimeWaitStatement : ( ( rule__TimeWaitStatement__Group__0 ) ) ;
    public final void ruleTimeWaitStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:241:2: ( ( ( rule__TimeWaitStatement__Group__0 ) ) )
            // InternalRailSL.g:242:2: ( ( rule__TimeWaitStatement__Group__0 ) )
            {
            // InternalRailSL.g:242:2: ( ( rule__TimeWaitStatement__Group__0 ) )
            // InternalRailSL.g:243:3: ( rule__TimeWaitStatement__Group__0 )
            {
             before(grammarAccess.getTimeWaitStatementAccess().getGroup()); 
            // InternalRailSL.g:244:3: ( rule__TimeWaitStatement__Group__0 )
            // InternalRailSL.g:244:4: rule__TimeWaitStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TimeWaitStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimeWaitStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTimeWaitStatement"


    // $ANTLR start "entryRuleContactWaitStatement"
    // InternalRailSL.g:253:1: entryRuleContactWaitStatement : ruleContactWaitStatement EOF ;
    public final void entryRuleContactWaitStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:254:1: ( ruleContactWaitStatement EOF )
            // InternalRailSL.g:255:1: ruleContactWaitStatement EOF
            {
             before(grammarAccess.getContactWaitStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleContactWaitStatement();

            state._fsp--;

             after(grammarAccess.getContactWaitStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContactWaitStatement"


    // $ANTLR start "ruleContactWaitStatement"
    // InternalRailSL.g:262:1: ruleContactWaitStatement : ( ( rule__ContactWaitStatement__Group__0 ) ) ;
    public final void ruleContactWaitStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:266:2: ( ( ( rule__ContactWaitStatement__Group__0 ) ) )
            // InternalRailSL.g:267:2: ( ( rule__ContactWaitStatement__Group__0 ) )
            {
            // InternalRailSL.g:267:2: ( ( rule__ContactWaitStatement__Group__0 ) )
            // InternalRailSL.g:268:3: ( rule__ContactWaitStatement__Group__0 )
            {
             before(grammarAccess.getContactWaitStatementAccess().getGroup()); 
            // InternalRailSL.g:269:3: ( rule__ContactWaitStatement__Group__0 )
            // InternalRailSL.g:269:4: rule__ContactWaitStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ContactWaitStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContactWaitStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContactWaitStatement"


    // $ANTLR start "entryRuleOpStatement"
    // InternalRailSL.g:278:1: entryRuleOpStatement : ruleOpStatement EOF ;
    public final void entryRuleOpStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:279:1: ( ruleOpStatement EOF )
            // InternalRailSL.g:280:1: ruleOpStatement EOF
            {
             before(grammarAccess.getOpStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleOpStatement();

            state._fsp--;

             after(grammarAccess.getOpStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpStatement"


    // $ANTLR start "ruleOpStatement"
    // InternalRailSL.g:287:1: ruleOpStatement : ( ( rule__OpStatement__Alternatives ) ) ;
    public final void ruleOpStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:291:2: ( ( ( rule__OpStatement__Alternatives ) ) )
            // InternalRailSL.g:292:2: ( ( rule__OpStatement__Alternatives ) )
            {
            // InternalRailSL.g:292:2: ( ( rule__OpStatement__Alternatives ) )
            // InternalRailSL.g:293:3: ( rule__OpStatement__Alternatives )
            {
             before(grammarAccess.getOpStatementAccess().getAlternatives()); 
            // InternalRailSL.g:294:3: ( rule__OpStatement__Alternatives )
            // InternalRailSL.g:294:4: rule__OpStatement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OpStatement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOpStatementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpStatement"


    // $ANTLR start "entryRuleCrossingStatement"
    // InternalRailSL.g:303:1: entryRuleCrossingStatement : ruleCrossingStatement EOF ;
    public final void entryRuleCrossingStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:304:1: ( ruleCrossingStatement EOF )
            // InternalRailSL.g:305:1: ruleCrossingStatement EOF
            {
             before(grammarAccess.getCrossingStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleCrossingStatement();

            state._fsp--;

             after(grammarAccess.getCrossingStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCrossingStatement"


    // $ANTLR start "ruleCrossingStatement"
    // InternalRailSL.g:312:1: ruleCrossingStatement : ( ( rule__CrossingStatement__Group__0 ) ) ;
    public final void ruleCrossingStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:316:2: ( ( ( rule__CrossingStatement__Group__0 ) ) )
            // InternalRailSL.g:317:2: ( ( rule__CrossingStatement__Group__0 ) )
            {
            // InternalRailSL.g:317:2: ( ( rule__CrossingStatement__Group__0 ) )
            // InternalRailSL.g:318:3: ( rule__CrossingStatement__Group__0 )
            {
             before(grammarAccess.getCrossingStatementAccess().getGroup()); 
            // InternalRailSL.g:319:3: ( rule__CrossingStatement__Group__0 )
            // InternalRailSL.g:319:4: rule__CrossingStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CrossingStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCrossingStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCrossingStatement"


    // $ANTLR start "entryRuleLightStatement"
    // InternalRailSL.g:328:1: entryRuleLightStatement : ruleLightStatement EOF ;
    public final void entryRuleLightStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:329:1: ( ruleLightStatement EOF )
            // InternalRailSL.g:330:1: ruleLightStatement EOF
            {
             before(grammarAccess.getLightStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleLightStatement();

            state._fsp--;

             after(grammarAccess.getLightStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLightStatement"


    // $ANTLR start "ruleLightStatement"
    // InternalRailSL.g:337:1: ruleLightStatement : ( ( rule__LightStatement__Group__0 ) ) ;
    public final void ruleLightStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:341:2: ( ( ( rule__LightStatement__Group__0 ) ) )
            // InternalRailSL.g:342:2: ( ( rule__LightStatement__Group__0 ) )
            {
            // InternalRailSL.g:342:2: ( ( rule__LightStatement__Group__0 ) )
            // InternalRailSL.g:343:3: ( rule__LightStatement__Group__0 )
            {
             before(grammarAccess.getLightStatementAccess().getGroup()); 
            // InternalRailSL.g:344:3: ( rule__LightStatement__Group__0 )
            // InternalRailSL.g:344:4: rule__LightStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LightStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLightStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLightStatement"


    // $ANTLR start "entryRuleConditionalStatement"
    // InternalRailSL.g:353:1: entryRuleConditionalStatement : ruleConditionalStatement EOF ;
    public final void entryRuleConditionalStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:354:1: ( ruleConditionalStatement EOF )
            // InternalRailSL.g:355:1: ruleConditionalStatement EOF
            {
             before(grammarAccess.getConditionalStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleConditionalStatement();

            state._fsp--;

             after(grammarAccess.getConditionalStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConditionalStatement"


    // $ANTLR start "ruleConditionalStatement"
    // InternalRailSL.g:362:1: ruleConditionalStatement : ( ( rule__ConditionalStatement__Group__0 ) ) ;
    public final void ruleConditionalStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:366:2: ( ( ( rule__ConditionalStatement__Group__0 ) ) )
            // InternalRailSL.g:367:2: ( ( rule__ConditionalStatement__Group__0 ) )
            {
            // InternalRailSL.g:367:2: ( ( rule__ConditionalStatement__Group__0 ) )
            // InternalRailSL.g:368:3: ( rule__ConditionalStatement__Group__0 )
            {
             before(grammarAccess.getConditionalStatementAccess().getGroup()); 
            // InternalRailSL.g:369:3: ( rule__ConditionalStatement__Group__0 )
            // InternalRailSL.g:369:4: rule__ConditionalStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConditionalStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConditionalStatement"


    // $ANTLR start "entryRuleConditionalLine"
    // InternalRailSL.g:378:1: entryRuleConditionalLine : ruleConditionalLine EOF ;
    public final void entryRuleConditionalLine() throws RecognitionException {
        try {
            // InternalRailSL.g:379:1: ( ruleConditionalLine EOF )
            // InternalRailSL.g:380:1: ruleConditionalLine EOF
            {
             before(grammarAccess.getConditionalLineRule()); 
            pushFollow(FOLLOW_1);
            ruleConditionalLine();

            state._fsp--;

             after(grammarAccess.getConditionalLineRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConditionalLine"


    // $ANTLR start "ruleConditionalLine"
    // InternalRailSL.g:387:1: ruleConditionalLine : ( ( rule__ConditionalLine__Group__0 ) ) ;
    public final void ruleConditionalLine() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:391:2: ( ( ( rule__ConditionalLine__Group__0 ) ) )
            // InternalRailSL.g:392:2: ( ( rule__ConditionalLine__Group__0 ) )
            {
            // InternalRailSL.g:392:2: ( ( rule__ConditionalLine__Group__0 ) )
            // InternalRailSL.g:393:3: ( rule__ConditionalLine__Group__0 )
            {
             before(grammarAccess.getConditionalLineAccess().getGroup()); 
            // InternalRailSL.g:394:3: ( rule__ConditionalLine__Group__0 )
            // InternalRailSL.g:394:4: rule__ConditionalLine__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConditionalLineAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConditionalLine"


    // $ANTLR start "entryRuleParallelStatement"
    // InternalRailSL.g:403:1: entryRuleParallelStatement : ruleParallelStatement EOF ;
    public final void entryRuleParallelStatement() throws RecognitionException {
        try {
            // InternalRailSL.g:404:1: ( ruleParallelStatement EOF )
            // InternalRailSL.g:405:1: ruleParallelStatement EOF
            {
             before(grammarAccess.getParallelStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleParallelStatement();

            state._fsp--;

             after(grammarAccess.getParallelStatementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParallelStatement"


    // $ANTLR start "ruleParallelStatement"
    // InternalRailSL.g:412:1: ruleParallelStatement : ( ( rule__ParallelStatement__Group__0 ) ) ;
    public final void ruleParallelStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:416:2: ( ( ( rule__ParallelStatement__Group__0 ) ) )
            // InternalRailSL.g:417:2: ( ( rule__ParallelStatement__Group__0 ) )
            {
            // InternalRailSL.g:417:2: ( ( rule__ParallelStatement__Group__0 ) )
            // InternalRailSL.g:418:3: ( rule__ParallelStatement__Group__0 )
            {
             before(grammarAccess.getParallelStatementAccess().getGroup()); 
            // InternalRailSL.g:419:3: ( rule__ParallelStatement__Group__0 )
            // InternalRailSL.g:419:4: rule__ParallelStatement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParallelStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParallelStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParallelStatement"


    // $ANTLR start "ruleBlockEnd"
    // InternalRailSL.g:428:1: ruleBlockEnd : ( ( rule__BlockEnd__Alternatives ) ) ;
    public final void ruleBlockEnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:432:1: ( ( ( rule__BlockEnd__Alternatives ) ) )
            // InternalRailSL.g:433:2: ( ( rule__BlockEnd__Alternatives ) )
            {
            // InternalRailSL.g:433:2: ( ( rule__BlockEnd__Alternatives ) )
            // InternalRailSL.g:434:3: ( rule__BlockEnd__Alternatives )
            {
             before(grammarAccess.getBlockEndAccess().getAlternatives()); 
            // InternalRailSL.g:435:3: ( rule__BlockEnd__Alternatives )
            // InternalRailSL.g:435:4: rule__BlockEnd__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BlockEnd__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBlockEndAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBlockEnd"


    // $ANTLR start "ruleTrackSpeedStop"
    // InternalRailSL.g:444:1: ruleTrackSpeedStop : ( ( 'stop' ) ) ;
    public final void ruleTrackSpeedStop() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:448:1: ( ( ( 'stop' ) ) )
            // InternalRailSL.g:449:2: ( ( 'stop' ) )
            {
            // InternalRailSL.g:449:2: ( ( 'stop' ) )
            // InternalRailSL.g:450:3: ( 'stop' )
            {
             before(grammarAccess.getTrackSpeedStopAccess().getSTOPEnumLiteralDeclaration()); 
            // InternalRailSL.g:451:3: ( 'stop' )
            // InternalRailSL.g:451:4: 'stop'
            {
            match(input,11,FOLLOW_2); 

            }

             after(grammarAccess.getTrackSpeedStopAccess().getSTOPEnumLiteralDeclaration()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrackSpeedStop"


    // $ANTLR start "ruleTrackSpeedDrive"
    // InternalRailSL.g:460:1: ruleTrackSpeedDrive : ( ( rule__TrackSpeedDrive__Alternatives ) ) ;
    public final void ruleTrackSpeedDrive() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:464:1: ( ( ( rule__TrackSpeedDrive__Alternatives ) ) )
            // InternalRailSL.g:465:2: ( ( rule__TrackSpeedDrive__Alternatives ) )
            {
            // InternalRailSL.g:465:2: ( ( rule__TrackSpeedDrive__Alternatives ) )
            // InternalRailSL.g:466:3: ( rule__TrackSpeedDrive__Alternatives )
            {
             before(grammarAccess.getTrackSpeedDriveAccess().getAlternatives()); 
            // InternalRailSL.g:467:3: ( rule__TrackSpeedDrive__Alternatives )
            // InternalRailSL.g:467:4: rule__TrackSpeedDrive__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TrackSpeedDrive__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTrackSpeedDriveAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrackSpeedDrive"


    // $ANTLR start "rulePointOrinetation"
    // InternalRailSL.g:476:1: rulePointOrinetation : ( ( rule__PointOrinetation__Alternatives ) ) ;
    public final void rulePointOrinetation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:480:1: ( ( ( rule__PointOrinetation__Alternatives ) ) )
            // InternalRailSL.g:481:2: ( ( rule__PointOrinetation__Alternatives ) )
            {
            // InternalRailSL.g:481:2: ( ( rule__PointOrinetation__Alternatives ) )
            // InternalRailSL.g:482:3: ( rule__PointOrinetation__Alternatives )
            {
             before(grammarAccess.getPointOrinetationAccess().getAlternatives()); 
            // InternalRailSL.g:483:3: ( rule__PointOrinetation__Alternatives )
            // InternalRailSL.g:483:4: rule__PointOrinetation__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PointOrinetation__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPointOrinetationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePointOrinetation"


    // $ANTLR start "ruleContactEvent"
    // InternalRailSL.g:492:1: ruleContactEvent : ( ( rule__ContactEvent__Alternatives ) ) ;
    public final void ruleContactEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:496:1: ( ( ( rule__ContactEvent__Alternatives ) ) )
            // InternalRailSL.g:497:2: ( ( rule__ContactEvent__Alternatives ) )
            {
            // InternalRailSL.g:497:2: ( ( rule__ContactEvent__Alternatives ) )
            // InternalRailSL.g:498:3: ( rule__ContactEvent__Alternatives )
            {
             before(grammarAccess.getContactEventAccess().getAlternatives()); 
            // InternalRailSL.g:499:3: ( rule__ContactEvent__Alternatives )
            // InternalRailSL.g:499:4: rule__ContactEvent__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ContactEvent__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getContactEventAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContactEvent"


    // $ANTLR start "ruleContactPosition"
    // InternalRailSL.g:508:1: ruleContactPosition : ( ( rule__ContactPosition__Alternatives ) ) ;
    public final void ruleContactPosition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:512:1: ( ( ( rule__ContactPosition__Alternatives ) ) )
            // InternalRailSL.g:513:2: ( ( rule__ContactPosition__Alternatives ) )
            {
            // InternalRailSL.g:513:2: ( ( rule__ContactPosition__Alternatives ) )
            // InternalRailSL.g:514:3: ( rule__ContactPosition__Alternatives )
            {
             before(grammarAccess.getContactPositionAccess().getAlternatives()); 
            // InternalRailSL.g:515:3: ( rule__ContactPosition__Alternatives )
            // InternalRailSL.g:515:4: rule__ContactPosition__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ContactPosition__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getContactPositionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContactPosition"


    // $ANTLR start "ruleCrossingMode"
    // InternalRailSL.g:524:1: ruleCrossingMode : ( ( rule__CrossingMode__Alternatives ) ) ;
    public final void ruleCrossingMode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:528:1: ( ( ( rule__CrossingMode__Alternatives ) ) )
            // InternalRailSL.g:529:2: ( ( rule__CrossingMode__Alternatives ) )
            {
            // InternalRailSL.g:529:2: ( ( rule__CrossingMode__Alternatives ) )
            // InternalRailSL.g:530:3: ( rule__CrossingMode__Alternatives )
            {
             before(grammarAccess.getCrossingModeAccess().getAlternatives()); 
            // InternalRailSL.g:531:3: ( rule__CrossingMode__Alternatives )
            // InternalRailSL.g:531:4: rule__CrossingMode__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CrossingMode__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCrossingModeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCrossingMode"


    // $ANTLR start "ruleRailSegment"
    // InternalRailSL.g:540:1: ruleRailSegment : ( ( rule__RailSegment__Alternatives ) ) ;
    public final void ruleRailSegment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:544:1: ( ( ( rule__RailSegment__Alternatives ) ) )
            // InternalRailSL.g:545:2: ( ( rule__RailSegment__Alternatives ) )
            {
            // InternalRailSL.g:545:2: ( ( rule__RailSegment__Alternatives ) )
            // InternalRailSL.g:546:3: ( rule__RailSegment__Alternatives )
            {
             before(grammarAccess.getRailSegmentAccess().getAlternatives()); 
            // InternalRailSL.g:547:3: ( rule__RailSegment__Alternatives )
            // InternalRailSL.g:547:4: rule__RailSegment__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RailSegment__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRailSegmentAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRailSegment"


    // $ANTLR start "rule__Block__Alternatives_0"
    // InternalRailSL.g:555:1: rule__Block__Alternatives_0 : ( ( 'Start:' ) | ( 'start:' ) );
    public final void rule__Block__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:559:1: ( ( 'Start:' ) | ( 'start:' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalRailSL.g:560:2: ( 'Start:' )
                    {
                    // InternalRailSL.g:560:2: ( 'Start:' )
                    // InternalRailSL.g:561:3: 'Start:'
                    {
                     before(grammarAccess.getBlockAccess().getStartKeyword_0_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getBlockAccess().getStartKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:566:2: ( 'start:' )
                    {
                    // InternalRailSL.g:566:2: ( 'start:' )
                    // InternalRailSL.g:567:3: 'start:'
                    {
                     before(grammarAccess.getBlockAccess().getStartKeyword_0_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getBlockAccess().getStartKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Alternatives_0"


    // $ANTLR start "rule__Statement__Alternatives"
    // InternalRailSL.g:576:1: rule__Statement__Alternatives : ( ( ruleSetStatement ) | ( ruleWaitStatement ) | ( ruleOpStatement ) | ( ruleConditionalStatement ) | ( ruleParallelStatement ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:580:1: ( ( ruleSetStatement ) | ( ruleWaitStatement ) | ( ruleOpStatement ) | ( ruleConditionalStatement ) | ( ruleParallelStatement ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 14:
            case 15:
                {
                alt2=1;
                }
                break;
            case 18:
            case 19:
            case 40:
            case 41:
            case 42:
            case 43:
                {
                alt2=2;
                }
                break;
            case 20:
            case 21:
            case 45:
            case 46:
            case 47:
            case 48:
                {
                alt2=3;
                }
                break;
            case 24:
            case 25:
                {
                alt2=4;
                }
                break;
            case 30:
            case 31:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalRailSL.g:581:2: ( ruleSetStatement )
                    {
                    // InternalRailSL.g:581:2: ( ruleSetStatement )
                    // InternalRailSL.g:582:3: ruleSetStatement
                    {
                     before(grammarAccess.getStatementAccess().getSetStatementParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSetStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getSetStatementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:587:2: ( ruleWaitStatement )
                    {
                    // InternalRailSL.g:587:2: ( ruleWaitStatement )
                    // InternalRailSL.g:588:3: ruleWaitStatement
                    {
                     before(grammarAccess.getStatementAccess().getWaitStatementParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleWaitStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getWaitStatementParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:593:2: ( ruleOpStatement )
                    {
                    // InternalRailSL.g:593:2: ( ruleOpStatement )
                    // InternalRailSL.g:594:3: ruleOpStatement
                    {
                     before(grammarAccess.getStatementAccess().getOpStatementParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleOpStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getOpStatementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:599:2: ( ruleConditionalStatement )
                    {
                    // InternalRailSL.g:599:2: ( ruleConditionalStatement )
                    // InternalRailSL.g:600:3: ruleConditionalStatement
                    {
                     before(grammarAccess.getStatementAccess().getConditionalStatementParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleConditionalStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getConditionalStatementParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalRailSL.g:605:2: ( ruleParallelStatement )
                    {
                    // InternalRailSL.g:605:2: ( ruleParallelStatement )
                    // InternalRailSL.g:606:3: ruleParallelStatement
                    {
                     before(grammarAccess.getStatementAccess().getParallelStatementParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleParallelStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getParallelStatementParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Alternatives"


    // $ANTLR start "rule__SetStatement__Alternatives"
    // InternalRailSL.g:615:1: rule__SetStatement__Alternatives : ( ( ruleTrackStatement ) | ( rulePointStatement ) );
    public final void rule__SetStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:619:1: ( ( ruleTrackStatement ) | ( rulePointStatement ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==97) ) {
                    alt3=1;
                }
                else if ( (LA3_1==100) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==15) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==100) ) {
                    alt3=2;
                }
                else if ( (LA3_2==97) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalRailSL.g:620:2: ( ruleTrackStatement )
                    {
                    // InternalRailSL.g:620:2: ( ruleTrackStatement )
                    // InternalRailSL.g:621:3: ruleTrackStatement
                    {
                     before(grammarAccess.getSetStatementAccess().getTrackStatementParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTrackStatement();

                    state._fsp--;

                     after(grammarAccess.getSetStatementAccess().getTrackStatementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:626:2: ( rulePointStatement )
                    {
                    // InternalRailSL.g:626:2: ( rulePointStatement )
                    // InternalRailSL.g:627:3: rulePointStatement
                    {
                     before(grammarAccess.getSetStatementAccess().getPointStatementParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePointStatement();

                    state._fsp--;

                     after(grammarAccess.getSetStatementAccess().getPointStatementParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetStatement__Alternatives"


    // $ANTLR start "rule__TrackStatement__Alternatives_0"
    // InternalRailSL.g:636:1: rule__TrackStatement__Alternatives_0 : ( ( 'Set' ) | ( 'set' ) );
    public final void rule__TrackStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:640:1: ( ( 'Set' ) | ( 'set' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalRailSL.g:641:2: ( 'Set' )
                    {
                    // InternalRailSL.g:641:2: ( 'Set' )
                    // InternalRailSL.g:642:3: 'Set'
                    {
                     before(grammarAccess.getTrackStatementAccess().getSetKeyword_0_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getTrackStatementAccess().getSetKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:647:2: ( 'set' )
                    {
                    // InternalRailSL.g:647:2: ( 'set' )
                    // InternalRailSL.g:648:3: 'set'
                    {
                     before(grammarAccess.getTrackStatementAccess().getSetKeyword_0_1()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getTrackStatementAccess().getSetKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Alternatives_0"


    // $ANTLR start "rule__TrackStatement__Alternatives_3_0"
    // InternalRailSL.g:657:1: rule__TrackStatement__Alternatives_3_0 : ( ( ',' ) | ( 'and' ) | ( ( rule__TrackStatement__Group_3_0_2__0 ) ) );
    public final void rule__TrackStatement__Alternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:661:1: ( ( ',' ) | ( 'and' ) | ( ( rule__TrackStatement__Group_3_0_2__0 ) ) )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                int LA5_1 = input.LA(2);

                if ( ((LA5_1>=49 && LA5_1<=96)) ) {
                    alt5=1;
                }
                else if ( (LA5_1==17) ) {
                    alt5=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA5_0==17) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalRailSL.g:662:2: ( ',' )
                    {
                    // InternalRailSL.g:662:2: ( ',' )
                    // InternalRailSL.g:663:3: ','
                    {
                     before(grammarAccess.getTrackStatementAccess().getCommaKeyword_3_0_0()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getTrackStatementAccess().getCommaKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:668:2: ( 'and' )
                    {
                    // InternalRailSL.g:668:2: ( 'and' )
                    // InternalRailSL.g:669:3: 'and'
                    {
                     before(grammarAccess.getTrackStatementAccess().getAndKeyword_3_0_1()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getTrackStatementAccess().getAndKeyword_3_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:674:2: ( ( rule__TrackStatement__Group_3_0_2__0 ) )
                    {
                    // InternalRailSL.g:674:2: ( ( rule__TrackStatement__Group_3_0_2__0 ) )
                    // InternalRailSL.g:675:3: ( rule__TrackStatement__Group_3_0_2__0 )
                    {
                     before(grammarAccess.getTrackStatementAccess().getGroup_3_0_2()); 
                    // InternalRailSL.g:676:3: ( rule__TrackStatement__Group_3_0_2__0 )
                    // InternalRailSL.g:676:4: rule__TrackStatement__Group_3_0_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TrackStatement__Group_3_0_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTrackStatementAccess().getGroup_3_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Alternatives_3_0"


    // $ANTLR start "rule__TrackStatement__Alternatives_5"
    // InternalRailSL.g:684:1: rule__TrackStatement__Alternatives_5 : ( ( ( rule__TrackStatement__SpeedAssignment_5_0 ) ) | ( ( rule__TrackStatement__Group_5_1__0 ) ) );
    public final void rule__TrackStatement__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:688:1: ( ( ( rule__TrackStatement__SpeedAssignment_5_0 ) ) | ( ( rule__TrackStatement__Group_5_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==11) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=36 && LA6_0<=37)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalRailSL.g:689:2: ( ( rule__TrackStatement__SpeedAssignment_5_0 ) )
                    {
                    // InternalRailSL.g:689:2: ( ( rule__TrackStatement__SpeedAssignment_5_0 ) )
                    // InternalRailSL.g:690:3: ( rule__TrackStatement__SpeedAssignment_5_0 )
                    {
                     before(grammarAccess.getTrackStatementAccess().getSpeedAssignment_5_0()); 
                    // InternalRailSL.g:691:3: ( rule__TrackStatement__SpeedAssignment_5_0 )
                    // InternalRailSL.g:691:4: rule__TrackStatement__SpeedAssignment_5_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TrackStatement__SpeedAssignment_5_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTrackStatementAccess().getSpeedAssignment_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:695:2: ( ( rule__TrackStatement__Group_5_1__0 ) )
                    {
                    // InternalRailSL.g:695:2: ( ( rule__TrackStatement__Group_5_1__0 ) )
                    // InternalRailSL.g:696:3: ( rule__TrackStatement__Group_5_1__0 )
                    {
                     before(grammarAccess.getTrackStatementAccess().getGroup_5_1()); 
                    // InternalRailSL.g:697:3: ( rule__TrackStatement__Group_5_1__0 )
                    // InternalRailSL.g:697:4: rule__TrackStatement__Group_5_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TrackStatement__Group_5_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTrackStatementAccess().getGroup_5_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Alternatives_5"


    // $ANTLR start "rule__PointStatement__Alternatives_0"
    // InternalRailSL.g:705:1: rule__PointStatement__Alternatives_0 : ( ( 'Set' ) | ( 'set' ) );
    public final void rule__PointStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:709:1: ( ( 'Set' ) | ( 'set' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            else if ( (LA7_0==15) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalRailSL.g:710:2: ( 'Set' )
                    {
                    // InternalRailSL.g:710:2: ( 'Set' )
                    // InternalRailSL.g:711:3: 'Set'
                    {
                     before(grammarAccess.getPointStatementAccess().getSetKeyword_0_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getPointStatementAccess().getSetKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:716:2: ( 'set' )
                    {
                    // InternalRailSL.g:716:2: ( 'set' )
                    // InternalRailSL.g:717:3: 'set'
                    {
                     before(grammarAccess.getPointStatementAccess().getSetKeyword_0_1()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getPointStatementAccess().getSetKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Alternatives_0"


    // $ANTLR start "rule__PointStatement__Alternatives_3_0"
    // InternalRailSL.g:726:1: rule__PointStatement__Alternatives_3_0 : ( ( ',' ) | ( 'and' ) | ( ( rule__PointStatement__Group_3_0_2__0 ) ) );
    public final void rule__PointStatement__Alternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:730:1: ( ( ',' ) | ( 'and' ) | ( ( rule__PointStatement__Group_3_0_2__0 ) ) )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==RULE_INT) ) {
                    alt8=1;
                }
                else if ( (LA8_1==17) ) {
                    alt8=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA8_0==17) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalRailSL.g:731:2: ( ',' )
                    {
                    // InternalRailSL.g:731:2: ( ',' )
                    // InternalRailSL.g:732:3: ','
                    {
                     before(grammarAccess.getPointStatementAccess().getCommaKeyword_3_0_0()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getPointStatementAccess().getCommaKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:737:2: ( 'and' )
                    {
                    // InternalRailSL.g:737:2: ( 'and' )
                    // InternalRailSL.g:738:3: 'and'
                    {
                     before(grammarAccess.getPointStatementAccess().getAndKeyword_3_0_1()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getPointStatementAccess().getAndKeyword_3_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:743:2: ( ( rule__PointStatement__Group_3_0_2__0 ) )
                    {
                    // InternalRailSL.g:743:2: ( ( rule__PointStatement__Group_3_0_2__0 ) )
                    // InternalRailSL.g:744:3: ( rule__PointStatement__Group_3_0_2__0 )
                    {
                     before(grammarAccess.getPointStatementAccess().getGroup_3_0_2()); 
                    // InternalRailSL.g:745:3: ( rule__PointStatement__Group_3_0_2__0 )
                    // InternalRailSL.g:745:4: rule__PointStatement__Group_3_0_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PointStatement__Group_3_0_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPointStatementAccess().getGroup_3_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Alternatives_3_0"


    // $ANTLR start "rule__WaitStatement__Alternatives"
    // InternalRailSL.g:753:1: rule__WaitStatement__Alternatives : ( ( ruleTimeWaitStatement ) | ( ruleContactWaitStatement ) );
    public final void rule__WaitStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:757:1: ( ( ruleTimeWaitStatement ) | ( ruleContactWaitStatement ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=18 && LA9_0<=19)) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=40 && LA9_0<=43)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalRailSL.g:758:2: ( ruleTimeWaitStatement )
                    {
                    // InternalRailSL.g:758:2: ( ruleTimeWaitStatement )
                    // InternalRailSL.g:759:3: ruleTimeWaitStatement
                    {
                     before(grammarAccess.getWaitStatementAccess().getTimeWaitStatementParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTimeWaitStatement();

                    state._fsp--;

                     after(grammarAccess.getWaitStatementAccess().getTimeWaitStatementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:764:2: ( ruleContactWaitStatement )
                    {
                    // InternalRailSL.g:764:2: ( ruleContactWaitStatement )
                    // InternalRailSL.g:765:3: ruleContactWaitStatement
                    {
                     before(grammarAccess.getWaitStatementAccess().getContactWaitStatementParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleContactWaitStatement();

                    state._fsp--;

                     after(grammarAccess.getWaitStatementAccess().getContactWaitStatementParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WaitStatement__Alternatives"


    // $ANTLR start "rule__TimeWaitStatement__Alternatives_0"
    // InternalRailSL.g:774:1: rule__TimeWaitStatement__Alternatives_0 : ( ( 'Wait' ) | ( 'wait' ) );
    public final void rule__TimeWaitStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:778:1: ( ( 'Wait' ) | ( 'wait' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            else if ( (LA10_0==19) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalRailSL.g:779:2: ( 'Wait' )
                    {
                    // InternalRailSL.g:779:2: ( 'Wait' )
                    // InternalRailSL.g:780:3: 'Wait'
                    {
                     before(grammarAccess.getTimeWaitStatementAccess().getWaitKeyword_0_0()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getTimeWaitStatementAccess().getWaitKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:785:2: ( 'wait' )
                    {
                    // InternalRailSL.g:785:2: ( 'wait' )
                    // InternalRailSL.g:786:3: 'wait'
                    {
                     before(grammarAccess.getTimeWaitStatementAccess().getWaitKeyword_0_1()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getTimeWaitStatementAccess().getWaitKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeWaitStatement__Alternatives_0"


    // $ANTLR start "rule__OpStatement__Alternatives"
    // InternalRailSL.g:795:1: rule__OpStatement__Alternatives : ( ( ruleCrossingStatement ) | ( ruleLightStatement ) );
    public final void rule__OpStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:799:1: ( ( ruleCrossingStatement ) | ( ruleLightStatement ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=45 && LA11_0<=48)) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=20 && LA11_0<=21)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalRailSL.g:800:2: ( ruleCrossingStatement )
                    {
                    // InternalRailSL.g:800:2: ( ruleCrossingStatement )
                    // InternalRailSL.g:801:3: ruleCrossingStatement
                    {
                     before(grammarAccess.getOpStatementAccess().getCrossingStatementParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleCrossingStatement();

                    state._fsp--;

                     after(grammarAccess.getOpStatementAccess().getCrossingStatementParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:806:2: ( ruleLightStatement )
                    {
                    // InternalRailSL.g:806:2: ( ruleLightStatement )
                    // InternalRailSL.g:807:3: ruleLightStatement
                    {
                     before(grammarAccess.getOpStatementAccess().getLightStatementParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleLightStatement();

                    state._fsp--;

                     after(grammarAccess.getOpStatementAccess().getLightStatementParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpStatement__Alternatives"


    // $ANTLR start "rule__LightStatement__Alternatives_0"
    // InternalRailSL.g:816:1: rule__LightStatement__Alternatives_0 : ( ( 'Turn' ) | ( 'turn' ) );
    public final void rule__LightStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:820:1: ( ( 'Turn' ) | ( 'turn' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            else if ( (LA12_0==21) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalRailSL.g:821:2: ( 'Turn' )
                    {
                    // InternalRailSL.g:821:2: ( 'Turn' )
                    // InternalRailSL.g:822:3: 'Turn'
                    {
                     before(grammarAccess.getLightStatementAccess().getTurnKeyword_0_0()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getLightStatementAccess().getTurnKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:827:2: ( 'turn' )
                    {
                    // InternalRailSL.g:827:2: ( 'turn' )
                    // InternalRailSL.g:828:3: 'turn'
                    {
                     before(grammarAccess.getLightStatementAccess().getTurnKeyword_0_1()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getLightStatementAccess().getTurnKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Alternatives_0"


    // $ANTLR start "rule__LightStatement__Alternatives_3_0"
    // InternalRailSL.g:837:1: rule__LightStatement__Alternatives_3_0 : ( ( ',' ) | ( 'and' ) | ( ( rule__LightStatement__Group_3_0_2__0 ) ) );
    public final void rule__LightStatement__Alternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:841:1: ( ( ',' ) | ( 'and' ) | ( ( rule__LightStatement__Group_3_0_2__0 ) ) )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==16) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==RULE_INT) ) {
                    alt13=1;
                }
                else if ( (LA13_1==17) ) {
                    alt13=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA13_0==17) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalRailSL.g:842:2: ( ',' )
                    {
                    // InternalRailSL.g:842:2: ( ',' )
                    // InternalRailSL.g:843:3: ','
                    {
                     before(grammarAccess.getLightStatementAccess().getCommaKeyword_3_0_0()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getLightStatementAccess().getCommaKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:848:2: ( 'and' )
                    {
                    // InternalRailSL.g:848:2: ( 'and' )
                    // InternalRailSL.g:849:3: 'and'
                    {
                     before(grammarAccess.getLightStatementAccess().getAndKeyword_3_0_1()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getLightStatementAccess().getAndKeyword_3_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:854:2: ( ( rule__LightStatement__Group_3_0_2__0 ) )
                    {
                    // InternalRailSL.g:854:2: ( ( rule__LightStatement__Group_3_0_2__0 ) )
                    // InternalRailSL.g:855:3: ( rule__LightStatement__Group_3_0_2__0 )
                    {
                     before(grammarAccess.getLightStatementAccess().getGroup_3_0_2()); 
                    // InternalRailSL.g:856:3: ( rule__LightStatement__Group_3_0_2__0 )
                    // InternalRailSL.g:856:4: rule__LightStatement__Group_3_0_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__LightStatement__Group_3_0_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLightStatementAccess().getGroup_3_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Alternatives_3_0"


    // $ANTLR start "rule__LightStatement__StateAlternatives_4_0"
    // InternalRailSL.g:864:1: rule__LightStatement__StateAlternatives_4_0 : ( ( 'on' ) | ( 'off' ) );
    public final void rule__LightStatement__StateAlternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:868:1: ( ( 'on' ) | ( 'off' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            else if ( (LA14_0==23) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalRailSL.g:869:2: ( 'on' )
                    {
                    // InternalRailSL.g:869:2: ( 'on' )
                    // InternalRailSL.g:870:3: 'on'
                    {
                     before(grammarAccess.getLightStatementAccess().getStateOnKeyword_4_0_0()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getLightStatementAccess().getStateOnKeyword_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:875:2: ( 'off' )
                    {
                    // InternalRailSL.g:875:2: ( 'off' )
                    // InternalRailSL.g:876:3: 'off'
                    {
                     before(grammarAccess.getLightStatementAccess().getStateOffKeyword_4_0_1()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getLightStatementAccess().getStateOffKeyword_4_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__StateAlternatives_4_0"


    // $ANTLR start "rule__ConditionalStatement__Alternatives_0"
    // InternalRailSL.g:885:1: rule__ConditionalStatement__Alternatives_0 : ( ( 'Branch:' ) | ( 'branch:' ) );
    public final void rule__ConditionalStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:889:1: ( ( 'Branch:' ) | ( 'branch:' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            else if ( (LA15_0==25) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalRailSL.g:890:2: ( 'Branch:' )
                    {
                    // InternalRailSL.g:890:2: ( 'Branch:' )
                    // InternalRailSL.g:891:3: 'Branch:'
                    {
                     before(grammarAccess.getConditionalStatementAccess().getBranchKeyword_0_0()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getConditionalStatementAccess().getBranchKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:896:2: ( 'branch:' )
                    {
                    // InternalRailSL.g:896:2: ( 'branch:' )
                    // InternalRailSL.g:897:3: 'branch:'
                    {
                     before(grammarAccess.getConditionalStatementAccess().getBranchKeyword_0_1()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getConditionalStatementAccess().getBranchKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalStatement__Alternatives_0"


    // $ANTLR start "rule__ConditionalLine__Alternatives_0"
    // InternalRailSL.g:906:1: rule__ConditionalLine__Alternatives_0 : ( ( 'If' ) | ( 'if' ) );
    public final void rule__ConditionalLine__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:910:1: ( ( 'If' ) | ( 'if' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            else if ( (LA16_0==27) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalRailSL.g:911:2: ( 'If' )
                    {
                    // InternalRailSL.g:911:2: ( 'If' )
                    // InternalRailSL.g:912:3: 'If'
                    {
                     before(grammarAccess.getConditionalLineAccess().getIfKeyword_0_0()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getConditionalLineAccess().getIfKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:917:2: ( 'if' )
                    {
                    // InternalRailSL.g:917:2: ( 'if' )
                    // InternalRailSL.g:918:3: 'if'
                    {
                     before(grammarAccess.getConditionalLineAccess().getIfKeyword_0_1()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getConditionalLineAccess().getIfKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Alternatives_0"


    // $ANTLR start "rule__ConditionalLine__Alternatives_7"
    // InternalRailSL.g:927:1: rule__ConditionalLine__Alternatives_7 : ( ( 'first' ) | ( 'first,' ) );
    public final void rule__ConditionalLine__Alternatives_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:931:1: ( ( 'first' ) | ( 'first,' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            else if ( (LA17_0==29) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalRailSL.g:932:2: ( 'first' )
                    {
                    // InternalRailSL.g:932:2: ( 'first' )
                    // InternalRailSL.g:933:3: 'first'
                    {
                     before(grammarAccess.getConditionalLineAccess().getFirstKeyword_7_0()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getConditionalLineAccess().getFirstKeyword_7_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:938:2: ( 'first,' )
                    {
                    // InternalRailSL.g:938:2: ( 'first,' )
                    // InternalRailSL.g:939:3: 'first,'
                    {
                     before(grammarAccess.getConditionalLineAccess().getFirstKeyword_7_1()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getConditionalLineAccess().getFirstKeyword_7_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Alternatives_7"


    // $ANTLR start "rule__ParallelStatement__Alternatives_0"
    // InternalRailSL.g:948:1: rule__ParallelStatement__Alternatives_0 : ( ( 'Parallel:' ) | ( 'parallel:' ) );
    public final void rule__ParallelStatement__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:952:1: ( ( 'Parallel:' ) | ( 'parallel:' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            else if ( (LA18_0==31) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalRailSL.g:953:2: ( 'Parallel:' )
                    {
                    // InternalRailSL.g:953:2: ( 'Parallel:' )
                    // InternalRailSL.g:954:3: 'Parallel:'
                    {
                     before(grammarAccess.getParallelStatementAccess().getParallelKeyword_0_0()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getParallelStatementAccess().getParallelKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:959:2: ( 'parallel:' )
                    {
                    // InternalRailSL.g:959:2: ( 'parallel:' )
                    // InternalRailSL.g:960:3: 'parallel:'
                    {
                     before(grammarAccess.getParallelStatementAccess().getParallelKeyword_0_1()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getParallelStatementAccess().getParallelKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParallelStatement__Alternatives_0"


    // $ANTLR start "rule__BlockEnd__Alternatives"
    // InternalRailSL.g:969:1: rule__BlockEnd__Alternatives : ( ( ( 'End.' ) ) | ( ( 'end.' ) ) | ( ( 'Loop.' ) ) | ( ( 'loop.' ) ) );
    public final void rule__BlockEnd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:973:1: ( ( ( 'End.' ) ) | ( ( 'end.' ) ) | ( ( 'Loop.' ) ) | ( ( 'loop.' ) ) )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt19=1;
                }
                break;
            case 33:
                {
                alt19=2;
                }
                break;
            case 34:
                {
                alt19=3;
                }
                break;
            case 35:
                {
                alt19=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalRailSL.g:974:2: ( ( 'End.' ) )
                    {
                    // InternalRailSL.g:974:2: ( ( 'End.' ) )
                    // InternalRailSL.g:975:3: ( 'End.' )
                    {
                     before(grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_0()); 
                    // InternalRailSL.g:976:3: ( 'End.' )
                    // InternalRailSL.g:976:4: 'End.'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:980:2: ( ( 'end.' ) )
                    {
                    // InternalRailSL.g:980:2: ( ( 'end.' ) )
                    // InternalRailSL.g:981:3: ( 'end.' )
                    {
                     before(grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_1()); 
                    // InternalRailSL.g:982:3: ( 'end.' )
                    // InternalRailSL.g:982:4: 'end.'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:986:2: ( ( 'Loop.' ) )
                    {
                    // InternalRailSL.g:986:2: ( ( 'Loop.' ) )
                    // InternalRailSL.g:987:3: ( 'Loop.' )
                    {
                     before(grammarAccess.getBlockEndAccess().getLOOPEnumLiteralDeclaration_2()); 
                    // InternalRailSL.g:988:3: ( 'Loop.' )
                    // InternalRailSL.g:988:4: 'Loop.'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getBlockEndAccess().getLOOPEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:992:2: ( ( 'loop.' ) )
                    {
                    // InternalRailSL.g:992:2: ( ( 'loop.' ) )
                    // InternalRailSL.g:993:3: ( 'loop.' )
                    {
                     before(grammarAccess.getBlockEndAccess().getLOOPEnumLiteralDeclaration_3()); 
                    // InternalRailSL.g:994:3: ( 'loop.' )
                    // InternalRailSL.g:994:4: 'loop.'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getBlockEndAccess().getLOOPEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BlockEnd__Alternatives"


    // $ANTLR start "rule__TrackSpeedDrive__Alternatives"
    // InternalRailSL.g:1002:1: rule__TrackSpeedDrive__Alternatives : ( ( ( 'full' ) ) | ( ( 'slow' ) ) );
    public final void rule__TrackSpeedDrive__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1006:1: ( ( ( 'full' ) ) | ( ( 'slow' ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==36) ) {
                alt20=1;
            }
            else if ( (LA20_0==37) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalRailSL.g:1007:2: ( ( 'full' ) )
                    {
                    // InternalRailSL.g:1007:2: ( ( 'full' ) )
                    // InternalRailSL.g:1008:3: ( 'full' )
                    {
                     before(grammarAccess.getTrackSpeedDriveAccess().getFULLEnumLiteralDeclaration_0()); 
                    // InternalRailSL.g:1009:3: ( 'full' )
                    // InternalRailSL.g:1009:4: 'full'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getTrackSpeedDriveAccess().getFULLEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1013:2: ( ( 'slow' ) )
                    {
                    // InternalRailSL.g:1013:2: ( ( 'slow' ) )
                    // InternalRailSL.g:1014:3: ( 'slow' )
                    {
                     before(grammarAccess.getTrackSpeedDriveAccess().getSLOWEnumLiteralDeclaration_1()); 
                    // InternalRailSL.g:1015:3: ( 'slow' )
                    // InternalRailSL.g:1015:4: 'slow'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getTrackSpeedDriveAccess().getSLOWEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackSpeedDrive__Alternatives"


    // $ANTLR start "rule__PointOrinetation__Alternatives"
    // InternalRailSL.g:1023:1: rule__PointOrinetation__Alternatives : ( ( ( 'straight' ) ) | ( ( 'branch' ) ) );
    public final void rule__PointOrinetation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1027:1: ( ( ( 'straight' ) ) | ( ( 'branch' ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38) ) {
                alt21=1;
            }
            else if ( (LA21_0==39) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalRailSL.g:1028:2: ( ( 'straight' ) )
                    {
                    // InternalRailSL.g:1028:2: ( ( 'straight' ) )
                    // InternalRailSL.g:1029:3: ( 'straight' )
                    {
                     before(grammarAccess.getPointOrinetationAccess().getSTRAIGHTEnumLiteralDeclaration_0()); 
                    // InternalRailSL.g:1030:3: ( 'straight' )
                    // InternalRailSL.g:1030:4: 'straight'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getPointOrinetationAccess().getSTRAIGHTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1034:2: ( ( 'branch' ) )
                    {
                    // InternalRailSL.g:1034:2: ( ( 'branch' ) )
                    // InternalRailSL.g:1035:3: ( 'branch' )
                    {
                     before(grammarAccess.getPointOrinetationAccess().getBRANCHEnumLiteralDeclaration_1()); 
                    // InternalRailSL.g:1036:3: ( 'branch' )
                    // InternalRailSL.g:1036:4: 'branch'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getPointOrinetationAccess().getBRANCHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointOrinetation__Alternatives"


    // $ANTLR start "rule__ContactEvent__Alternatives"
    // InternalRailSL.g:1044:1: rule__ContactEvent__Alternatives : ( ( ( 'Reach' ) ) | ( ( 'reach' ) ) | ( ( 'Pass' ) ) | ( ( 'pass' ) ) );
    public final void rule__ContactEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1048:1: ( ( ( 'Reach' ) ) | ( ( 'reach' ) ) | ( ( 'Pass' ) ) | ( ( 'pass' ) ) )
            int alt22=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt22=1;
                }
                break;
            case 41:
                {
                alt22=2;
                }
                break;
            case 42:
                {
                alt22=3;
                }
                break;
            case 43:
                {
                alt22=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalRailSL.g:1049:2: ( ( 'Reach' ) )
                    {
                    // InternalRailSL.g:1049:2: ( ( 'Reach' ) )
                    // InternalRailSL.g:1050:3: ( 'Reach' )
                    {
                     before(grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_0()); 
                    // InternalRailSL.g:1051:3: ( 'Reach' )
                    // InternalRailSL.g:1051:4: 'Reach'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1055:2: ( ( 'reach' ) )
                    {
                    // InternalRailSL.g:1055:2: ( ( 'reach' ) )
                    // InternalRailSL.g:1056:3: ( 'reach' )
                    {
                     before(grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_1()); 
                    // InternalRailSL.g:1057:3: ( 'reach' )
                    // InternalRailSL.g:1057:4: 'reach'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1061:2: ( ( 'Pass' ) )
                    {
                    // InternalRailSL.g:1061:2: ( ( 'Pass' ) )
                    // InternalRailSL.g:1062:3: ( 'Pass' )
                    {
                     before(grammarAccess.getContactEventAccess().getPASSEnumLiteralDeclaration_2()); 
                    // InternalRailSL.g:1063:3: ( 'Pass' )
                    // InternalRailSL.g:1063:4: 'Pass'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getContactEventAccess().getPASSEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1067:2: ( ( 'pass' ) )
                    {
                    // InternalRailSL.g:1067:2: ( ( 'pass' ) )
                    // InternalRailSL.g:1068:3: ( 'pass' )
                    {
                     before(grammarAccess.getContactEventAccess().getPASSEnumLiteralDeclaration_3()); 
                    // InternalRailSL.g:1069:3: ( 'pass' )
                    // InternalRailSL.g:1069:4: 'pass'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getContactEventAccess().getPASSEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactEvent__Alternatives"


    // $ANTLR start "rule__ContactPosition__Alternatives"
    // InternalRailSL.g:1077:1: rule__ContactPosition__Alternatives : ( ( ( 'first' ) ) | ( ( 'second' ) ) );
    public final void rule__ContactPosition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1081:1: ( ( ( 'first' ) ) | ( ( 'second' ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==28) ) {
                alt23=1;
            }
            else if ( (LA23_0==44) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalRailSL.g:1082:2: ( ( 'first' ) )
                    {
                    // InternalRailSL.g:1082:2: ( ( 'first' ) )
                    // InternalRailSL.g:1083:3: ( 'first' )
                    {
                     before(grammarAccess.getContactPositionAccess().getFIRSTEnumLiteralDeclaration_0()); 
                    // InternalRailSL.g:1084:3: ( 'first' )
                    // InternalRailSL.g:1084:4: 'first'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getContactPositionAccess().getFIRSTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1088:2: ( ( 'second' ) )
                    {
                    // InternalRailSL.g:1088:2: ( ( 'second' ) )
                    // InternalRailSL.g:1089:3: ( 'second' )
                    {
                     before(grammarAccess.getContactPositionAccess().getSECONDEnumLiteralDeclaration_1()); 
                    // InternalRailSL.g:1090:3: ( 'second' )
                    // InternalRailSL.g:1090:4: 'second'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getContactPositionAccess().getSECONDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactPosition__Alternatives"


    // $ANTLR start "rule__CrossingMode__Alternatives"
    // InternalRailSL.g:1098:1: rule__CrossingMode__Alternatives : ( ( ( 'Open' ) ) | ( ( 'open' ) ) | ( ( 'Close' ) ) | ( ( 'close' ) ) );
    public final void rule__CrossingMode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1102:1: ( ( ( 'Open' ) ) | ( ( 'open' ) ) | ( ( 'Close' ) ) | ( ( 'close' ) ) )
            int alt24=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt24=1;
                }
                break;
            case 46:
                {
                alt24=2;
                }
                break;
            case 47:
                {
                alt24=3;
                }
                break;
            case 48:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalRailSL.g:1103:2: ( ( 'Open' ) )
                    {
                    // InternalRailSL.g:1103:2: ( ( 'Open' ) )
                    // InternalRailSL.g:1104:3: ( 'Open' )
                    {
                     before(grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_0()); 
                    // InternalRailSL.g:1105:3: ( 'Open' )
                    // InternalRailSL.g:1105:4: 'Open'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1109:2: ( ( 'open' ) )
                    {
                    // InternalRailSL.g:1109:2: ( ( 'open' ) )
                    // InternalRailSL.g:1110:3: ( 'open' )
                    {
                     before(grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_1()); 
                    // InternalRailSL.g:1111:3: ( 'open' )
                    // InternalRailSL.g:1111:4: 'open'
                    {
                    match(input,46,FOLLOW_2); 

                    }

                     after(grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1115:2: ( ( 'Close' ) )
                    {
                    // InternalRailSL.g:1115:2: ( ( 'Close' ) )
                    // InternalRailSL.g:1116:3: ( 'Close' )
                    {
                     before(grammarAccess.getCrossingModeAccess().getCLOSEEnumLiteralDeclaration_2()); 
                    // InternalRailSL.g:1117:3: ( 'Close' )
                    // InternalRailSL.g:1117:4: 'Close'
                    {
                    match(input,47,FOLLOW_2); 

                    }

                     after(grammarAccess.getCrossingModeAccess().getCLOSEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1121:2: ( ( 'close' ) )
                    {
                    // InternalRailSL.g:1121:2: ( ( 'close' ) )
                    // InternalRailSL.g:1122:3: ( 'close' )
                    {
                     before(grammarAccess.getCrossingModeAccess().getCLOSEEnumLiteralDeclaration_3()); 
                    // InternalRailSL.g:1123:3: ( 'close' )
                    // InternalRailSL.g:1123:4: 'close'
                    {
                    match(input,48,FOLLOW_2); 

                    }

                     after(grammarAccess.getCrossingModeAccess().getCLOSEEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossingMode__Alternatives"


    // $ANTLR start "rule__RailSegment__Alternatives"
    // InternalRailSL.g:1131:1: rule__RailSegment__Alternatives : ( ( ( 'KH_ST_0' ) ) | ( ( 'KH_ST_1' ) ) | ( ( 'KH_ST_2' ) ) | ( ( 'KH_ST_3' ) ) | ( ( 'KH_ST_4' ) ) | ( ( 'KH_ST_5' ) ) | ( ( 'KH_ST_6' ) ) | ( ( 'KH_LN_0' ) ) | ( ( 'KH_LN_1' ) ) | ( ( 'KH_LN_2' ) ) | ( ( 'KH_LN_3' ) ) | ( ( 'KH_LN_4' ) ) | ( ( 'KH_LN_5' ) ) | ( ( 'KH_LN_6' ) ) | ( ( 'KH_LN_7' ) ) | ( ( 'KH_LN_8' ) ) | ( ( 'KIO_LN_0' ) ) | ( ( 'KIO_LN_1' ) ) | ( ( 'OC_ST_0' ) ) | ( ( 'OC_ST_1' ) ) | ( ( 'OC_ST_2' ) ) | ( ( 'OC_ST_3' ) ) | ( ( 'OC_ST_4' ) ) | ( ( 'OC_LN_0' ) ) | ( ( 'OC_LN_1' ) ) | ( ( 'OC_LN_2' ) ) | ( ( 'OC_LN_3' ) ) | ( ( 'OC_LN_4' ) ) | ( ( 'OC_LN_5' ) ) | ( ( 'IC_ST_0' ) ) | ( ( 'IC_ST_1' ) ) | ( ( 'IC_ST_2' ) ) | ( ( 'IC_ST_3' ) ) | ( ( 'IC_ST_4' ) ) | ( ( 'IC_LN_0' ) ) | ( ( 'IC_LN_1' ) ) | ( ( 'IC_LN_2' ) ) | ( ( 'IC_LN_3' ) ) | ( ( 'IC_LN_4' ) ) | ( ( 'IC_LN_5' ) ) | ( ( 'OC_JCT_0' ) ) | ( ( 'IC_JCT_0' ) ) | ( ( 'OI_LN_0' ) ) | ( ( 'OI_LN_1' ) ) | ( ( 'OI_LN_2' ) ) | ( ( 'IO_LN_0' ) ) | ( ( 'IO_LN_1' ) ) | ( ( 'IO_LN_2' ) ) );
    public final void rule__RailSegment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1135:1: ( ( ( 'KH_ST_0' ) ) | ( ( 'KH_ST_1' ) ) | ( ( 'KH_ST_2' ) ) | ( ( 'KH_ST_3' ) ) | ( ( 'KH_ST_4' ) ) | ( ( 'KH_ST_5' ) ) | ( ( 'KH_ST_6' ) ) | ( ( 'KH_LN_0' ) ) | ( ( 'KH_LN_1' ) ) | ( ( 'KH_LN_2' ) ) | ( ( 'KH_LN_3' ) ) | ( ( 'KH_LN_4' ) ) | ( ( 'KH_LN_5' ) ) | ( ( 'KH_LN_6' ) ) | ( ( 'KH_LN_7' ) ) | ( ( 'KH_LN_8' ) ) | ( ( 'KIO_LN_0' ) ) | ( ( 'KIO_LN_1' ) ) | ( ( 'OC_ST_0' ) ) | ( ( 'OC_ST_1' ) ) | ( ( 'OC_ST_2' ) ) | ( ( 'OC_ST_3' ) ) | ( ( 'OC_ST_4' ) ) | ( ( 'OC_LN_0' ) ) | ( ( 'OC_LN_1' ) ) | ( ( 'OC_LN_2' ) ) | ( ( 'OC_LN_3' ) ) | ( ( 'OC_LN_4' ) ) | ( ( 'OC_LN_5' ) ) | ( ( 'IC_ST_0' ) ) | ( ( 'IC_ST_1' ) ) | ( ( 'IC_ST_2' ) ) | ( ( 'IC_ST_3' ) ) | ( ( 'IC_ST_4' ) ) | ( ( 'IC_LN_0' ) ) | ( ( 'IC_LN_1' ) ) | ( ( 'IC_LN_2' ) ) | ( ( 'IC_LN_3' ) ) | ( ( 'IC_LN_4' ) ) | ( ( 'IC_LN_5' ) ) | ( ( 'OC_JCT_0' ) ) | ( ( 'IC_JCT_0' ) ) | ( ( 'OI_LN_0' ) ) | ( ( 'OI_LN_1' ) ) | ( ( 'OI_LN_2' ) ) | ( ( 'IO_LN_0' ) ) | ( ( 'IO_LN_1' ) ) | ( ( 'IO_LN_2' ) ) )
            int alt25=48;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt25=1;
                }
                break;
            case 50:
                {
                alt25=2;
                }
                break;
            case 51:
                {
                alt25=3;
                }
                break;
            case 52:
                {
                alt25=4;
                }
                break;
            case 53:
                {
                alt25=5;
                }
                break;
            case 54:
                {
                alt25=6;
                }
                break;
            case 55:
                {
                alt25=7;
                }
                break;
            case 56:
                {
                alt25=8;
                }
                break;
            case 57:
                {
                alt25=9;
                }
                break;
            case 58:
                {
                alt25=10;
                }
                break;
            case 59:
                {
                alt25=11;
                }
                break;
            case 60:
                {
                alt25=12;
                }
                break;
            case 61:
                {
                alt25=13;
                }
                break;
            case 62:
                {
                alt25=14;
                }
                break;
            case 63:
                {
                alt25=15;
                }
                break;
            case 64:
                {
                alt25=16;
                }
                break;
            case 65:
                {
                alt25=17;
                }
                break;
            case 66:
                {
                alt25=18;
                }
                break;
            case 67:
                {
                alt25=19;
                }
                break;
            case 68:
                {
                alt25=20;
                }
                break;
            case 69:
                {
                alt25=21;
                }
                break;
            case 70:
                {
                alt25=22;
                }
                break;
            case 71:
                {
                alt25=23;
                }
                break;
            case 72:
                {
                alt25=24;
                }
                break;
            case 73:
                {
                alt25=25;
                }
                break;
            case 74:
                {
                alt25=26;
                }
                break;
            case 75:
                {
                alt25=27;
                }
                break;
            case 76:
                {
                alt25=28;
                }
                break;
            case 77:
                {
                alt25=29;
                }
                break;
            case 78:
                {
                alt25=30;
                }
                break;
            case 79:
                {
                alt25=31;
                }
                break;
            case 80:
                {
                alt25=32;
                }
                break;
            case 81:
                {
                alt25=33;
                }
                break;
            case 82:
                {
                alt25=34;
                }
                break;
            case 83:
                {
                alt25=35;
                }
                break;
            case 84:
                {
                alt25=36;
                }
                break;
            case 85:
                {
                alt25=37;
                }
                break;
            case 86:
                {
                alt25=38;
                }
                break;
            case 87:
                {
                alt25=39;
                }
                break;
            case 88:
                {
                alt25=40;
                }
                break;
            case 89:
                {
                alt25=41;
                }
                break;
            case 90:
                {
                alt25=42;
                }
                break;
            case 91:
                {
                alt25=43;
                }
                break;
            case 92:
                {
                alt25=44;
                }
                break;
            case 93:
                {
                alt25=45;
                }
                break;
            case 94:
                {
                alt25=46;
                }
                break;
            case 95:
                {
                alt25=47;
                }
                break;
            case 96:
                {
                alt25=48;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalRailSL.g:1136:2: ( ( 'KH_ST_0' ) )
                    {
                    // InternalRailSL.g:1136:2: ( ( 'KH_ST_0' ) )
                    // InternalRailSL.g:1137:3: ( 'KH_ST_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_ST_0EnumLiteralDeclaration_0()); 
                    // InternalRailSL.g:1138:3: ( 'KH_ST_0' )
                    // InternalRailSL.g:1138:4: 'KH_ST_0'
                    {
                    match(input,49,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_ST_0EnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1142:2: ( ( 'KH_ST_1' ) )
                    {
                    // InternalRailSL.g:1142:2: ( ( 'KH_ST_1' ) )
                    // InternalRailSL.g:1143:3: ( 'KH_ST_1' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_ST_1EnumLiteralDeclaration_1()); 
                    // InternalRailSL.g:1144:3: ( 'KH_ST_1' )
                    // InternalRailSL.g:1144:4: 'KH_ST_1'
                    {
                    match(input,50,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_ST_1EnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1148:2: ( ( 'KH_ST_2' ) )
                    {
                    // InternalRailSL.g:1148:2: ( ( 'KH_ST_2' ) )
                    // InternalRailSL.g:1149:3: ( 'KH_ST_2' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_ST_2EnumLiteralDeclaration_2()); 
                    // InternalRailSL.g:1150:3: ( 'KH_ST_2' )
                    // InternalRailSL.g:1150:4: 'KH_ST_2'
                    {
                    match(input,51,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_ST_2EnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1154:2: ( ( 'KH_ST_3' ) )
                    {
                    // InternalRailSL.g:1154:2: ( ( 'KH_ST_3' ) )
                    // InternalRailSL.g:1155:3: ( 'KH_ST_3' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_ST_3EnumLiteralDeclaration_3()); 
                    // InternalRailSL.g:1156:3: ( 'KH_ST_3' )
                    // InternalRailSL.g:1156:4: 'KH_ST_3'
                    {
                    match(input,52,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_ST_3EnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalRailSL.g:1160:2: ( ( 'KH_ST_4' ) )
                    {
                    // InternalRailSL.g:1160:2: ( ( 'KH_ST_4' ) )
                    // InternalRailSL.g:1161:3: ( 'KH_ST_4' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_ST_4EnumLiteralDeclaration_4()); 
                    // InternalRailSL.g:1162:3: ( 'KH_ST_4' )
                    // InternalRailSL.g:1162:4: 'KH_ST_4'
                    {
                    match(input,53,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_ST_4EnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalRailSL.g:1166:2: ( ( 'KH_ST_5' ) )
                    {
                    // InternalRailSL.g:1166:2: ( ( 'KH_ST_5' ) )
                    // InternalRailSL.g:1167:3: ( 'KH_ST_5' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_ST_5EnumLiteralDeclaration_5()); 
                    // InternalRailSL.g:1168:3: ( 'KH_ST_5' )
                    // InternalRailSL.g:1168:4: 'KH_ST_5'
                    {
                    match(input,54,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_ST_5EnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalRailSL.g:1172:2: ( ( 'KH_ST_6' ) )
                    {
                    // InternalRailSL.g:1172:2: ( ( 'KH_ST_6' ) )
                    // InternalRailSL.g:1173:3: ( 'KH_ST_6' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_ST_6EnumLiteralDeclaration_6()); 
                    // InternalRailSL.g:1174:3: ( 'KH_ST_6' )
                    // InternalRailSL.g:1174:4: 'KH_ST_6'
                    {
                    match(input,55,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_ST_6EnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalRailSL.g:1178:2: ( ( 'KH_LN_0' ) )
                    {
                    // InternalRailSL.g:1178:2: ( ( 'KH_LN_0' ) )
                    // InternalRailSL.g:1179:3: ( 'KH_LN_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_LN_0EnumLiteralDeclaration_7()); 
                    // InternalRailSL.g:1180:3: ( 'KH_LN_0' )
                    // InternalRailSL.g:1180:4: 'KH_LN_0'
                    {
                    match(input,56,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_LN_0EnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalRailSL.g:1184:2: ( ( 'KH_LN_1' ) )
                    {
                    // InternalRailSL.g:1184:2: ( ( 'KH_LN_1' ) )
                    // InternalRailSL.g:1185:3: ( 'KH_LN_1' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_LN_1EnumLiteralDeclaration_8()); 
                    // InternalRailSL.g:1186:3: ( 'KH_LN_1' )
                    // InternalRailSL.g:1186:4: 'KH_LN_1'
                    {
                    match(input,57,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_LN_1EnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalRailSL.g:1190:2: ( ( 'KH_LN_2' ) )
                    {
                    // InternalRailSL.g:1190:2: ( ( 'KH_LN_2' ) )
                    // InternalRailSL.g:1191:3: ( 'KH_LN_2' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_LN_2EnumLiteralDeclaration_9()); 
                    // InternalRailSL.g:1192:3: ( 'KH_LN_2' )
                    // InternalRailSL.g:1192:4: 'KH_LN_2'
                    {
                    match(input,58,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_LN_2EnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalRailSL.g:1196:2: ( ( 'KH_LN_3' ) )
                    {
                    // InternalRailSL.g:1196:2: ( ( 'KH_LN_3' ) )
                    // InternalRailSL.g:1197:3: ( 'KH_LN_3' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_LN_3EnumLiteralDeclaration_10()); 
                    // InternalRailSL.g:1198:3: ( 'KH_LN_3' )
                    // InternalRailSL.g:1198:4: 'KH_LN_3'
                    {
                    match(input,59,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_LN_3EnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalRailSL.g:1202:2: ( ( 'KH_LN_4' ) )
                    {
                    // InternalRailSL.g:1202:2: ( ( 'KH_LN_4' ) )
                    // InternalRailSL.g:1203:3: ( 'KH_LN_4' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_LN_4EnumLiteralDeclaration_11()); 
                    // InternalRailSL.g:1204:3: ( 'KH_LN_4' )
                    // InternalRailSL.g:1204:4: 'KH_LN_4'
                    {
                    match(input,60,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_LN_4EnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalRailSL.g:1208:2: ( ( 'KH_LN_5' ) )
                    {
                    // InternalRailSL.g:1208:2: ( ( 'KH_LN_5' ) )
                    // InternalRailSL.g:1209:3: ( 'KH_LN_5' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_LN_5EnumLiteralDeclaration_12()); 
                    // InternalRailSL.g:1210:3: ( 'KH_LN_5' )
                    // InternalRailSL.g:1210:4: 'KH_LN_5'
                    {
                    match(input,61,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_LN_5EnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalRailSL.g:1214:2: ( ( 'KH_LN_6' ) )
                    {
                    // InternalRailSL.g:1214:2: ( ( 'KH_LN_6' ) )
                    // InternalRailSL.g:1215:3: ( 'KH_LN_6' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_LN_6EnumLiteralDeclaration_13()); 
                    // InternalRailSL.g:1216:3: ( 'KH_LN_6' )
                    // InternalRailSL.g:1216:4: 'KH_LN_6'
                    {
                    match(input,62,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_LN_6EnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalRailSL.g:1220:2: ( ( 'KH_LN_7' ) )
                    {
                    // InternalRailSL.g:1220:2: ( ( 'KH_LN_7' ) )
                    // InternalRailSL.g:1221:3: ( 'KH_LN_7' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_LN_7EnumLiteralDeclaration_14()); 
                    // InternalRailSL.g:1222:3: ( 'KH_LN_7' )
                    // InternalRailSL.g:1222:4: 'KH_LN_7'
                    {
                    match(input,63,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_LN_7EnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalRailSL.g:1226:2: ( ( 'KH_LN_8' ) )
                    {
                    // InternalRailSL.g:1226:2: ( ( 'KH_LN_8' ) )
                    // InternalRailSL.g:1227:3: ( 'KH_LN_8' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKH_LN_8EnumLiteralDeclaration_15()); 
                    // InternalRailSL.g:1228:3: ( 'KH_LN_8' )
                    // InternalRailSL.g:1228:4: 'KH_LN_8'
                    {
                    match(input,64,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKH_LN_8EnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalRailSL.g:1232:2: ( ( 'KIO_LN_0' ) )
                    {
                    // InternalRailSL.g:1232:2: ( ( 'KIO_LN_0' ) )
                    // InternalRailSL.g:1233:3: ( 'KIO_LN_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKIO_LN_0EnumLiteralDeclaration_16()); 
                    // InternalRailSL.g:1234:3: ( 'KIO_LN_0' )
                    // InternalRailSL.g:1234:4: 'KIO_LN_0'
                    {
                    match(input,65,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKIO_LN_0EnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalRailSL.g:1238:2: ( ( 'KIO_LN_1' ) )
                    {
                    // InternalRailSL.g:1238:2: ( ( 'KIO_LN_1' ) )
                    // InternalRailSL.g:1239:3: ( 'KIO_LN_1' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getKIO_LN_1EnumLiteralDeclaration_17()); 
                    // InternalRailSL.g:1240:3: ( 'KIO_LN_1' )
                    // InternalRailSL.g:1240:4: 'KIO_LN_1'
                    {
                    match(input,66,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getKIO_LN_1EnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalRailSL.g:1244:2: ( ( 'OC_ST_0' ) )
                    {
                    // InternalRailSL.g:1244:2: ( ( 'OC_ST_0' ) )
                    // InternalRailSL.g:1245:3: ( 'OC_ST_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_ST_0EnumLiteralDeclaration_18()); 
                    // InternalRailSL.g:1246:3: ( 'OC_ST_0' )
                    // InternalRailSL.g:1246:4: 'OC_ST_0'
                    {
                    match(input,67,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_ST_0EnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalRailSL.g:1250:2: ( ( 'OC_ST_1' ) )
                    {
                    // InternalRailSL.g:1250:2: ( ( 'OC_ST_1' ) )
                    // InternalRailSL.g:1251:3: ( 'OC_ST_1' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_ST_1EnumLiteralDeclaration_19()); 
                    // InternalRailSL.g:1252:3: ( 'OC_ST_1' )
                    // InternalRailSL.g:1252:4: 'OC_ST_1'
                    {
                    match(input,68,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_ST_1EnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalRailSL.g:1256:2: ( ( 'OC_ST_2' ) )
                    {
                    // InternalRailSL.g:1256:2: ( ( 'OC_ST_2' ) )
                    // InternalRailSL.g:1257:3: ( 'OC_ST_2' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_ST_2EnumLiteralDeclaration_20()); 
                    // InternalRailSL.g:1258:3: ( 'OC_ST_2' )
                    // InternalRailSL.g:1258:4: 'OC_ST_2'
                    {
                    match(input,69,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_ST_2EnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalRailSL.g:1262:2: ( ( 'OC_ST_3' ) )
                    {
                    // InternalRailSL.g:1262:2: ( ( 'OC_ST_3' ) )
                    // InternalRailSL.g:1263:3: ( 'OC_ST_3' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_ST_3EnumLiteralDeclaration_21()); 
                    // InternalRailSL.g:1264:3: ( 'OC_ST_3' )
                    // InternalRailSL.g:1264:4: 'OC_ST_3'
                    {
                    match(input,70,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_ST_3EnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalRailSL.g:1268:2: ( ( 'OC_ST_4' ) )
                    {
                    // InternalRailSL.g:1268:2: ( ( 'OC_ST_4' ) )
                    // InternalRailSL.g:1269:3: ( 'OC_ST_4' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_ST_4EnumLiteralDeclaration_22()); 
                    // InternalRailSL.g:1270:3: ( 'OC_ST_4' )
                    // InternalRailSL.g:1270:4: 'OC_ST_4'
                    {
                    match(input,71,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_ST_4EnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalRailSL.g:1274:2: ( ( 'OC_LN_0' ) )
                    {
                    // InternalRailSL.g:1274:2: ( ( 'OC_LN_0' ) )
                    // InternalRailSL.g:1275:3: ( 'OC_LN_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_LN_0EnumLiteralDeclaration_23()); 
                    // InternalRailSL.g:1276:3: ( 'OC_LN_0' )
                    // InternalRailSL.g:1276:4: 'OC_LN_0'
                    {
                    match(input,72,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_LN_0EnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalRailSL.g:1280:2: ( ( 'OC_LN_1' ) )
                    {
                    // InternalRailSL.g:1280:2: ( ( 'OC_LN_1' ) )
                    // InternalRailSL.g:1281:3: ( 'OC_LN_1' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_LN_1EnumLiteralDeclaration_24()); 
                    // InternalRailSL.g:1282:3: ( 'OC_LN_1' )
                    // InternalRailSL.g:1282:4: 'OC_LN_1'
                    {
                    match(input,73,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_LN_1EnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalRailSL.g:1286:2: ( ( 'OC_LN_2' ) )
                    {
                    // InternalRailSL.g:1286:2: ( ( 'OC_LN_2' ) )
                    // InternalRailSL.g:1287:3: ( 'OC_LN_2' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_LN_2EnumLiteralDeclaration_25()); 
                    // InternalRailSL.g:1288:3: ( 'OC_LN_2' )
                    // InternalRailSL.g:1288:4: 'OC_LN_2'
                    {
                    match(input,74,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_LN_2EnumLiteralDeclaration_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalRailSL.g:1292:2: ( ( 'OC_LN_3' ) )
                    {
                    // InternalRailSL.g:1292:2: ( ( 'OC_LN_3' ) )
                    // InternalRailSL.g:1293:3: ( 'OC_LN_3' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_LN_3EnumLiteralDeclaration_26()); 
                    // InternalRailSL.g:1294:3: ( 'OC_LN_3' )
                    // InternalRailSL.g:1294:4: 'OC_LN_3'
                    {
                    match(input,75,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_LN_3EnumLiteralDeclaration_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalRailSL.g:1298:2: ( ( 'OC_LN_4' ) )
                    {
                    // InternalRailSL.g:1298:2: ( ( 'OC_LN_4' ) )
                    // InternalRailSL.g:1299:3: ( 'OC_LN_4' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_LN_4EnumLiteralDeclaration_27()); 
                    // InternalRailSL.g:1300:3: ( 'OC_LN_4' )
                    // InternalRailSL.g:1300:4: 'OC_LN_4'
                    {
                    match(input,76,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_LN_4EnumLiteralDeclaration_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalRailSL.g:1304:2: ( ( 'OC_LN_5' ) )
                    {
                    // InternalRailSL.g:1304:2: ( ( 'OC_LN_5' ) )
                    // InternalRailSL.g:1305:3: ( 'OC_LN_5' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_LN_5EnumLiteralDeclaration_28()); 
                    // InternalRailSL.g:1306:3: ( 'OC_LN_5' )
                    // InternalRailSL.g:1306:4: 'OC_LN_5'
                    {
                    match(input,77,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_LN_5EnumLiteralDeclaration_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalRailSL.g:1310:2: ( ( 'IC_ST_0' ) )
                    {
                    // InternalRailSL.g:1310:2: ( ( 'IC_ST_0' ) )
                    // InternalRailSL.g:1311:3: ( 'IC_ST_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_ST_0EnumLiteralDeclaration_29()); 
                    // InternalRailSL.g:1312:3: ( 'IC_ST_0' )
                    // InternalRailSL.g:1312:4: 'IC_ST_0'
                    {
                    match(input,78,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_ST_0EnumLiteralDeclaration_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalRailSL.g:1316:2: ( ( 'IC_ST_1' ) )
                    {
                    // InternalRailSL.g:1316:2: ( ( 'IC_ST_1' ) )
                    // InternalRailSL.g:1317:3: ( 'IC_ST_1' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_ST_1EnumLiteralDeclaration_30()); 
                    // InternalRailSL.g:1318:3: ( 'IC_ST_1' )
                    // InternalRailSL.g:1318:4: 'IC_ST_1'
                    {
                    match(input,79,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_ST_1EnumLiteralDeclaration_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalRailSL.g:1322:2: ( ( 'IC_ST_2' ) )
                    {
                    // InternalRailSL.g:1322:2: ( ( 'IC_ST_2' ) )
                    // InternalRailSL.g:1323:3: ( 'IC_ST_2' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_ST_2EnumLiteralDeclaration_31()); 
                    // InternalRailSL.g:1324:3: ( 'IC_ST_2' )
                    // InternalRailSL.g:1324:4: 'IC_ST_2'
                    {
                    match(input,80,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_ST_2EnumLiteralDeclaration_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalRailSL.g:1328:2: ( ( 'IC_ST_3' ) )
                    {
                    // InternalRailSL.g:1328:2: ( ( 'IC_ST_3' ) )
                    // InternalRailSL.g:1329:3: ( 'IC_ST_3' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_ST_3EnumLiteralDeclaration_32()); 
                    // InternalRailSL.g:1330:3: ( 'IC_ST_3' )
                    // InternalRailSL.g:1330:4: 'IC_ST_3'
                    {
                    match(input,81,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_ST_3EnumLiteralDeclaration_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalRailSL.g:1334:2: ( ( 'IC_ST_4' ) )
                    {
                    // InternalRailSL.g:1334:2: ( ( 'IC_ST_4' ) )
                    // InternalRailSL.g:1335:3: ( 'IC_ST_4' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_ST_4EnumLiteralDeclaration_33()); 
                    // InternalRailSL.g:1336:3: ( 'IC_ST_4' )
                    // InternalRailSL.g:1336:4: 'IC_ST_4'
                    {
                    match(input,82,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_ST_4EnumLiteralDeclaration_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalRailSL.g:1340:2: ( ( 'IC_LN_0' ) )
                    {
                    // InternalRailSL.g:1340:2: ( ( 'IC_LN_0' ) )
                    // InternalRailSL.g:1341:3: ( 'IC_LN_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_LN_0EnumLiteralDeclaration_34()); 
                    // InternalRailSL.g:1342:3: ( 'IC_LN_0' )
                    // InternalRailSL.g:1342:4: 'IC_LN_0'
                    {
                    match(input,83,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_LN_0EnumLiteralDeclaration_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalRailSL.g:1346:2: ( ( 'IC_LN_1' ) )
                    {
                    // InternalRailSL.g:1346:2: ( ( 'IC_LN_1' ) )
                    // InternalRailSL.g:1347:3: ( 'IC_LN_1' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_LN_1EnumLiteralDeclaration_35()); 
                    // InternalRailSL.g:1348:3: ( 'IC_LN_1' )
                    // InternalRailSL.g:1348:4: 'IC_LN_1'
                    {
                    match(input,84,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_LN_1EnumLiteralDeclaration_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalRailSL.g:1352:2: ( ( 'IC_LN_2' ) )
                    {
                    // InternalRailSL.g:1352:2: ( ( 'IC_LN_2' ) )
                    // InternalRailSL.g:1353:3: ( 'IC_LN_2' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_LN_2EnumLiteralDeclaration_36()); 
                    // InternalRailSL.g:1354:3: ( 'IC_LN_2' )
                    // InternalRailSL.g:1354:4: 'IC_LN_2'
                    {
                    match(input,85,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_LN_2EnumLiteralDeclaration_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalRailSL.g:1358:2: ( ( 'IC_LN_3' ) )
                    {
                    // InternalRailSL.g:1358:2: ( ( 'IC_LN_3' ) )
                    // InternalRailSL.g:1359:3: ( 'IC_LN_3' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_LN_3EnumLiteralDeclaration_37()); 
                    // InternalRailSL.g:1360:3: ( 'IC_LN_3' )
                    // InternalRailSL.g:1360:4: 'IC_LN_3'
                    {
                    match(input,86,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_LN_3EnumLiteralDeclaration_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalRailSL.g:1364:2: ( ( 'IC_LN_4' ) )
                    {
                    // InternalRailSL.g:1364:2: ( ( 'IC_LN_4' ) )
                    // InternalRailSL.g:1365:3: ( 'IC_LN_4' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_LN_4EnumLiteralDeclaration_38()); 
                    // InternalRailSL.g:1366:3: ( 'IC_LN_4' )
                    // InternalRailSL.g:1366:4: 'IC_LN_4'
                    {
                    match(input,87,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_LN_4EnumLiteralDeclaration_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalRailSL.g:1370:2: ( ( 'IC_LN_5' ) )
                    {
                    // InternalRailSL.g:1370:2: ( ( 'IC_LN_5' ) )
                    // InternalRailSL.g:1371:3: ( 'IC_LN_5' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_LN_5EnumLiteralDeclaration_39()); 
                    // InternalRailSL.g:1372:3: ( 'IC_LN_5' )
                    // InternalRailSL.g:1372:4: 'IC_LN_5'
                    {
                    match(input,88,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_LN_5EnumLiteralDeclaration_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalRailSL.g:1376:2: ( ( 'OC_JCT_0' ) )
                    {
                    // InternalRailSL.g:1376:2: ( ( 'OC_JCT_0' ) )
                    // InternalRailSL.g:1377:3: ( 'OC_JCT_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOC_JCT_0EnumLiteralDeclaration_40()); 
                    // InternalRailSL.g:1378:3: ( 'OC_JCT_0' )
                    // InternalRailSL.g:1378:4: 'OC_JCT_0'
                    {
                    match(input,89,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOC_JCT_0EnumLiteralDeclaration_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalRailSL.g:1382:2: ( ( 'IC_JCT_0' ) )
                    {
                    // InternalRailSL.g:1382:2: ( ( 'IC_JCT_0' ) )
                    // InternalRailSL.g:1383:3: ( 'IC_JCT_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIC_JCT_0EnumLiteralDeclaration_41()); 
                    // InternalRailSL.g:1384:3: ( 'IC_JCT_0' )
                    // InternalRailSL.g:1384:4: 'IC_JCT_0'
                    {
                    match(input,90,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIC_JCT_0EnumLiteralDeclaration_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalRailSL.g:1388:2: ( ( 'OI_LN_0' ) )
                    {
                    // InternalRailSL.g:1388:2: ( ( 'OI_LN_0' ) )
                    // InternalRailSL.g:1389:3: ( 'OI_LN_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOI_LN_0EnumLiteralDeclaration_42()); 
                    // InternalRailSL.g:1390:3: ( 'OI_LN_0' )
                    // InternalRailSL.g:1390:4: 'OI_LN_0'
                    {
                    match(input,91,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOI_LN_0EnumLiteralDeclaration_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalRailSL.g:1394:2: ( ( 'OI_LN_1' ) )
                    {
                    // InternalRailSL.g:1394:2: ( ( 'OI_LN_1' ) )
                    // InternalRailSL.g:1395:3: ( 'OI_LN_1' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOI_LN_1EnumLiteralDeclaration_43()); 
                    // InternalRailSL.g:1396:3: ( 'OI_LN_1' )
                    // InternalRailSL.g:1396:4: 'OI_LN_1'
                    {
                    match(input,92,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOI_LN_1EnumLiteralDeclaration_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalRailSL.g:1400:2: ( ( 'OI_LN_2' ) )
                    {
                    // InternalRailSL.g:1400:2: ( ( 'OI_LN_2' ) )
                    // InternalRailSL.g:1401:3: ( 'OI_LN_2' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getOI_LN_2EnumLiteralDeclaration_44()); 
                    // InternalRailSL.g:1402:3: ( 'OI_LN_2' )
                    // InternalRailSL.g:1402:4: 'OI_LN_2'
                    {
                    match(input,93,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getOI_LN_2EnumLiteralDeclaration_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalRailSL.g:1406:2: ( ( 'IO_LN_0' ) )
                    {
                    // InternalRailSL.g:1406:2: ( ( 'IO_LN_0' ) )
                    // InternalRailSL.g:1407:3: ( 'IO_LN_0' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIO_LN_0EnumLiteralDeclaration_45()); 
                    // InternalRailSL.g:1408:3: ( 'IO_LN_0' )
                    // InternalRailSL.g:1408:4: 'IO_LN_0'
                    {
                    match(input,94,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIO_LN_0EnumLiteralDeclaration_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalRailSL.g:1412:2: ( ( 'IO_LN_1' ) )
                    {
                    // InternalRailSL.g:1412:2: ( ( 'IO_LN_1' ) )
                    // InternalRailSL.g:1413:3: ( 'IO_LN_1' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIO_LN_1EnumLiteralDeclaration_46()); 
                    // InternalRailSL.g:1414:3: ( 'IO_LN_1' )
                    // InternalRailSL.g:1414:4: 'IO_LN_1'
                    {
                    match(input,95,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIO_LN_1EnumLiteralDeclaration_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalRailSL.g:1418:2: ( ( 'IO_LN_2' ) )
                    {
                    // InternalRailSL.g:1418:2: ( ( 'IO_LN_2' ) )
                    // InternalRailSL.g:1419:3: ( 'IO_LN_2' )
                    {
                     before(grammarAccess.getRailSegmentAccess().getIO_LN_2EnumLiteralDeclaration_47()); 
                    // InternalRailSL.g:1420:3: ( 'IO_LN_2' )
                    // InternalRailSL.g:1420:4: 'IO_LN_2'
                    {
                    match(input,96,FOLLOW_2); 

                    }

                     after(grammarAccess.getRailSegmentAccess().getIO_LN_2EnumLiteralDeclaration_47()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RailSegment__Alternatives"


    // $ANTLR start "rule__Block__Group__0"
    // InternalRailSL.g:1428:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1432:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // InternalRailSL.g:1433:2: rule__Block__Group__0__Impl rule__Block__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Block__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Block__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__0"


    // $ANTLR start "rule__Block__Group__0__Impl"
    // InternalRailSL.g:1440:1: rule__Block__Group__0__Impl : ( ( rule__Block__Alternatives_0 ) ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1444:1: ( ( ( rule__Block__Alternatives_0 ) ) )
            // InternalRailSL.g:1445:1: ( ( rule__Block__Alternatives_0 ) )
            {
            // InternalRailSL.g:1445:1: ( ( rule__Block__Alternatives_0 ) )
            // InternalRailSL.g:1446:2: ( rule__Block__Alternatives_0 )
            {
             before(grammarAccess.getBlockAccess().getAlternatives_0()); 
            // InternalRailSL.g:1447:2: ( rule__Block__Alternatives_0 )
            // InternalRailSL.g:1447:3: rule__Block__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Block__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getBlockAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__0__Impl"


    // $ANTLR start "rule__Block__Group__1"
    // InternalRailSL.g:1455:1: rule__Block__Group__1 : rule__Block__Group__1__Impl rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1459:1: ( rule__Block__Group__1__Impl rule__Block__Group__2 )
            // InternalRailSL.g:1460:2: rule__Block__Group__1__Impl rule__Block__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Block__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Block__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__1"


    // $ANTLR start "rule__Block__Group__1__Impl"
    // InternalRailSL.g:1467:1: rule__Block__Group__1__Impl : ( ( ( rule__Block__StatementsAssignment_1 ) ) ( ( rule__Block__StatementsAssignment_1 )* ) ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1471:1: ( ( ( ( rule__Block__StatementsAssignment_1 ) ) ( ( rule__Block__StatementsAssignment_1 )* ) ) )
            // InternalRailSL.g:1472:1: ( ( ( rule__Block__StatementsAssignment_1 ) ) ( ( rule__Block__StatementsAssignment_1 )* ) )
            {
            // InternalRailSL.g:1472:1: ( ( ( rule__Block__StatementsAssignment_1 ) ) ( ( rule__Block__StatementsAssignment_1 )* ) )
            // InternalRailSL.g:1473:2: ( ( rule__Block__StatementsAssignment_1 ) ) ( ( rule__Block__StatementsAssignment_1 )* )
            {
            // InternalRailSL.g:1473:2: ( ( rule__Block__StatementsAssignment_1 ) )
            // InternalRailSL.g:1474:3: ( rule__Block__StatementsAssignment_1 )
            {
             before(grammarAccess.getBlockAccess().getStatementsAssignment_1()); 
            // InternalRailSL.g:1475:3: ( rule__Block__StatementsAssignment_1 )
            // InternalRailSL.g:1475:4: rule__Block__StatementsAssignment_1
            {
            pushFollow(FOLLOW_5);
            rule__Block__StatementsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBlockAccess().getStatementsAssignment_1()); 

            }

            // InternalRailSL.g:1478:2: ( ( rule__Block__StatementsAssignment_1 )* )
            // InternalRailSL.g:1479:3: ( rule__Block__StatementsAssignment_1 )*
            {
             before(grammarAccess.getBlockAccess().getStatementsAssignment_1()); 
            // InternalRailSL.g:1480:3: ( rule__Block__StatementsAssignment_1 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=14 && LA26_0<=15)||(LA26_0>=18 && LA26_0<=21)||(LA26_0>=24 && LA26_0<=25)||(LA26_0>=30 && LA26_0<=31)||(LA26_0>=40 && LA26_0<=43)||(LA26_0>=45 && LA26_0<=48)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalRailSL.g:1480:4: rule__Block__StatementsAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Block__StatementsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getBlockAccess().getStatementsAssignment_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__1__Impl"


    // $ANTLR start "rule__Block__Group__2"
    // InternalRailSL.g:1489:1: rule__Block__Group__2 : rule__Block__Group__2__Impl ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1493:1: ( rule__Block__Group__2__Impl )
            // InternalRailSL.g:1494:2: rule__Block__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Block__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__2"


    // $ANTLR start "rule__Block__Group__2__Impl"
    // InternalRailSL.g:1500:1: rule__Block__Group__2__Impl : ( ( rule__Block__EndAssignment_2 ) ) ;
    public final void rule__Block__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1504:1: ( ( ( rule__Block__EndAssignment_2 ) ) )
            // InternalRailSL.g:1505:1: ( ( rule__Block__EndAssignment_2 ) )
            {
            // InternalRailSL.g:1505:1: ( ( rule__Block__EndAssignment_2 ) )
            // InternalRailSL.g:1506:2: ( rule__Block__EndAssignment_2 )
            {
             before(grammarAccess.getBlockAccess().getEndAssignment_2()); 
            // InternalRailSL.g:1507:2: ( rule__Block__EndAssignment_2 )
            // InternalRailSL.g:1507:3: rule__Block__EndAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Block__EndAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBlockAccess().getEndAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__2__Impl"


    // $ANTLR start "rule__TrackStatement__Group__0"
    // InternalRailSL.g:1516:1: rule__TrackStatement__Group__0 : rule__TrackStatement__Group__0__Impl rule__TrackStatement__Group__1 ;
    public final void rule__TrackStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1520:1: ( rule__TrackStatement__Group__0__Impl rule__TrackStatement__Group__1 )
            // InternalRailSL.g:1521:2: rule__TrackStatement__Group__0__Impl rule__TrackStatement__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__TrackStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__0"


    // $ANTLR start "rule__TrackStatement__Group__0__Impl"
    // InternalRailSL.g:1528:1: rule__TrackStatement__Group__0__Impl : ( ( rule__TrackStatement__Alternatives_0 ) ) ;
    public final void rule__TrackStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1532:1: ( ( ( rule__TrackStatement__Alternatives_0 ) ) )
            // InternalRailSL.g:1533:1: ( ( rule__TrackStatement__Alternatives_0 ) )
            {
            // InternalRailSL.g:1533:1: ( ( rule__TrackStatement__Alternatives_0 ) )
            // InternalRailSL.g:1534:2: ( rule__TrackStatement__Alternatives_0 )
            {
             before(grammarAccess.getTrackStatementAccess().getAlternatives_0()); 
            // InternalRailSL.g:1535:2: ( rule__TrackStatement__Alternatives_0 )
            // InternalRailSL.g:1535:3: rule__TrackStatement__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTrackStatementAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__0__Impl"


    // $ANTLR start "rule__TrackStatement__Group__1"
    // InternalRailSL.g:1543:1: rule__TrackStatement__Group__1 : rule__TrackStatement__Group__1__Impl rule__TrackStatement__Group__2 ;
    public final void rule__TrackStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1547:1: ( rule__TrackStatement__Group__1__Impl rule__TrackStatement__Group__2 )
            // InternalRailSL.g:1548:2: rule__TrackStatement__Group__1__Impl rule__TrackStatement__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__TrackStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__1"


    // $ANTLR start "rule__TrackStatement__Group__1__Impl"
    // InternalRailSL.g:1555:1: rule__TrackStatement__Group__1__Impl : ( 'track' ) ;
    public final void rule__TrackStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1559:1: ( ( 'track' ) )
            // InternalRailSL.g:1560:1: ( 'track' )
            {
            // InternalRailSL.g:1560:1: ( 'track' )
            // InternalRailSL.g:1561:2: 'track'
            {
             before(grammarAccess.getTrackStatementAccess().getTrackKeyword_1()); 
            match(input,97,FOLLOW_2); 
             after(grammarAccess.getTrackStatementAccess().getTrackKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__1__Impl"


    // $ANTLR start "rule__TrackStatement__Group__2"
    // InternalRailSL.g:1570:1: rule__TrackStatement__Group__2 : rule__TrackStatement__Group__2__Impl rule__TrackStatement__Group__3 ;
    public final void rule__TrackStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1574:1: ( rule__TrackStatement__Group__2__Impl rule__TrackStatement__Group__3 )
            // InternalRailSL.g:1575:2: rule__TrackStatement__Group__2__Impl rule__TrackStatement__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__TrackStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__2"


    // $ANTLR start "rule__TrackStatement__Group__2__Impl"
    // InternalRailSL.g:1582:1: rule__TrackStatement__Group__2__Impl : ( ( rule__TrackStatement__SegmentsAssignment_2 ) ) ;
    public final void rule__TrackStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1586:1: ( ( ( rule__TrackStatement__SegmentsAssignment_2 ) ) )
            // InternalRailSL.g:1587:1: ( ( rule__TrackStatement__SegmentsAssignment_2 ) )
            {
            // InternalRailSL.g:1587:1: ( ( rule__TrackStatement__SegmentsAssignment_2 ) )
            // InternalRailSL.g:1588:2: ( rule__TrackStatement__SegmentsAssignment_2 )
            {
             before(grammarAccess.getTrackStatementAccess().getSegmentsAssignment_2()); 
            // InternalRailSL.g:1589:2: ( rule__TrackStatement__SegmentsAssignment_2 )
            // InternalRailSL.g:1589:3: rule__TrackStatement__SegmentsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__SegmentsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTrackStatementAccess().getSegmentsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__2__Impl"


    // $ANTLR start "rule__TrackStatement__Group__3"
    // InternalRailSL.g:1597:1: rule__TrackStatement__Group__3 : rule__TrackStatement__Group__3__Impl rule__TrackStatement__Group__4 ;
    public final void rule__TrackStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1601:1: ( rule__TrackStatement__Group__3__Impl rule__TrackStatement__Group__4 )
            // InternalRailSL.g:1602:2: rule__TrackStatement__Group__3__Impl rule__TrackStatement__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__TrackStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__3"


    // $ANTLR start "rule__TrackStatement__Group__3__Impl"
    // InternalRailSL.g:1609:1: rule__TrackStatement__Group__3__Impl : ( ( rule__TrackStatement__Group_3__0 )* ) ;
    public final void rule__TrackStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1613:1: ( ( ( rule__TrackStatement__Group_3__0 )* ) )
            // InternalRailSL.g:1614:1: ( ( rule__TrackStatement__Group_3__0 )* )
            {
            // InternalRailSL.g:1614:1: ( ( rule__TrackStatement__Group_3__0 )* )
            // InternalRailSL.g:1615:2: ( rule__TrackStatement__Group_3__0 )*
            {
             before(grammarAccess.getTrackStatementAccess().getGroup_3()); 
            // InternalRailSL.g:1616:2: ( rule__TrackStatement__Group_3__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=16 && LA27_0<=17)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalRailSL.g:1616:3: rule__TrackStatement__Group_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TrackStatement__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getTrackStatementAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__3__Impl"


    // $ANTLR start "rule__TrackStatement__Group__4"
    // InternalRailSL.g:1624:1: rule__TrackStatement__Group__4 : rule__TrackStatement__Group__4__Impl rule__TrackStatement__Group__5 ;
    public final void rule__TrackStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1628:1: ( rule__TrackStatement__Group__4__Impl rule__TrackStatement__Group__5 )
            // InternalRailSL.g:1629:2: rule__TrackStatement__Group__4__Impl rule__TrackStatement__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__TrackStatement__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__4"


    // $ANTLR start "rule__TrackStatement__Group__4__Impl"
    // InternalRailSL.g:1636:1: rule__TrackStatement__Group__4__Impl : ( 'to' ) ;
    public final void rule__TrackStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1640:1: ( ( 'to' ) )
            // InternalRailSL.g:1641:1: ( 'to' )
            {
            // InternalRailSL.g:1641:1: ( 'to' )
            // InternalRailSL.g:1642:2: 'to'
            {
             before(grammarAccess.getTrackStatementAccess().getToKeyword_4()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getTrackStatementAccess().getToKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__4__Impl"


    // $ANTLR start "rule__TrackStatement__Group__5"
    // InternalRailSL.g:1651:1: rule__TrackStatement__Group__5 : rule__TrackStatement__Group__5__Impl rule__TrackStatement__Group__6 ;
    public final void rule__TrackStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1655:1: ( rule__TrackStatement__Group__5__Impl rule__TrackStatement__Group__6 )
            // InternalRailSL.g:1656:2: rule__TrackStatement__Group__5__Impl rule__TrackStatement__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__TrackStatement__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__5"


    // $ANTLR start "rule__TrackStatement__Group__5__Impl"
    // InternalRailSL.g:1663:1: rule__TrackStatement__Group__5__Impl : ( ( rule__TrackStatement__Alternatives_5 ) ) ;
    public final void rule__TrackStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1667:1: ( ( ( rule__TrackStatement__Alternatives_5 ) ) )
            // InternalRailSL.g:1668:1: ( ( rule__TrackStatement__Alternatives_5 ) )
            {
            // InternalRailSL.g:1668:1: ( ( rule__TrackStatement__Alternatives_5 ) )
            // InternalRailSL.g:1669:2: ( rule__TrackStatement__Alternatives_5 )
            {
             before(grammarAccess.getTrackStatementAccess().getAlternatives_5()); 
            // InternalRailSL.g:1670:2: ( rule__TrackStatement__Alternatives_5 )
            // InternalRailSL.g:1670:3: rule__TrackStatement__Alternatives_5
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__Alternatives_5();

            state._fsp--;


            }

             after(grammarAccess.getTrackStatementAccess().getAlternatives_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__5__Impl"


    // $ANTLR start "rule__TrackStatement__Group__6"
    // InternalRailSL.g:1678:1: rule__TrackStatement__Group__6 : rule__TrackStatement__Group__6__Impl ;
    public final void rule__TrackStatement__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1682:1: ( rule__TrackStatement__Group__6__Impl )
            // InternalRailSL.g:1683:2: rule__TrackStatement__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__6"


    // $ANTLR start "rule__TrackStatement__Group__6__Impl"
    // InternalRailSL.g:1689:1: rule__TrackStatement__Group__6__Impl : ( '.' ) ;
    public final void rule__TrackStatement__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1693:1: ( ( '.' ) )
            // InternalRailSL.g:1694:1: ( '.' )
            {
            // InternalRailSL.g:1694:1: ( '.' )
            // InternalRailSL.g:1695:2: '.'
            {
             before(grammarAccess.getTrackStatementAccess().getFullStopKeyword_6()); 
            match(input,99,FOLLOW_2); 
             after(grammarAccess.getTrackStatementAccess().getFullStopKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group__6__Impl"


    // $ANTLR start "rule__TrackStatement__Group_3__0"
    // InternalRailSL.g:1705:1: rule__TrackStatement__Group_3__0 : rule__TrackStatement__Group_3__0__Impl rule__TrackStatement__Group_3__1 ;
    public final void rule__TrackStatement__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1709:1: ( rule__TrackStatement__Group_3__0__Impl rule__TrackStatement__Group_3__1 )
            // InternalRailSL.g:1710:2: rule__TrackStatement__Group_3__0__Impl rule__TrackStatement__Group_3__1
            {
            pushFollow(FOLLOW_7);
            rule__TrackStatement__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_3__0"


    // $ANTLR start "rule__TrackStatement__Group_3__0__Impl"
    // InternalRailSL.g:1717:1: rule__TrackStatement__Group_3__0__Impl : ( ( rule__TrackStatement__Alternatives_3_0 ) ) ;
    public final void rule__TrackStatement__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1721:1: ( ( ( rule__TrackStatement__Alternatives_3_0 ) ) )
            // InternalRailSL.g:1722:1: ( ( rule__TrackStatement__Alternatives_3_0 ) )
            {
            // InternalRailSL.g:1722:1: ( ( rule__TrackStatement__Alternatives_3_0 ) )
            // InternalRailSL.g:1723:2: ( rule__TrackStatement__Alternatives_3_0 )
            {
             before(grammarAccess.getTrackStatementAccess().getAlternatives_3_0()); 
            // InternalRailSL.g:1724:2: ( rule__TrackStatement__Alternatives_3_0 )
            // InternalRailSL.g:1724:3: rule__TrackStatement__Alternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__Alternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTrackStatementAccess().getAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_3__0__Impl"


    // $ANTLR start "rule__TrackStatement__Group_3__1"
    // InternalRailSL.g:1732:1: rule__TrackStatement__Group_3__1 : rule__TrackStatement__Group_3__1__Impl ;
    public final void rule__TrackStatement__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1736:1: ( rule__TrackStatement__Group_3__1__Impl )
            // InternalRailSL.g:1737:2: rule__TrackStatement__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_3__1"


    // $ANTLR start "rule__TrackStatement__Group_3__1__Impl"
    // InternalRailSL.g:1743:1: rule__TrackStatement__Group_3__1__Impl : ( ( rule__TrackStatement__SegmentsAssignment_3_1 ) ) ;
    public final void rule__TrackStatement__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1747:1: ( ( ( rule__TrackStatement__SegmentsAssignment_3_1 ) ) )
            // InternalRailSL.g:1748:1: ( ( rule__TrackStatement__SegmentsAssignment_3_1 ) )
            {
            // InternalRailSL.g:1748:1: ( ( rule__TrackStatement__SegmentsAssignment_3_1 ) )
            // InternalRailSL.g:1749:2: ( rule__TrackStatement__SegmentsAssignment_3_1 )
            {
             before(grammarAccess.getTrackStatementAccess().getSegmentsAssignment_3_1()); 
            // InternalRailSL.g:1750:2: ( rule__TrackStatement__SegmentsAssignment_3_1 )
            // InternalRailSL.g:1750:3: rule__TrackStatement__SegmentsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__SegmentsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTrackStatementAccess().getSegmentsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_3__1__Impl"


    // $ANTLR start "rule__TrackStatement__Group_3_0_2__0"
    // InternalRailSL.g:1759:1: rule__TrackStatement__Group_3_0_2__0 : rule__TrackStatement__Group_3_0_2__0__Impl rule__TrackStatement__Group_3_0_2__1 ;
    public final void rule__TrackStatement__Group_3_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1763:1: ( rule__TrackStatement__Group_3_0_2__0__Impl rule__TrackStatement__Group_3_0_2__1 )
            // InternalRailSL.g:1764:2: rule__TrackStatement__Group_3_0_2__0__Impl rule__TrackStatement__Group_3_0_2__1
            {
            pushFollow(FOLLOW_12);
            rule__TrackStatement__Group_3_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group_3_0_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_3_0_2__0"


    // $ANTLR start "rule__TrackStatement__Group_3_0_2__0__Impl"
    // InternalRailSL.g:1771:1: rule__TrackStatement__Group_3_0_2__0__Impl : ( ',' ) ;
    public final void rule__TrackStatement__Group_3_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1775:1: ( ( ',' ) )
            // InternalRailSL.g:1776:1: ( ',' )
            {
            // InternalRailSL.g:1776:1: ( ',' )
            // InternalRailSL.g:1777:2: ','
            {
             before(grammarAccess.getTrackStatementAccess().getCommaKeyword_3_0_2_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getTrackStatementAccess().getCommaKeyword_3_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_3_0_2__0__Impl"


    // $ANTLR start "rule__TrackStatement__Group_3_0_2__1"
    // InternalRailSL.g:1786:1: rule__TrackStatement__Group_3_0_2__1 : rule__TrackStatement__Group_3_0_2__1__Impl ;
    public final void rule__TrackStatement__Group_3_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1790:1: ( rule__TrackStatement__Group_3_0_2__1__Impl )
            // InternalRailSL.g:1791:2: rule__TrackStatement__Group_3_0_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group_3_0_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_3_0_2__1"


    // $ANTLR start "rule__TrackStatement__Group_3_0_2__1__Impl"
    // InternalRailSL.g:1797:1: rule__TrackStatement__Group_3_0_2__1__Impl : ( 'and' ) ;
    public final void rule__TrackStatement__Group_3_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1801:1: ( ( 'and' ) )
            // InternalRailSL.g:1802:1: ( 'and' )
            {
            // InternalRailSL.g:1802:1: ( 'and' )
            // InternalRailSL.g:1803:2: 'and'
            {
             before(grammarAccess.getTrackStatementAccess().getAndKeyword_3_0_2_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getTrackStatementAccess().getAndKeyword_3_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_3_0_2__1__Impl"


    // $ANTLR start "rule__TrackStatement__Group_5_1__0"
    // InternalRailSL.g:1813:1: rule__TrackStatement__Group_5_1__0 : rule__TrackStatement__Group_5_1__0__Impl rule__TrackStatement__Group_5_1__1 ;
    public final void rule__TrackStatement__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1817:1: ( rule__TrackStatement__Group_5_1__0__Impl rule__TrackStatement__Group_5_1__1 )
            // InternalRailSL.g:1818:2: rule__TrackStatement__Group_5_1__0__Impl rule__TrackStatement__Group_5_1__1
            {
            pushFollow(FOLLOW_13);
            rule__TrackStatement__Group_5_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group_5_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_5_1__0"


    // $ANTLR start "rule__TrackStatement__Group_5_1__0__Impl"
    // InternalRailSL.g:1825:1: rule__TrackStatement__Group_5_1__0__Impl : ( ( rule__TrackStatement__SpeedAssignment_5_1_0 ) ) ;
    public final void rule__TrackStatement__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1829:1: ( ( ( rule__TrackStatement__SpeedAssignment_5_1_0 ) ) )
            // InternalRailSL.g:1830:1: ( ( rule__TrackStatement__SpeedAssignment_5_1_0 ) )
            {
            // InternalRailSL.g:1830:1: ( ( rule__TrackStatement__SpeedAssignment_5_1_0 ) )
            // InternalRailSL.g:1831:2: ( rule__TrackStatement__SpeedAssignment_5_1_0 )
            {
             before(grammarAccess.getTrackStatementAccess().getSpeedAssignment_5_1_0()); 
            // InternalRailSL.g:1832:2: ( rule__TrackStatement__SpeedAssignment_5_1_0 )
            // InternalRailSL.g:1832:3: rule__TrackStatement__SpeedAssignment_5_1_0
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__SpeedAssignment_5_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTrackStatementAccess().getSpeedAssignment_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_5_1__0__Impl"


    // $ANTLR start "rule__TrackStatement__Group_5_1__1"
    // InternalRailSL.g:1840:1: rule__TrackStatement__Group_5_1__1 : rule__TrackStatement__Group_5_1__1__Impl ;
    public final void rule__TrackStatement__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1844:1: ( rule__TrackStatement__Group_5_1__1__Impl )
            // InternalRailSL.g:1845:2: rule__TrackStatement__Group_5_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrackStatement__Group_5_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_5_1__1"


    // $ANTLR start "rule__TrackStatement__Group_5_1__1__Impl"
    // InternalRailSL.g:1851:1: rule__TrackStatement__Group_5_1__1__Impl : ( ( rule__TrackStatement__ReverseAssignment_5_1_1 )? ) ;
    public final void rule__TrackStatement__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1855:1: ( ( ( rule__TrackStatement__ReverseAssignment_5_1_1 )? ) )
            // InternalRailSL.g:1856:1: ( ( rule__TrackStatement__ReverseAssignment_5_1_1 )? )
            {
            // InternalRailSL.g:1856:1: ( ( rule__TrackStatement__ReverseAssignment_5_1_1 )? )
            // InternalRailSL.g:1857:2: ( rule__TrackStatement__ReverseAssignment_5_1_1 )?
            {
             before(grammarAccess.getTrackStatementAccess().getReverseAssignment_5_1_1()); 
            // InternalRailSL.g:1858:2: ( rule__TrackStatement__ReverseAssignment_5_1_1 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==110) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRailSL.g:1858:3: rule__TrackStatement__ReverseAssignment_5_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__TrackStatement__ReverseAssignment_5_1_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTrackStatementAccess().getReverseAssignment_5_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__Group_5_1__1__Impl"


    // $ANTLR start "rule__PointStatement__Group__0"
    // InternalRailSL.g:1867:1: rule__PointStatement__Group__0 : rule__PointStatement__Group__0__Impl rule__PointStatement__Group__1 ;
    public final void rule__PointStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1871:1: ( rule__PointStatement__Group__0__Impl rule__PointStatement__Group__1 )
            // InternalRailSL.g:1872:2: rule__PointStatement__Group__0__Impl rule__PointStatement__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__PointStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__0"


    // $ANTLR start "rule__PointStatement__Group__0__Impl"
    // InternalRailSL.g:1879:1: rule__PointStatement__Group__0__Impl : ( ( rule__PointStatement__Alternatives_0 ) ) ;
    public final void rule__PointStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1883:1: ( ( ( rule__PointStatement__Alternatives_0 ) ) )
            // InternalRailSL.g:1884:1: ( ( rule__PointStatement__Alternatives_0 ) )
            {
            // InternalRailSL.g:1884:1: ( ( rule__PointStatement__Alternatives_0 ) )
            // InternalRailSL.g:1885:2: ( rule__PointStatement__Alternatives_0 )
            {
             before(grammarAccess.getPointStatementAccess().getAlternatives_0()); 
            // InternalRailSL.g:1886:2: ( rule__PointStatement__Alternatives_0 )
            // InternalRailSL.g:1886:3: rule__PointStatement__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__PointStatement__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getPointStatementAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__0__Impl"


    // $ANTLR start "rule__PointStatement__Group__1"
    // InternalRailSL.g:1894:1: rule__PointStatement__Group__1 : rule__PointStatement__Group__1__Impl rule__PointStatement__Group__2 ;
    public final void rule__PointStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1898:1: ( rule__PointStatement__Group__1__Impl rule__PointStatement__Group__2 )
            // InternalRailSL.g:1899:2: rule__PointStatement__Group__1__Impl rule__PointStatement__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__PointStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__1"


    // $ANTLR start "rule__PointStatement__Group__1__Impl"
    // InternalRailSL.g:1906:1: rule__PointStatement__Group__1__Impl : ( 'point' ) ;
    public final void rule__PointStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1910:1: ( ( 'point' ) )
            // InternalRailSL.g:1911:1: ( 'point' )
            {
            // InternalRailSL.g:1911:1: ( 'point' )
            // InternalRailSL.g:1912:2: 'point'
            {
             before(grammarAccess.getPointStatementAccess().getPointKeyword_1()); 
            match(input,100,FOLLOW_2); 
             after(grammarAccess.getPointStatementAccess().getPointKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__1__Impl"


    // $ANTLR start "rule__PointStatement__Group__2"
    // InternalRailSL.g:1921:1: rule__PointStatement__Group__2 : rule__PointStatement__Group__2__Impl rule__PointStatement__Group__3 ;
    public final void rule__PointStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1925:1: ( rule__PointStatement__Group__2__Impl rule__PointStatement__Group__3 )
            // InternalRailSL.g:1926:2: rule__PointStatement__Group__2__Impl rule__PointStatement__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__PointStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointStatement__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__2"


    // $ANTLR start "rule__PointStatement__Group__2__Impl"
    // InternalRailSL.g:1933:1: rule__PointStatement__Group__2__Impl : ( ( rule__PointStatement__PointsAssignment_2 ) ) ;
    public final void rule__PointStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1937:1: ( ( ( rule__PointStatement__PointsAssignment_2 ) ) )
            // InternalRailSL.g:1938:1: ( ( rule__PointStatement__PointsAssignment_2 ) )
            {
            // InternalRailSL.g:1938:1: ( ( rule__PointStatement__PointsAssignment_2 ) )
            // InternalRailSL.g:1939:2: ( rule__PointStatement__PointsAssignment_2 )
            {
             before(grammarAccess.getPointStatementAccess().getPointsAssignment_2()); 
            // InternalRailSL.g:1940:2: ( rule__PointStatement__PointsAssignment_2 )
            // InternalRailSL.g:1940:3: rule__PointStatement__PointsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PointStatement__PointsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPointStatementAccess().getPointsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__2__Impl"


    // $ANTLR start "rule__PointStatement__Group__3"
    // InternalRailSL.g:1948:1: rule__PointStatement__Group__3 : rule__PointStatement__Group__3__Impl rule__PointStatement__Group__4 ;
    public final void rule__PointStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1952:1: ( rule__PointStatement__Group__3__Impl rule__PointStatement__Group__4 )
            // InternalRailSL.g:1953:2: rule__PointStatement__Group__3__Impl rule__PointStatement__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__PointStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointStatement__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__3"


    // $ANTLR start "rule__PointStatement__Group__3__Impl"
    // InternalRailSL.g:1960:1: rule__PointStatement__Group__3__Impl : ( ( rule__PointStatement__Group_3__0 )* ) ;
    public final void rule__PointStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1964:1: ( ( ( rule__PointStatement__Group_3__0 )* ) )
            // InternalRailSL.g:1965:1: ( ( rule__PointStatement__Group_3__0 )* )
            {
            // InternalRailSL.g:1965:1: ( ( rule__PointStatement__Group_3__0 )* )
            // InternalRailSL.g:1966:2: ( rule__PointStatement__Group_3__0 )*
            {
             before(grammarAccess.getPointStatementAccess().getGroup_3()); 
            // InternalRailSL.g:1967:2: ( rule__PointStatement__Group_3__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=16 && LA29_0<=17)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalRailSL.g:1967:3: rule__PointStatement__Group_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__PointStatement__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getPointStatementAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__3__Impl"


    // $ANTLR start "rule__PointStatement__Group__4"
    // InternalRailSL.g:1975:1: rule__PointStatement__Group__4 : rule__PointStatement__Group__4__Impl rule__PointStatement__Group__5 ;
    public final void rule__PointStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1979:1: ( rule__PointStatement__Group__4__Impl rule__PointStatement__Group__5 )
            // InternalRailSL.g:1980:2: rule__PointStatement__Group__4__Impl rule__PointStatement__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__PointStatement__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointStatement__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__4"


    // $ANTLR start "rule__PointStatement__Group__4__Impl"
    // InternalRailSL.g:1987:1: rule__PointStatement__Group__4__Impl : ( 'to' ) ;
    public final void rule__PointStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:1991:1: ( ( 'to' ) )
            // InternalRailSL.g:1992:1: ( 'to' )
            {
            // InternalRailSL.g:1992:1: ( 'to' )
            // InternalRailSL.g:1993:2: 'to'
            {
             before(grammarAccess.getPointStatementAccess().getToKeyword_4()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getPointStatementAccess().getToKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__4__Impl"


    // $ANTLR start "rule__PointStatement__Group__5"
    // InternalRailSL.g:2002:1: rule__PointStatement__Group__5 : rule__PointStatement__Group__5__Impl rule__PointStatement__Group__6 ;
    public final void rule__PointStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2006:1: ( rule__PointStatement__Group__5__Impl rule__PointStatement__Group__6 )
            // InternalRailSL.g:2007:2: rule__PointStatement__Group__5__Impl rule__PointStatement__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__PointStatement__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointStatement__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__5"


    // $ANTLR start "rule__PointStatement__Group__5__Impl"
    // InternalRailSL.g:2014:1: rule__PointStatement__Group__5__Impl : ( ( rule__PointStatement__OrientationAssignment_5 ) ) ;
    public final void rule__PointStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2018:1: ( ( ( rule__PointStatement__OrientationAssignment_5 ) ) )
            // InternalRailSL.g:2019:1: ( ( rule__PointStatement__OrientationAssignment_5 ) )
            {
            // InternalRailSL.g:2019:1: ( ( rule__PointStatement__OrientationAssignment_5 ) )
            // InternalRailSL.g:2020:2: ( rule__PointStatement__OrientationAssignment_5 )
            {
             before(grammarAccess.getPointStatementAccess().getOrientationAssignment_5()); 
            // InternalRailSL.g:2021:2: ( rule__PointStatement__OrientationAssignment_5 )
            // InternalRailSL.g:2021:3: rule__PointStatement__OrientationAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__PointStatement__OrientationAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getPointStatementAccess().getOrientationAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__5__Impl"


    // $ANTLR start "rule__PointStatement__Group__6"
    // InternalRailSL.g:2029:1: rule__PointStatement__Group__6 : rule__PointStatement__Group__6__Impl ;
    public final void rule__PointStatement__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2033:1: ( rule__PointStatement__Group__6__Impl )
            // InternalRailSL.g:2034:2: rule__PointStatement__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PointStatement__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__6"


    // $ANTLR start "rule__PointStatement__Group__6__Impl"
    // InternalRailSL.g:2040:1: rule__PointStatement__Group__6__Impl : ( '.' ) ;
    public final void rule__PointStatement__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2044:1: ( ( '.' ) )
            // InternalRailSL.g:2045:1: ( '.' )
            {
            // InternalRailSL.g:2045:1: ( '.' )
            // InternalRailSL.g:2046:2: '.'
            {
             before(grammarAccess.getPointStatementAccess().getFullStopKeyword_6()); 
            match(input,99,FOLLOW_2); 
             after(grammarAccess.getPointStatementAccess().getFullStopKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group__6__Impl"


    // $ANTLR start "rule__PointStatement__Group_3__0"
    // InternalRailSL.g:2056:1: rule__PointStatement__Group_3__0 : rule__PointStatement__Group_3__0__Impl rule__PointStatement__Group_3__1 ;
    public final void rule__PointStatement__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2060:1: ( rule__PointStatement__Group_3__0__Impl rule__PointStatement__Group_3__1 )
            // InternalRailSL.g:2061:2: rule__PointStatement__Group_3__0__Impl rule__PointStatement__Group_3__1
            {
            pushFollow(FOLLOW_15);
            rule__PointStatement__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointStatement__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group_3__0"


    // $ANTLR start "rule__PointStatement__Group_3__0__Impl"
    // InternalRailSL.g:2068:1: rule__PointStatement__Group_3__0__Impl : ( ( rule__PointStatement__Alternatives_3_0 ) ) ;
    public final void rule__PointStatement__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2072:1: ( ( ( rule__PointStatement__Alternatives_3_0 ) ) )
            // InternalRailSL.g:2073:1: ( ( rule__PointStatement__Alternatives_3_0 ) )
            {
            // InternalRailSL.g:2073:1: ( ( rule__PointStatement__Alternatives_3_0 ) )
            // InternalRailSL.g:2074:2: ( rule__PointStatement__Alternatives_3_0 )
            {
             before(grammarAccess.getPointStatementAccess().getAlternatives_3_0()); 
            // InternalRailSL.g:2075:2: ( rule__PointStatement__Alternatives_3_0 )
            // InternalRailSL.g:2075:3: rule__PointStatement__Alternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__PointStatement__Alternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getPointStatementAccess().getAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group_3__0__Impl"


    // $ANTLR start "rule__PointStatement__Group_3__1"
    // InternalRailSL.g:2083:1: rule__PointStatement__Group_3__1 : rule__PointStatement__Group_3__1__Impl ;
    public final void rule__PointStatement__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2087:1: ( rule__PointStatement__Group_3__1__Impl )
            // InternalRailSL.g:2088:2: rule__PointStatement__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PointStatement__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group_3__1"


    // $ANTLR start "rule__PointStatement__Group_3__1__Impl"
    // InternalRailSL.g:2094:1: rule__PointStatement__Group_3__1__Impl : ( ( rule__PointStatement__PointsAssignment_3_1 ) ) ;
    public final void rule__PointStatement__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2098:1: ( ( ( rule__PointStatement__PointsAssignment_3_1 ) ) )
            // InternalRailSL.g:2099:1: ( ( rule__PointStatement__PointsAssignment_3_1 ) )
            {
            // InternalRailSL.g:2099:1: ( ( rule__PointStatement__PointsAssignment_3_1 ) )
            // InternalRailSL.g:2100:2: ( rule__PointStatement__PointsAssignment_3_1 )
            {
             before(grammarAccess.getPointStatementAccess().getPointsAssignment_3_1()); 
            // InternalRailSL.g:2101:2: ( rule__PointStatement__PointsAssignment_3_1 )
            // InternalRailSL.g:2101:3: rule__PointStatement__PointsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__PointStatement__PointsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getPointStatementAccess().getPointsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group_3__1__Impl"


    // $ANTLR start "rule__PointStatement__Group_3_0_2__0"
    // InternalRailSL.g:2110:1: rule__PointStatement__Group_3_0_2__0 : rule__PointStatement__Group_3_0_2__0__Impl rule__PointStatement__Group_3_0_2__1 ;
    public final void rule__PointStatement__Group_3_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2114:1: ( rule__PointStatement__Group_3_0_2__0__Impl rule__PointStatement__Group_3_0_2__1 )
            // InternalRailSL.g:2115:2: rule__PointStatement__Group_3_0_2__0__Impl rule__PointStatement__Group_3_0_2__1
            {
            pushFollow(FOLLOW_12);
            rule__PointStatement__Group_3_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PointStatement__Group_3_0_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group_3_0_2__0"


    // $ANTLR start "rule__PointStatement__Group_3_0_2__0__Impl"
    // InternalRailSL.g:2122:1: rule__PointStatement__Group_3_0_2__0__Impl : ( ',' ) ;
    public final void rule__PointStatement__Group_3_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2126:1: ( ( ',' ) )
            // InternalRailSL.g:2127:1: ( ',' )
            {
            // InternalRailSL.g:2127:1: ( ',' )
            // InternalRailSL.g:2128:2: ','
            {
             before(grammarAccess.getPointStatementAccess().getCommaKeyword_3_0_2_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getPointStatementAccess().getCommaKeyword_3_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group_3_0_2__0__Impl"


    // $ANTLR start "rule__PointStatement__Group_3_0_2__1"
    // InternalRailSL.g:2137:1: rule__PointStatement__Group_3_0_2__1 : rule__PointStatement__Group_3_0_2__1__Impl ;
    public final void rule__PointStatement__Group_3_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2141:1: ( rule__PointStatement__Group_3_0_2__1__Impl )
            // InternalRailSL.g:2142:2: rule__PointStatement__Group_3_0_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PointStatement__Group_3_0_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group_3_0_2__1"


    // $ANTLR start "rule__PointStatement__Group_3_0_2__1__Impl"
    // InternalRailSL.g:2148:1: rule__PointStatement__Group_3_0_2__1__Impl : ( 'and' ) ;
    public final void rule__PointStatement__Group_3_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2152:1: ( ( 'and' ) )
            // InternalRailSL.g:2153:1: ( 'and' )
            {
            // InternalRailSL.g:2153:1: ( 'and' )
            // InternalRailSL.g:2154:2: 'and'
            {
             before(grammarAccess.getPointStatementAccess().getAndKeyword_3_0_2_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getPointStatementAccess().getAndKeyword_3_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__Group_3_0_2__1__Impl"


    // $ANTLR start "rule__TimeWaitStatement__Group__0"
    // InternalRailSL.g:2164:1: rule__TimeWaitStatement__Group__0 : rule__TimeWaitStatement__Group__0__Impl rule__TimeWaitStatement__Group__1 ;
    public final void rule__TimeWaitStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2168:1: ( rule__TimeWaitStatement__Group__0__Impl rule__TimeWaitStatement__Group__1 )
            // InternalRailSL.g:2169:2: rule__TimeWaitStatement__Group__0__Impl rule__TimeWaitStatement__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__TimeWaitStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeWaitStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeWaitStatement__Group__0"


    // $ANTLR start "rule__TimeWaitStatement__Group__0__Impl"
    // InternalRailSL.g:2176:1: rule__TimeWaitStatement__Group__0__Impl : ( ( rule__TimeWaitStatement__Alternatives_0 ) ) ;
    public final void rule__TimeWaitStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2180:1: ( ( ( rule__TimeWaitStatement__Alternatives_0 ) ) )
            // InternalRailSL.g:2181:1: ( ( rule__TimeWaitStatement__Alternatives_0 ) )
            {
            // InternalRailSL.g:2181:1: ( ( rule__TimeWaitStatement__Alternatives_0 ) )
            // InternalRailSL.g:2182:2: ( rule__TimeWaitStatement__Alternatives_0 )
            {
             before(grammarAccess.getTimeWaitStatementAccess().getAlternatives_0()); 
            // InternalRailSL.g:2183:2: ( rule__TimeWaitStatement__Alternatives_0 )
            // InternalRailSL.g:2183:3: rule__TimeWaitStatement__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__TimeWaitStatement__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeWaitStatementAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeWaitStatement__Group__0__Impl"


    // $ANTLR start "rule__TimeWaitStatement__Group__1"
    // InternalRailSL.g:2191:1: rule__TimeWaitStatement__Group__1 : rule__TimeWaitStatement__Group__1__Impl rule__TimeWaitStatement__Group__2 ;
    public final void rule__TimeWaitStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2195:1: ( rule__TimeWaitStatement__Group__1__Impl rule__TimeWaitStatement__Group__2 )
            // InternalRailSL.g:2196:2: rule__TimeWaitStatement__Group__1__Impl rule__TimeWaitStatement__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__TimeWaitStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeWaitStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeWaitStatement__Group__1"


    // $ANTLR start "rule__TimeWaitStatement__Group__1__Impl"
    // InternalRailSL.g:2203:1: rule__TimeWaitStatement__Group__1__Impl : ( 'for' ) ;
    public final void rule__TimeWaitStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2207:1: ( ( 'for' ) )
            // InternalRailSL.g:2208:1: ( 'for' )
            {
            // InternalRailSL.g:2208:1: ( 'for' )
            // InternalRailSL.g:2209:2: 'for'
            {
             before(grammarAccess.getTimeWaitStatementAccess().getForKeyword_1()); 
            match(input,101,FOLLOW_2); 
             after(grammarAccess.getTimeWaitStatementAccess().getForKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeWaitStatement__Group__1__Impl"


    // $ANTLR start "rule__TimeWaitStatement__Group__2"
    // InternalRailSL.g:2218:1: rule__TimeWaitStatement__Group__2 : rule__TimeWaitStatement__Group__2__Impl rule__TimeWaitStatement__Group__3 ;
    public final void rule__TimeWaitStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2222:1: ( rule__TimeWaitStatement__Group__2__Impl rule__TimeWaitStatement__Group__3 )
            // InternalRailSL.g:2223:2: rule__TimeWaitStatement__Group__2__Impl rule__TimeWaitStatement__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__TimeWaitStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeWaitStatement__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeWaitStatement__Group__2"


    // $ANTLR start "rule__TimeWaitStatement__Group__2__Impl"
    // InternalRailSL.g:2230:1: rule__TimeWaitStatement__Group__2__Impl : ( ( rule__TimeWaitStatement__TimeAssignment_2 ) ) ;
    public final void rule__TimeWaitStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2234:1: ( ( ( rule__TimeWaitStatement__TimeAssignment_2 ) ) )
            // InternalRailSL.g:2235:1: ( ( rule__TimeWaitStatement__TimeAssignment_2 ) )
            {
            // InternalRailSL.g:2235:1: ( ( rule__TimeWaitStatement__TimeAssignment_2 ) )
            // InternalRailSL.g:2236:2: ( rule__TimeWaitStatement__TimeAssignment_2 )
            {
             before(grammarAccess.getTimeWaitStatementAccess().getTimeAssignment_2()); 
            // InternalRailSL.g:2237:2: ( rule__TimeWaitStatement__TimeAssignment_2 )
            // InternalRailSL.g:2237:3: rule__TimeWaitStatement__TimeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TimeWaitStatement__TimeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTimeWaitStatementAccess().getTimeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeWaitStatement__Group__2__Impl"


    // $ANTLR start "rule__TimeWaitStatement__Group__3"
    // InternalRailSL.g:2245:1: rule__TimeWaitStatement__Group__3 : rule__TimeWaitStatement__Group__3__Impl ;
    public final void rule__TimeWaitStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2249:1: ( rule__TimeWaitStatement__Group__3__Impl )
            // InternalRailSL.g:2250:2: rule__TimeWaitStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TimeWaitStatement__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeWaitStatement__Group__3"


    // $ANTLR start "rule__TimeWaitStatement__Group__3__Impl"
    // InternalRailSL.g:2256:1: rule__TimeWaitStatement__Group__3__Impl : ( 'seconds.' ) ;
    public final void rule__TimeWaitStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2260:1: ( ( 'seconds.' ) )
            // InternalRailSL.g:2261:1: ( 'seconds.' )
            {
            // InternalRailSL.g:2261:1: ( 'seconds.' )
            // InternalRailSL.g:2262:2: 'seconds.'
            {
             before(grammarAccess.getTimeWaitStatementAccess().getSecondsKeyword_3()); 
            match(input,102,FOLLOW_2); 
             after(grammarAccess.getTimeWaitStatementAccess().getSecondsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeWaitStatement__Group__3__Impl"


    // $ANTLR start "rule__ContactWaitStatement__Group__0"
    // InternalRailSL.g:2272:1: rule__ContactWaitStatement__Group__0 : rule__ContactWaitStatement__Group__0__Impl rule__ContactWaitStatement__Group__1 ;
    public final void rule__ContactWaitStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2276:1: ( rule__ContactWaitStatement__Group__0__Impl rule__ContactWaitStatement__Group__1 )
            // InternalRailSL.g:2277:2: rule__ContactWaitStatement__Group__0__Impl rule__ContactWaitStatement__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__ContactWaitStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContactWaitStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__0"


    // $ANTLR start "rule__ContactWaitStatement__Group__0__Impl"
    // InternalRailSL.g:2284:1: rule__ContactWaitStatement__Group__0__Impl : ( ( rule__ContactWaitStatement__EventAssignment_0 ) ) ;
    public final void rule__ContactWaitStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2288:1: ( ( ( rule__ContactWaitStatement__EventAssignment_0 ) ) )
            // InternalRailSL.g:2289:1: ( ( rule__ContactWaitStatement__EventAssignment_0 ) )
            {
            // InternalRailSL.g:2289:1: ( ( rule__ContactWaitStatement__EventAssignment_0 ) )
            // InternalRailSL.g:2290:2: ( rule__ContactWaitStatement__EventAssignment_0 )
            {
             before(grammarAccess.getContactWaitStatementAccess().getEventAssignment_0()); 
            // InternalRailSL.g:2291:2: ( rule__ContactWaitStatement__EventAssignment_0 )
            // InternalRailSL.g:2291:3: rule__ContactWaitStatement__EventAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ContactWaitStatement__EventAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getContactWaitStatementAccess().getEventAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__0__Impl"


    // $ANTLR start "rule__ContactWaitStatement__Group__1"
    // InternalRailSL.g:2299:1: rule__ContactWaitStatement__Group__1 : rule__ContactWaitStatement__Group__1__Impl rule__ContactWaitStatement__Group__2 ;
    public final void rule__ContactWaitStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2303:1: ( rule__ContactWaitStatement__Group__1__Impl rule__ContactWaitStatement__Group__2 )
            // InternalRailSL.g:2304:2: rule__ContactWaitStatement__Group__1__Impl rule__ContactWaitStatement__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__ContactWaitStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContactWaitStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__1"


    // $ANTLR start "rule__ContactWaitStatement__Group__1__Impl"
    // InternalRailSL.g:2311:1: rule__ContactWaitStatement__Group__1__Impl : ( ( rule__ContactWaitStatement__ContactAssignment_1 ) ) ;
    public final void rule__ContactWaitStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2315:1: ( ( ( rule__ContactWaitStatement__ContactAssignment_1 ) ) )
            // InternalRailSL.g:2316:1: ( ( rule__ContactWaitStatement__ContactAssignment_1 ) )
            {
            // InternalRailSL.g:2316:1: ( ( rule__ContactWaitStatement__ContactAssignment_1 ) )
            // InternalRailSL.g:2317:2: ( rule__ContactWaitStatement__ContactAssignment_1 )
            {
             before(grammarAccess.getContactWaitStatementAccess().getContactAssignment_1()); 
            // InternalRailSL.g:2318:2: ( rule__ContactWaitStatement__ContactAssignment_1 )
            // InternalRailSL.g:2318:3: rule__ContactWaitStatement__ContactAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ContactWaitStatement__ContactAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getContactWaitStatementAccess().getContactAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__1__Impl"


    // $ANTLR start "rule__ContactWaitStatement__Group__2"
    // InternalRailSL.g:2326:1: rule__ContactWaitStatement__Group__2 : rule__ContactWaitStatement__Group__2__Impl rule__ContactWaitStatement__Group__3 ;
    public final void rule__ContactWaitStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2330:1: ( rule__ContactWaitStatement__Group__2__Impl rule__ContactWaitStatement__Group__3 )
            // InternalRailSL.g:2331:2: rule__ContactWaitStatement__Group__2__Impl rule__ContactWaitStatement__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__ContactWaitStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContactWaitStatement__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__2"


    // $ANTLR start "rule__ContactWaitStatement__Group__2__Impl"
    // InternalRailSL.g:2338:1: rule__ContactWaitStatement__Group__2__Impl : ( 'contact' ) ;
    public final void rule__ContactWaitStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2342:1: ( ( 'contact' ) )
            // InternalRailSL.g:2343:1: ( 'contact' )
            {
            // InternalRailSL.g:2343:1: ( 'contact' )
            // InternalRailSL.g:2344:2: 'contact'
            {
             before(grammarAccess.getContactWaitStatementAccess().getContactKeyword_2()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getContactWaitStatementAccess().getContactKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__2__Impl"


    // $ANTLR start "rule__ContactWaitStatement__Group__3"
    // InternalRailSL.g:2353:1: rule__ContactWaitStatement__Group__3 : rule__ContactWaitStatement__Group__3__Impl rule__ContactWaitStatement__Group__4 ;
    public final void rule__ContactWaitStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2357:1: ( rule__ContactWaitStatement__Group__3__Impl rule__ContactWaitStatement__Group__4 )
            // InternalRailSL.g:2358:2: rule__ContactWaitStatement__Group__3__Impl rule__ContactWaitStatement__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__ContactWaitStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContactWaitStatement__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__3"


    // $ANTLR start "rule__ContactWaitStatement__Group__3__Impl"
    // InternalRailSL.g:2365:1: rule__ContactWaitStatement__Group__3__Impl : ( ( 'of' )? ) ;
    public final void rule__ContactWaitStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2369:1: ( ( ( 'of' )? ) )
            // InternalRailSL.g:2370:1: ( ( 'of' )? )
            {
            // InternalRailSL.g:2370:1: ( ( 'of' )? )
            // InternalRailSL.g:2371:2: ( 'of' )?
            {
             before(grammarAccess.getContactWaitStatementAccess().getOfKeyword_3()); 
            // InternalRailSL.g:2372:2: ( 'of' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==104) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalRailSL.g:2372:3: 'of'
                    {
                    match(input,104,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getContactWaitStatementAccess().getOfKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__3__Impl"


    // $ANTLR start "rule__ContactWaitStatement__Group__4"
    // InternalRailSL.g:2380:1: rule__ContactWaitStatement__Group__4 : rule__ContactWaitStatement__Group__4__Impl rule__ContactWaitStatement__Group__5 ;
    public final void rule__ContactWaitStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2384:1: ( rule__ContactWaitStatement__Group__4__Impl rule__ContactWaitStatement__Group__5 )
            // InternalRailSL.g:2385:2: rule__ContactWaitStatement__Group__4__Impl rule__ContactWaitStatement__Group__5
            {
            pushFollow(FOLLOW_11);
            rule__ContactWaitStatement__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContactWaitStatement__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__4"


    // $ANTLR start "rule__ContactWaitStatement__Group__4__Impl"
    // InternalRailSL.g:2392:1: rule__ContactWaitStatement__Group__4__Impl : ( ( rule__ContactWaitStatement__SegmentAssignment_4 ) ) ;
    public final void rule__ContactWaitStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2396:1: ( ( ( rule__ContactWaitStatement__SegmentAssignment_4 ) ) )
            // InternalRailSL.g:2397:1: ( ( rule__ContactWaitStatement__SegmentAssignment_4 ) )
            {
            // InternalRailSL.g:2397:1: ( ( rule__ContactWaitStatement__SegmentAssignment_4 ) )
            // InternalRailSL.g:2398:2: ( rule__ContactWaitStatement__SegmentAssignment_4 )
            {
             before(grammarAccess.getContactWaitStatementAccess().getSegmentAssignment_4()); 
            // InternalRailSL.g:2399:2: ( rule__ContactWaitStatement__SegmentAssignment_4 )
            // InternalRailSL.g:2399:3: rule__ContactWaitStatement__SegmentAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ContactWaitStatement__SegmentAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getContactWaitStatementAccess().getSegmentAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__4__Impl"


    // $ANTLR start "rule__ContactWaitStatement__Group__5"
    // InternalRailSL.g:2407:1: rule__ContactWaitStatement__Group__5 : rule__ContactWaitStatement__Group__5__Impl ;
    public final void rule__ContactWaitStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2411:1: ( rule__ContactWaitStatement__Group__5__Impl )
            // InternalRailSL.g:2412:2: rule__ContactWaitStatement__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ContactWaitStatement__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__5"


    // $ANTLR start "rule__ContactWaitStatement__Group__5__Impl"
    // InternalRailSL.g:2418:1: rule__ContactWaitStatement__Group__5__Impl : ( '.' ) ;
    public final void rule__ContactWaitStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2422:1: ( ( '.' ) )
            // InternalRailSL.g:2423:1: ( '.' )
            {
            // InternalRailSL.g:2423:1: ( '.' )
            // InternalRailSL.g:2424:2: '.'
            {
             before(grammarAccess.getContactWaitStatementAccess().getFullStopKeyword_5()); 
            match(input,99,FOLLOW_2); 
             after(grammarAccess.getContactWaitStatementAccess().getFullStopKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__Group__5__Impl"


    // $ANTLR start "rule__CrossingStatement__Group__0"
    // InternalRailSL.g:2434:1: rule__CrossingStatement__Group__0 : rule__CrossingStatement__Group__0__Impl rule__CrossingStatement__Group__1 ;
    public final void rule__CrossingStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2438:1: ( rule__CrossingStatement__Group__0__Impl rule__CrossingStatement__Group__1 )
            // InternalRailSL.g:2439:2: rule__CrossingStatement__Group__0__Impl rule__CrossingStatement__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__CrossingStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CrossingStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossingStatement__Group__0"


    // $ANTLR start "rule__CrossingStatement__Group__0__Impl"
    // InternalRailSL.g:2446:1: rule__CrossingStatement__Group__0__Impl : ( ( rule__CrossingStatement__ModeAssignment_0 ) ) ;
    public final void rule__CrossingStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2450:1: ( ( ( rule__CrossingStatement__ModeAssignment_0 ) ) )
            // InternalRailSL.g:2451:1: ( ( rule__CrossingStatement__ModeAssignment_0 ) )
            {
            // InternalRailSL.g:2451:1: ( ( rule__CrossingStatement__ModeAssignment_0 ) )
            // InternalRailSL.g:2452:2: ( rule__CrossingStatement__ModeAssignment_0 )
            {
             before(grammarAccess.getCrossingStatementAccess().getModeAssignment_0()); 
            // InternalRailSL.g:2453:2: ( rule__CrossingStatement__ModeAssignment_0 )
            // InternalRailSL.g:2453:3: rule__CrossingStatement__ModeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CrossingStatement__ModeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCrossingStatementAccess().getModeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossingStatement__Group__0__Impl"


    // $ANTLR start "rule__CrossingStatement__Group__1"
    // InternalRailSL.g:2461:1: rule__CrossingStatement__Group__1 : rule__CrossingStatement__Group__1__Impl ;
    public final void rule__CrossingStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2465:1: ( rule__CrossingStatement__Group__1__Impl )
            // InternalRailSL.g:2466:2: rule__CrossingStatement__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CrossingStatement__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossingStatement__Group__1"


    // $ANTLR start "rule__CrossingStatement__Group__1__Impl"
    // InternalRailSL.g:2472:1: rule__CrossingStatement__Group__1__Impl : ( 'crossing.' ) ;
    public final void rule__CrossingStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2476:1: ( ( 'crossing.' ) )
            // InternalRailSL.g:2477:1: ( 'crossing.' )
            {
            // InternalRailSL.g:2477:1: ( 'crossing.' )
            // InternalRailSL.g:2478:2: 'crossing.'
            {
             before(grammarAccess.getCrossingStatementAccess().getCrossingKeyword_1()); 
            match(input,105,FOLLOW_2); 
             after(grammarAccess.getCrossingStatementAccess().getCrossingKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossingStatement__Group__1__Impl"


    // $ANTLR start "rule__LightStatement__Group__0"
    // InternalRailSL.g:2488:1: rule__LightStatement__Group__0 : rule__LightStatement__Group__0__Impl rule__LightStatement__Group__1 ;
    public final void rule__LightStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2492:1: ( rule__LightStatement__Group__0__Impl rule__LightStatement__Group__1 )
            // InternalRailSL.g:2493:2: rule__LightStatement__Group__0__Impl rule__LightStatement__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__LightStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LightStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__0"


    // $ANTLR start "rule__LightStatement__Group__0__Impl"
    // InternalRailSL.g:2500:1: rule__LightStatement__Group__0__Impl : ( ( rule__LightStatement__Alternatives_0 ) ) ;
    public final void rule__LightStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2504:1: ( ( ( rule__LightStatement__Alternatives_0 ) ) )
            // InternalRailSL.g:2505:1: ( ( rule__LightStatement__Alternatives_0 ) )
            {
            // InternalRailSL.g:2505:1: ( ( rule__LightStatement__Alternatives_0 ) )
            // InternalRailSL.g:2506:2: ( rule__LightStatement__Alternatives_0 )
            {
             before(grammarAccess.getLightStatementAccess().getAlternatives_0()); 
            // InternalRailSL.g:2507:2: ( rule__LightStatement__Alternatives_0 )
            // InternalRailSL.g:2507:3: rule__LightStatement__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__LightStatement__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getLightStatementAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__0__Impl"


    // $ANTLR start "rule__LightStatement__Group__1"
    // InternalRailSL.g:2515:1: rule__LightStatement__Group__1 : rule__LightStatement__Group__1__Impl rule__LightStatement__Group__2 ;
    public final void rule__LightStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2519:1: ( rule__LightStatement__Group__1__Impl rule__LightStatement__Group__2 )
            // InternalRailSL.g:2520:2: rule__LightStatement__Group__1__Impl rule__LightStatement__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__LightStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LightStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__1"


    // $ANTLR start "rule__LightStatement__Group__1__Impl"
    // InternalRailSL.g:2527:1: rule__LightStatement__Group__1__Impl : ( 'light' ) ;
    public final void rule__LightStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2531:1: ( ( 'light' ) )
            // InternalRailSL.g:2532:1: ( 'light' )
            {
            // InternalRailSL.g:2532:1: ( 'light' )
            // InternalRailSL.g:2533:2: 'light'
            {
             before(grammarAccess.getLightStatementAccess().getLightKeyword_1()); 
            match(input,106,FOLLOW_2); 
             after(grammarAccess.getLightStatementAccess().getLightKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__1__Impl"


    // $ANTLR start "rule__LightStatement__Group__2"
    // InternalRailSL.g:2542:1: rule__LightStatement__Group__2 : rule__LightStatement__Group__2__Impl rule__LightStatement__Group__3 ;
    public final void rule__LightStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2546:1: ( rule__LightStatement__Group__2__Impl rule__LightStatement__Group__3 )
            // InternalRailSL.g:2547:2: rule__LightStatement__Group__2__Impl rule__LightStatement__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__LightStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LightStatement__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__2"


    // $ANTLR start "rule__LightStatement__Group__2__Impl"
    // InternalRailSL.g:2554:1: rule__LightStatement__Group__2__Impl : ( ( rule__LightStatement__LightsAssignment_2 ) ) ;
    public final void rule__LightStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2558:1: ( ( ( rule__LightStatement__LightsAssignment_2 ) ) )
            // InternalRailSL.g:2559:1: ( ( rule__LightStatement__LightsAssignment_2 ) )
            {
            // InternalRailSL.g:2559:1: ( ( rule__LightStatement__LightsAssignment_2 ) )
            // InternalRailSL.g:2560:2: ( rule__LightStatement__LightsAssignment_2 )
            {
             before(grammarAccess.getLightStatementAccess().getLightsAssignment_2()); 
            // InternalRailSL.g:2561:2: ( rule__LightStatement__LightsAssignment_2 )
            // InternalRailSL.g:2561:3: rule__LightStatement__LightsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LightStatement__LightsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLightStatementAccess().getLightsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__2__Impl"


    // $ANTLR start "rule__LightStatement__Group__3"
    // InternalRailSL.g:2569:1: rule__LightStatement__Group__3 : rule__LightStatement__Group__3__Impl rule__LightStatement__Group__4 ;
    public final void rule__LightStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2573:1: ( rule__LightStatement__Group__3__Impl rule__LightStatement__Group__4 )
            // InternalRailSL.g:2574:2: rule__LightStatement__Group__3__Impl rule__LightStatement__Group__4
            {
            pushFollow(FOLLOW_24);
            rule__LightStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LightStatement__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__3"


    // $ANTLR start "rule__LightStatement__Group__3__Impl"
    // InternalRailSL.g:2581:1: rule__LightStatement__Group__3__Impl : ( ( rule__LightStatement__Group_3__0 )* ) ;
    public final void rule__LightStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2585:1: ( ( ( rule__LightStatement__Group_3__0 )* ) )
            // InternalRailSL.g:2586:1: ( ( rule__LightStatement__Group_3__0 )* )
            {
            // InternalRailSL.g:2586:1: ( ( rule__LightStatement__Group_3__0 )* )
            // InternalRailSL.g:2587:2: ( rule__LightStatement__Group_3__0 )*
            {
             before(grammarAccess.getLightStatementAccess().getGroup_3()); 
            // InternalRailSL.g:2588:2: ( rule__LightStatement__Group_3__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=16 && LA31_0<=17)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalRailSL.g:2588:3: rule__LightStatement__Group_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__LightStatement__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getLightStatementAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__3__Impl"


    // $ANTLR start "rule__LightStatement__Group__4"
    // InternalRailSL.g:2596:1: rule__LightStatement__Group__4 : rule__LightStatement__Group__4__Impl rule__LightStatement__Group__5 ;
    public final void rule__LightStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2600:1: ( rule__LightStatement__Group__4__Impl rule__LightStatement__Group__5 )
            // InternalRailSL.g:2601:2: rule__LightStatement__Group__4__Impl rule__LightStatement__Group__5
            {
            pushFollow(FOLLOW_11);
            rule__LightStatement__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LightStatement__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__4"


    // $ANTLR start "rule__LightStatement__Group__4__Impl"
    // InternalRailSL.g:2608:1: rule__LightStatement__Group__4__Impl : ( ( rule__LightStatement__StateAssignment_4 ) ) ;
    public final void rule__LightStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2612:1: ( ( ( rule__LightStatement__StateAssignment_4 ) ) )
            // InternalRailSL.g:2613:1: ( ( rule__LightStatement__StateAssignment_4 ) )
            {
            // InternalRailSL.g:2613:1: ( ( rule__LightStatement__StateAssignment_4 ) )
            // InternalRailSL.g:2614:2: ( rule__LightStatement__StateAssignment_4 )
            {
             before(grammarAccess.getLightStatementAccess().getStateAssignment_4()); 
            // InternalRailSL.g:2615:2: ( rule__LightStatement__StateAssignment_4 )
            // InternalRailSL.g:2615:3: rule__LightStatement__StateAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__LightStatement__StateAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getLightStatementAccess().getStateAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__4__Impl"


    // $ANTLR start "rule__LightStatement__Group__5"
    // InternalRailSL.g:2623:1: rule__LightStatement__Group__5 : rule__LightStatement__Group__5__Impl ;
    public final void rule__LightStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2627:1: ( rule__LightStatement__Group__5__Impl )
            // InternalRailSL.g:2628:2: rule__LightStatement__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LightStatement__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__5"


    // $ANTLR start "rule__LightStatement__Group__5__Impl"
    // InternalRailSL.g:2634:1: rule__LightStatement__Group__5__Impl : ( '.' ) ;
    public final void rule__LightStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2638:1: ( ( '.' ) )
            // InternalRailSL.g:2639:1: ( '.' )
            {
            // InternalRailSL.g:2639:1: ( '.' )
            // InternalRailSL.g:2640:2: '.'
            {
             before(grammarAccess.getLightStatementAccess().getFullStopKeyword_5()); 
            match(input,99,FOLLOW_2); 
             after(grammarAccess.getLightStatementAccess().getFullStopKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group__5__Impl"


    // $ANTLR start "rule__LightStatement__Group_3__0"
    // InternalRailSL.g:2650:1: rule__LightStatement__Group_3__0 : rule__LightStatement__Group_3__0__Impl rule__LightStatement__Group_3__1 ;
    public final void rule__LightStatement__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2654:1: ( rule__LightStatement__Group_3__0__Impl rule__LightStatement__Group_3__1 )
            // InternalRailSL.g:2655:2: rule__LightStatement__Group_3__0__Impl rule__LightStatement__Group_3__1
            {
            pushFollow(FOLLOW_15);
            rule__LightStatement__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LightStatement__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group_3__0"


    // $ANTLR start "rule__LightStatement__Group_3__0__Impl"
    // InternalRailSL.g:2662:1: rule__LightStatement__Group_3__0__Impl : ( ( rule__LightStatement__Alternatives_3_0 ) ) ;
    public final void rule__LightStatement__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2666:1: ( ( ( rule__LightStatement__Alternatives_3_0 ) ) )
            // InternalRailSL.g:2667:1: ( ( rule__LightStatement__Alternatives_3_0 ) )
            {
            // InternalRailSL.g:2667:1: ( ( rule__LightStatement__Alternatives_3_0 ) )
            // InternalRailSL.g:2668:2: ( rule__LightStatement__Alternatives_3_0 )
            {
             before(grammarAccess.getLightStatementAccess().getAlternatives_3_0()); 
            // InternalRailSL.g:2669:2: ( rule__LightStatement__Alternatives_3_0 )
            // InternalRailSL.g:2669:3: rule__LightStatement__Alternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__LightStatement__Alternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getLightStatementAccess().getAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group_3__0__Impl"


    // $ANTLR start "rule__LightStatement__Group_3__1"
    // InternalRailSL.g:2677:1: rule__LightStatement__Group_3__1 : rule__LightStatement__Group_3__1__Impl ;
    public final void rule__LightStatement__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2681:1: ( rule__LightStatement__Group_3__1__Impl )
            // InternalRailSL.g:2682:2: rule__LightStatement__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LightStatement__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group_3__1"


    // $ANTLR start "rule__LightStatement__Group_3__1__Impl"
    // InternalRailSL.g:2688:1: rule__LightStatement__Group_3__1__Impl : ( ( rule__LightStatement__LightsAssignment_3_1 ) ) ;
    public final void rule__LightStatement__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2692:1: ( ( ( rule__LightStatement__LightsAssignment_3_1 ) ) )
            // InternalRailSL.g:2693:1: ( ( rule__LightStatement__LightsAssignment_3_1 ) )
            {
            // InternalRailSL.g:2693:1: ( ( rule__LightStatement__LightsAssignment_3_1 ) )
            // InternalRailSL.g:2694:2: ( rule__LightStatement__LightsAssignment_3_1 )
            {
             before(grammarAccess.getLightStatementAccess().getLightsAssignment_3_1()); 
            // InternalRailSL.g:2695:2: ( rule__LightStatement__LightsAssignment_3_1 )
            // InternalRailSL.g:2695:3: rule__LightStatement__LightsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__LightStatement__LightsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getLightStatementAccess().getLightsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group_3__1__Impl"


    // $ANTLR start "rule__LightStatement__Group_3_0_2__0"
    // InternalRailSL.g:2704:1: rule__LightStatement__Group_3_0_2__0 : rule__LightStatement__Group_3_0_2__0__Impl rule__LightStatement__Group_3_0_2__1 ;
    public final void rule__LightStatement__Group_3_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2708:1: ( rule__LightStatement__Group_3_0_2__0__Impl rule__LightStatement__Group_3_0_2__1 )
            // InternalRailSL.g:2709:2: rule__LightStatement__Group_3_0_2__0__Impl rule__LightStatement__Group_3_0_2__1
            {
            pushFollow(FOLLOW_12);
            rule__LightStatement__Group_3_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LightStatement__Group_3_0_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group_3_0_2__0"


    // $ANTLR start "rule__LightStatement__Group_3_0_2__0__Impl"
    // InternalRailSL.g:2716:1: rule__LightStatement__Group_3_0_2__0__Impl : ( ',' ) ;
    public final void rule__LightStatement__Group_3_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2720:1: ( ( ',' ) )
            // InternalRailSL.g:2721:1: ( ',' )
            {
            // InternalRailSL.g:2721:1: ( ',' )
            // InternalRailSL.g:2722:2: ','
            {
             before(grammarAccess.getLightStatementAccess().getCommaKeyword_3_0_2_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getLightStatementAccess().getCommaKeyword_3_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group_3_0_2__0__Impl"


    // $ANTLR start "rule__LightStatement__Group_3_0_2__1"
    // InternalRailSL.g:2731:1: rule__LightStatement__Group_3_0_2__1 : rule__LightStatement__Group_3_0_2__1__Impl ;
    public final void rule__LightStatement__Group_3_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2735:1: ( rule__LightStatement__Group_3_0_2__1__Impl )
            // InternalRailSL.g:2736:2: rule__LightStatement__Group_3_0_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LightStatement__Group_3_0_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group_3_0_2__1"


    // $ANTLR start "rule__LightStatement__Group_3_0_2__1__Impl"
    // InternalRailSL.g:2742:1: rule__LightStatement__Group_3_0_2__1__Impl : ( 'and' ) ;
    public final void rule__LightStatement__Group_3_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2746:1: ( ( 'and' ) )
            // InternalRailSL.g:2747:1: ( 'and' )
            {
            // InternalRailSL.g:2747:1: ( 'and' )
            // InternalRailSL.g:2748:2: 'and'
            {
             before(grammarAccess.getLightStatementAccess().getAndKeyword_3_0_2_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getLightStatementAccess().getAndKeyword_3_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__Group_3_0_2__1__Impl"


    // $ANTLR start "rule__ConditionalStatement__Group__0"
    // InternalRailSL.g:2758:1: rule__ConditionalStatement__Group__0 : rule__ConditionalStatement__Group__0__Impl rule__ConditionalStatement__Group__1 ;
    public final void rule__ConditionalStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2762:1: ( rule__ConditionalStatement__Group__0__Impl rule__ConditionalStatement__Group__1 )
            // InternalRailSL.g:2763:2: rule__ConditionalStatement__Group__0__Impl rule__ConditionalStatement__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__ConditionalStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalStatement__Group__0"


    // $ANTLR start "rule__ConditionalStatement__Group__0__Impl"
    // InternalRailSL.g:2770:1: rule__ConditionalStatement__Group__0__Impl : ( ( rule__ConditionalStatement__Alternatives_0 ) ) ;
    public final void rule__ConditionalStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2774:1: ( ( ( rule__ConditionalStatement__Alternatives_0 ) ) )
            // InternalRailSL.g:2775:1: ( ( rule__ConditionalStatement__Alternatives_0 ) )
            {
            // InternalRailSL.g:2775:1: ( ( rule__ConditionalStatement__Alternatives_0 ) )
            // InternalRailSL.g:2776:2: ( rule__ConditionalStatement__Alternatives_0 )
            {
             before(grammarAccess.getConditionalStatementAccess().getAlternatives_0()); 
            // InternalRailSL.g:2777:2: ( rule__ConditionalStatement__Alternatives_0 )
            // InternalRailSL.g:2777:3: rule__ConditionalStatement__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalStatement__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getConditionalStatementAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalStatement__Group__0__Impl"


    // $ANTLR start "rule__ConditionalStatement__Group__1"
    // InternalRailSL.g:2785:1: rule__ConditionalStatement__Group__1 : rule__ConditionalStatement__Group__1__Impl rule__ConditionalStatement__Group__2 ;
    public final void rule__ConditionalStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2789:1: ( rule__ConditionalStatement__Group__1__Impl rule__ConditionalStatement__Group__2 )
            // InternalRailSL.g:2790:2: rule__ConditionalStatement__Group__1__Impl rule__ConditionalStatement__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__ConditionalStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalStatement__Group__1"


    // $ANTLR start "rule__ConditionalStatement__Group__1__Impl"
    // InternalRailSL.g:2797:1: rule__ConditionalStatement__Group__1__Impl : ( ( rule__ConditionalStatement__LinesAssignment_1 ) ) ;
    public final void rule__ConditionalStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2801:1: ( ( ( rule__ConditionalStatement__LinesAssignment_1 ) ) )
            // InternalRailSL.g:2802:1: ( ( rule__ConditionalStatement__LinesAssignment_1 ) )
            {
            // InternalRailSL.g:2802:1: ( ( rule__ConditionalStatement__LinesAssignment_1 ) )
            // InternalRailSL.g:2803:2: ( rule__ConditionalStatement__LinesAssignment_1 )
            {
             before(grammarAccess.getConditionalStatementAccess().getLinesAssignment_1()); 
            // InternalRailSL.g:2804:2: ( rule__ConditionalStatement__LinesAssignment_1 )
            // InternalRailSL.g:2804:3: rule__ConditionalStatement__LinesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalStatement__LinesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConditionalStatementAccess().getLinesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalStatement__Group__1__Impl"


    // $ANTLR start "rule__ConditionalStatement__Group__2"
    // InternalRailSL.g:2812:1: rule__ConditionalStatement__Group__2 : rule__ConditionalStatement__Group__2__Impl ;
    public final void rule__ConditionalStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2816:1: ( rule__ConditionalStatement__Group__2__Impl )
            // InternalRailSL.g:2817:2: rule__ConditionalStatement__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalStatement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalStatement__Group__2"


    // $ANTLR start "rule__ConditionalStatement__Group__2__Impl"
    // InternalRailSL.g:2823:1: rule__ConditionalStatement__Group__2__Impl : ( ( ( rule__ConditionalStatement__LinesAssignment_2 ) ) ( ( rule__ConditionalStatement__LinesAssignment_2 )* ) ) ;
    public final void rule__ConditionalStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2827:1: ( ( ( ( rule__ConditionalStatement__LinesAssignment_2 ) ) ( ( rule__ConditionalStatement__LinesAssignment_2 )* ) ) )
            // InternalRailSL.g:2828:1: ( ( ( rule__ConditionalStatement__LinesAssignment_2 ) ) ( ( rule__ConditionalStatement__LinesAssignment_2 )* ) )
            {
            // InternalRailSL.g:2828:1: ( ( ( rule__ConditionalStatement__LinesAssignment_2 ) ) ( ( rule__ConditionalStatement__LinesAssignment_2 )* ) )
            // InternalRailSL.g:2829:2: ( ( rule__ConditionalStatement__LinesAssignment_2 ) ) ( ( rule__ConditionalStatement__LinesAssignment_2 )* )
            {
            // InternalRailSL.g:2829:2: ( ( rule__ConditionalStatement__LinesAssignment_2 ) )
            // InternalRailSL.g:2830:3: ( rule__ConditionalStatement__LinesAssignment_2 )
            {
             before(grammarAccess.getConditionalStatementAccess().getLinesAssignment_2()); 
            // InternalRailSL.g:2831:3: ( rule__ConditionalStatement__LinesAssignment_2 )
            // InternalRailSL.g:2831:4: rule__ConditionalStatement__LinesAssignment_2
            {
            pushFollow(FOLLOW_26);
            rule__ConditionalStatement__LinesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConditionalStatementAccess().getLinesAssignment_2()); 

            }

            // InternalRailSL.g:2834:2: ( ( rule__ConditionalStatement__LinesAssignment_2 )* )
            // InternalRailSL.g:2835:3: ( rule__ConditionalStatement__LinesAssignment_2 )*
            {
             before(grammarAccess.getConditionalStatementAccess().getLinesAssignment_2()); 
            // InternalRailSL.g:2836:3: ( rule__ConditionalStatement__LinesAssignment_2 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=26 && LA32_0<=27)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalRailSL.g:2836:4: rule__ConditionalStatement__LinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__ConditionalStatement__LinesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getConditionalStatementAccess().getLinesAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalStatement__Group__2__Impl"


    // $ANTLR start "rule__ConditionalLine__Group__0"
    // InternalRailSL.g:2846:1: rule__ConditionalLine__Group__0 : rule__ConditionalLine__Group__0__Impl rule__ConditionalLine__Group__1 ;
    public final void rule__ConditionalLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2850:1: ( rule__ConditionalLine__Group__0__Impl rule__ConditionalLine__Group__1 )
            // InternalRailSL.g:2851:2: rule__ConditionalLine__Group__0__Impl rule__ConditionalLine__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__ConditionalLine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__0"


    // $ANTLR start "rule__ConditionalLine__Group__0__Impl"
    // InternalRailSL.g:2858:1: rule__ConditionalLine__Group__0__Impl : ( ( rule__ConditionalLine__Alternatives_0 ) ) ;
    public final void rule__ConditionalLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2862:1: ( ( ( rule__ConditionalLine__Alternatives_0 ) ) )
            // InternalRailSL.g:2863:1: ( ( rule__ConditionalLine__Alternatives_0 ) )
            {
            // InternalRailSL.g:2863:1: ( ( rule__ConditionalLine__Alternatives_0 ) )
            // InternalRailSL.g:2864:2: ( rule__ConditionalLine__Alternatives_0 )
            {
             before(grammarAccess.getConditionalLineAccess().getAlternatives_0()); 
            // InternalRailSL.g:2865:2: ( rule__ConditionalLine__Alternatives_0 )
            // InternalRailSL.g:2865:3: rule__ConditionalLine__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getConditionalLineAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__0__Impl"


    // $ANTLR start "rule__ConditionalLine__Group__1"
    // InternalRailSL.g:2873:1: rule__ConditionalLine__Group__1 : rule__ConditionalLine__Group__1__Impl rule__ConditionalLine__Group__2 ;
    public final void rule__ConditionalLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2877:1: ( rule__ConditionalLine__Group__1__Impl rule__ConditionalLine__Group__2 )
            // InternalRailSL.g:2878:2: rule__ConditionalLine__Group__1__Impl rule__ConditionalLine__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__ConditionalLine__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__1"


    // $ANTLR start "rule__ConditionalLine__Group__1__Impl"
    // InternalRailSL.g:2885:1: rule__ConditionalLine__Group__1__Impl : ( ( rule__ConditionalLine__ContactAssignment_1 ) ) ;
    public final void rule__ConditionalLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2889:1: ( ( ( rule__ConditionalLine__ContactAssignment_1 ) ) )
            // InternalRailSL.g:2890:1: ( ( rule__ConditionalLine__ContactAssignment_1 ) )
            {
            // InternalRailSL.g:2890:1: ( ( rule__ConditionalLine__ContactAssignment_1 ) )
            // InternalRailSL.g:2891:2: ( rule__ConditionalLine__ContactAssignment_1 )
            {
             before(grammarAccess.getConditionalLineAccess().getContactAssignment_1()); 
            // InternalRailSL.g:2892:2: ( rule__ConditionalLine__ContactAssignment_1 )
            // InternalRailSL.g:2892:3: rule__ConditionalLine__ContactAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalLine__ContactAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConditionalLineAccess().getContactAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__1__Impl"


    // $ANTLR start "rule__ConditionalLine__Group__2"
    // InternalRailSL.g:2900:1: rule__ConditionalLine__Group__2 : rule__ConditionalLine__Group__2__Impl rule__ConditionalLine__Group__3 ;
    public final void rule__ConditionalLine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2904:1: ( rule__ConditionalLine__Group__2__Impl rule__ConditionalLine__Group__3 )
            // InternalRailSL.g:2905:2: rule__ConditionalLine__Group__2__Impl rule__ConditionalLine__Group__3
            {
            pushFollow(FOLLOW_27);
            rule__ConditionalLine__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__2"


    // $ANTLR start "rule__ConditionalLine__Group__2__Impl"
    // InternalRailSL.g:2912:1: rule__ConditionalLine__Group__2__Impl : ( 'contact' ) ;
    public final void rule__ConditionalLine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2916:1: ( ( 'contact' ) )
            // InternalRailSL.g:2917:1: ( 'contact' )
            {
            // InternalRailSL.g:2917:1: ( 'contact' )
            // InternalRailSL.g:2918:2: 'contact'
            {
             before(grammarAccess.getConditionalLineAccess().getContactKeyword_2()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getConditionalLineAccess().getContactKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__2__Impl"


    // $ANTLR start "rule__ConditionalLine__Group__3"
    // InternalRailSL.g:2927:1: rule__ConditionalLine__Group__3 : rule__ConditionalLine__Group__3__Impl rule__ConditionalLine__Group__4 ;
    public final void rule__ConditionalLine__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2931:1: ( rule__ConditionalLine__Group__3__Impl rule__ConditionalLine__Group__4 )
            // InternalRailSL.g:2932:2: rule__ConditionalLine__Group__3__Impl rule__ConditionalLine__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__ConditionalLine__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__3"


    // $ANTLR start "rule__ConditionalLine__Group__3__Impl"
    // InternalRailSL.g:2939:1: rule__ConditionalLine__Group__3__Impl : ( 'of' ) ;
    public final void rule__ConditionalLine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2943:1: ( ( 'of' ) )
            // InternalRailSL.g:2944:1: ( 'of' )
            {
            // InternalRailSL.g:2944:1: ( 'of' )
            // InternalRailSL.g:2945:2: 'of'
            {
             before(grammarAccess.getConditionalLineAccess().getOfKeyword_3()); 
            match(input,104,FOLLOW_2); 
             after(grammarAccess.getConditionalLineAccess().getOfKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__3__Impl"


    // $ANTLR start "rule__ConditionalLine__Group__4"
    // InternalRailSL.g:2954:1: rule__ConditionalLine__Group__4 : rule__ConditionalLine__Group__4__Impl rule__ConditionalLine__Group__5 ;
    public final void rule__ConditionalLine__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2958:1: ( rule__ConditionalLine__Group__4__Impl rule__ConditionalLine__Group__5 )
            // InternalRailSL.g:2959:2: rule__ConditionalLine__Group__4__Impl rule__ConditionalLine__Group__5
            {
            pushFollow(FOLLOW_28);
            rule__ConditionalLine__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__4"


    // $ANTLR start "rule__ConditionalLine__Group__4__Impl"
    // InternalRailSL.g:2966:1: rule__ConditionalLine__Group__4__Impl : ( ( rule__ConditionalLine__SegmentAssignment_4 ) ) ;
    public final void rule__ConditionalLine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2970:1: ( ( ( rule__ConditionalLine__SegmentAssignment_4 ) ) )
            // InternalRailSL.g:2971:1: ( ( rule__ConditionalLine__SegmentAssignment_4 ) )
            {
            // InternalRailSL.g:2971:1: ( ( rule__ConditionalLine__SegmentAssignment_4 ) )
            // InternalRailSL.g:2972:2: ( rule__ConditionalLine__SegmentAssignment_4 )
            {
             before(grammarAccess.getConditionalLineAccess().getSegmentAssignment_4()); 
            // InternalRailSL.g:2973:2: ( rule__ConditionalLine__SegmentAssignment_4 )
            // InternalRailSL.g:2973:3: rule__ConditionalLine__SegmentAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalLine__SegmentAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConditionalLineAccess().getSegmentAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__4__Impl"


    // $ANTLR start "rule__ConditionalLine__Group__5"
    // InternalRailSL.g:2981:1: rule__ConditionalLine__Group__5 : rule__ConditionalLine__Group__5__Impl rule__ConditionalLine__Group__6 ;
    public final void rule__ConditionalLine__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2985:1: ( rule__ConditionalLine__Group__5__Impl rule__ConditionalLine__Group__6 )
            // InternalRailSL.g:2986:2: rule__ConditionalLine__Group__5__Impl rule__ConditionalLine__Group__6
            {
            pushFollow(FOLLOW_29);
            rule__ConditionalLine__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__5"


    // $ANTLR start "rule__ConditionalLine__Group__5__Impl"
    // InternalRailSL.g:2993:1: rule__ConditionalLine__Group__5__Impl : ( 'is' ) ;
    public final void rule__ConditionalLine__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:2997:1: ( ( 'is' ) )
            // InternalRailSL.g:2998:1: ( 'is' )
            {
            // InternalRailSL.g:2998:1: ( 'is' )
            // InternalRailSL.g:2999:2: 'is'
            {
             before(grammarAccess.getConditionalLineAccess().getIsKeyword_5()); 
            match(input,107,FOLLOW_2); 
             after(grammarAccess.getConditionalLineAccess().getIsKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__5__Impl"


    // $ANTLR start "rule__ConditionalLine__Group__6"
    // InternalRailSL.g:3008:1: rule__ConditionalLine__Group__6 : rule__ConditionalLine__Group__6__Impl rule__ConditionalLine__Group__7 ;
    public final void rule__ConditionalLine__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3012:1: ( rule__ConditionalLine__Group__6__Impl rule__ConditionalLine__Group__7 )
            // InternalRailSL.g:3013:2: rule__ConditionalLine__Group__6__Impl rule__ConditionalLine__Group__7
            {
            pushFollow(FOLLOW_30);
            rule__ConditionalLine__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__6"


    // $ANTLR start "rule__ConditionalLine__Group__6__Impl"
    // InternalRailSL.g:3020:1: rule__ConditionalLine__Group__6__Impl : ( 'reached' ) ;
    public final void rule__ConditionalLine__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3024:1: ( ( 'reached' ) )
            // InternalRailSL.g:3025:1: ( 'reached' )
            {
            // InternalRailSL.g:3025:1: ( 'reached' )
            // InternalRailSL.g:3026:2: 'reached'
            {
             before(grammarAccess.getConditionalLineAccess().getReachedKeyword_6()); 
            match(input,108,FOLLOW_2); 
             after(grammarAccess.getConditionalLineAccess().getReachedKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__6__Impl"


    // $ANTLR start "rule__ConditionalLine__Group__7"
    // InternalRailSL.g:3035:1: rule__ConditionalLine__Group__7 : rule__ConditionalLine__Group__7__Impl rule__ConditionalLine__Group__8 ;
    public final void rule__ConditionalLine__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3039:1: ( rule__ConditionalLine__Group__7__Impl rule__ConditionalLine__Group__8 )
            // InternalRailSL.g:3040:2: rule__ConditionalLine__Group__7__Impl rule__ConditionalLine__Group__8
            {
            pushFollow(FOLLOW_31);
            rule__ConditionalLine__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__7"


    // $ANTLR start "rule__ConditionalLine__Group__7__Impl"
    // InternalRailSL.g:3047:1: rule__ConditionalLine__Group__7__Impl : ( ( rule__ConditionalLine__Alternatives_7 ) ) ;
    public final void rule__ConditionalLine__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3051:1: ( ( ( rule__ConditionalLine__Alternatives_7 ) ) )
            // InternalRailSL.g:3052:1: ( ( rule__ConditionalLine__Alternatives_7 ) )
            {
            // InternalRailSL.g:3052:1: ( ( rule__ConditionalLine__Alternatives_7 ) )
            // InternalRailSL.g:3053:2: ( rule__ConditionalLine__Alternatives_7 )
            {
             before(grammarAccess.getConditionalLineAccess().getAlternatives_7()); 
            // InternalRailSL.g:3054:2: ( rule__ConditionalLine__Alternatives_7 )
            // InternalRailSL.g:3054:3: rule__ConditionalLine__Alternatives_7
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Alternatives_7();

            state._fsp--;


            }

             after(grammarAccess.getConditionalLineAccess().getAlternatives_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__7__Impl"


    // $ANTLR start "rule__ConditionalLine__Group__8"
    // InternalRailSL.g:3062:1: rule__ConditionalLine__Group__8 : rule__ConditionalLine__Group__8__Impl rule__ConditionalLine__Group__9 ;
    public final void rule__ConditionalLine__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3066:1: ( rule__ConditionalLine__Group__8__Impl rule__ConditionalLine__Group__9 )
            // InternalRailSL.g:3067:2: rule__ConditionalLine__Group__8__Impl rule__ConditionalLine__Group__9
            {
            pushFollow(FOLLOW_32);
            rule__ConditionalLine__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__8"


    // $ANTLR start "rule__ConditionalLine__Group__8__Impl"
    // InternalRailSL.g:3074:1: rule__ConditionalLine__Group__8__Impl : ( 'do' ) ;
    public final void rule__ConditionalLine__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3078:1: ( ( 'do' ) )
            // InternalRailSL.g:3079:1: ( 'do' )
            {
            // InternalRailSL.g:3079:1: ( 'do' )
            // InternalRailSL.g:3080:2: 'do'
            {
             before(grammarAccess.getConditionalLineAccess().getDoKeyword_8()); 
            match(input,109,FOLLOW_2); 
             after(grammarAccess.getConditionalLineAccess().getDoKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__8__Impl"


    // $ANTLR start "rule__ConditionalLine__Group__9"
    // InternalRailSL.g:3089:1: rule__ConditionalLine__Group__9 : rule__ConditionalLine__Group__9__Impl ;
    public final void rule__ConditionalLine__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3093:1: ( rule__ConditionalLine__Group__9__Impl )
            // InternalRailSL.g:3094:2: rule__ConditionalLine__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalLine__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__9"


    // $ANTLR start "rule__ConditionalLine__Group__9__Impl"
    // InternalRailSL.g:3100:1: rule__ConditionalLine__Group__9__Impl : ( ( rule__ConditionalLine__BlockAssignment_9 ) ) ;
    public final void rule__ConditionalLine__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3104:1: ( ( ( rule__ConditionalLine__BlockAssignment_9 ) ) )
            // InternalRailSL.g:3105:1: ( ( rule__ConditionalLine__BlockAssignment_9 ) )
            {
            // InternalRailSL.g:3105:1: ( ( rule__ConditionalLine__BlockAssignment_9 ) )
            // InternalRailSL.g:3106:2: ( rule__ConditionalLine__BlockAssignment_9 )
            {
             before(grammarAccess.getConditionalLineAccess().getBlockAssignment_9()); 
            // InternalRailSL.g:3107:2: ( rule__ConditionalLine__BlockAssignment_9 )
            // InternalRailSL.g:3107:3: rule__ConditionalLine__BlockAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__ConditionalLine__BlockAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getConditionalLineAccess().getBlockAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__Group__9__Impl"


    // $ANTLR start "rule__ParallelStatement__Group__0"
    // InternalRailSL.g:3116:1: rule__ParallelStatement__Group__0 : rule__ParallelStatement__Group__0__Impl rule__ParallelStatement__Group__1 ;
    public final void rule__ParallelStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3120:1: ( rule__ParallelStatement__Group__0__Impl rule__ParallelStatement__Group__1 )
            // InternalRailSL.g:3121:2: rule__ParallelStatement__Group__0__Impl rule__ParallelStatement__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__ParallelStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParallelStatement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParallelStatement__Group__0"


    // $ANTLR start "rule__ParallelStatement__Group__0__Impl"
    // InternalRailSL.g:3128:1: rule__ParallelStatement__Group__0__Impl : ( ( rule__ParallelStatement__Alternatives_0 ) ) ;
    public final void rule__ParallelStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3132:1: ( ( ( rule__ParallelStatement__Alternatives_0 ) ) )
            // InternalRailSL.g:3133:1: ( ( rule__ParallelStatement__Alternatives_0 ) )
            {
            // InternalRailSL.g:3133:1: ( ( rule__ParallelStatement__Alternatives_0 ) )
            // InternalRailSL.g:3134:2: ( rule__ParallelStatement__Alternatives_0 )
            {
             before(grammarAccess.getParallelStatementAccess().getAlternatives_0()); 
            // InternalRailSL.g:3135:2: ( rule__ParallelStatement__Alternatives_0 )
            // InternalRailSL.g:3135:3: rule__ParallelStatement__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ParallelStatement__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getParallelStatementAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParallelStatement__Group__0__Impl"


    // $ANTLR start "rule__ParallelStatement__Group__1"
    // InternalRailSL.g:3143:1: rule__ParallelStatement__Group__1 : rule__ParallelStatement__Group__1__Impl rule__ParallelStatement__Group__2 ;
    public final void rule__ParallelStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3147:1: ( rule__ParallelStatement__Group__1__Impl rule__ParallelStatement__Group__2 )
            // InternalRailSL.g:3148:2: rule__ParallelStatement__Group__1__Impl rule__ParallelStatement__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__ParallelStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParallelStatement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParallelStatement__Group__1"


    // $ANTLR start "rule__ParallelStatement__Group__1__Impl"
    // InternalRailSL.g:3155:1: rule__ParallelStatement__Group__1__Impl : ( ( rule__ParallelStatement__BlocksAssignment_1 ) ) ;
    public final void rule__ParallelStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3159:1: ( ( ( rule__ParallelStatement__BlocksAssignment_1 ) ) )
            // InternalRailSL.g:3160:1: ( ( rule__ParallelStatement__BlocksAssignment_1 ) )
            {
            // InternalRailSL.g:3160:1: ( ( rule__ParallelStatement__BlocksAssignment_1 ) )
            // InternalRailSL.g:3161:2: ( rule__ParallelStatement__BlocksAssignment_1 )
            {
             before(grammarAccess.getParallelStatementAccess().getBlocksAssignment_1()); 
            // InternalRailSL.g:3162:2: ( rule__ParallelStatement__BlocksAssignment_1 )
            // InternalRailSL.g:3162:3: rule__ParallelStatement__BlocksAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParallelStatement__BlocksAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParallelStatementAccess().getBlocksAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParallelStatement__Group__1__Impl"


    // $ANTLR start "rule__ParallelStatement__Group__2"
    // InternalRailSL.g:3170:1: rule__ParallelStatement__Group__2 : rule__ParallelStatement__Group__2__Impl ;
    public final void rule__ParallelStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3174:1: ( rule__ParallelStatement__Group__2__Impl )
            // InternalRailSL.g:3175:2: rule__ParallelStatement__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParallelStatement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParallelStatement__Group__2"


    // $ANTLR start "rule__ParallelStatement__Group__2__Impl"
    // InternalRailSL.g:3181:1: rule__ParallelStatement__Group__2__Impl : ( ( ( rule__ParallelStatement__BlocksAssignment_2 ) ) ( ( rule__ParallelStatement__BlocksAssignment_2 )* ) ) ;
    public final void rule__ParallelStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3185:1: ( ( ( ( rule__ParallelStatement__BlocksAssignment_2 ) ) ( ( rule__ParallelStatement__BlocksAssignment_2 )* ) ) )
            // InternalRailSL.g:3186:1: ( ( ( rule__ParallelStatement__BlocksAssignment_2 ) ) ( ( rule__ParallelStatement__BlocksAssignment_2 )* ) )
            {
            // InternalRailSL.g:3186:1: ( ( ( rule__ParallelStatement__BlocksAssignment_2 ) ) ( ( rule__ParallelStatement__BlocksAssignment_2 )* ) )
            // InternalRailSL.g:3187:2: ( ( rule__ParallelStatement__BlocksAssignment_2 ) ) ( ( rule__ParallelStatement__BlocksAssignment_2 )* )
            {
            // InternalRailSL.g:3187:2: ( ( rule__ParallelStatement__BlocksAssignment_2 ) )
            // InternalRailSL.g:3188:3: ( rule__ParallelStatement__BlocksAssignment_2 )
            {
             before(grammarAccess.getParallelStatementAccess().getBlocksAssignment_2()); 
            // InternalRailSL.g:3189:3: ( rule__ParallelStatement__BlocksAssignment_2 )
            // InternalRailSL.g:3189:4: rule__ParallelStatement__BlocksAssignment_2
            {
            pushFollow(FOLLOW_33);
            rule__ParallelStatement__BlocksAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getParallelStatementAccess().getBlocksAssignment_2()); 

            }

            // InternalRailSL.g:3192:2: ( ( rule__ParallelStatement__BlocksAssignment_2 )* )
            // InternalRailSL.g:3193:3: ( rule__ParallelStatement__BlocksAssignment_2 )*
            {
             before(grammarAccess.getParallelStatementAccess().getBlocksAssignment_2()); 
            // InternalRailSL.g:3194:3: ( rule__ParallelStatement__BlocksAssignment_2 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=12 && LA33_0<=13)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalRailSL.g:3194:4: rule__ParallelStatement__BlocksAssignment_2
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__ParallelStatement__BlocksAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getParallelStatementAccess().getBlocksAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParallelStatement__Group__2__Impl"


    // $ANTLR start "rule__RailProgram__BlockAssignment"
    // InternalRailSL.g:3204:1: rule__RailProgram__BlockAssignment : ( ruleBlock ) ;
    public final void rule__RailProgram__BlockAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3208:1: ( ( ruleBlock ) )
            // InternalRailSL.g:3209:2: ( ruleBlock )
            {
            // InternalRailSL.g:3209:2: ( ruleBlock )
            // InternalRailSL.g:3210:3: ruleBlock
            {
             before(grammarAccess.getRailProgramAccess().getBlockBlockParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getRailProgramAccess().getBlockBlockParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RailProgram__BlockAssignment"


    // $ANTLR start "rule__Block__StatementsAssignment_1"
    // InternalRailSL.g:3219:1: rule__Block__StatementsAssignment_1 : ( ruleStatement ) ;
    public final void rule__Block__StatementsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3223:1: ( ( ruleStatement ) )
            // InternalRailSL.g:3224:2: ( ruleStatement )
            {
            // InternalRailSL.g:3224:2: ( ruleStatement )
            // InternalRailSL.g:3225:3: ruleStatement
            {
             before(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__StatementsAssignment_1"


    // $ANTLR start "rule__Block__EndAssignment_2"
    // InternalRailSL.g:3234:1: rule__Block__EndAssignment_2 : ( ruleBlockEnd ) ;
    public final void rule__Block__EndAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3238:1: ( ( ruleBlockEnd ) )
            // InternalRailSL.g:3239:2: ( ruleBlockEnd )
            {
            // InternalRailSL.g:3239:2: ( ruleBlockEnd )
            // InternalRailSL.g:3240:3: ruleBlockEnd
            {
             before(grammarAccess.getBlockAccess().getEndBlockEndEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBlockEnd();

            state._fsp--;

             after(grammarAccess.getBlockAccess().getEndBlockEndEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__EndAssignment_2"


    // $ANTLR start "rule__TrackStatement__SegmentsAssignment_2"
    // InternalRailSL.g:3249:1: rule__TrackStatement__SegmentsAssignment_2 : ( ruleRailSegment ) ;
    public final void rule__TrackStatement__SegmentsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3253:1: ( ( ruleRailSegment ) )
            // InternalRailSL.g:3254:2: ( ruleRailSegment )
            {
            // InternalRailSL.g:3254:2: ( ruleRailSegment )
            // InternalRailSL.g:3255:3: ruleRailSegment
            {
             before(grammarAccess.getTrackStatementAccess().getSegmentsRailSegmentEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleRailSegment();

            state._fsp--;

             after(grammarAccess.getTrackStatementAccess().getSegmentsRailSegmentEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__SegmentsAssignment_2"


    // $ANTLR start "rule__TrackStatement__SegmentsAssignment_3_1"
    // InternalRailSL.g:3264:1: rule__TrackStatement__SegmentsAssignment_3_1 : ( ruleRailSegment ) ;
    public final void rule__TrackStatement__SegmentsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3268:1: ( ( ruleRailSegment ) )
            // InternalRailSL.g:3269:2: ( ruleRailSegment )
            {
            // InternalRailSL.g:3269:2: ( ruleRailSegment )
            // InternalRailSL.g:3270:3: ruleRailSegment
            {
             before(grammarAccess.getTrackStatementAccess().getSegmentsRailSegmentEnumRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleRailSegment();

            state._fsp--;

             after(grammarAccess.getTrackStatementAccess().getSegmentsRailSegmentEnumRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__SegmentsAssignment_3_1"


    // $ANTLR start "rule__TrackStatement__SpeedAssignment_5_0"
    // InternalRailSL.g:3279:1: rule__TrackStatement__SpeedAssignment_5_0 : ( ruleTrackSpeedStop ) ;
    public final void rule__TrackStatement__SpeedAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3283:1: ( ( ruleTrackSpeedStop ) )
            // InternalRailSL.g:3284:2: ( ruleTrackSpeedStop )
            {
            // InternalRailSL.g:3284:2: ( ruleTrackSpeedStop )
            // InternalRailSL.g:3285:3: ruleTrackSpeedStop
            {
             before(grammarAccess.getTrackStatementAccess().getSpeedTrackSpeedStopEnumRuleCall_5_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTrackSpeedStop();

            state._fsp--;

             after(grammarAccess.getTrackStatementAccess().getSpeedTrackSpeedStopEnumRuleCall_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__SpeedAssignment_5_0"


    // $ANTLR start "rule__TrackStatement__SpeedAssignment_5_1_0"
    // InternalRailSL.g:3294:1: rule__TrackStatement__SpeedAssignment_5_1_0 : ( ruleTrackSpeedDrive ) ;
    public final void rule__TrackStatement__SpeedAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3298:1: ( ( ruleTrackSpeedDrive ) )
            // InternalRailSL.g:3299:2: ( ruleTrackSpeedDrive )
            {
            // InternalRailSL.g:3299:2: ( ruleTrackSpeedDrive )
            // InternalRailSL.g:3300:3: ruleTrackSpeedDrive
            {
             before(grammarAccess.getTrackStatementAccess().getSpeedTrackSpeedDriveEnumRuleCall_5_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleTrackSpeedDrive();

            state._fsp--;

             after(grammarAccess.getTrackStatementAccess().getSpeedTrackSpeedDriveEnumRuleCall_5_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__SpeedAssignment_5_1_0"


    // $ANTLR start "rule__TrackStatement__ReverseAssignment_5_1_1"
    // InternalRailSL.g:3309:1: rule__TrackStatement__ReverseAssignment_5_1_1 : ( ( 'reverse' ) ) ;
    public final void rule__TrackStatement__ReverseAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3313:1: ( ( ( 'reverse' ) ) )
            // InternalRailSL.g:3314:2: ( ( 'reverse' ) )
            {
            // InternalRailSL.g:3314:2: ( ( 'reverse' ) )
            // InternalRailSL.g:3315:3: ( 'reverse' )
            {
             before(grammarAccess.getTrackStatementAccess().getReverseReverseKeyword_5_1_1_0()); 
            // InternalRailSL.g:3316:3: ( 'reverse' )
            // InternalRailSL.g:3317:4: 'reverse'
            {
             before(grammarAccess.getTrackStatementAccess().getReverseReverseKeyword_5_1_1_0()); 
            match(input,110,FOLLOW_2); 
             after(grammarAccess.getTrackStatementAccess().getReverseReverseKeyword_5_1_1_0()); 

            }

             after(grammarAccess.getTrackStatementAccess().getReverseReverseKeyword_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackStatement__ReverseAssignment_5_1_1"


    // $ANTLR start "rule__PointStatement__PointsAssignment_2"
    // InternalRailSL.g:3328:1: rule__PointStatement__PointsAssignment_2 : ( RULE_INT ) ;
    public final void rule__PointStatement__PointsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3332:1: ( ( RULE_INT ) )
            // InternalRailSL.g:3333:2: ( RULE_INT )
            {
            // InternalRailSL.g:3333:2: ( RULE_INT )
            // InternalRailSL.g:3334:3: RULE_INT
            {
             before(grammarAccess.getPointStatementAccess().getPointsINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPointStatementAccess().getPointsINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__PointsAssignment_2"


    // $ANTLR start "rule__PointStatement__PointsAssignment_3_1"
    // InternalRailSL.g:3343:1: rule__PointStatement__PointsAssignment_3_1 : ( RULE_INT ) ;
    public final void rule__PointStatement__PointsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3347:1: ( ( RULE_INT ) )
            // InternalRailSL.g:3348:2: ( RULE_INT )
            {
            // InternalRailSL.g:3348:2: ( RULE_INT )
            // InternalRailSL.g:3349:3: RULE_INT
            {
             before(grammarAccess.getPointStatementAccess().getPointsINTTerminalRuleCall_3_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPointStatementAccess().getPointsINTTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__PointsAssignment_3_1"


    // $ANTLR start "rule__PointStatement__OrientationAssignment_5"
    // InternalRailSL.g:3358:1: rule__PointStatement__OrientationAssignment_5 : ( rulePointOrinetation ) ;
    public final void rule__PointStatement__OrientationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3362:1: ( ( rulePointOrinetation ) )
            // InternalRailSL.g:3363:2: ( rulePointOrinetation )
            {
            // InternalRailSL.g:3363:2: ( rulePointOrinetation )
            // InternalRailSL.g:3364:3: rulePointOrinetation
            {
             before(grammarAccess.getPointStatementAccess().getOrientationPointOrinetationEnumRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            rulePointOrinetation();

            state._fsp--;

             after(grammarAccess.getPointStatementAccess().getOrientationPointOrinetationEnumRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PointStatement__OrientationAssignment_5"


    // $ANTLR start "rule__TimeWaitStatement__TimeAssignment_2"
    // InternalRailSL.g:3373:1: rule__TimeWaitStatement__TimeAssignment_2 : ( RULE_INT ) ;
    public final void rule__TimeWaitStatement__TimeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3377:1: ( ( RULE_INT ) )
            // InternalRailSL.g:3378:2: ( RULE_INT )
            {
            // InternalRailSL.g:3378:2: ( RULE_INT )
            // InternalRailSL.g:3379:3: RULE_INT
            {
             before(grammarAccess.getTimeWaitStatementAccess().getTimeINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTimeWaitStatementAccess().getTimeINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeWaitStatement__TimeAssignment_2"


    // $ANTLR start "rule__ContactWaitStatement__EventAssignment_0"
    // InternalRailSL.g:3388:1: rule__ContactWaitStatement__EventAssignment_0 : ( ruleContactEvent ) ;
    public final void rule__ContactWaitStatement__EventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3392:1: ( ( ruleContactEvent ) )
            // InternalRailSL.g:3393:2: ( ruleContactEvent )
            {
            // InternalRailSL.g:3393:2: ( ruleContactEvent )
            // InternalRailSL.g:3394:3: ruleContactEvent
            {
             before(grammarAccess.getContactWaitStatementAccess().getEventContactEventEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleContactEvent();

            state._fsp--;

             after(grammarAccess.getContactWaitStatementAccess().getEventContactEventEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__EventAssignment_0"


    // $ANTLR start "rule__ContactWaitStatement__ContactAssignment_1"
    // InternalRailSL.g:3403:1: rule__ContactWaitStatement__ContactAssignment_1 : ( ruleContactPosition ) ;
    public final void rule__ContactWaitStatement__ContactAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3407:1: ( ( ruleContactPosition ) )
            // InternalRailSL.g:3408:2: ( ruleContactPosition )
            {
            // InternalRailSL.g:3408:2: ( ruleContactPosition )
            // InternalRailSL.g:3409:3: ruleContactPosition
            {
             before(grammarAccess.getContactWaitStatementAccess().getContactContactPositionEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleContactPosition();

            state._fsp--;

             after(grammarAccess.getContactWaitStatementAccess().getContactContactPositionEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__ContactAssignment_1"


    // $ANTLR start "rule__ContactWaitStatement__SegmentAssignment_4"
    // InternalRailSL.g:3418:1: rule__ContactWaitStatement__SegmentAssignment_4 : ( ruleRailSegment ) ;
    public final void rule__ContactWaitStatement__SegmentAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3422:1: ( ( ruleRailSegment ) )
            // InternalRailSL.g:3423:2: ( ruleRailSegment )
            {
            // InternalRailSL.g:3423:2: ( ruleRailSegment )
            // InternalRailSL.g:3424:3: ruleRailSegment
            {
             before(grammarAccess.getContactWaitStatementAccess().getSegmentRailSegmentEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleRailSegment();

            state._fsp--;

             after(grammarAccess.getContactWaitStatementAccess().getSegmentRailSegmentEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContactWaitStatement__SegmentAssignment_4"


    // $ANTLR start "rule__CrossingStatement__ModeAssignment_0"
    // InternalRailSL.g:3433:1: rule__CrossingStatement__ModeAssignment_0 : ( ruleCrossingMode ) ;
    public final void rule__CrossingStatement__ModeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3437:1: ( ( ruleCrossingMode ) )
            // InternalRailSL.g:3438:2: ( ruleCrossingMode )
            {
            // InternalRailSL.g:3438:2: ( ruleCrossingMode )
            // InternalRailSL.g:3439:3: ruleCrossingMode
            {
             before(grammarAccess.getCrossingStatementAccess().getModeCrossingModeEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleCrossingMode();

            state._fsp--;

             after(grammarAccess.getCrossingStatementAccess().getModeCrossingModeEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CrossingStatement__ModeAssignment_0"


    // $ANTLR start "rule__LightStatement__LightsAssignment_2"
    // InternalRailSL.g:3448:1: rule__LightStatement__LightsAssignment_2 : ( RULE_INT ) ;
    public final void rule__LightStatement__LightsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3452:1: ( ( RULE_INT ) )
            // InternalRailSL.g:3453:2: ( RULE_INT )
            {
            // InternalRailSL.g:3453:2: ( RULE_INT )
            // InternalRailSL.g:3454:3: RULE_INT
            {
             before(grammarAccess.getLightStatementAccess().getLightsINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getLightStatementAccess().getLightsINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__LightsAssignment_2"


    // $ANTLR start "rule__LightStatement__LightsAssignment_3_1"
    // InternalRailSL.g:3463:1: rule__LightStatement__LightsAssignment_3_1 : ( RULE_INT ) ;
    public final void rule__LightStatement__LightsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3467:1: ( ( RULE_INT ) )
            // InternalRailSL.g:3468:2: ( RULE_INT )
            {
            // InternalRailSL.g:3468:2: ( RULE_INT )
            // InternalRailSL.g:3469:3: RULE_INT
            {
             before(grammarAccess.getLightStatementAccess().getLightsINTTerminalRuleCall_3_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getLightStatementAccess().getLightsINTTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__LightsAssignment_3_1"


    // $ANTLR start "rule__LightStatement__StateAssignment_4"
    // InternalRailSL.g:3478:1: rule__LightStatement__StateAssignment_4 : ( ( rule__LightStatement__StateAlternatives_4_0 ) ) ;
    public final void rule__LightStatement__StateAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3482:1: ( ( ( rule__LightStatement__StateAlternatives_4_0 ) ) )
            // InternalRailSL.g:3483:2: ( ( rule__LightStatement__StateAlternatives_4_0 ) )
            {
            // InternalRailSL.g:3483:2: ( ( rule__LightStatement__StateAlternatives_4_0 ) )
            // InternalRailSL.g:3484:3: ( rule__LightStatement__StateAlternatives_4_0 )
            {
             before(grammarAccess.getLightStatementAccess().getStateAlternatives_4_0()); 
            // InternalRailSL.g:3485:3: ( rule__LightStatement__StateAlternatives_4_0 )
            // InternalRailSL.g:3485:4: rule__LightStatement__StateAlternatives_4_0
            {
            pushFollow(FOLLOW_2);
            rule__LightStatement__StateAlternatives_4_0();

            state._fsp--;


            }

             after(grammarAccess.getLightStatementAccess().getStateAlternatives_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LightStatement__StateAssignment_4"


    // $ANTLR start "rule__ConditionalStatement__LinesAssignment_1"
    // InternalRailSL.g:3493:1: rule__ConditionalStatement__LinesAssignment_1 : ( ruleConditionalLine ) ;
    public final void rule__ConditionalStatement__LinesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3497:1: ( ( ruleConditionalLine ) )
            // InternalRailSL.g:3498:2: ( ruleConditionalLine )
            {
            // InternalRailSL.g:3498:2: ( ruleConditionalLine )
            // InternalRailSL.g:3499:3: ruleConditionalLine
            {
             before(grammarAccess.getConditionalStatementAccess().getLinesConditionalLineParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleConditionalLine();

            state._fsp--;

             after(grammarAccess.getConditionalStatementAccess().getLinesConditionalLineParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalStatement__LinesAssignment_1"


    // $ANTLR start "rule__ConditionalStatement__LinesAssignment_2"
    // InternalRailSL.g:3508:1: rule__ConditionalStatement__LinesAssignment_2 : ( ruleConditionalLine ) ;
    public final void rule__ConditionalStatement__LinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3512:1: ( ( ruleConditionalLine ) )
            // InternalRailSL.g:3513:2: ( ruleConditionalLine )
            {
            // InternalRailSL.g:3513:2: ( ruleConditionalLine )
            // InternalRailSL.g:3514:3: ruleConditionalLine
            {
             before(grammarAccess.getConditionalStatementAccess().getLinesConditionalLineParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleConditionalLine();

            state._fsp--;

             after(grammarAccess.getConditionalStatementAccess().getLinesConditionalLineParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalStatement__LinesAssignment_2"


    // $ANTLR start "rule__ConditionalLine__ContactAssignment_1"
    // InternalRailSL.g:3523:1: rule__ConditionalLine__ContactAssignment_1 : ( ruleContactPosition ) ;
    public final void rule__ConditionalLine__ContactAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3527:1: ( ( ruleContactPosition ) )
            // InternalRailSL.g:3528:2: ( ruleContactPosition )
            {
            // InternalRailSL.g:3528:2: ( ruleContactPosition )
            // InternalRailSL.g:3529:3: ruleContactPosition
            {
             before(grammarAccess.getConditionalLineAccess().getContactContactPositionEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleContactPosition();

            state._fsp--;

             after(grammarAccess.getConditionalLineAccess().getContactContactPositionEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__ContactAssignment_1"


    // $ANTLR start "rule__ConditionalLine__SegmentAssignment_4"
    // InternalRailSL.g:3538:1: rule__ConditionalLine__SegmentAssignment_4 : ( ruleRailSegment ) ;
    public final void rule__ConditionalLine__SegmentAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3542:1: ( ( ruleRailSegment ) )
            // InternalRailSL.g:3543:2: ( ruleRailSegment )
            {
            // InternalRailSL.g:3543:2: ( ruleRailSegment )
            // InternalRailSL.g:3544:3: ruleRailSegment
            {
             before(grammarAccess.getConditionalLineAccess().getSegmentRailSegmentEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleRailSegment();

            state._fsp--;

             after(grammarAccess.getConditionalLineAccess().getSegmentRailSegmentEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__SegmentAssignment_4"


    // $ANTLR start "rule__ConditionalLine__BlockAssignment_9"
    // InternalRailSL.g:3553:1: rule__ConditionalLine__BlockAssignment_9 : ( ruleBlock ) ;
    public final void rule__ConditionalLine__BlockAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3557:1: ( ( ruleBlock ) )
            // InternalRailSL.g:3558:2: ( ruleBlock )
            {
            // InternalRailSL.g:3558:2: ( ruleBlock )
            // InternalRailSL.g:3559:3: ruleBlock
            {
             before(grammarAccess.getConditionalLineAccess().getBlockBlockParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getConditionalLineAccess().getBlockBlockParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConditionalLine__BlockAssignment_9"


    // $ANTLR start "rule__ParallelStatement__BlocksAssignment_1"
    // InternalRailSL.g:3568:1: rule__ParallelStatement__BlocksAssignment_1 : ( ruleBlock ) ;
    public final void rule__ParallelStatement__BlocksAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3572:1: ( ( ruleBlock ) )
            // InternalRailSL.g:3573:2: ( ruleBlock )
            {
            // InternalRailSL.g:3573:2: ( ruleBlock )
            // InternalRailSL.g:3574:3: ruleBlock
            {
             before(grammarAccess.getParallelStatementAccess().getBlocksBlockParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getParallelStatementAccess().getBlocksBlockParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParallelStatement__BlocksAssignment_1"


    // $ANTLR start "rule__ParallelStatement__BlocksAssignment_2"
    // InternalRailSL.g:3583:1: rule__ParallelStatement__BlocksAssignment_2 : ( ruleBlock ) ;
    public final void rule__ParallelStatement__BlocksAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRailSL.g:3587:1: ( ( ruleBlock ) )
            // InternalRailSL.g:3588:2: ( ruleBlock )
            {
            // InternalRailSL.g:3588:2: ( ruleBlock )
            // InternalRailSL.g:3589:3: ruleBlock
            {
             before(grammarAccess.getParallelStatementAccess().getBlocksBlockParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getParallelStatementAccess().getBlocksBlockParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParallelStatement__BlocksAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0001EF00C33CC000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000F00000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0001EF00C33CC002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0xFFFE000000000000L,0x00000001FFFFFFFFL});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000030000L,0x0000000400000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000003000000800L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000100010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xFFFE000000000000L,0x00000101FFFFFFFFL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000C30000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000003002L});

}