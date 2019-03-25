package de.cau.cs.kieler.railsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.cau.cs.kieler.railsl.services.RailSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRailSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Start:'", "'start:'", "'Set'", "'set'", "'track'", "','", "'and'", "'to'", "'reverse'", "'.'", "'point'", "'Wait'", "'wait'", "'for'", "'seconds.'", "'contact'", "'of'", "'crossing.'", "'Turn'", "'turn'", "'light'", "'on'", "'off'", "'Branch:'", "'branch:'", "'If'", "'if'", "'is'", "'reached'", "'first'", "'first,'", "'do'", "'Parallel:'", "'parallel:'", "'End.'", "'end.'", "'Loop.'", "'loop.'", "'stop'", "'full'", "'slow'", "'straight'", "'branch'", "'Reach'", "'reach'", "'Pass'", "'pass'", "'second'", "'Open'", "'open'", "'Close'", "'close'", "'KH_ST_0'", "'KH_ST_1'", "'KH_ST_2'", "'KH_ST_3'", "'KH_ST_4'", "'KH_ST_5'", "'KH_ST_6'", "'KH_LN_0'", "'KH_LN_1'", "'KH_LN_2'", "'KH_LN_3'", "'KH_LN_4'", "'KH_LN_5'", "'KH_LN_6'", "'KH_LN_7'", "'KH_LN_8'", "'KIO_LN_0'", "'KIO_LN_1'", "'OC_ST_0'", "'OC_ST_1'", "'OC_ST_2'", "'OC_ST_3'", "'OC_ST_4'", "'OC_LN_0'", "'OC_LN_1'", "'OC_LN_2'", "'OC_LN_3'", "'OC_LN_4'", "'OC_LN_5'", "'IC_ST_0'", "'IC_ST_1'", "'IC_ST_2'", "'IC_ST_3'", "'IC_ST_4'", "'IC_LN_0'", "'IC_LN_1'", "'IC_LN_2'", "'IC_LN_3'", "'IC_LN_4'", "'IC_LN_5'", "'OC_JCT_0'", "'IC_JCT_0'", "'OI_LN_0'", "'OI_LN_1'", "'OI_LN_2'", "'IO_LN_0'", "'IO_LN_1'", "'IO_LN_2'"
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

        public InternalRailSLParser(TokenStream input, RailSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "RailProgram";
       	}

       	@Override
       	protected RailSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleRailProgram"
    // InternalRailSL.g:65:1: entryRuleRailProgram returns [EObject current=null] : iv_ruleRailProgram= ruleRailProgram EOF ;
    public final EObject entryRuleRailProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRailProgram = null;


        try {
            // InternalRailSL.g:65:52: (iv_ruleRailProgram= ruleRailProgram EOF )
            // InternalRailSL.g:66:2: iv_ruleRailProgram= ruleRailProgram EOF
            {
             newCompositeNode(grammarAccess.getRailProgramRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRailProgram=ruleRailProgram();

            state._fsp--;

             current =iv_ruleRailProgram; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRailProgram"


    // $ANTLR start "ruleRailProgram"
    // InternalRailSL.g:72:1: ruleRailProgram returns [EObject current=null] : ( (lv_block_0_0= ruleBlock ) ) ;
    public final EObject ruleRailProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_block_0_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:78:2: ( ( (lv_block_0_0= ruleBlock ) ) )
            // InternalRailSL.g:79:2: ( (lv_block_0_0= ruleBlock ) )
            {
            // InternalRailSL.g:79:2: ( (lv_block_0_0= ruleBlock ) )
            // InternalRailSL.g:80:3: (lv_block_0_0= ruleBlock )
            {
            // InternalRailSL.g:80:3: (lv_block_0_0= ruleBlock )
            // InternalRailSL.g:81:4: lv_block_0_0= ruleBlock
            {

            				newCompositeNode(grammarAccess.getRailProgramAccess().getBlockBlockParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_block_0_0=ruleBlock();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getRailProgramRule());
            				}
            				set(
            					current,
            					"block",
            					lv_block_0_0,
            					"de.cau.cs.kieler.railsl.RailSL.Block");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRailProgram"


    // $ANTLR start "entryRuleBlock"
    // InternalRailSL.g:101:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalRailSL.g:101:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalRailSL.g:102:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalRailSL.g:108:1: ruleBlock returns [EObject current=null] : ( (otherlv_0= 'Start:' | otherlv_1= 'start:' ) ( (lv_statements_2_0= ruleStatement ) )+ ( (lv_end_3_0= ruleBlockEnd ) ) ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_statements_2_0 = null;

        Enumerator lv_end_3_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:114:2: ( ( (otherlv_0= 'Start:' | otherlv_1= 'start:' ) ( (lv_statements_2_0= ruleStatement ) )+ ( (lv_end_3_0= ruleBlockEnd ) ) ) )
            // InternalRailSL.g:115:2: ( (otherlv_0= 'Start:' | otherlv_1= 'start:' ) ( (lv_statements_2_0= ruleStatement ) )+ ( (lv_end_3_0= ruleBlockEnd ) ) )
            {
            // InternalRailSL.g:115:2: ( (otherlv_0= 'Start:' | otherlv_1= 'start:' ) ( (lv_statements_2_0= ruleStatement ) )+ ( (lv_end_3_0= ruleBlockEnd ) ) )
            // InternalRailSL.g:116:3: (otherlv_0= 'Start:' | otherlv_1= 'start:' ) ( (lv_statements_2_0= ruleStatement ) )+ ( (lv_end_3_0= ruleBlockEnd ) )
            {
            // InternalRailSL.g:116:3: (otherlv_0= 'Start:' | otherlv_1= 'start:' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalRailSL.g:117:4: otherlv_0= 'Start:'
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getBlockAccess().getStartKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:122:4: otherlv_1= 'start:'
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getStartKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRailSL.g:127:3: ( (lv_statements_2_0= ruleStatement ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=13 && LA2_0<=14)||(LA2_0>=22 && LA2_0<=23)||(LA2_0>=29 && LA2_0<=30)||(LA2_0>=34 && LA2_0<=35)||(LA2_0>=43 && LA2_0<=44)||(LA2_0>=54 && LA2_0<=57)||(LA2_0>=59 && LA2_0<=62)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRailSL.g:128:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalRailSL.g:128:4: (lv_statements_2_0= ruleStatement )
            	    // InternalRailSL.g:129:5: lv_statements_2_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_2_0,
            	    						"de.cau.cs.kieler.railsl.RailSL.Statement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // InternalRailSL.g:146:3: ( (lv_end_3_0= ruleBlockEnd ) )
            // InternalRailSL.g:147:4: (lv_end_3_0= ruleBlockEnd )
            {
            // InternalRailSL.g:147:4: (lv_end_3_0= ruleBlockEnd )
            // InternalRailSL.g:148:5: lv_end_3_0= ruleBlockEnd
            {

            					newCompositeNode(grammarAccess.getBlockAccess().getEndBlockEndEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_end_3_0=ruleBlockEnd();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBlockRule());
            					}
            					set(
            						current,
            						"end",
            						lv_end_3_0,
            						"de.cau.cs.kieler.railsl.RailSL.BlockEnd");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleStatement"
    // InternalRailSL.g:169:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalRailSL.g:169:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalRailSL.g:170:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalRailSL.g:176:1: ruleStatement returns [EObject current=null] : (this_SetStatement_0= ruleSetStatement | this_WaitStatement_1= ruleWaitStatement | this_OpStatement_2= ruleOpStatement | this_ConditionalStatement_3= ruleConditionalStatement | this_ParallelStatement_4= ruleParallelStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SetStatement_0 = null;

        EObject this_WaitStatement_1 = null;

        EObject this_OpStatement_2 = null;

        EObject this_ConditionalStatement_3 = null;

        EObject this_ParallelStatement_4 = null;



        	enterRule();

        try {
            // InternalRailSL.g:182:2: ( (this_SetStatement_0= ruleSetStatement | this_WaitStatement_1= ruleWaitStatement | this_OpStatement_2= ruleOpStatement | this_ConditionalStatement_3= ruleConditionalStatement | this_ParallelStatement_4= ruleParallelStatement ) )
            // InternalRailSL.g:183:2: (this_SetStatement_0= ruleSetStatement | this_WaitStatement_1= ruleWaitStatement | this_OpStatement_2= ruleOpStatement | this_ConditionalStatement_3= ruleConditionalStatement | this_ParallelStatement_4= ruleParallelStatement )
            {
            // InternalRailSL.g:183:2: (this_SetStatement_0= ruleSetStatement | this_WaitStatement_1= ruleWaitStatement | this_OpStatement_2= ruleOpStatement | this_ConditionalStatement_3= ruleConditionalStatement | this_ParallelStatement_4= ruleParallelStatement )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 13:
            case 14:
                {
                alt3=1;
                }
                break;
            case 22:
            case 23:
            case 54:
            case 55:
            case 56:
            case 57:
                {
                alt3=2;
                }
                break;
            case 29:
            case 30:
            case 59:
            case 60:
            case 61:
            case 62:
                {
                alt3=3;
                }
                break;
            case 34:
            case 35:
                {
                alt3=4;
                }
                break;
            case 43:
            case 44:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalRailSL.g:184:3: this_SetStatement_0= ruleSetStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getSetStatementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SetStatement_0=ruleSetStatement();

                    state._fsp--;


                    			current = this_SetStatement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:193:3: this_WaitStatement_1= ruleWaitStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getWaitStatementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_WaitStatement_1=ruleWaitStatement();

                    state._fsp--;


                    			current = this_WaitStatement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRailSL.g:202:3: this_OpStatement_2= ruleOpStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getOpStatementParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OpStatement_2=ruleOpStatement();

                    state._fsp--;


                    			current = this_OpStatement_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRailSL.g:211:3: this_ConditionalStatement_3= ruleConditionalStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getConditionalStatementParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ConditionalStatement_3=ruleConditionalStatement();

                    state._fsp--;


                    			current = this_ConditionalStatement_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRailSL.g:220:3: this_ParallelStatement_4= ruleParallelStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getParallelStatementParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParallelStatement_4=ruleParallelStatement();

                    state._fsp--;


                    			current = this_ParallelStatement_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleSetStatement"
    // InternalRailSL.g:232:1: entryRuleSetStatement returns [EObject current=null] : iv_ruleSetStatement= ruleSetStatement EOF ;
    public final EObject entryRuleSetStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStatement = null;


        try {
            // InternalRailSL.g:232:53: (iv_ruleSetStatement= ruleSetStatement EOF )
            // InternalRailSL.g:233:2: iv_ruleSetStatement= ruleSetStatement EOF
            {
             newCompositeNode(grammarAccess.getSetStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetStatement=ruleSetStatement();

            state._fsp--;

             current =iv_ruleSetStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetStatement"


    // $ANTLR start "ruleSetStatement"
    // InternalRailSL.g:239:1: ruleSetStatement returns [EObject current=null] : (this_TrackStatement_0= ruleTrackStatement | this_PointStatement_1= rulePointStatement ) ;
    public final EObject ruleSetStatement() throws RecognitionException {
        EObject current = null;

        EObject this_TrackStatement_0 = null;

        EObject this_PointStatement_1 = null;



        	enterRule();

        try {
            // InternalRailSL.g:245:2: ( (this_TrackStatement_0= ruleTrackStatement | this_PointStatement_1= rulePointStatement ) )
            // InternalRailSL.g:246:2: (this_TrackStatement_0= ruleTrackStatement | this_PointStatement_1= rulePointStatement )
            {
            // InternalRailSL.g:246:2: (this_TrackStatement_0= ruleTrackStatement | this_PointStatement_1= rulePointStatement )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==15) ) {
                    alt4=1;
                }
                else if ( (LA4_1==21) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==14) ) {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==15) ) {
                    alt4=1;
                }
                else if ( (LA4_2==21) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalRailSL.g:247:3: this_TrackStatement_0= ruleTrackStatement
                    {

                    			newCompositeNode(grammarAccess.getSetStatementAccess().getTrackStatementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TrackStatement_0=ruleTrackStatement();

                    state._fsp--;


                    			current = this_TrackStatement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:256:3: this_PointStatement_1= rulePointStatement
                    {

                    			newCompositeNode(grammarAccess.getSetStatementAccess().getPointStatementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PointStatement_1=rulePointStatement();

                    state._fsp--;


                    			current = this_PointStatement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetStatement"


    // $ANTLR start "entryRuleTrackStatement"
    // InternalRailSL.g:268:1: entryRuleTrackStatement returns [EObject current=null] : iv_ruleTrackStatement= ruleTrackStatement EOF ;
    public final EObject entryRuleTrackStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrackStatement = null;


        try {
            // InternalRailSL.g:268:55: (iv_ruleTrackStatement= ruleTrackStatement EOF )
            // InternalRailSL.g:269:2: iv_ruleTrackStatement= ruleTrackStatement EOF
            {
             newCompositeNode(grammarAccess.getTrackStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrackStatement=ruleTrackStatement();

            state._fsp--;

             current =iv_ruleTrackStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrackStatement"


    // $ANTLR start "ruleTrackStatement"
    // InternalRailSL.g:275:1: ruleTrackStatement returns [EObject current=null] : ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'track' ( (lv_segments_3_0= ruleRailSegment ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_segments_8_0= ruleRailSegment ) ) )* otherlv_9= 'to' ( ( (lv_speed_10_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_11_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_12_0= 'reverse' ) )? ) ) otherlv_13= '.' ) ;
    public final EObject ruleTrackStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_reverse_12_0=null;
        Token otherlv_13=null;
        Enumerator lv_segments_3_0 = null;

        Enumerator lv_segments_8_0 = null;

        Enumerator lv_speed_10_0 = null;

        Enumerator lv_speed_11_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:281:2: ( ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'track' ( (lv_segments_3_0= ruleRailSegment ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_segments_8_0= ruleRailSegment ) ) )* otherlv_9= 'to' ( ( (lv_speed_10_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_11_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_12_0= 'reverse' ) )? ) ) otherlv_13= '.' ) )
            // InternalRailSL.g:282:2: ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'track' ( (lv_segments_3_0= ruleRailSegment ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_segments_8_0= ruleRailSegment ) ) )* otherlv_9= 'to' ( ( (lv_speed_10_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_11_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_12_0= 'reverse' ) )? ) ) otherlv_13= '.' )
            {
            // InternalRailSL.g:282:2: ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'track' ( (lv_segments_3_0= ruleRailSegment ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_segments_8_0= ruleRailSegment ) ) )* otherlv_9= 'to' ( ( (lv_speed_10_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_11_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_12_0= 'reverse' ) )? ) ) otherlv_13= '.' )
            // InternalRailSL.g:283:3: (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'track' ( (lv_segments_3_0= ruleRailSegment ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_segments_8_0= ruleRailSegment ) ) )* otherlv_9= 'to' ( ( (lv_speed_10_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_11_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_12_0= 'reverse' ) )? ) ) otherlv_13= '.'
            {
            // InternalRailSL.g:283:3: (otherlv_0= 'Set' | otherlv_1= 'set' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==14) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalRailSL.g:284:4: otherlv_0= 'Set'
                    {
                    otherlv_0=(Token)match(input,13,FOLLOW_5); 

                    				newLeafNode(otherlv_0, grammarAccess.getTrackStatementAccess().getSetKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:289:4: otherlv_1= 'set'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getTrackStatementAccess().getSetKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getTrackStatementAccess().getTrackKeyword_1());
            		
            // InternalRailSL.g:298:3: ( (lv_segments_3_0= ruleRailSegment ) )
            // InternalRailSL.g:299:4: (lv_segments_3_0= ruleRailSegment )
            {
            // InternalRailSL.g:299:4: (lv_segments_3_0= ruleRailSegment )
            // InternalRailSL.g:300:5: lv_segments_3_0= ruleRailSegment
            {

            					newCompositeNode(grammarAccess.getTrackStatementAccess().getSegmentsRailSegmentEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
            lv_segments_3_0=ruleRailSegment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTrackStatementRule());
            					}
            					add(
            						current,
            						"segments",
            						lv_segments_3_0,
            						"de.cau.cs.kieler.railsl.RailSL.RailSegment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRailSL.g:317:3: ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_segments_8_0= ruleRailSegment ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=16 && LA7_0<=17)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalRailSL.g:318:4: (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_segments_8_0= ruleRailSegment ) )
            	    {
            	    // InternalRailSL.g:318:4: (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) )
            	    int alt6=3;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==16) ) {
            	        int LA6_1 = input.LA(2);

            	        if ( ((LA6_1>=63 && LA6_1<=110)) ) {
            	            alt6=1;
            	        }
            	        else if ( (LA6_1==17) ) {
            	            alt6=3;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 6, 1, input);

            	            throw nvae;
            	        }
            	    }
            	    else if ( (LA6_0==17) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalRailSL.g:319:5: otherlv_4= ','
            	            {
            	            otherlv_4=(Token)match(input,16,FOLLOW_6); 

            	            					newLeafNode(otherlv_4, grammarAccess.getTrackStatementAccess().getCommaKeyword_3_0_0());
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalRailSL.g:324:5: otherlv_5= 'and'
            	            {
            	            otherlv_5=(Token)match(input,17,FOLLOW_6); 

            	            					newLeafNode(otherlv_5, grammarAccess.getTrackStatementAccess().getAndKeyword_3_0_1());
            	            				

            	            }
            	            break;
            	        case 3 :
            	            // InternalRailSL.g:329:5: (otherlv_6= ',' otherlv_7= 'and' )
            	            {
            	            // InternalRailSL.g:329:5: (otherlv_6= ',' otherlv_7= 'and' )
            	            // InternalRailSL.g:330:6: otherlv_6= ',' otherlv_7= 'and'
            	            {
            	            otherlv_6=(Token)match(input,16,FOLLOW_8); 

            	            						newLeafNode(otherlv_6, grammarAccess.getTrackStatementAccess().getCommaKeyword_3_0_2_0());
            	            					
            	            otherlv_7=(Token)match(input,17,FOLLOW_6); 

            	            						newLeafNode(otherlv_7, grammarAccess.getTrackStatementAccess().getAndKeyword_3_0_2_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalRailSL.g:340:4: ( (lv_segments_8_0= ruleRailSegment ) )
            	    // InternalRailSL.g:341:5: (lv_segments_8_0= ruleRailSegment )
            	    {
            	    // InternalRailSL.g:341:5: (lv_segments_8_0= ruleRailSegment )
            	    // InternalRailSL.g:342:6: lv_segments_8_0= ruleRailSegment
            	    {

            	    						newCompositeNode(grammarAccess.getTrackStatementAccess().getSegmentsRailSegmentEnumRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_segments_8_0=ruleRailSegment();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTrackStatementRule());
            	    						}
            	    						add(
            	    							current,
            	    							"segments",
            	    							lv_segments_8_0,
            	    							"de.cau.cs.kieler.railsl.RailSL.RailSegment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_9=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_9, grammarAccess.getTrackStatementAccess().getToKeyword_4());
            		
            // InternalRailSL.g:364:3: ( ( (lv_speed_10_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_11_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_12_0= 'reverse' ) )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==49) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=50 && LA9_0<=51)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalRailSL.g:365:4: ( (lv_speed_10_0= ruleTrackSpeedStop ) )
                    {
                    // InternalRailSL.g:365:4: ( (lv_speed_10_0= ruleTrackSpeedStop ) )
                    // InternalRailSL.g:366:5: (lv_speed_10_0= ruleTrackSpeedStop )
                    {
                    // InternalRailSL.g:366:5: (lv_speed_10_0= ruleTrackSpeedStop )
                    // InternalRailSL.g:367:6: lv_speed_10_0= ruleTrackSpeedStop
                    {

                    						newCompositeNode(grammarAccess.getTrackStatementAccess().getSpeedTrackSpeedStopEnumRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_speed_10_0=ruleTrackSpeedStop();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTrackStatementRule());
                    						}
                    						set(
                    							current,
                    							"speed",
                    							lv_speed_10_0,
                    							"de.cau.cs.kieler.railsl.RailSL.TrackSpeedStop");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:385:4: ( ( (lv_speed_11_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_12_0= 'reverse' ) )? )
                    {
                    // InternalRailSL.g:385:4: ( ( (lv_speed_11_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_12_0= 'reverse' ) )? )
                    // InternalRailSL.g:386:5: ( (lv_speed_11_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_12_0= 'reverse' ) )?
                    {
                    // InternalRailSL.g:386:5: ( (lv_speed_11_0= ruleTrackSpeedDrive ) )
                    // InternalRailSL.g:387:6: (lv_speed_11_0= ruleTrackSpeedDrive )
                    {
                    // InternalRailSL.g:387:6: (lv_speed_11_0= ruleTrackSpeedDrive )
                    // InternalRailSL.g:388:7: lv_speed_11_0= ruleTrackSpeedDrive
                    {

                    							newCompositeNode(grammarAccess.getTrackStatementAccess().getSpeedTrackSpeedDriveEnumRuleCall_5_1_0_0());
                    						
                    pushFollow(FOLLOW_11);
                    lv_speed_11_0=ruleTrackSpeedDrive();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getTrackStatementRule());
                    							}
                    							set(
                    								current,
                    								"speed",
                    								lv_speed_11_0,
                    								"de.cau.cs.kieler.railsl.RailSL.TrackSpeedDrive");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalRailSL.g:405:5: ( (lv_reverse_12_0= 'reverse' ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==19) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalRailSL.g:406:6: (lv_reverse_12_0= 'reverse' )
                            {
                            // InternalRailSL.g:406:6: (lv_reverse_12_0= 'reverse' )
                            // InternalRailSL.g:407:7: lv_reverse_12_0= 'reverse'
                            {
                            lv_reverse_12_0=(Token)match(input,19,FOLLOW_10); 

                            							newLeafNode(lv_reverse_12_0, grammarAccess.getTrackStatementAccess().getReverseReverseKeyword_5_1_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTrackStatementRule());
                            							}
                            							setWithLastConsumed(current, "reverse", true, "reverse");
                            						

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getTrackStatementAccess().getFullStopKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrackStatement"


    // $ANTLR start "entryRulePointStatement"
    // InternalRailSL.g:429:1: entryRulePointStatement returns [EObject current=null] : iv_rulePointStatement= rulePointStatement EOF ;
    public final EObject entryRulePointStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointStatement = null;


        try {
            // InternalRailSL.g:429:55: (iv_rulePointStatement= rulePointStatement EOF )
            // InternalRailSL.g:430:2: iv_rulePointStatement= rulePointStatement EOF
            {
             newCompositeNode(grammarAccess.getPointStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePointStatement=rulePointStatement();

            state._fsp--;

             current =iv_rulePointStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePointStatement"


    // $ANTLR start "rulePointStatement"
    // InternalRailSL.g:436:1: rulePointStatement returns [EObject current=null] : ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'point' ( (lv_points_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_points_8_0= RULE_INT ) ) )* otherlv_9= 'to' ( (lv_orientation_10_0= rulePointOrinetation ) ) otherlv_11= '.' ) ;
    public final EObject rulePointStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_points_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_points_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Enumerator lv_orientation_10_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:442:2: ( ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'point' ( (lv_points_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_points_8_0= RULE_INT ) ) )* otherlv_9= 'to' ( (lv_orientation_10_0= rulePointOrinetation ) ) otherlv_11= '.' ) )
            // InternalRailSL.g:443:2: ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'point' ( (lv_points_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_points_8_0= RULE_INT ) ) )* otherlv_9= 'to' ( (lv_orientation_10_0= rulePointOrinetation ) ) otherlv_11= '.' )
            {
            // InternalRailSL.g:443:2: ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'point' ( (lv_points_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_points_8_0= RULE_INT ) ) )* otherlv_9= 'to' ( (lv_orientation_10_0= rulePointOrinetation ) ) otherlv_11= '.' )
            // InternalRailSL.g:444:3: (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'point' ( (lv_points_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_points_8_0= RULE_INT ) ) )* otherlv_9= 'to' ( (lv_orientation_10_0= rulePointOrinetation ) ) otherlv_11= '.'
            {
            // InternalRailSL.g:444:3: (otherlv_0= 'Set' | otherlv_1= 'set' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            else if ( (LA10_0==14) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalRailSL.g:445:4: otherlv_0= 'Set'
                    {
                    otherlv_0=(Token)match(input,13,FOLLOW_12); 

                    				newLeafNode(otherlv_0, grammarAccess.getPointStatementAccess().getSetKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:450:4: otherlv_1= 'set'
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getPointStatementAccess().getSetKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,21,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getPointStatementAccess().getPointKeyword_1());
            		
            // InternalRailSL.g:459:3: ( (lv_points_3_0= RULE_INT ) )
            // InternalRailSL.g:460:4: (lv_points_3_0= RULE_INT )
            {
            // InternalRailSL.g:460:4: (lv_points_3_0= RULE_INT )
            // InternalRailSL.g:461:5: lv_points_3_0= RULE_INT
            {
            lv_points_3_0=(Token)match(input,RULE_INT,FOLLOW_7); 

            					newLeafNode(lv_points_3_0, grammarAccess.getPointStatementAccess().getPointsINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPointStatementRule());
            					}
            					addWithLastConsumed(
            						current,
            						"points",
            						lv_points_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalRailSL.g:477:3: ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_points_8_0= RULE_INT ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=16 && LA12_0<=17)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalRailSL.g:478:4: (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_points_8_0= RULE_INT ) )
            	    {
            	    // InternalRailSL.g:478:4: (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) )
            	    int alt11=3;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==16) ) {
            	        int LA11_1 = input.LA(2);

            	        if ( (LA11_1==17) ) {
            	            alt11=3;
            	        }
            	        else if ( (LA11_1==RULE_INT) ) {
            	            alt11=1;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 11, 1, input);

            	            throw nvae;
            	        }
            	    }
            	    else if ( (LA11_0==17) ) {
            	        alt11=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // InternalRailSL.g:479:5: otherlv_4= ','
            	            {
            	            otherlv_4=(Token)match(input,16,FOLLOW_13); 

            	            					newLeafNode(otherlv_4, grammarAccess.getPointStatementAccess().getCommaKeyword_3_0_0());
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalRailSL.g:484:5: otherlv_5= 'and'
            	            {
            	            otherlv_5=(Token)match(input,17,FOLLOW_13); 

            	            					newLeafNode(otherlv_5, grammarAccess.getPointStatementAccess().getAndKeyword_3_0_1());
            	            				

            	            }
            	            break;
            	        case 3 :
            	            // InternalRailSL.g:489:5: (otherlv_6= ',' otherlv_7= 'and' )
            	            {
            	            // InternalRailSL.g:489:5: (otherlv_6= ',' otherlv_7= 'and' )
            	            // InternalRailSL.g:490:6: otherlv_6= ',' otherlv_7= 'and'
            	            {
            	            otherlv_6=(Token)match(input,16,FOLLOW_8); 

            	            						newLeafNode(otherlv_6, grammarAccess.getPointStatementAccess().getCommaKeyword_3_0_2_0());
            	            					
            	            otherlv_7=(Token)match(input,17,FOLLOW_13); 

            	            						newLeafNode(otherlv_7, grammarAccess.getPointStatementAccess().getAndKeyword_3_0_2_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalRailSL.g:500:4: ( (lv_points_8_0= RULE_INT ) )
            	    // InternalRailSL.g:501:5: (lv_points_8_0= RULE_INT )
            	    {
            	    // InternalRailSL.g:501:5: (lv_points_8_0= RULE_INT )
            	    // InternalRailSL.g:502:6: lv_points_8_0= RULE_INT
            	    {
            	    lv_points_8_0=(Token)match(input,RULE_INT,FOLLOW_7); 

            	    						newLeafNode(lv_points_8_0, grammarAccess.getPointStatementAccess().getPointsINTTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getPointStatementRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"points",
            	    							lv_points_8_0,
            	    							"org.eclipse.xtext.common.Terminals.INT");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_9=(Token)match(input,18,FOLLOW_14); 

            			newLeafNode(otherlv_9, grammarAccess.getPointStatementAccess().getToKeyword_4());
            		
            // InternalRailSL.g:523:3: ( (lv_orientation_10_0= rulePointOrinetation ) )
            // InternalRailSL.g:524:4: (lv_orientation_10_0= rulePointOrinetation )
            {
            // InternalRailSL.g:524:4: (lv_orientation_10_0= rulePointOrinetation )
            // InternalRailSL.g:525:5: lv_orientation_10_0= rulePointOrinetation
            {

            					newCompositeNode(grammarAccess.getPointStatementAccess().getOrientationPointOrinetationEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_10);
            lv_orientation_10_0=rulePointOrinetation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointStatementRule());
            					}
            					set(
            						current,
            						"orientation",
            						lv_orientation_10_0,
            						"de.cau.cs.kieler.railsl.RailSL.PointOrinetation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getPointStatementAccess().getFullStopKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointStatement"


    // $ANTLR start "entryRuleWaitStatement"
    // InternalRailSL.g:550:1: entryRuleWaitStatement returns [EObject current=null] : iv_ruleWaitStatement= ruleWaitStatement EOF ;
    public final EObject entryRuleWaitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWaitStatement = null;


        try {
            // InternalRailSL.g:550:54: (iv_ruleWaitStatement= ruleWaitStatement EOF )
            // InternalRailSL.g:551:2: iv_ruleWaitStatement= ruleWaitStatement EOF
            {
             newCompositeNode(grammarAccess.getWaitStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWaitStatement=ruleWaitStatement();

            state._fsp--;

             current =iv_ruleWaitStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWaitStatement"


    // $ANTLR start "ruleWaitStatement"
    // InternalRailSL.g:557:1: ruleWaitStatement returns [EObject current=null] : (this_TimeWaitStatement_0= ruleTimeWaitStatement | this_ContactWaitStatement_1= ruleContactWaitStatement ) ;
    public final EObject ruleWaitStatement() throws RecognitionException {
        EObject current = null;

        EObject this_TimeWaitStatement_0 = null;

        EObject this_ContactWaitStatement_1 = null;



        	enterRule();

        try {
            // InternalRailSL.g:563:2: ( (this_TimeWaitStatement_0= ruleTimeWaitStatement | this_ContactWaitStatement_1= ruleContactWaitStatement ) )
            // InternalRailSL.g:564:2: (this_TimeWaitStatement_0= ruleTimeWaitStatement | this_ContactWaitStatement_1= ruleContactWaitStatement )
            {
            // InternalRailSL.g:564:2: (this_TimeWaitStatement_0= ruleTimeWaitStatement | this_ContactWaitStatement_1= ruleContactWaitStatement )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=22 && LA13_0<=23)) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=54 && LA13_0<=57)) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalRailSL.g:565:3: this_TimeWaitStatement_0= ruleTimeWaitStatement
                    {

                    			newCompositeNode(grammarAccess.getWaitStatementAccess().getTimeWaitStatementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeWaitStatement_0=ruleTimeWaitStatement();

                    state._fsp--;


                    			current = this_TimeWaitStatement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:574:3: this_ContactWaitStatement_1= ruleContactWaitStatement
                    {

                    			newCompositeNode(grammarAccess.getWaitStatementAccess().getContactWaitStatementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContactWaitStatement_1=ruleContactWaitStatement();

                    state._fsp--;


                    			current = this_ContactWaitStatement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWaitStatement"


    // $ANTLR start "entryRuleTimeWaitStatement"
    // InternalRailSL.g:586:1: entryRuleTimeWaitStatement returns [EObject current=null] : iv_ruleTimeWaitStatement= ruleTimeWaitStatement EOF ;
    public final EObject entryRuleTimeWaitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeWaitStatement = null;


        try {
            // InternalRailSL.g:586:58: (iv_ruleTimeWaitStatement= ruleTimeWaitStatement EOF )
            // InternalRailSL.g:587:2: iv_ruleTimeWaitStatement= ruleTimeWaitStatement EOF
            {
             newCompositeNode(grammarAccess.getTimeWaitStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeWaitStatement=ruleTimeWaitStatement();

            state._fsp--;

             current =iv_ruleTimeWaitStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeWaitStatement"


    // $ANTLR start "ruleTimeWaitStatement"
    // InternalRailSL.g:593:1: ruleTimeWaitStatement returns [EObject current=null] : ( (otherlv_0= 'Wait' | otherlv_1= 'wait' ) otherlv_2= 'for' ( (lv_time_3_0= RULE_INT ) ) otherlv_4= 'seconds.' ) ;
    public final EObject ruleTimeWaitStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_time_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalRailSL.g:599:2: ( ( (otherlv_0= 'Wait' | otherlv_1= 'wait' ) otherlv_2= 'for' ( (lv_time_3_0= RULE_INT ) ) otherlv_4= 'seconds.' ) )
            // InternalRailSL.g:600:2: ( (otherlv_0= 'Wait' | otherlv_1= 'wait' ) otherlv_2= 'for' ( (lv_time_3_0= RULE_INT ) ) otherlv_4= 'seconds.' )
            {
            // InternalRailSL.g:600:2: ( (otherlv_0= 'Wait' | otherlv_1= 'wait' ) otherlv_2= 'for' ( (lv_time_3_0= RULE_INT ) ) otherlv_4= 'seconds.' )
            // InternalRailSL.g:601:3: (otherlv_0= 'Wait' | otherlv_1= 'wait' ) otherlv_2= 'for' ( (lv_time_3_0= RULE_INT ) ) otherlv_4= 'seconds.'
            {
            // InternalRailSL.g:601:3: (otherlv_0= 'Wait' | otherlv_1= 'wait' )
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
                    // InternalRailSL.g:602:4: otherlv_0= 'Wait'
                    {
                    otherlv_0=(Token)match(input,22,FOLLOW_15); 

                    				newLeafNode(otherlv_0, grammarAccess.getTimeWaitStatementAccess().getWaitKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:607:4: otherlv_1= 'wait'
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_15); 

                    				newLeafNode(otherlv_1, grammarAccess.getTimeWaitStatementAccess().getWaitKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,24,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getTimeWaitStatementAccess().getForKeyword_1());
            		
            // InternalRailSL.g:616:3: ( (lv_time_3_0= RULE_INT ) )
            // InternalRailSL.g:617:4: (lv_time_3_0= RULE_INT )
            {
            // InternalRailSL.g:617:4: (lv_time_3_0= RULE_INT )
            // InternalRailSL.g:618:5: lv_time_3_0= RULE_INT
            {
            lv_time_3_0=(Token)match(input,RULE_INT,FOLLOW_16); 

            					newLeafNode(lv_time_3_0, grammarAccess.getTimeWaitStatementAccess().getTimeINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeWaitStatementRule());
            					}
            					setWithLastConsumed(
            						current,
            						"time",
            						lv_time_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTimeWaitStatementAccess().getSecondsKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeWaitStatement"


    // $ANTLR start "entryRuleContactWaitStatement"
    // InternalRailSL.g:642:1: entryRuleContactWaitStatement returns [EObject current=null] : iv_ruleContactWaitStatement= ruleContactWaitStatement EOF ;
    public final EObject entryRuleContactWaitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContactWaitStatement = null;


        try {
            // InternalRailSL.g:642:61: (iv_ruleContactWaitStatement= ruleContactWaitStatement EOF )
            // InternalRailSL.g:643:2: iv_ruleContactWaitStatement= ruleContactWaitStatement EOF
            {
             newCompositeNode(grammarAccess.getContactWaitStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContactWaitStatement=ruleContactWaitStatement();

            state._fsp--;

             current =iv_ruleContactWaitStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContactWaitStatement"


    // $ANTLR start "ruleContactWaitStatement"
    // InternalRailSL.g:649:1: ruleContactWaitStatement returns [EObject current=null] : ( ( (lv_event_0_0= ruleContactEvent ) ) ( (lv_contact_1_0= ruleContactPosition ) ) otherlv_2= 'contact' (otherlv_3= 'of' )? ( (lv_segment_4_0= ruleRailSegment ) ) otherlv_5= '.' ) ;
    public final EObject ruleContactWaitStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_event_0_0 = null;

        Enumerator lv_contact_1_0 = null;

        Enumerator lv_segment_4_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:655:2: ( ( ( (lv_event_0_0= ruleContactEvent ) ) ( (lv_contact_1_0= ruleContactPosition ) ) otherlv_2= 'contact' (otherlv_3= 'of' )? ( (lv_segment_4_0= ruleRailSegment ) ) otherlv_5= '.' ) )
            // InternalRailSL.g:656:2: ( ( (lv_event_0_0= ruleContactEvent ) ) ( (lv_contact_1_0= ruleContactPosition ) ) otherlv_2= 'contact' (otherlv_3= 'of' )? ( (lv_segment_4_0= ruleRailSegment ) ) otherlv_5= '.' )
            {
            // InternalRailSL.g:656:2: ( ( (lv_event_0_0= ruleContactEvent ) ) ( (lv_contact_1_0= ruleContactPosition ) ) otherlv_2= 'contact' (otherlv_3= 'of' )? ( (lv_segment_4_0= ruleRailSegment ) ) otherlv_5= '.' )
            // InternalRailSL.g:657:3: ( (lv_event_0_0= ruleContactEvent ) ) ( (lv_contact_1_0= ruleContactPosition ) ) otherlv_2= 'contact' (otherlv_3= 'of' )? ( (lv_segment_4_0= ruleRailSegment ) ) otherlv_5= '.'
            {
            // InternalRailSL.g:657:3: ( (lv_event_0_0= ruleContactEvent ) )
            // InternalRailSL.g:658:4: (lv_event_0_0= ruleContactEvent )
            {
            // InternalRailSL.g:658:4: (lv_event_0_0= ruleContactEvent )
            // InternalRailSL.g:659:5: lv_event_0_0= ruleContactEvent
            {

            					newCompositeNode(grammarAccess.getContactWaitStatementAccess().getEventContactEventEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
            lv_event_0_0=ruleContactEvent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContactWaitStatementRule());
            					}
            					set(
            						current,
            						"event",
            						lv_event_0_0,
            						"de.cau.cs.kieler.railsl.RailSL.ContactEvent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRailSL.g:676:3: ( (lv_contact_1_0= ruleContactPosition ) )
            // InternalRailSL.g:677:4: (lv_contact_1_0= ruleContactPosition )
            {
            // InternalRailSL.g:677:4: (lv_contact_1_0= ruleContactPosition )
            // InternalRailSL.g:678:5: lv_contact_1_0= ruleContactPosition
            {

            					newCompositeNode(grammarAccess.getContactWaitStatementAccess().getContactContactPositionEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_contact_1_0=ruleContactPosition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContactWaitStatementRule());
            					}
            					set(
            						current,
            						"contact",
            						lv_contact_1_0,
            						"de.cau.cs.kieler.railsl.RailSL.ContactPosition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getContactWaitStatementAccess().getContactKeyword_2());
            		
            // InternalRailSL.g:699:3: (otherlv_3= 'of' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRailSL.g:700:4: otherlv_3= 'of'
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getContactWaitStatementAccess().getOfKeyword_3());
                    			

                    }
                    break;

            }

            // InternalRailSL.g:705:3: ( (lv_segment_4_0= ruleRailSegment ) )
            // InternalRailSL.g:706:4: (lv_segment_4_0= ruleRailSegment )
            {
            // InternalRailSL.g:706:4: (lv_segment_4_0= ruleRailSegment )
            // InternalRailSL.g:707:5: lv_segment_4_0= ruleRailSegment
            {

            					newCompositeNode(grammarAccess.getContactWaitStatementAccess().getSegmentRailSegmentEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_10);
            lv_segment_4_0=ruleRailSegment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContactWaitStatementRule());
            					}
            					set(
            						current,
            						"segment",
            						lv_segment_4_0,
            						"de.cau.cs.kieler.railsl.RailSL.RailSegment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getContactWaitStatementAccess().getFullStopKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContactWaitStatement"


    // $ANTLR start "entryRuleOpStatement"
    // InternalRailSL.g:732:1: entryRuleOpStatement returns [EObject current=null] : iv_ruleOpStatement= ruleOpStatement EOF ;
    public final EObject entryRuleOpStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpStatement = null;


        try {
            // InternalRailSL.g:732:52: (iv_ruleOpStatement= ruleOpStatement EOF )
            // InternalRailSL.g:733:2: iv_ruleOpStatement= ruleOpStatement EOF
            {
             newCompositeNode(grammarAccess.getOpStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOpStatement=ruleOpStatement();

            state._fsp--;

             current =iv_ruleOpStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOpStatement"


    // $ANTLR start "ruleOpStatement"
    // InternalRailSL.g:739:1: ruleOpStatement returns [EObject current=null] : (this_CrossingStatement_0= ruleCrossingStatement | this_LightStatement_1= ruleLightStatement ) ;
    public final EObject ruleOpStatement() throws RecognitionException {
        EObject current = null;

        EObject this_CrossingStatement_0 = null;

        EObject this_LightStatement_1 = null;



        	enterRule();

        try {
            // InternalRailSL.g:745:2: ( (this_CrossingStatement_0= ruleCrossingStatement | this_LightStatement_1= ruleLightStatement ) )
            // InternalRailSL.g:746:2: (this_CrossingStatement_0= ruleCrossingStatement | this_LightStatement_1= ruleLightStatement )
            {
            // InternalRailSL.g:746:2: (this_CrossingStatement_0= ruleCrossingStatement | this_LightStatement_1= ruleLightStatement )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=59 && LA16_0<=62)) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=29 && LA16_0<=30)) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalRailSL.g:747:3: this_CrossingStatement_0= ruleCrossingStatement
                    {

                    			newCompositeNode(grammarAccess.getOpStatementAccess().getCrossingStatementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_CrossingStatement_0=ruleCrossingStatement();

                    state._fsp--;


                    			current = this_CrossingStatement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:756:3: this_LightStatement_1= ruleLightStatement
                    {

                    			newCompositeNode(grammarAccess.getOpStatementAccess().getLightStatementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LightStatement_1=ruleLightStatement();

                    state._fsp--;


                    			current = this_LightStatement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOpStatement"


    // $ANTLR start "entryRuleCrossingStatement"
    // InternalRailSL.g:768:1: entryRuleCrossingStatement returns [EObject current=null] : iv_ruleCrossingStatement= ruleCrossingStatement EOF ;
    public final EObject entryRuleCrossingStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossingStatement = null;


        try {
            // InternalRailSL.g:768:58: (iv_ruleCrossingStatement= ruleCrossingStatement EOF )
            // InternalRailSL.g:769:2: iv_ruleCrossingStatement= ruleCrossingStatement EOF
            {
             newCompositeNode(grammarAccess.getCrossingStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCrossingStatement=ruleCrossingStatement();

            state._fsp--;

             current =iv_ruleCrossingStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCrossingStatement"


    // $ANTLR start "ruleCrossingStatement"
    // InternalRailSL.g:775:1: ruleCrossingStatement returns [EObject current=null] : ( ( (lv_mode_0_0= ruleCrossingMode ) ) otherlv_1= 'crossing.' ) ;
    public final EObject ruleCrossingStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_mode_0_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:781:2: ( ( ( (lv_mode_0_0= ruleCrossingMode ) ) otherlv_1= 'crossing.' ) )
            // InternalRailSL.g:782:2: ( ( (lv_mode_0_0= ruleCrossingMode ) ) otherlv_1= 'crossing.' )
            {
            // InternalRailSL.g:782:2: ( ( (lv_mode_0_0= ruleCrossingMode ) ) otherlv_1= 'crossing.' )
            // InternalRailSL.g:783:3: ( (lv_mode_0_0= ruleCrossingMode ) ) otherlv_1= 'crossing.'
            {
            // InternalRailSL.g:783:3: ( (lv_mode_0_0= ruleCrossingMode ) )
            // InternalRailSL.g:784:4: (lv_mode_0_0= ruleCrossingMode )
            {
            // InternalRailSL.g:784:4: (lv_mode_0_0= ruleCrossingMode )
            // InternalRailSL.g:785:5: lv_mode_0_0= ruleCrossingMode
            {

            					newCompositeNode(grammarAccess.getCrossingStatementAccess().getModeCrossingModeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
            lv_mode_0_0=ruleCrossingMode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCrossingStatementRule());
            					}
            					set(
            						current,
            						"mode",
            						lv_mode_0_0,
            						"de.cau.cs.kieler.railsl.RailSL.CrossingMode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getCrossingStatementAccess().getCrossingKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCrossingStatement"


    // $ANTLR start "entryRuleLightStatement"
    // InternalRailSL.g:810:1: entryRuleLightStatement returns [EObject current=null] : iv_ruleLightStatement= ruleLightStatement EOF ;
    public final EObject entryRuleLightStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLightStatement = null;


        try {
            // InternalRailSL.g:810:55: (iv_ruleLightStatement= ruleLightStatement EOF )
            // InternalRailSL.g:811:2: iv_ruleLightStatement= ruleLightStatement EOF
            {
             newCompositeNode(grammarAccess.getLightStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLightStatement=ruleLightStatement();

            state._fsp--;

             current =iv_ruleLightStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLightStatement"


    // $ANTLR start "ruleLightStatement"
    // InternalRailSL.g:817:1: ruleLightStatement returns [EObject current=null] : ( (otherlv_0= 'Turn' | otherlv_1= 'turn' ) otherlv_2= 'light' ( (lv_lights_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_lights_8_0= RULE_INT ) ) )* ( ( (lv_state_9_1= 'on' | lv_state_9_2= 'off' ) ) ) otherlv_10= '.' ) ;
    public final EObject ruleLightStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_lights_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_lights_8_0=null;
        Token lv_state_9_1=null;
        Token lv_state_9_2=null;
        Token otherlv_10=null;


        	enterRule();

        try {
            // InternalRailSL.g:823:2: ( ( (otherlv_0= 'Turn' | otherlv_1= 'turn' ) otherlv_2= 'light' ( (lv_lights_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_lights_8_0= RULE_INT ) ) )* ( ( (lv_state_9_1= 'on' | lv_state_9_2= 'off' ) ) ) otherlv_10= '.' ) )
            // InternalRailSL.g:824:2: ( (otherlv_0= 'Turn' | otherlv_1= 'turn' ) otherlv_2= 'light' ( (lv_lights_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_lights_8_0= RULE_INT ) ) )* ( ( (lv_state_9_1= 'on' | lv_state_9_2= 'off' ) ) ) otherlv_10= '.' )
            {
            // InternalRailSL.g:824:2: ( (otherlv_0= 'Turn' | otherlv_1= 'turn' ) otherlv_2= 'light' ( (lv_lights_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_lights_8_0= RULE_INT ) ) )* ( ( (lv_state_9_1= 'on' | lv_state_9_2= 'off' ) ) ) otherlv_10= '.' )
            // InternalRailSL.g:825:3: (otherlv_0= 'Turn' | otherlv_1= 'turn' ) otherlv_2= 'light' ( (lv_lights_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_lights_8_0= RULE_INT ) ) )* ( ( (lv_state_9_1= 'on' | lv_state_9_2= 'off' ) ) ) otherlv_10= '.'
            {
            // InternalRailSL.g:825:3: (otherlv_0= 'Turn' | otherlv_1= 'turn' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            else if ( (LA17_0==30) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalRailSL.g:826:4: otherlv_0= 'Turn'
                    {
                    otherlv_0=(Token)match(input,29,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getLightStatementAccess().getTurnKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:831:4: otherlv_1= 'turn'
                    {
                    otherlv_1=(Token)match(input,30,FOLLOW_21); 

                    				newLeafNode(otherlv_1, grammarAccess.getLightStatementAccess().getTurnKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,31,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getLightStatementAccess().getLightKeyword_1());
            		
            // InternalRailSL.g:840:3: ( (lv_lights_3_0= RULE_INT ) )
            // InternalRailSL.g:841:4: (lv_lights_3_0= RULE_INT )
            {
            // InternalRailSL.g:841:4: (lv_lights_3_0= RULE_INT )
            // InternalRailSL.g:842:5: lv_lights_3_0= RULE_INT
            {
            lv_lights_3_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					newLeafNode(lv_lights_3_0, grammarAccess.getLightStatementAccess().getLightsINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLightStatementRule());
            					}
            					addWithLastConsumed(
            						current,
            						"lights",
            						lv_lights_3_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalRailSL.g:858:3: ( (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_lights_8_0= RULE_INT ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=16 && LA19_0<=17)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalRailSL.g:859:4: (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) ) ( (lv_lights_8_0= RULE_INT ) )
            	    {
            	    // InternalRailSL.g:859:4: (otherlv_4= ',' | otherlv_5= 'and' | (otherlv_6= ',' otherlv_7= 'and' ) )
            	    int alt18=3;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==16) ) {
            	        int LA18_1 = input.LA(2);

            	        if ( (LA18_1==17) ) {
            	            alt18=3;
            	        }
            	        else if ( (LA18_1==RULE_INT) ) {
            	            alt18=1;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 18, 1, input);

            	            throw nvae;
            	        }
            	    }
            	    else if ( (LA18_0==17) ) {
            	        alt18=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // InternalRailSL.g:860:5: otherlv_4= ','
            	            {
            	            otherlv_4=(Token)match(input,16,FOLLOW_13); 

            	            					newLeafNode(otherlv_4, grammarAccess.getLightStatementAccess().getCommaKeyword_3_0_0());
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalRailSL.g:865:5: otherlv_5= 'and'
            	            {
            	            otherlv_5=(Token)match(input,17,FOLLOW_13); 

            	            					newLeafNode(otherlv_5, grammarAccess.getLightStatementAccess().getAndKeyword_3_0_1());
            	            				

            	            }
            	            break;
            	        case 3 :
            	            // InternalRailSL.g:870:5: (otherlv_6= ',' otherlv_7= 'and' )
            	            {
            	            // InternalRailSL.g:870:5: (otherlv_6= ',' otherlv_7= 'and' )
            	            // InternalRailSL.g:871:6: otherlv_6= ',' otherlv_7= 'and'
            	            {
            	            otherlv_6=(Token)match(input,16,FOLLOW_8); 

            	            						newLeafNode(otherlv_6, grammarAccess.getLightStatementAccess().getCommaKeyword_3_0_2_0());
            	            					
            	            otherlv_7=(Token)match(input,17,FOLLOW_13); 

            	            						newLeafNode(otherlv_7, grammarAccess.getLightStatementAccess().getAndKeyword_3_0_2_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalRailSL.g:881:4: ( (lv_lights_8_0= RULE_INT ) )
            	    // InternalRailSL.g:882:5: (lv_lights_8_0= RULE_INT )
            	    {
            	    // InternalRailSL.g:882:5: (lv_lights_8_0= RULE_INT )
            	    // InternalRailSL.g:883:6: lv_lights_8_0= RULE_INT
            	    {
            	    lv_lights_8_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            	    						newLeafNode(lv_lights_8_0, grammarAccess.getLightStatementAccess().getLightsINTTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getLightStatementRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"lights",
            	    							lv_lights_8_0,
            	    							"org.eclipse.xtext.common.Terminals.INT");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalRailSL.g:900:3: ( ( (lv_state_9_1= 'on' | lv_state_9_2= 'off' ) ) )
            // InternalRailSL.g:901:4: ( (lv_state_9_1= 'on' | lv_state_9_2= 'off' ) )
            {
            // InternalRailSL.g:901:4: ( (lv_state_9_1= 'on' | lv_state_9_2= 'off' ) )
            // InternalRailSL.g:902:5: (lv_state_9_1= 'on' | lv_state_9_2= 'off' )
            {
            // InternalRailSL.g:902:5: (lv_state_9_1= 'on' | lv_state_9_2= 'off' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            else if ( (LA20_0==33) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalRailSL.g:903:6: lv_state_9_1= 'on'
                    {
                    lv_state_9_1=(Token)match(input,32,FOLLOW_10); 

                    						newLeafNode(lv_state_9_1, grammarAccess.getLightStatementAccess().getStateOnKeyword_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLightStatementRule());
                    						}
                    						setWithLastConsumed(current, "state", lv_state_9_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:914:6: lv_state_9_2= 'off'
                    {
                    lv_state_9_2=(Token)match(input,33,FOLLOW_10); 

                    						newLeafNode(lv_state_9_2, grammarAccess.getLightStatementAccess().getStateOffKeyword_4_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getLightStatementRule());
                    						}
                    						setWithLastConsumed(current, "state", lv_state_9_2, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_10=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getLightStatementAccess().getFullStopKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLightStatement"


    // $ANTLR start "entryRuleConditionalStatement"
    // InternalRailSL.g:935:1: entryRuleConditionalStatement returns [EObject current=null] : iv_ruleConditionalStatement= ruleConditionalStatement EOF ;
    public final EObject entryRuleConditionalStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalStatement = null;


        try {
            // InternalRailSL.g:935:61: (iv_ruleConditionalStatement= ruleConditionalStatement EOF )
            // InternalRailSL.g:936:2: iv_ruleConditionalStatement= ruleConditionalStatement EOF
            {
             newCompositeNode(grammarAccess.getConditionalStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditionalStatement=ruleConditionalStatement();

            state._fsp--;

             current =iv_ruleConditionalStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalStatement"


    // $ANTLR start "ruleConditionalStatement"
    // InternalRailSL.g:942:1: ruleConditionalStatement returns [EObject current=null] : ( (otherlv_0= 'Branch:' | otherlv_1= 'branch:' ) ( (lv_lines_2_0= ruleConditionalLine ) ) ( (lv_lines_3_0= ruleConditionalLine ) )+ ) ;
    public final EObject ruleConditionalStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_lines_2_0 = null;

        EObject lv_lines_3_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:948:2: ( ( (otherlv_0= 'Branch:' | otherlv_1= 'branch:' ) ( (lv_lines_2_0= ruleConditionalLine ) ) ( (lv_lines_3_0= ruleConditionalLine ) )+ ) )
            // InternalRailSL.g:949:2: ( (otherlv_0= 'Branch:' | otherlv_1= 'branch:' ) ( (lv_lines_2_0= ruleConditionalLine ) ) ( (lv_lines_3_0= ruleConditionalLine ) )+ )
            {
            // InternalRailSL.g:949:2: ( (otherlv_0= 'Branch:' | otherlv_1= 'branch:' ) ( (lv_lines_2_0= ruleConditionalLine ) ) ( (lv_lines_3_0= ruleConditionalLine ) )+ )
            // InternalRailSL.g:950:3: (otherlv_0= 'Branch:' | otherlv_1= 'branch:' ) ( (lv_lines_2_0= ruleConditionalLine ) ) ( (lv_lines_3_0= ruleConditionalLine ) )+
            {
            // InternalRailSL.g:950:3: (otherlv_0= 'Branch:' | otherlv_1= 'branch:' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            else if ( (LA21_0==35) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalRailSL.g:951:4: otherlv_0= 'Branch:'
                    {
                    otherlv_0=(Token)match(input,34,FOLLOW_23); 

                    				newLeafNode(otherlv_0, grammarAccess.getConditionalStatementAccess().getBranchKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:956:4: otherlv_1= 'branch:'
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_23); 

                    				newLeafNode(otherlv_1, grammarAccess.getConditionalStatementAccess().getBranchKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRailSL.g:961:3: ( (lv_lines_2_0= ruleConditionalLine ) )
            // InternalRailSL.g:962:4: (lv_lines_2_0= ruleConditionalLine )
            {
            // InternalRailSL.g:962:4: (lv_lines_2_0= ruleConditionalLine )
            // InternalRailSL.g:963:5: lv_lines_2_0= ruleConditionalLine
            {

            					newCompositeNode(grammarAccess.getConditionalStatementAccess().getLinesConditionalLineParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_23);
            lv_lines_2_0=ruleConditionalLine();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionalStatementRule());
            					}
            					add(
            						current,
            						"lines",
            						lv_lines_2_0,
            						"de.cau.cs.kieler.railsl.RailSL.ConditionalLine");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRailSL.g:980:3: ( (lv_lines_3_0= ruleConditionalLine ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=36 && LA22_0<=37)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalRailSL.g:981:4: (lv_lines_3_0= ruleConditionalLine )
            	    {
            	    // InternalRailSL.g:981:4: (lv_lines_3_0= ruleConditionalLine )
            	    // InternalRailSL.g:982:5: lv_lines_3_0= ruleConditionalLine
            	    {

            	    					newCompositeNode(grammarAccess.getConditionalStatementAccess().getLinesConditionalLineParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_24);
            	    lv_lines_3_0=ruleConditionalLine();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConditionalStatementRule());
            	    					}
            	    					add(
            	    						current,
            	    						"lines",
            	    						lv_lines_3_0,
            	    						"de.cau.cs.kieler.railsl.RailSL.ConditionalLine");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalStatement"


    // $ANTLR start "entryRuleConditionalLine"
    // InternalRailSL.g:1003:1: entryRuleConditionalLine returns [EObject current=null] : iv_ruleConditionalLine= ruleConditionalLine EOF ;
    public final EObject entryRuleConditionalLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalLine = null;


        try {
            // InternalRailSL.g:1003:56: (iv_ruleConditionalLine= ruleConditionalLine EOF )
            // InternalRailSL.g:1004:2: iv_ruleConditionalLine= ruleConditionalLine EOF
            {
             newCompositeNode(grammarAccess.getConditionalLineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditionalLine=ruleConditionalLine();

            state._fsp--;

             current =iv_ruleConditionalLine; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalLine"


    // $ANTLR start "ruleConditionalLine"
    // InternalRailSL.g:1010:1: ruleConditionalLine returns [EObject current=null] : ( (otherlv_0= 'If' | otherlv_1= 'if' ) ( (lv_contact_2_0= ruleContactPosition ) ) otherlv_3= 'contact' otherlv_4= 'of' ( (lv_segment_5_0= ruleRailSegment ) ) otherlv_6= 'is' otherlv_7= 'reached' (otherlv_8= 'first' | otherlv_9= 'first,' ) otherlv_10= 'do' ( (lv_block_11_0= ruleBlock ) ) ) ;
    public final EObject ruleConditionalLine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Enumerator lv_contact_2_0 = null;

        Enumerator lv_segment_5_0 = null;

        EObject lv_block_11_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:1016:2: ( ( (otherlv_0= 'If' | otherlv_1= 'if' ) ( (lv_contact_2_0= ruleContactPosition ) ) otherlv_3= 'contact' otherlv_4= 'of' ( (lv_segment_5_0= ruleRailSegment ) ) otherlv_6= 'is' otherlv_7= 'reached' (otherlv_8= 'first' | otherlv_9= 'first,' ) otherlv_10= 'do' ( (lv_block_11_0= ruleBlock ) ) ) )
            // InternalRailSL.g:1017:2: ( (otherlv_0= 'If' | otherlv_1= 'if' ) ( (lv_contact_2_0= ruleContactPosition ) ) otherlv_3= 'contact' otherlv_4= 'of' ( (lv_segment_5_0= ruleRailSegment ) ) otherlv_6= 'is' otherlv_7= 'reached' (otherlv_8= 'first' | otherlv_9= 'first,' ) otherlv_10= 'do' ( (lv_block_11_0= ruleBlock ) ) )
            {
            // InternalRailSL.g:1017:2: ( (otherlv_0= 'If' | otherlv_1= 'if' ) ( (lv_contact_2_0= ruleContactPosition ) ) otherlv_3= 'contact' otherlv_4= 'of' ( (lv_segment_5_0= ruleRailSegment ) ) otherlv_6= 'is' otherlv_7= 'reached' (otherlv_8= 'first' | otherlv_9= 'first,' ) otherlv_10= 'do' ( (lv_block_11_0= ruleBlock ) ) )
            // InternalRailSL.g:1018:3: (otherlv_0= 'If' | otherlv_1= 'if' ) ( (lv_contact_2_0= ruleContactPosition ) ) otherlv_3= 'contact' otherlv_4= 'of' ( (lv_segment_5_0= ruleRailSegment ) ) otherlv_6= 'is' otherlv_7= 'reached' (otherlv_8= 'first' | otherlv_9= 'first,' ) otherlv_10= 'do' ( (lv_block_11_0= ruleBlock ) )
            {
            // InternalRailSL.g:1018:3: (otherlv_0= 'If' | otherlv_1= 'if' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==36) ) {
                alt23=1;
            }
            else if ( (LA23_0==37) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalRailSL.g:1019:4: otherlv_0= 'If'
                    {
                    otherlv_0=(Token)match(input,36,FOLLOW_17); 

                    				newLeafNode(otherlv_0, grammarAccess.getConditionalLineAccess().getIfKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1024:4: otherlv_1= 'if'
                    {
                    otherlv_1=(Token)match(input,37,FOLLOW_17); 

                    				newLeafNode(otherlv_1, grammarAccess.getConditionalLineAccess().getIfKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRailSL.g:1029:3: ( (lv_contact_2_0= ruleContactPosition ) )
            // InternalRailSL.g:1030:4: (lv_contact_2_0= ruleContactPosition )
            {
            // InternalRailSL.g:1030:4: (lv_contact_2_0= ruleContactPosition )
            // InternalRailSL.g:1031:5: lv_contact_2_0= ruleContactPosition
            {

            					newCompositeNode(grammarAccess.getConditionalLineAccess().getContactContactPositionEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_contact_2_0=ruleContactPosition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionalLineRule());
            					}
            					set(
            						current,
            						"contact",
            						lv_contact_2_0,
            						"de.cau.cs.kieler.railsl.RailSL.ContactPosition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_25); 

            			newLeafNode(otherlv_3, grammarAccess.getConditionalLineAccess().getContactKeyword_2());
            		
            otherlv_4=(Token)match(input,27,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getConditionalLineAccess().getOfKeyword_3());
            		
            // InternalRailSL.g:1056:3: ( (lv_segment_5_0= ruleRailSegment ) )
            // InternalRailSL.g:1057:4: (lv_segment_5_0= ruleRailSegment )
            {
            // InternalRailSL.g:1057:4: (lv_segment_5_0= ruleRailSegment )
            // InternalRailSL.g:1058:5: lv_segment_5_0= ruleRailSegment
            {

            					newCompositeNode(grammarAccess.getConditionalLineAccess().getSegmentRailSegmentEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_26);
            lv_segment_5_0=ruleRailSegment();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionalLineRule());
            					}
            					set(
            						current,
            						"segment",
            						lv_segment_5_0,
            						"de.cau.cs.kieler.railsl.RailSL.RailSegment");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,38,FOLLOW_27); 

            			newLeafNode(otherlv_6, grammarAccess.getConditionalLineAccess().getIsKeyword_5());
            		
            otherlv_7=(Token)match(input,39,FOLLOW_28); 

            			newLeafNode(otherlv_7, grammarAccess.getConditionalLineAccess().getReachedKeyword_6());
            		
            // InternalRailSL.g:1083:3: (otherlv_8= 'first' | otherlv_9= 'first,' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==40) ) {
                alt24=1;
            }
            else if ( (LA24_0==41) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalRailSL.g:1084:4: otherlv_8= 'first'
                    {
                    otherlv_8=(Token)match(input,40,FOLLOW_29); 

                    				newLeafNode(otherlv_8, grammarAccess.getConditionalLineAccess().getFirstKeyword_7_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1089:4: otherlv_9= 'first,'
                    {
                    otherlv_9=(Token)match(input,41,FOLLOW_29); 

                    				newLeafNode(otherlv_9, grammarAccess.getConditionalLineAccess().getFirstKeyword_7_1());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,42,FOLLOW_30); 

            			newLeafNode(otherlv_10, grammarAccess.getConditionalLineAccess().getDoKeyword_8());
            		
            // InternalRailSL.g:1098:3: ( (lv_block_11_0= ruleBlock ) )
            // InternalRailSL.g:1099:4: (lv_block_11_0= ruleBlock )
            {
            // InternalRailSL.g:1099:4: (lv_block_11_0= ruleBlock )
            // InternalRailSL.g:1100:5: lv_block_11_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getConditionalLineAccess().getBlockBlockParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_2);
            lv_block_11_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionalLineRule());
            					}
            					set(
            						current,
            						"block",
            						lv_block_11_0,
            						"de.cau.cs.kieler.railsl.RailSL.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalLine"


    // $ANTLR start "entryRuleParallelStatement"
    // InternalRailSL.g:1121:1: entryRuleParallelStatement returns [EObject current=null] : iv_ruleParallelStatement= ruleParallelStatement EOF ;
    public final EObject entryRuleParallelStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParallelStatement = null;


        try {
            // InternalRailSL.g:1121:58: (iv_ruleParallelStatement= ruleParallelStatement EOF )
            // InternalRailSL.g:1122:2: iv_ruleParallelStatement= ruleParallelStatement EOF
            {
             newCompositeNode(grammarAccess.getParallelStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParallelStatement=ruleParallelStatement();

            state._fsp--;

             current =iv_ruleParallelStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParallelStatement"


    // $ANTLR start "ruleParallelStatement"
    // InternalRailSL.g:1128:1: ruleParallelStatement returns [EObject current=null] : ( (otherlv_0= 'Parallel:' | otherlv_1= 'parallel:' ) ( (lv_blocks_2_0= ruleBlock ) ) ( (lv_blocks_3_0= ruleBlock ) )+ ) ;
    public final EObject ruleParallelStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_blocks_2_0 = null;

        EObject lv_blocks_3_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:1134:2: ( ( (otherlv_0= 'Parallel:' | otherlv_1= 'parallel:' ) ( (lv_blocks_2_0= ruleBlock ) ) ( (lv_blocks_3_0= ruleBlock ) )+ ) )
            // InternalRailSL.g:1135:2: ( (otherlv_0= 'Parallel:' | otherlv_1= 'parallel:' ) ( (lv_blocks_2_0= ruleBlock ) ) ( (lv_blocks_3_0= ruleBlock ) )+ )
            {
            // InternalRailSL.g:1135:2: ( (otherlv_0= 'Parallel:' | otherlv_1= 'parallel:' ) ( (lv_blocks_2_0= ruleBlock ) ) ( (lv_blocks_3_0= ruleBlock ) )+ )
            // InternalRailSL.g:1136:3: (otherlv_0= 'Parallel:' | otherlv_1= 'parallel:' ) ( (lv_blocks_2_0= ruleBlock ) ) ( (lv_blocks_3_0= ruleBlock ) )+
            {
            // InternalRailSL.g:1136:3: (otherlv_0= 'Parallel:' | otherlv_1= 'parallel:' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==43) ) {
                alt25=1;
            }
            else if ( (LA25_0==44) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalRailSL.g:1137:4: otherlv_0= 'Parallel:'
                    {
                    otherlv_0=(Token)match(input,43,FOLLOW_30); 

                    				newLeafNode(otherlv_0, grammarAccess.getParallelStatementAccess().getParallelKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1142:4: otherlv_1= 'parallel:'
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_30); 

                    				newLeafNode(otherlv_1, grammarAccess.getParallelStatementAccess().getParallelKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRailSL.g:1147:3: ( (lv_blocks_2_0= ruleBlock ) )
            // InternalRailSL.g:1148:4: (lv_blocks_2_0= ruleBlock )
            {
            // InternalRailSL.g:1148:4: (lv_blocks_2_0= ruleBlock )
            // InternalRailSL.g:1149:5: lv_blocks_2_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getParallelStatementAccess().getBlocksBlockParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_30);
            lv_blocks_2_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParallelStatementRule());
            					}
            					add(
            						current,
            						"blocks",
            						lv_blocks_2_0,
            						"de.cau.cs.kieler.railsl.RailSL.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRailSL.g:1166:3: ( (lv_blocks_3_0= ruleBlock ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=11 && LA26_0<=12)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalRailSL.g:1167:4: (lv_blocks_3_0= ruleBlock )
            	    {
            	    // InternalRailSL.g:1167:4: (lv_blocks_3_0= ruleBlock )
            	    // InternalRailSL.g:1168:5: lv_blocks_3_0= ruleBlock
            	    {

            	    					newCompositeNode(grammarAccess.getParallelStatementAccess().getBlocksBlockParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_blocks_3_0=ruleBlock();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getParallelStatementRule());
            	    					}
            	    					add(
            	    						current,
            	    						"blocks",
            	    						lv_blocks_3_0,
            	    						"de.cau.cs.kieler.railsl.RailSL.Block");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParallelStatement"


    // $ANTLR start "ruleBlockEnd"
    // InternalRailSL.g:1189:1: ruleBlockEnd returns [Enumerator current=null] : ( (enumLiteral_0= 'End.' ) | (enumLiteral_1= 'end.' ) | (enumLiteral_2= 'Loop.' ) | (enumLiteral_3= 'loop.' ) ) ;
    public final Enumerator ruleBlockEnd() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRailSL.g:1195:2: ( ( (enumLiteral_0= 'End.' ) | (enumLiteral_1= 'end.' ) | (enumLiteral_2= 'Loop.' ) | (enumLiteral_3= 'loop.' ) ) )
            // InternalRailSL.g:1196:2: ( (enumLiteral_0= 'End.' ) | (enumLiteral_1= 'end.' ) | (enumLiteral_2= 'Loop.' ) | (enumLiteral_3= 'loop.' ) )
            {
            // InternalRailSL.g:1196:2: ( (enumLiteral_0= 'End.' ) | (enumLiteral_1= 'end.' ) | (enumLiteral_2= 'Loop.' ) | (enumLiteral_3= 'loop.' ) )
            int alt27=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt27=1;
                }
                break;
            case 46:
                {
                alt27=2;
                }
                break;
            case 47:
                {
                alt27=3;
                }
                break;
            case 48:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalRailSL.g:1197:3: (enumLiteral_0= 'End.' )
                    {
                    // InternalRailSL.g:1197:3: (enumLiteral_0= 'End.' )
                    // InternalRailSL.g:1198:4: enumLiteral_0= 'End.'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1205:3: (enumLiteral_1= 'end.' )
                    {
                    // InternalRailSL.g:1205:3: (enumLiteral_1= 'end.' )
                    // InternalRailSL.g:1206:4: enumLiteral_1= 'end.'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1213:3: (enumLiteral_2= 'Loop.' )
                    {
                    // InternalRailSL.g:1213:3: (enumLiteral_2= 'Loop.' )
                    // InternalRailSL.g:1214:4: enumLiteral_2= 'Loop.'
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getBlockEndAccess().getLOOPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBlockEndAccess().getLOOPEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1221:3: (enumLiteral_3= 'loop.' )
                    {
                    // InternalRailSL.g:1221:3: (enumLiteral_3= 'loop.' )
                    // InternalRailSL.g:1222:4: enumLiteral_3= 'loop.'
                    {
                    enumLiteral_3=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getBlockEndAccess().getLOOPEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getBlockEndAccess().getLOOPEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockEnd"


    // $ANTLR start "ruleTrackSpeedStop"
    // InternalRailSL.g:1232:1: ruleTrackSpeedStop returns [Enumerator current=null] : (enumLiteral_0= 'stop' ) ;
    public final Enumerator ruleTrackSpeedStop() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalRailSL.g:1238:2: ( (enumLiteral_0= 'stop' ) )
            // InternalRailSL.g:1239:2: (enumLiteral_0= 'stop' )
            {
            // InternalRailSL.g:1239:2: (enumLiteral_0= 'stop' )
            // InternalRailSL.g:1240:3: enumLiteral_0= 'stop'
            {
            enumLiteral_0=(Token)match(input,49,FOLLOW_2); 

            			current = grammarAccess.getTrackSpeedStopAccess().getSTOPEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getTrackSpeedStopAccess().getSTOPEnumLiteralDeclaration());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrackSpeedStop"


    // $ANTLR start "ruleTrackSpeedDrive"
    // InternalRailSL.g:1249:1: ruleTrackSpeedDrive returns [Enumerator current=null] : ( (enumLiteral_0= 'full' ) | (enumLiteral_1= 'slow' ) ) ;
    public final Enumerator ruleTrackSpeedDrive() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRailSL.g:1255:2: ( ( (enumLiteral_0= 'full' ) | (enumLiteral_1= 'slow' ) ) )
            // InternalRailSL.g:1256:2: ( (enumLiteral_0= 'full' ) | (enumLiteral_1= 'slow' ) )
            {
            // InternalRailSL.g:1256:2: ( (enumLiteral_0= 'full' ) | (enumLiteral_1= 'slow' ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==50) ) {
                alt28=1;
            }
            else if ( (LA28_0==51) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalRailSL.g:1257:3: (enumLiteral_0= 'full' )
                    {
                    // InternalRailSL.g:1257:3: (enumLiteral_0= 'full' )
                    // InternalRailSL.g:1258:4: enumLiteral_0= 'full'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getTrackSpeedDriveAccess().getFULLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTrackSpeedDriveAccess().getFULLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1265:3: (enumLiteral_1= 'slow' )
                    {
                    // InternalRailSL.g:1265:3: (enumLiteral_1= 'slow' )
                    // InternalRailSL.g:1266:4: enumLiteral_1= 'slow'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getTrackSpeedDriveAccess().getSLOWEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getTrackSpeedDriveAccess().getSLOWEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrackSpeedDrive"


    // $ANTLR start "rulePointOrinetation"
    // InternalRailSL.g:1276:1: rulePointOrinetation returns [Enumerator current=null] : ( (enumLiteral_0= 'straight' ) | (enumLiteral_1= 'branch' ) ) ;
    public final Enumerator rulePointOrinetation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRailSL.g:1282:2: ( ( (enumLiteral_0= 'straight' ) | (enumLiteral_1= 'branch' ) ) )
            // InternalRailSL.g:1283:2: ( (enumLiteral_0= 'straight' ) | (enumLiteral_1= 'branch' ) )
            {
            // InternalRailSL.g:1283:2: ( (enumLiteral_0= 'straight' ) | (enumLiteral_1= 'branch' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==52) ) {
                alt29=1;
            }
            else if ( (LA29_0==53) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalRailSL.g:1284:3: (enumLiteral_0= 'straight' )
                    {
                    // InternalRailSL.g:1284:3: (enumLiteral_0= 'straight' )
                    // InternalRailSL.g:1285:4: enumLiteral_0= 'straight'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getPointOrinetationAccess().getSTRAIGHTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPointOrinetationAccess().getSTRAIGHTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1292:3: (enumLiteral_1= 'branch' )
                    {
                    // InternalRailSL.g:1292:3: (enumLiteral_1= 'branch' )
                    // InternalRailSL.g:1293:4: enumLiteral_1= 'branch'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getPointOrinetationAccess().getBRANCHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPointOrinetationAccess().getBRANCHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePointOrinetation"


    // $ANTLR start "ruleContactEvent"
    // InternalRailSL.g:1303:1: ruleContactEvent returns [Enumerator current=null] : ( (enumLiteral_0= 'Reach' ) | (enumLiteral_1= 'reach' ) | (enumLiteral_2= 'Pass' ) | (enumLiteral_3= 'pass' ) ) ;
    public final Enumerator ruleContactEvent() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRailSL.g:1309:2: ( ( (enumLiteral_0= 'Reach' ) | (enumLiteral_1= 'reach' ) | (enumLiteral_2= 'Pass' ) | (enumLiteral_3= 'pass' ) ) )
            // InternalRailSL.g:1310:2: ( (enumLiteral_0= 'Reach' ) | (enumLiteral_1= 'reach' ) | (enumLiteral_2= 'Pass' ) | (enumLiteral_3= 'pass' ) )
            {
            // InternalRailSL.g:1310:2: ( (enumLiteral_0= 'Reach' ) | (enumLiteral_1= 'reach' ) | (enumLiteral_2= 'Pass' ) | (enumLiteral_3= 'pass' ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt30=1;
                }
                break;
            case 55:
                {
                alt30=2;
                }
                break;
            case 56:
                {
                alt30=3;
                }
                break;
            case 57:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalRailSL.g:1311:3: (enumLiteral_0= 'Reach' )
                    {
                    // InternalRailSL.g:1311:3: (enumLiteral_0= 'Reach' )
                    // InternalRailSL.g:1312:4: enumLiteral_0= 'Reach'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1319:3: (enumLiteral_1= 'reach' )
                    {
                    // InternalRailSL.g:1319:3: (enumLiteral_1= 'reach' )
                    // InternalRailSL.g:1320:4: enumLiteral_1= 'reach'
                    {
                    enumLiteral_1=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1327:3: (enumLiteral_2= 'Pass' )
                    {
                    // InternalRailSL.g:1327:3: (enumLiteral_2= 'Pass' )
                    // InternalRailSL.g:1328:4: enumLiteral_2= 'Pass'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getContactEventAccess().getPASSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getContactEventAccess().getPASSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1335:3: (enumLiteral_3= 'pass' )
                    {
                    // InternalRailSL.g:1335:3: (enumLiteral_3= 'pass' )
                    // InternalRailSL.g:1336:4: enumLiteral_3= 'pass'
                    {
                    enumLiteral_3=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getContactEventAccess().getPASSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getContactEventAccess().getPASSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContactEvent"


    // $ANTLR start "ruleContactPosition"
    // InternalRailSL.g:1346:1: ruleContactPosition returns [Enumerator current=null] : ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'second' ) ) ;
    public final Enumerator ruleContactPosition() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRailSL.g:1352:2: ( ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'second' ) ) )
            // InternalRailSL.g:1353:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'second' ) )
            {
            // InternalRailSL.g:1353:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'second' ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==40) ) {
                alt31=1;
            }
            else if ( (LA31_0==58) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalRailSL.g:1354:3: (enumLiteral_0= 'first' )
                    {
                    // InternalRailSL.g:1354:3: (enumLiteral_0= 'first' )
                    // InternalRailSL.g:1355:4: enumLiteral_0= 'first'
                    {
                    enumLiteral_0=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getContactPositionAccess().getFIRSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getContactPositionAccess().getFIRSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1362:3: (enumLiteral_1= 'second' )
                    {
                    // InternalRailSL.g:1362:3: (enumLiteral_1= 'second' )
                    // InternalRailSL.g:1363:4: enumLiteral_1= 'second'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getContactPositionAccess().getSECONDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getContactPositionAccess().getSECONDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContactPosition"


    // $ANTLR start "ruleCrossingMode"
    // InternalRailSL.g:1373:1: ruleCrossingMode returns [Enumerator current=null] : ( (enumLiteral_0= 'Open' ) | (enumLiteral_1= 'open' ) | (enumLiteral_2= 'Close' ) | (enumLiteral_3= 'close' ) ) ;
    public final Enumerator ruleCrossingMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRailSL.g:1379:2: ( ( (enumLiteral_0= 'Open' ) | (enumLiteral_1= 'open' ) | (enumLiteral_2= 'Close' ) | (enumLiteral_3= 'close' ) ) )
            // InternalRailSL.g:1380:2: ( (enumLiteral_0= 'Open' ) | (enumLiteral_1= 'open' ) | (enumLiteral_2= 'Close' ) | (enumLiteral_3= 'close' ) )
            {
            // InternalRailSL.g:1380:2: ( (enumLiteral_0= 'Open' ) | (enumLiteral_1= 'open' ) | (enumLiteral_2= 'Close' ) | (enumLiteral_3= 'close' ) )
            int alt32=4;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt32=1;
                }
                break;
            case 60:
                {
                alt32=2;
                }
                break;
            case 61:
                {
                alt32=3;
                }
                break;
            case 62:
                {
                alt32=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalRailSL.g:1381:3: (enumLiteral_0= 'Open' )
                    {
                    // InternalRailSL.g:1381:3: (enumLiteral_0= 'Open' )
                    // InternalRailSL.g:1382:4: enumLiteral_0= 'Open'
                    {
                    enumLiteral_0=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1389:3: (enumLiteral_1= 'open' )
                    {
                    // InternalRailSL.g:1389:3: (enumLiteral_1= 'open' )
                    // InternalRailSL.g:1390:4: enumLiteral_1= 'open'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1397:3: (enumLiteral_2= 'Close' )
                    {
                    // InternalRailSL.g:1397:3: (enumLiteral_2= 'Close' )
                    // InternalRailSL.g:1398:4: enumLiteral_2= 'Close'
                    {
                    enumLiteral_2=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getCrossingModeAccess().getCLOSEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCrossingModeAccess().getCLOSEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1405:3: (enumLiteral_3= 'close' )
                    {
                    // InternalRailSL.g:1405:3: (enumLiteral_3= 'close' )
                    // InternalRailSL.g:1406:4: enumLiteral_3= 'close'
                    {
                    enumLiteral_3=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getCrossingModeAccess().getCLOSEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getCrossingModeAccess().getCLOSEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCrossingMode"


    // $ANTLR start "ruleRailSegment"
    // InternalRailSL.g:1416:1: ruleRailSegment returns [Enumerator current=null] : ( (enumLiteral_0= 'KH_ST_0' ) | (enumLiteral_1= 'KH_ST_1' ) | (enumLiteral_2= 'KH_ST_2' ) | (enumLiteral_3= 'KH_ST_3' ) | (enumLiteral_4= 'KH_ST_4' ) | (enumLiteral_5= 'KH_ST_5' ) | (enumLiteral_6= 'KH_ST_6' ) | (enumLiteral_7= 'KH_LN_0' ) | (enumLiteral_8= 'KH_LN_1' ) | (enumLiteral_9= 'KH_LN_2' ) | (enumLiteral_10= 'KH_LN_3' ) | (enumLiteral_11= 'KH_LN_4' ) | (enumLiteral_12= 'KH_LN_5' ) | (enumLiteral_13= 'KH_LN_6' ) | (enumLiteral_14= 'KH_LN_7' ) | (enumLiteral_15= 'KH_LN_8' ) | (enumLiteral_16= 'KIO_LN_0' ) | (enumLiteral_17= 'KIO_LN_1' ) | (enumLiteral_18= 'OC_ST_0' ) | (enumLiteral_19= 'OC_ST_1' ) | (enumLiteral_20= 'OC_ST_2' ) | (enumLiteral_21= 'OC_ST_3' ) | (enumLiteral_22= 'OC_ST_4' ) | (enumLiteral_23= 'OC_LN_0' ) | (enumLiteral_24= 'OC_LN_1' ) | (enumLiteral_25= 'OC_LN_2' ) | (enumLiteral_26= 'OC_LN_3' ) | (enumLiteral_27= 'OC_LN_4' ) | (enumLiteral_28= 'OC_LN_5' ) | (enumLiteral_29= 'IC_ST_0' ) | (enumLiteral_30= 'IC_ST_1' ) | (enumLiteral_31= 'IC_ST_2' ) | (enumLiteral_32= 'IC_ST_3' ) | (enumLiteral_33= 'IC_ST_4' ) | (enumLiteral_34= 'IC_LN_0' ) | (enumLiteral_35= 'IC_LN_1' ) | (enumLiteral_36= 'IC_LN_2' ) | (enumLiteral_37= 'IC_LN_3' ) | (enumLiteral_38= 'IC_LN_4' ) | (enumLiteral_39= 'IC_LN_5' ) | (enumLiteral_40= 'OC_JCT_0' ) | (enumLiteral_41= 'IC_JCT_0' ) | (enumLiteral_42= 'OI_LN_0' ) | (enumLiteral_43= 'OI_LN_1' ) | (enumLiteral_44= 'OI_LN_2' ) | (enumLiteral_45= 'IO_LN_0' ) | (enumLiteral_46= 'IO_LN_1' ) | (enumLiteral_47= 'IO_LN_2' ) ) ;
    public final Enumerator ruleRailSegment() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;
        Token enumLiteral_23=null;
        Token enumLiteral_24=null;
        Token enumLiteral_25=null;
        Token enumLiteral_26=null;
        Token enumLiteral_27=null;
        Token enumLiteral_28=null;
        Token enumLiteral_29=null;
        Token enumLiteral_30=null;
        Token enumLiteral_31=null;
        Token enumLiteral_32=null;
        Token enumLiteral_33=null;
        Token enumLiteral_34=null;
        Token enumLiteral_35=null;
        Token enumLiteral_36=null;
        Token enumLiteral_37=null;
        Token enumLiteral_38=null;
        Token enumLiteral_39=null;
        Token enumLiteral_40=null;
        Token enumLiteral_41=null;
        Token enumLiteral_42=null;
        Token enumLiteral_43=null;
        Token enumLiteral_44=null;
        Token enumLiteral_45=null;
        Token enumLiteral_46=null;
        Token enumLiteral_47=null;


        	enterRule();

        try {
            // InternalRailSL.g:1422:2: ( ( (enumLiteral_0= 'KH_ST_0' ) | (enumLiteral_1= 'KH_ST_1' ) | (enumLiteral_2= 'KH_ST_2' ) | (enumLiteral_3= 'KH_ST_3' ) | (enumLiteral_4= 'KH_ST_4' ) | (enumLiteral_5= 'KH_ST_5' ) | (enumLiteral_6= 'KH_ST_6' ) | (enumLiteral_7= 'KH_LN_0' ) | (enumLiteral_8= 'KH_LN_1' ) | (enumLiteral_9= 'KH_LN_2' ) | (enumLiteral_10= 'KH_LN_3' ) | (enumLiteral_11= 'KH_LN_4' ) | (enumLiteral_12= 'KH_LN_5' ) | (enumLiteral_13= 'KH_LN_6' ) | (enumLiteral_14= 'KH_LN_7' ) | (enumLiteral_15= 'KH_LN_8' ) | (enumLiteral_16= 'KIO_LN_0' ) | (enumLiteral_17= 'KIO_LN_1' ) | (enumLiteral_18= 'OC_ST_0' ) | (enumLiteral_19= 'OC_ST_1' ) | (enumLiteral_20= 'OC_ST_2' ) | (enumLiteral_21= 'OC_ST_3' ) | (enumLiteral_22= 'OC_ST_4' ) | (enumLiteral_23= 'OC_LN_0' ) | (enumLiteral_24= 'OC_LN_1' ) | (enumLiteral_25= 'OC_LN_2' ) | (enumLiteral_26= 'OC_LN_3' ) | (enumLiteral_27= 'OC_LN_4' ) | (enumLiteral_28= 'OC_LN_5' ) | (enumLiteral_29= 'IC_ST_0' ) | (enumLiteral_30= 'IC_ST_1' ) | (enumLiteral_31= 'IC_ST_2' ) | (enumLiteral_32= 'IC_ST_3' ) | (enumLiteral_33= 'IC_ST_4' ) | (enumLiteral_34= 'IC_LN_0' ) | (enumLiteral_35= 'IC_LN_1' ) | (enumLiteral_36= 'IC_LN_2' ) | (enumLiteral_37= 'IC_LN_3' ) | (enumLiteral_38= 'IC_LN_4' ) | (enumLiteral_39= 'IC_LN_5' ) | (enumLiteral_40= 'OC_JCT_0' ) | (enumLiteral_41= 'IC_JCT_0' ) | (enumLiteral_42= 'OI_LN_0' ) | (enumLiteral_43= 'OI_LN_1' ) | (enumLiteral_44= 'OI_LN_2' ) | (enumLiteral_45= 'IO_LN_0' ) | (enumLiteral_46= 'IO_LN_1' ) | (enumLiteral_47= 'IO_LN_2' ) ) )
            // InternalRailSL.g:1423:2: ( (enumLiteral_0= 'KH_ST_0' ) | (enumLiteral_1= 'KH_ST_1' ) | (enumLiteral_2= 'KH_ST_2' ) | (enumLiteral_3= 'KH_ST_3' ) | (enumLiteral_4= 'KH_ST_4' ) | (enumLiteral_5= 'KH_ST_5' ) | (enumLiteral_6= 'KH_ST_6' ) | (enumLiteral_7= 'KH_LN_0' ) | (enumLiteral_8= 'KH_LN_1' ) | (enumLiteral_9= 'KH_LN_2' ) | (enumLiteral_10= 'KH_LN_3' ) | (enumLiteral_11= 'KH_LN_4' ) | (enumLiteral_12= 'KH_LN_5' ) | (enumLiteral_13= 'KH_LN_6' ) | (enumLiteral_14= 'KH_LN_7' ) | (enumLiteral_15= 'KH_LN_8' ) | (enumLiteral_16= 'KIO_LN_0' ) | (enumLiteral_17= 'KIO_LN_1' ) | (enumLiteral_18= 'OC_ST_0' ) | (enumLiteral_19= 'OC_ST_1' ) | (enumLiteral_20= 'OC_ST_2' ) | (enumLiteral_21= 'OC_ST_3' ) | (enumLiteral_22= 'OC_ST_4' ) | (enumLiteral_23= 'OC_LN_0' ) | (enumLiteral_24= 'OC_LN_1' ) | (enumLiteral_25= 'OC_LN_2' ) | (enumLiteral_26= 'OC_LN_3' ) | (enumLiteral_27= 'OC_LN_4' ) | (enumLiteral_28= 'OC_LN_5' ) | (enumLiteral_29= 'IC_ST_0' ) | (enumLiteral_30= 'IC_ST_1' ) | (enumLiteral_31= 'IC_ST_2' ) | (enumLiteral_32= 'IC_ST_3' ) | (enumLiteral_33= 'IC_ST_4' ) | (enumLiteral_34= 'IC_LN_0' ) | (enumLiteral_35= 'IC_LN_1' ) | (enumLiteral_36= 'IC_LN_2' ) | (enumLiteral_37= 'IC_LN_3' ) | (enumLiteral_38= 'IC_LN_4' ) | (enumLiteral_39= 'IC_LN_5' ) | (enumLiteral_40= 'OC_JCT_0' ) | (enumLiteral_41= 'IC_JCT_0' ) | (enumLiteral_42= 'OI_LN_0' ) | (enumLiteral_43= 'OI_LN_1' ) | (enumLiteral_44= 'OI_LN_2' ) | (enumLiteral_45= 'IO_LN_0' ) | (enumLiteral_46= 'IO_LN_1' ) | (enumLiteral_47= 'IO_LN_2' ) )
            {
            // InternalRailSL.g:1423:2: ( (enumLiteral_0= 'KH_ST_0' ) | (enumLiteral_1= 'KH_ST_1' ) | (enumLiteral_2= 'KH_ST_2' ) | (enumLiteral_3= 'KH_ST_3' ) | (enumLiteral_4= 'KH_ST_4' ) | (enumLiteral_5= 'KH_ST_5' ) | (enumLiteral_6= 'KH_ST_6' ) | (enumLiteral_7= 'KH_LN_0' ) | (enumLiteral_8= 'KH_LN_1' ) | (enumLiteral_9= 'KH_LN_2' ) | (enumLiteral_10= 'KH_LN_3' ) | (enumLiteral_11= 'KH_LN_4' ) | (enumLiteral_12= 'KH_LN_5' ) | (enumLiteral_13= 'KH_LN_6' ) | (enumLiteral_14= 'KH_LN_7' ) | (enumLiteral_15= 'KH_LN_8' ) | (enumLiteral_16= 'KIO_LN_0' ) | (enumLiteral_17= 'KIO_LN_1' ) | (enumLiteral_18= 'OC_ST_0' ) | (enumLiteral_19= 'OC_ST_1' ) | (enumLiteral_20= 'OC_ST_2' ) | (enumLiteral_21= 'OC_ST_3' ) | (enumLiteral_22= 'OC_ST_4' ) | (enumLiteral_23= 'OC_LN_0' ) | (enumLiteral_24= 'OC_LN_1' ) | (enumLiteral_25= 'OC_LN_2' ) | (enumLiteral_26= 'OC_LN_3' ) | (enumLiteral_27= 'OC_LN_4' ) | (enumLiteral_28= 'OC_LN_5' ) | (enumLiteral_29= 'IC_ST_0' ) | (enumLiteral_30= 'IC_ST_1' ) | (enumLiteral_31= 'IC_ST_2' ) | (enumLiteral_32= 'IC_ST_3' ) | (enumLiteral_33= 'IC_ST_4' ) | (enumLiteral_34= 'IC_LN_0' ) | (enumLiteral_35= 'IC_LN_1' ) | (enumLiteral_36= 'IC_LN_2' ) | (enumLiteral_37= 'IC_LN_3' ) | (enumLiteral_38= 'IC_LN_4' ) | (enumLiteral_39= 'IC_LN_5' ) | (enumLiteral_40= 'OC_JCT_0' ) | (enumLiteral_41= 'IC_JCT_0' ) | (enumLiteral_42= 'OI_LN_0' ) | (enumLiteral_43= 'OI_LN_1' ) | (enumLiteral_44= 'OI_LN_2' ) | (enumLiteral_45= 'IO_LN_0' ) | (enumLiteral_46= 'IO_LN_1' ) | (enumLiteral_47= 'IO_LN_2' ) )
            int alt33=48;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt33=1;
                }
                break;
            case 64:
                {
                alt33=2;
                }
                break;
            case 65:
                {
                alt33=3;
                }
                break;
            case 66:
                {
                alt33=4;
                }
                break;
            case 67:
                {
                alt33=5;
                }
                break;
            case 68:
                {
                alt33=6;
                }
                break;
            case 69:
                {
                alt33=7;
                }
                break;
            case 70:
                {
                alt33=8;
                }
                break;
            case 71:
                {
                alt33=9;
                }
                break;
            case 72:
                {
                alt33=10;
                }
                break;
            case 73:
                {
                alt33=11;
                }
                break;
            case 74:
                {
                alt33=12;
                }
                break;
            case 75:
                {
                alt33=13;
                }
                break;
            case 76:
                {
                alt33=14;
                }
                break;
            case 77:
                {
                alt33=15;
                }
                break;
            case 78:
                {
                alt33=16;
                }
                break;
            case 79:
                {
                alt33=17;
                }
                break;
            case 80:
                {
                alt33=18;
                }
                break;
            case 81:
                {
                alt33=19;
                }
                break;
            case 82:
                {
                alt33=20;
                }
                break;
            case 83:
                {
                alt33=21;
                }
                break;
            case 84:
                {
                alt33=22;
                }
                break;
            case 85:
                {
                alt33=23;
                }
                break;
            case 86:
                {
                alt33=24;
                }
                break;
            case 87:
                {
                alt33=25;
                }
                break;
            case 88:
                {
                alt33=26;
                }
                break;
            case 89:
                {
                alt33=27;
                }
                break;
            case 90:
                {
                alt33=28;
                }
                break;
            case 91:
                {
                alt33=29;
                }
                break;
            case 92:
                {
                alt33=30;
                }
                break;
            case 93:
                {
                alt33=31;
                }
                break;
            case 94:
                {
                alt33=32;
                }
                break;
            case 95:
                {
                alt33=33;
                }
                break;
            case 96:
                {
                alt33=34;
                }
                break;
            case 97:
                {
                alt33=35;
                }
                break;
            case 98:
                {
                alt33=36;
                }
                break;
            case 99:
                {
                alt33=37;
                }
                break;
            case 100:
                {
                alt33=38;
                }
                break;
            case 101:
                {
                alt33=39;
                }
                break;
            case 102:
                {
                alt33=40;
                }
                break;
            case 103:
                {
                alt33=41;
                }
                break;
            case 104:
                {
                alt33=42;
                }
                break;
            case 105:
                {
                alt33=43;
                }
                break;
            case 106:
                {
                alt33=44;
                }
                break;
            case 107:
                {
                alt33=45;
                }
                break;
            case 108:
                {
                alt33=46;
                }
                break;
            case 109:
                {
                alt33=47;
                }
                break;
            case 110:
                {
                alt33=48;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalRailSL.g:1424:3: (enumLiteral_0= 'KH_ST_0' )
                    {
                    // InternalRailSL.g:1424:3: (enumLiteral_0= 'KH_ST_0' )
                    // InternalRailSL.g:1425:4: enumLiteral_0= 'KH_ST_0'
                    {
                    enumLiteral_0=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_0EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRailSegmentAccess().getKH_ST_0EnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1432:3: (enumLiteral_1= 'KH_ST_1' )
                    {
                    // InternalRailSL.g:1432:3: (enumLiteral_1= 'KH_ST_1' )
                    // InternalRailSL.g:1433:4: enumLiteral_1= 'KH_ST_1'
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getRailSegmentAccess().getKH_ST_1EnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1440:3: (enumLiteral_2= 'KH_ST_2' )
                    {
                    // InternalRailSL.g:1440:3: (enumLiteral_2= 'KH_ST_2' )
                    // InternalRailSL.g:1441:4: enumLiteral_2= 'KH_ST_2'
                    {
                    enumLiteral_2=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_2EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getRailSegmentAccess().getKH_ST_2EnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1448:3: (enumLiteral_3= 'KH_ST_3' )
                    {
                    // InternalRailSL.g:1448:3: (enumLiteral_3= 'KH_ST_3' )
                    // InternalRailSL.g:1449:4: enumLiteral_3= 'KH_ST_3'
                    {
                    enumLiteral_3=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_3EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getRailSegmentAccess().getKH_ST_3EnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRailSL.g:1456:3: (enumLiteral_4= 'KH_ST_4' )
                    {
                    // InternalRailSL.g:1456:3: (enumLiteral_4= 'KH_ST_4' )
                    // InternalRailSL.g:1457:4: enumLiteral_4= 'KH_ST_4'
                    {
                    enumLiteral_4=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_4EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getRailSegmentAccess().getKH_ST_4EnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRailSL.g:1464:3: (enumLiteral_5= 'KH_ST_5' )
                    {
                    // InternalRailSL.g:1464:3: (enumLiteral_5= 'KH_ST_5' )
                    // InternalRailSL.g:1465:4: enumLiteral_5= 'KH_ST_5'
                    {
                    enumLiteral_5=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_5EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getRailSegmentAccess().getKH_ST_5EnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRailSL.g:1472:3: (enumLiteral_6= 'KH_ST_6' )
                    {
                    // InternalRailSL.g:1472:3: (enumLiteral_6= 'KH_ST_6' )
                    // InternalRailSL.g:1473:4: enumLiteral_6= 'KH_ST_6'
                    {
                    enumLiteral_6=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_6EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getRailSegmentAccess().getKH_ST_6EnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalRailSL.g:1480:3: (enumLiteral_7= 'KH_LN_0' )
                    {
                    // InternalRailSL.g:1480:3: (enumLiteral_7= 'KH_LN_0' )
                    // InternalRailSL.g:1481:4: enumLiteral_7= 'KH_LN_0'
                    {
                    enumLiteral_7=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_0EnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getRailSegmentAccess().getKH_LN_0EnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalRailSL.g:1488:3: (enumLiteral_8= 'KH_LN_1' )
                    {
                    // InternalRailSL.g:1488:3: (enumLiteral_8= 'KH_LN_1' )
                    // InternalRailSL.g:1489:4: enumLiteral_8= 'KH_LN_1'
                    {
                    enumLiteral_8=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_1EnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getRailSegmentAccess().getKH_LN_1EnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalRailSL.g:1496:3: (enumLiteral_9= 'KH_LN_2' )
                    {
                    // InternalRailSL.g:1496:3: (enumLiteral_9= 'KH_LN_2' )
                    // InternalRailSL.g:1497:4: enumLiteral_9= 'KH_LN_2'
                    {
                    enumLiteral_9=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_2EnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getRailSegmentAccess().getKH_LN_2EnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalRailSL.g:1504:3: (enumLiteral_10= 'KH_LN_3' )
                    {
                    // InternalRailSL.g:1504:3: (enumLiteral_10= 'KH_LN_3' )
                    // InternalRailSL.g:1505:4: enumLiteral_10= 'KH_LN_3'
                    {
                    enumLiteral_10=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_3EnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getRailSegmentAccess().getKH_LN_3EnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalRailSL.g:1512:3: (enumLiteral_11= 'KH_LN_4' )
                    {
                    // InternalRailSL.g:1512:3: (enumLiteral_11= 'KH_LN_4' )
                    // InternalRailSL.g:1513:4: enumLiteral_11= 'KH_LN_4'
                    {
                    enumLiteral_11=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_4EnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getRailSegmentAccess().getKH_LN_4EnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalRailSL.g:1520:3: (enumLiteral_12= 'KH_LN_5' )
                    {
                    // InternalRailSL.g:1520:3: (enumLiteral_12= 'KH_LN_5' )
                    // InternalRailSL.g:1521:4: enumLiteral_12= 'KH_LN_5'
                    {
                    enumLiteral_12=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_5EnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getRailSegmentAccess().getKH_LN_5EnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalRailSL.g:1528:3: (enumLiteral_13= 'KH_LN_6' )
                    {
                    // InternalRailSL.g:1528:3: (enumLiteral_13= 'KH_LN_6' )
                    // InternalRailSL.g:1529:4: enumLiteral_13= 'KH_LN_6'
                    {
                    enumLiteral_13=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_6EnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getRailSegmentAccess().getKH_LN_6EnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalRailSL.g:1536:3: (enumLiteral_14= 'KH_LN_7' )
                    {
                    // InternalRailSL.g:1536:3: (enumLiteral_14= 'KH_LN_7' )
                    // InternalRailSL.g:1537:4: enumLiteral_14= 'KH_LN_7'
                    {
                    enumLiteral_14=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_7EnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getRailSegmentAccess().getKH_LN_7EnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalRailSL.g:1544:3: (enumLiteral_15= 'KH_LN_8' )
                    {
                    // InternalRailSL.g:1544:3: (enumLiteral_15= 'KH_LN_8' )
                    // InternalRailSL.g:1545:4: enumLiteral_15= 'KH_LN_8'
                    {
                    enumLiteral_15=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_8EnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getRailSegmentAccess().getKH_LN_8EnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalRailSL.g:1552:3: (enumLiteral_16= 'KIO_LN_0' )
                    {
                    // InternalRailSL.g:1552:3: (enumLiteral_16= 'KIO_LN_0' )
                    // InternalRailSL.g:1553:4: enumLiteral_16= 'KIO_LN_0'
                    {
                    enumLiteral_16=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKIO_LN_0EnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getRailSegmentAccess().getKIO_LN_0EnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalRailSL.g:1560:3: (enumLiteral_17= 'KIO_LN_1' )
                    {
                    // InternalRailSL.g:1560:3: (enumLiteral_17= 'KIO_LN_1' )
                    // InternalRailSL.g:1561:4: enumLiteral_17= 'KIO_LN_1'
                    {
                    enumLiteral_17=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKIO_LN_1EnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getRailSegmentAccess().getKIO_LN_1EnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalRailSL.g:1568:3: (enumLiteral_18= 'OC_ST_0' )
                    {
                    // InternalRailSL.g:1568:3: (enumLiteral_18= 'OC_ST_0' )
                    // InternalRailSL.g:1569:4: enumLiteral_18= 'OC_ST_0'
                    {
                    enumLiteral_18=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_ST_0EnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getRailSegmentAccess().getOC_ST_0EnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalRailSL.g:1576:3: (enumLiteral_19= 'OC_ST_1' )
                    {
                    // InternalRailSL.g:1576:3: (enumLiteral_19= 'OC_ST_1' )
                    // InternalRailSL.g:1577:4: enumLiteral_19= 'OC_ST_1'
                    {
                    enumLiteral_19=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_ST_1EnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getRailSegmentAccess().getOC_ST_1EnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalRailSL.g:1584:3: (enumLiteral_20= 'OC_ST_2' )
                    {
                    // InternalRailSL.g:1584:3: (enumLiteral_20= 'OC_ST_2' )
                    // InternalRailSL.g:1585:4: enumLiteral_20= 'OC_ST_2'
                    {
                    enumLiteral_20=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_ST_2EnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getRailSegmentAccess().getOC_ST_2EnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalRailSL.g:1592:3: (enumLiteral_21= 'OC_ST_3' )
                    {
                    // InternalRailSL.g:1592:3: (enumLiteral_21= 'OC_ST_3' )
                    // InternalRailSL.g:1593:4: enumLiteral_21= 'OC_ST_3'
                    {
                    enumLiteral_21=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_ST_3EnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getRailSegmentAccess().getOC_ST_3EnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalRailSL.g:1600:3: (enumLiteral_22= 'OC_ST_4' )
                    {
                    // InternalRailSL.g:1600:3: (enumLiteral_22= 'OC_ST_4' )
                    // InternalRailSL.g:1601:4: enumLiteral_22= 'OC_ST_4'
                    {
                    enumLiteral_22=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_ST_4EnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getRailSegmentAccess().getOC_ST_4EnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalRailSL.g:1608:3: (enumLiteral_23= 'OC_LN_0' )
                    {
                    // InternalRailSL.g:1608:3: (enumLiteral_23= 'OC_LN_0' )
                    // InternalRailSL.g:1609:4: enumLiteral_23= 'OC_LN_0'
                    {
                    enumLiteral_23=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_0EnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getRailSegmentAccess().getOC_LN_0EnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalRailSL.g:1616:3: (enumLiteral_24= 'OC_LN_1' )
                    {
                    // InternalRailSL.g:1616:3: (enumLiteral_24= 'OC_LN_1' )
                    // InternalRailSL.g:1617:4: enumLiteral_24= 'OC_LN_1'
                    {
                    enumLiteral_24=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_1EnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getRailSegmentAccess().getOC_LN_1EnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalRailSL.g:1624:3: (enumLiteral_25= 'OC_LN_2' )
                    {
                    // InternalRailSL.g:1624:3: (enumLiteral_25= 'OC_LN_2' )
                    // InternalRailSL.g:1625:4: enumLiteral_25= 'OC_LN_2'
                    {
                    enumLiteral_25=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_2EnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getRailSegmentAccess().getOC_LN_2EnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalRailSL.g:1632:3: (enumLiteral_26= 'OC_LN_3' )
                    {
                    // InternalRailSL.g:1632:3: (enumLiteral_26= 'OC_LN_3' )
                    // InternalRailSL.g:1633:4: enumLiteral_26= 'OC_LN_3'
                    {
                    enumLiteral_26=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_3EnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getRailSegmentAccess().getOC_LN_3EnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalRailSL.g:1640:3: (enumLiteral_27= 'OC_LN_4' )
                    {
                    // InternalRailSL.g:1640:3: (enumLiteral_27= 'OC_LN_4' )
                    // InternalRailSL.g:1641:4: enumLiteral_27= 'OC_LN_4'
                    {
                    enumLiteral_27=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_4EnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getRailSegmentAccess().getOC_LN_4EnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalRailSL.g:1648:3: (enumLiteral_28= 'OC_LN_5' )
                    {
                    // InternalRailSL.g:1648:3: (enumLiteral_28= 'OC_LN_5' )
                    // InternalRailSL.g:1649:4: enumLiteral_28= 'OC_LN_5'
                    {
                    enumLiteral_28=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_5EnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getRailSegmentAccess().getOC_LN_5EnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalRailSL.g:1656:3: (enumLiteral_29= 'IC_ST_0' )
                    {
                    // InternalRailSL.g:1656:3: (enumLiteral_29= 'IC_ST_0' )
                    // InternalRailSL.g:1657:4: enumLiteral_29= 'IC_ST_0'
                    {
                    enumLiteral_29=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_ST_0EnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getRailSegmentAccess().getIC_ST_0EnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalRailSL.g:1664:3: (enumLiteral_30= 'IC_ST_1' )
                    {
                    // InternalRailSL.g:1664:3: (enumLiteral_30= 'IC_ST_1' )
                    // InternalRailSL.g:1665:4: enumLiteral_30= 'IC_ST_1'
                    {
                    enumLiteral_30=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_ST_1EnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getRailSegmentAccess().getIC_ST_1EnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalRailSL.g:1672:3: (enumLiteral_31= 'IC_ST_2' )
                    {
                    // InternalRailSL.g:1672:3: (enumLiteral_31= 'IC_ST_2' )
                    // InternalRailSL.g:1673:4: enumLiteral_31= 'IC_ST_2'
                    {
                    enumLiteral_31=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_ST_2EnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getRailSegmentAccess().getIC_ST_2EnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalRailSL.g:1680:3: (enumLiteral_32= 'IC_ST_3' )
                    {
                    // InternalRailSL.g:1680:3: (enumLiteral_32= 'IC_ST_3' )
                    // InternalRailSL.g:1681:4: enumLiteral_32= 'IC_ST_3'
                    {
                    enumLiteral_32=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_ST_3EnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getRailSegmentAccess().getIC_ST_3EnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalRailSL.g:1688:3: (enumLiteral_33= 'IC_ST_4' )
                    {
                    // InternalRailSL.g:1688:3: (enumLiteral_33= 'IC_ST_4' )
                    // InternalRailSL.g:1689:4: enumLiteral_33= 'IC_ST_4'
                    {
                    enumLiteral_33=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_ST_4EnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getRailSegmentAccess().getIC_ST_4EnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalRailSL.g:1696:3: (enumLiteral_34= 'IC_LN_0' )
                    {
                    // InternalRailSL.g:1696:3: (enumLiteral_34= 'IC_LN_0' )
                    // InternalRailSL.g:1697:4: enumLiteral_34= 'IC_LN_0'
                    {
                    enumLiteral_34=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_0EnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getRailSegmentAccess().getIC_LN_0EnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalRailSL.g:1704:3: (enumLiteral_35= 'IC_LN_1' )
                    {
                    // InternalRailSL.g:1704:3: (enumLiteral_35= 'IC_LN_1' )
                    // InternalRailSL.g:1705:4: enumLiteral_35= 'IC_LN_1'
                    {
                    enumLiteral_35=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_1EnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getRailSegmentAccess().getIC_LN_1EnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalRailSL.g:1712:3: (enumLiteral_36= 'IC_LN_2' )
                    {
                    // InternalRailSL.g:1712:3: (enumLiteral_36= 'IC_LN_2' )
                    // InternalRailSL.g:1713:4: enumLiteral_36= 'IC_LN_2'
                    {
                    enumLiteral_36=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_2EnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getRailSegmentAccess().getIC_LN_2EnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;
                case 38 :
                    // InternalRailSL.g:1720:3: (enumLiteral_37= 'IC_LN_3' )
                    {
                    // InternalRailSL.g:1720:3: (enumLiteral_37= 'IC_LN_3' )
                    // InternalRailSL.g:1721:4: enumLiteral_37= 'IC_LN_3'
                    {
                    enumLiteral_37=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_3EnumLiteralDeclaration_37().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_37, grammarAccess.getRailSegmentAccess().getIC_LN_3EnumLiteralDeclaration_37());
                    			

                    }


                    }
                    break;
                case 39 :
                    // InternalRailSL.g:1728:3: (enumLiteral_38= 'IC_LN_4' )
                    {
                    // InternalRailSL.g:1728:3: (enumLiteral_38= 'IC_LN_4' )
                    // InternalRailSL.g:1729:4: enumLiteral_38= 'IC_LN_4'
                    {
                    enumLiteral_38=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_4EnumLiteralDeclaration_38().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_38, grammarAccess.getRailSegmentAccess().getIC_LN_4EnumLiteralDeclaration_38());
                    			

                    }


                    }
                    break;
                case 40 :
                    // InternalRailSL.g:1736:3: (enumLiteral_39= 'IC_LN_5' )
                    {
                    // InternalRailSL.g:1736:3: (enumLiteral_39= 'IC_LN_5' )
                    // InternalRailSL.g:1737:4: enumLiteral_39= 'IC_LN_5'
                    {
                    enumLiteral_39=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_5EnumLiteralDeclaration_39().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_39, grammarAccess.getRailSegmentAccess().getIC_LN_5EnumLiteralDeclaration_39());
                    			

                    }


                    }
                    break;
                case 41 :
                    // InternalRailSL.g:1744:3: (enumLiteral_40= 'OC_JCT_0' )
                    {
                    // InternalRailSL.g:1744:3: (enumLiteral_40= 'OC_JCT_0' )
                    // InternalRailSL.g:1745:4: enumLiteral_40= 'OC_JCT_0'
                    {
                    enumLiteral_40=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_JCT_0EnumLiteralDeclaration_40().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_40, grammarAccess.getRailSegmentAccess().getOC_JCT_0EnumLiteralDeclaration_40());
                    			

                    }


                    }
                    break;
                case 42 :
                    // InternalRailSL.g:1752:3: (enumLiteral_41= 'IC_JCT_0' )
                    {
                    // InternalRailSL.g:1752:3: (enumLiteral_41= 'IC_JCT_0' )
                    // InternalRailSL.g:1753:4: enumLiteral_41= 'IC_JCT_0'
                    {
                    enumLiteral_41=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_JCT_0EnumLiteralDeclaration_41().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_41, grammarAccess.getRailSegmentAccess().getIC_JCT_0EnumLiteralDeclaration_41());
                    			

                    }


                    }
                    break;
                case 43 :
                    // InternalRailSL.g:1760:3: (enumLiteral_42= 'OI_LN_0' )
                    {
                    // InternalRailSL.g:1760:3: (enumLiteral_42= 'OI_LN_0' )
                    // InternalRailSL.g:1761:4: enumLiteral_42= 'OI_LN_0'
                    {
                    enumLiteral_42=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOI_LN_0EnumLiteralDeclaration_42().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_42, grammarAccess.getRailSegmentAccess().getOI_LN_0EnumLiteralDeclaration_42());
                    			

                    }


                    }
                    break;
                case 44 :
                    // InternalRailSL.g:1768:3: (enumLiteral_43= 'OI_LN_1' )
                    {
                    // InternalRailSL.g:1768:3: (enumLiteral_43= 'OI_LN_1' )
                    // InternalRailSL.g:1769:4: enumLiteral_43= 'OI_LN_1'
                    {
                    enumLiteral_43=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOI_LN_1EnumLiteralDeclaration_43().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_43, grammarAccess.getRailSegmentAccess().getOI_LN_1EnumLiteralDeclaration_43());
                    			

                    }


                    }
                    break;
                case 45 :
                    // InternalRailSL.g:1776:3: (enumLiteral_44= 'OI_LN_2' )
                    {
                    // InternalRailSL.g:1776:3: (enumLiteral_44= 'OI_LN_2' )
                    // InternalRailSL.g:1777:4: enumLiteral_44= 'OI_LN_2'
                    {
                    enumLiteral_44=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOI_LN_2EnumLiteralDeclaration_44().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_44, grammarAccess.getRailSegmentAccess().getOI_LN_2EnumLiteralDeclaration_44());
                    			

                    }


                    }
                    break;
                case 46 :
                    // InternalRailSL.g:1784:3: (enumLiteral_45= 'IO_LN_0' )
                    {
                    // InternalRailSL.g:1784:3: (enumLiteral_45= 'IO_LN_0' )
                    // InternalRailSL.g:1785:4: enumLiteral_45= 'IO_LN_0'
                    {
                    enumLiteral_45=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIO_LN_0EnumLiteralDeclaration_45().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_45, grammarAccess.getRailSegmentAccess().getIO_LN_0EnumLiteralDeclaration_45());
                    			

                    }


                    }
                    break;
                case 47 :
                    // InternalRailSL.g:1792:3: (enumLiteral_46= 'IO_LN_1' )
                    {
                    // InternalRailSL.g:1792:3: (enumLiteral_46= 'IO_LN_1' )
                    // InternalRailSL.g:1793:4: enumLiteral_46= 'IO_LN_1'
                    {
                    enumLiteral_46=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIO_LN_1EnumLiteralDeclaration_46().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_46, grammarAccess.getRailSegmentAccess().getIO_LN_1EnumLiteralDeclaration_46());
                    			

                    }


                    }
                    break;
                case 48 :
                    // InternalRailSL.g:1800:3: (enumLiteral_47= 'IO_LN_2' )
                    {
                    // InternalRailSL.g:1800:3: (enumLiteral_47= 'IO_LN_2' )
                    // InternalRailSL.g:1801:4: enumLiteral_47= 'IO_LN_2'
                    {
                    enumLiteral_47=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIO_LN_2EnumLiteralDeclaration_47().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_47, grammarAccess.getRailSegmentAccess().getIO_LN_2EnumLiteralDeclaration_47());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRailSegment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x7BC0180C60C06000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x7BC1F80C60C06000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x8000000000000000L,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0400010000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x8000000008000000L,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000300030000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000001802L});

}