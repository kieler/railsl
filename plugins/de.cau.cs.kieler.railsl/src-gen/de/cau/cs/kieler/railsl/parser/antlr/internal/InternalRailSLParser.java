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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Start'", "'start'", "':'", "'.'", "'Set'", "'set'", "'track'", "','", "'and'", "'to'", "'reverse'", "'point'", "'Wait'", "'wait'", "'for'", "'seconds'", "'second'", "'contact'", "'of'", "'crossing'", "'Turn'", "'turn'", "'light'", "'Branch'", "'branch'", "'any'", "'If'", "'if'", "'is'", "'reached'", "'first'", "'do'", "'Parallel'", "'parallel'", "'Join'", "'join'", "'End'", "'end'", "'Loop'", "'loop'", "'stop'", "'full'", "'slow'", "'straight'", "'Reach'", "'reach'", "'Pass'", "'pass'", "'Open'", "'open'", "'Close'", "'close'", "'on'", "'off'", "'IC_JCT_0'", "'IC_LN_0'", "'IC_LN_1'", "'IC_LN_2'", "'IC_LN_3'", "'IC_LN_4'", "'IC_LN_5'", "'IC_ST_0'", "'IC_ST_1'", "'IC_ST_2'", "'IC_ST_3'", "'IC_ST_4'", "'IO_LN_0'", "'IO_LN_1'", "'IO_LN_2'", "'KH_LN_0'", "'KH_LN_1'", "'KH_LN_2'", "'KH_LN_3'", "'KH_LN_4'", "'KH_LN_5'", "'KH_LN_6'", "'KH_LN_7'", "'KH_LN_8'", "'KH_ST_0'", "'KH_ST_1'", "'KH_ST_2'", "'KH_ST_3'", "'KH_ST_4'", "'KH_ST_5'", "'KH_ST_6'", "'KIO_LN_0'", "'KIO_LN_1'", "'OC_JCT_0'", "'OC_LN_0'", "'OC_LN_1'", "'OC_LN_2'", "'OC_LN_3'", "'OC_LN_4'", "'OC_LN_5'", "'OC_ST_0'", "'OC_ST_1'", "'OC_ST_2'", "'OC_ST_3'", "'OC_ST_4'", "'OI_LN_0'", "'OI_LN_1'", "'OI_LN_2'"
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
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__112=112;
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
    // InternalRailSL.g:108:1: ruleBlock returns [EObject current=null] : ( (otherlv_0= 'Start' | otherlv_1= 'start' ) otherlv_2= ':' ( (lv_statements_3_0= ruleStatement ) )+ ( (lv_end_4_0= ruleBlockEnd ) ) otherlv_5= '.' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_statements_3_0 = null;

        Enumerator lv_end_4_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:114:2: ( ( (otherlv_0= 'Start' | otherlv_1= 'start' ) otherlv_2= ':' ( (lv_statements_3_0= ruleStatement ) )+ ( (lv_end_4_0= ruleBlockEnd ) ) otherlv_5= '.' ) )
            // InternalRailSL.g:115:2: ( (otherlv_0= 'Start' | otherlv_1= 'start' ) otherlv_2= ':' ( (lv_statements_3_0= ruleStatement ) )+ ( (lv_end_4_0= ruleBlockEnd ) ) otherlv_5= '.' )
            {
            // InternalRailSL.g:115:2: ( (otherlv_0= 'Start' | otherlv_1= 'start' ) otherlv_2= ':' ( (lv_statements_3_0= ruleStatement ) )+ ( (lv_end_4_0= ruleBlockEnd ) ) otherlv_5= '.' )
            // InternalRailSL.g:116:3: (otherlv_0= 'Start' | otherlv_1= 'start' ) otherlv_2= ':' ( (lv_statements_3_0= ruleStatement ) )+ ( (lv_end_4_0= ruleBlockEnd ) ) otherlv_5= '.'
            {
            // InternalRailSL.g:116:3: (otherlv_0= 'Start' | otherlv_1= 'start' )
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
                    // InternalRailSL.g:117:4: otherlv_0= 'Start'
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getBlockAccess().getStartKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:122:4: otherlv_1= 'start'
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getStartKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getBlockAccess().getColonKeyword_1());
            		
            // InternalRailSL.g:131:3: ( (lv_statements_3_0= ruleStatement ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=11 && LA2_0<=12)||(LA2_0>=15 && LA2_0<=16)||(LA2_0>=23 && LA2_0<=24)||(LA2_0>=31 && LA2_0<=32)||(LA2_0>=34 && LA2_0<=35)||(LA2_0>=43 && LA2_0<=44)||(LA2_0>=55 && LA2_0<=62)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRailSL.g:132:4: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalRailSL.g:132:4: (lv_statements_3_0= ruleStatement )
            	    // InternalRailSL.g:133:5: lv_statements_3_0= ruleStatement
            	    {

            	    					newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBlockRule());
            	    					}
            	    					add(
            	    						current,
            	    						"statements",
            	    						lv_statements_3_0,
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

            // InternalRailSL.g:150:3: ( (lv_end_4_0= ruleBlockEnd ) )
            // InternalRailSL.g:151:4: (lv_end_4_0= ruleBlockEnd )
            {
            // InternalRailSL.g:151:4: (lv_end_4_0= ruleBlockEnd )
            // InternalRailSL.g:152:5: lv_end_4_0= ruleBlockEnd
            {

            					newCompositeNode(grammarAccess.getBlockAccess().getEndBlockEndEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_end_4_0=ruleBlockEnd();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBlockRule());
            					}
            					set(
            						current,
            						"end",
            						lv_end_4_0,
            						"de.cau.cs.kieler.railsl.RailSL.BlockEnd");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getBlockAccess().getFullStopKeyword_4());
            		

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
    // InternalRailSL.g:177:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalRailSL.g:177:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalRailSL.g:178:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalRailSL.g:184:1: ruleStatement returns [EObject current=null] : (this_SetStatement_0= ruleSetStatement | this_WaitStatement_1= ruleWaitStatement | this_OpStatement_2= ruleOpStatement | this_ConditionalStatement_3= ruleConditionalStatement | this_ParallelStatement_4= ruleParallelStatement | this_Block_5= ruleBlock ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SetStatement_0 = null;

        EObject this_WaitStatement_1 = null;

        EObject this_OpStatement_2 = null;

        EObject this_ConditionalStatement_3 = null;

        EObject this_ParallelStatement_4 = null;

        EObject this_Block_5 = null;



        	enterRule();

        try {
            // InternalRailSL.g:190:2: ( (this_SetStatement_0= ruleSetStatement | this_WaitStatement_1= ruleWaitStatement | this_OpStatement_2= ruleOpStatement | this_ConditionalStatement_3= ruleConditionalStatement | this_ParallelStatement_4= ruleParallelStatement | this_Block_5= ruleBlock ) )
            // InternalRailSL.g:191:2: (this_SetStatement_0= ruleSetStatement | this_WaitStatement_1= ruleWaitStatement | this_OpStatement_2= ruleOpStatement | this_ConditionalStatement_3= ruleConditionalStatement | this_ParallelStatement_4= ruleParallelStatement | this_Block_5= ruleBlock )
            {
            // InternalRailSL.g:191:2: (this_SetStatement_0= ruleSetStatement | this_WaitStatement_1= ruleWaitStatement | this_OpStatement_2= ruleOpStatement | this_ConditionalStatement_3= ruleConditionalStatement | this_ParallelStatement_4= ruleParallelStatement | this_Block_5= ruleBlock )
            int alt3=6;
            switch ( input.LA(1) ) {
            case 15:
            case 16:
                {
                alt3=1;
                }
                break;
            case 23:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==36) ) {
                    alt3=4;
                }
                else if ( (LA3_2==RULE_INT||LA3_2==25) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case 24:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==36) ) {
                    alt3=4;
                }
                else if ( (LA3_3==RULE_INT||LA3_3==25) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            case 55:
            case 56:
            case 57:
            case 58:
                {
                alt3=2;
                }
                break;
            case 31:
            case 32:
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
            case 11:
            case 12:
                {
                alt3=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalRailSL.g:192:3: this_SetStatement_0= ruleSetStatement
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
                    // InternalRailSL.g:201:3: this_WaitStatement_1= ruleWaitStatement
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
                    // InternalRailSL.g:210:3: this_OpStatement_2= ruleOpStatement
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
                    // InternalRailSL.g:219:3: this_ConditionalStatement_3= ruleConditionalStatement
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
                    // InternalRailSL.g:228:3: this_ParallelStatement_4= ruleParallelStatement
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getParallelStatementParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParallelStatement_4=ruleParallelStatement();

                    state._fsp--;


                    			current = this_ParallelStatement_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRailSL.g:237:3: this_Block_5= ruleBlock
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Block_5=ruleBlock();

                    state._fsp--;


                    			current = this_Block_5;
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
    // InternalRailSL.g:249:1: entryRuleSetStatement returns [EObject current=null] : iv_ruleSetStatement= ruleSetStatement EOF ;
    public final EObject entryRuleSetStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStatement = null;


        try {
            // InternalRailSL.g:249:53: (iv_ruleSetStatement= ruleSetStatement EOF )
            // InternalRailSL.g:250:2: iv_ruleSetStatement= ruleSetStatement EOF
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
    // InternalRailSL.g:256:1: ruleSetStatement returns [EObject current=null] : (this_TrackStatement_0= ruleTrackStatement | this_PointStatement_1= rulePointStatement ) ;
    public final EObject ruleSetStatement() throws RecognitionException {
        EObject current = null;

        EObject this_TrackStatement_0 = null;

        EObject this_PointStatement_1 = null;



        	enterRule();

        try {
            // InternalRailSL.g:262:2: ( (this_TrackStatement_0= ruleTrackStatement | this_PointStatement_1= rulePointStatement ) )
            // InternalRailSL.g:263:2: (this_TrackStatement_0= ruleTrackStatement | this_PointStatement_1= rulePointStatement )
            {
            // InternalRailSL.g:263:2: (this_TrackStatement_0= ruleTrackStatement | this_PointStatement_1= rulePointStatement )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==17) ) {
                    alt4=1;
                }
                else if ( (LA4_1==22) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA4_0==16) ) {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==17) ) {
                    alt4=1;
                }
                else if ( (LA4_2==22) ) {
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
                    // InternalRailSL.g:264:3: this_TrackStatement_0= ruleTrackStatement
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
                    // InternalRailSL.g:273:3: this_PointStatement_1= rulePointStatement
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
    // InternalRailSL.g:285:1: entryRuleTrackStatement returns [EObject current=null] : iv_ruleTrackStatement= ruleTrackStatement EOF ;
    public final EObject entryRuleTrackStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrackStatement = null;


        try {
            // InternalRailSL.g:285:55: (iv_ruleTrackStatement= ruleTrackStatement EOF )
            // InternalRailSL.g:286:2: iv_ruleTrackStatement= ruleTrackStatement EOF
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
    // InternalRailSL.g:292:1: ruleTrackStatement returns [EObject current=null] : ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'track' ( (lv_segments_3_0= ruleRailSegment ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_segments_6_0= ruleRailSegment ) ) )* otherlv_7= 'to' ( ( (lv_speed_8_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_9_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_10_0= 'reverse' ) )? ) ) otherlv_11= '.' ) ;
    public final EObject ruleTrackStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_reverse_10_0=null;
        Token otherlv_11=null;
        Enumerator lv_segments_3_0 = null;

        Enumerator lv_segments_6_0 = null;

        Enumerator lv_speed_8_0 = null;

        Enumerator lv_speed_9_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:298:2: ( ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'track' ( (lv_segments_3_0= ruleRailSegment ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_segments_6_0= ruleRailSegment ) ) )* otherlv_7= 'to' ( ( (lv_speed_8_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_9_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_10_0= 'reverse' ) )? ) ) otherlv_11= '.' ) )
            // InternalRailSL.g:299:2: ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'track' ( (lv_segments_3_0= ruleRailSegment ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_segments_6_0= ruleRailSegment ) ) )* otherlv_7= 'to' ( ( (lv_speed_8_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_9_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_10_0= 'reverse' ) )? ) ) otherlv_11= '.' )
            {
            // InternalRailSL.g:299:2: ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'track' ( (lv_segments_3_0= ruleRailSegment ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_segments_6_0= ruleRailSegment ) ) )* otherlv_7= 'to' ( ( (lv_speed_8_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_9_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_10_0= 'reverse' ) )? ) ) otherlv_11= '.' )
            // InternalRailSL.g:300:3: (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'track' ( (lv_segments_3_0= ruleRailSegment ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_segments_6_0= ruleRailSegment ) ) )* otherlv_7= 'to' ( ( (lv_speed_8_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_9_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_10_0= 'reverse' ) )? ) ) otherlv_11= '.'
            {
            // InternalRailSL.g:300:3: (otherlv_0= 'Set' | otherlv_1= 'set' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==16) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalRailSL.g:301:4: otherlv_0= 'Set'
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_0, grammarAccess.getTrackStatementAccess().getSetKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:306:4: otherlv_1= 'set'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getTrackStatementAccess().getSetKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,17,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getTrackStatementAccess().getTrackKeyword_1());
            		
            // InternalRailSL.g:315:3: ( (lv_segments_3_0= ruleRailSegment ) )
            // InternalRailSL.g:316:4: (lv_segments_3_0= ruleRailSegment )
            {
            // InternalRailSL.g:316:4: (lv_segments_3_0= ruleRailSegment )
            // InternalRailSL.g:317:5: lv_segments_3_0= ruleRailSegment
            {

            					newCompositeNode(grammarAccess.getTrackStatementAccess().getSegmentsRailSegmentEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalRailSL.g:334:3: ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_segments_6_0= ruleRailSegment ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=18 && LA7_0<=19)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalRailSL.g:335:4: (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_segments_6_0= ruleRailSegment ) )
            	    {
            	    // InternalRailSL.g:335:4: (otherlv_4= ',' | otherlv_5= 'and' )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==18) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==19) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalRailSL.g:336:5: otherlv_4= ','
            	            {
            	            otherlv_4=(Token)match(input,18,FOLLOW_8); 

            	            					newLeafNode(otherlv_4, grammarAccess.getTrackStatementAccess().getCommaKeyword_3_0_0());
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalRailSL.g:341:5: otherlv_5= 'and'
            	            {
            	            otherlv_5=(Token)match(input,19,FOLLOW_8); 

            	            					newLeafNode(otherlv_5, grammarAccess.getTrackStatementAccess().getAndKeyword_3_0_1());
            	            				

            	            }
            	            break;

            	    }

            	    // InternalRailSL.g:346:4: ( (lv_segments_6_0= ruleRailSegment ) )
            	    // InternalRailSL.g:347:5: (lv_segments_6_0= ruleRailSegment )
            	    {
            	    // InternalRailSL.g:347:5: (lv_segments_6_0= ruleRailSegment )
            	    // InternalRailSL.g:348:6: lv_segments_6_0= ruleRailSegment
            	    {

            	    						newCompositeNode(grammarAccess.getTrackStatementAccess().getSegmentsRailSegmentEnumRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_segments_6_0=ruleRailSegment();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTrackStatementRule());
            	    						}
            	    						add(
            	    							current,
            	    							"segments",
            	    							lv_segments_6_0,
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

            otherlv_7=(Token)match(input,20,FOLLOW_10); 

            			newLeafNode(otherlv_7, grammarAccess.getTrackStatementAccess().getToKeyword_4());
            		
            // InternalRailSL.g:370:3: ( ( (lv_speed_8_0= ruleTrackSpeedStop ) ) | ( ( (lv_speed_9_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_10_0= 'reverse' ) )? ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==51) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=52 && LA9_0<=53)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalRailSL.g:371:4: ( (lv_speed_8_0= ruleTrackSpeedStop ) )
                    {
                    // InternalRailSL.g:371:4: ( (lv_speed_8_0= ruleTrackSpeedStop ) )
                    // InternalRailSL.g:372:5: (lv_speed_8_0= ruleTrackSpeedStop )
                    {
                    // InternalRailSL.g:372:5: (lv_speed_8_0= ruleTrackSpeedStop )
                    // InternalRailSL.g:373:6: lv_speed_8_0= ruleTrackSpeedStop
                    {

                    						newCompositeNode(grammarAccess.getTrackStatementAccess().getSpeedTrackSpeedStopEnumRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_speed_8_0=ruleTrackSpeedStop();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTrackStatementRule());
                    						}
                    						set(
                    							current,
                    							"speed",
                    							lv_speed_8_0,
                    							"de.cau.cs.kieler.railsl.RailSL.TrackSpeedStop");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:391:4: ( ( (lv_speed_9_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_10_0= 'reverse' ) )? )
                    {
                    // InternalRailSL.g:391:4: ( ( (lv_speed_9_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_10_0= 'reverse' ) )? )
                    // InternalRailSL.g:392:5: ( (lv_speed_9_0= ruleTrackSpeedDrive ) ) ( (lv_reverse_10_0= 'reverse' ) )?
                    {
                    // InternalRailSL.g:392:5: ( (lv_speed_9_0= ruleTrackSpeedDrive ) )
                    // InternalRailSL.g:393:6: (lv_speed_9_0= ruleTrackSpeedDrive )
                    {
                    // InternalRailSL.g:393:6: (lv_speed_9_0= ruleTrackSpeedDrive )
                    // InternalRailSL.g:394:7: lv_speed_9_0= ruleTrackSpeedDrive
                    {

                    							newCompositeNode(grammarAccess.getTrackStatementAccess().getSpeedTrackSpeedDriveEnumRuleCall_5_1_0_0());
                    						
                    pushFollow(FOLLOW_11);
                    lv_speed_9_0=ruleTrackSpeedDrive();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getTrackStatementRule());
                    							}
                    							set(
                    								current,
                    								"speed",
                    								lv_speed_9_0,
                    								"de.cau.cs.kieler.railsl.RailSL.TrackSpeedDrive");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalRailSL.g:411:5: ( (lv_reverse_10_0= 'reverse' ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==21) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalRailSL.g:412:6: (lv_reverse_10_0= 'reverse' )
                            {
                            // InternalRailSL.g:412:6: (lv_reverse_10_0= 'reverse' )
                            // InternalRailSL.g:413:7: lv_reverse_10_0= 'reverse'
                            {
                            lv_reverse_10_0=(Token)match(input,21,FOLLOW_6); 

                            							newLeafNode(lv_reverse_10_0, grammarAccess.getTrackStatementAccess().getReverseReverseKeyword_5_1_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getTrackStatementRule());
                            							}
                            							setWithLastConsumed(current, "reverse", lv_reverse_10_0 != null, "reverse");
                            						

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getTrackStatementAccess().getFullStopKeyword_6());
            		

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
    // InternalRailSL.g:435:1: entryRulePointStatement returns [EObject current=null] : iv_rulePointStatement= rulePointStatement EOF ;
    public final EObject entryRulePointStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePointStatement = null;


        try {
            // InternalRailSL.g:435:55: (iv_rulePointStatement= rulePointStatement EOF )
            // InternalRailSL.g:436:2: iv_rulePointStatement= rulePointStatement EOF
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
    // InternalRailSL.g:442:1: rulePointStatement returns [EObject current=null] : ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'point' ( (lv_points_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_points_6_0= RULE_INT ) ) )* otherlv_7= 'to' ( (lv_orientation_8_0= rulePointOrientation ) ) otherlv_9= '.' ) ;
    public final EObject rulePointStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_points_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_points_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_orientation_8_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:448:2: ( ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'point' ( (lv_points_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_points_6_0= RULE_INT ) ) )* otherlv_7= 'to' ( (lv_orientation_8_0= rulePointOrientation ) ) otherlv_9= '.' ) )
            // InternalRailSL.g:449:2: ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'point' ( (lv_points_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_points_6_0= RULE_INT ) ) )* otherlv_7= 'to' ( (lv_orientation_8_0= rulePointOrientation ) ) otherlv_9= '.' )
            {
            // InternalRailSL.g:449:2: ( (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'point' ( (lv_points_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_points_6_0= RULE_INT ) ) )* otherlv_7= 'to' ( (lv_orientation_8_0= rulePointOrientation ) ) otherlv_9= '.' )
            // InternalRailSL.g:450:3: (otherlv_0= 'Set' | otherlv_1= 'set' ) otherlv_2= 'point' ( (lv_points_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_points_6_0= RULE_INT ) ) )* otherlv_7= 'to' ( (lv_orientation_8_0= rulePointOrientation ) ) otherlv_9= '.'
            {
            // InternalRailSL.g:450:3: (otherlv_0= 'Set' | otherlv_1= 'set' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            else if ( (LA10_0==16) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalRailSL.g:451:4: otherlv_0= 'Set'
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_12); 

                    				newLeafNode(otherlv_0, grammarAccess.getPointStatementAccess().getSetKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:456:4: otherlv_1= 'set'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getPointStatementAccess().getSetKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,22,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getPointStatementAccess().getPointKeyword_1());
            		
            // InternalRailSL.g:465:3: ( (lv_points_3_0= RULE_INT ) )
            // InternalRailSL.g:466:4: (lv_points_3_0= RULE_INT )
            {
            // InternalRailSL.g:466:4: (lv_points_3_0= RULE_INT )
            // InternalRailSL.g:467:5: lv_points_3_0= RULE_INT
            {
            lv_points_3_0=(Token)match(input,RULE_INT,FOLLOW_9); 

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

            // InternalRailSL.g:483:3: ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_points_6_0= RULE_INT ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=18 && LA12_0<=19)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalRailSL.g:484:4: (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_points_6_0= RULE_INT ) )
            	    {
            	    // InternalRailSL.g:484:4: (otherlv_4= ',' | otherlv_5= 'and' )
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==18) ) {
            	        alt11=1;
            	    }
            	    else if ( (LA11_0==19) ) {
            	        alt11=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // InternalRailSL.g:485:5: otherlv_4= ','
            	            {
            	            otherlv_4=(Token)match(input,18,FOLLOW_13); 

            	            					newLeafNode(otherlv_4, grammarAccess.getPointStatementAccess().getCommaKeyword_3_0_0());
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalRailSL.g:490:5: otherlv_5= 'and'
            	            {
            	            otherlv_5=(Token)match(input,19,FOLLOW_13); 

            	            					newLeafNode(otherlv_5, grammarAccess.getPointStatementAccess().getAndKeyword_3_0_1());
            	            				

            	            }
            	            break;

            	    }

            	    // InternalRailSL.g:495:4: ( (lv_points_6_0= RULE_INT ) )
            	    // InternalRailSL.g:496:5: (lv_points_6_0= RULE_INT )
            	    {
            	    // InternalRailSL.g:496:5: (lv_points_6_0= RULE_INT )
            	    // InternalRailSL.g:497:6: lv_points_6_0= RULE_INT
            	    {
            	    lv_points_6_0=(Token)match(input,RULE_INT,FOLLOW_9); 

            	    						newLeafNode(lv_points_6_0, grammarAccess.getPointStatementAccess().getPointsINTTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getPointStatementRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"points",
            	    							lv_points_6_0,
            	    							"org.eclipse.xtext.common.Terminals.INT");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_7=(Token)match(input,20,FOLLOW_14); 

            			newLeafNode(otherlv_7, grammarAccess.getPointStatementAccess().getToKeyword_4());
            		
            // InternalRailSL.g:518:3: ( (lv_orientation_8_0= rulePointOrientation ) )
            // InternalRailSL.g:519:4: (lv_orientation_8_0= rulePointOrientation )
            {
            // InternalRailSL.g:519:4: (lv_orientation_8_0= rulePointOrientation )
            // InternalRailSL.g:520:5: lv_orientation_8_0= rulePointOrientation
            {

            					newCompositeNode(grammarAccess.getPointStatementAccess().getOrientationPointOrientationEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_6);
            lv_orientation_8_0=rulePointOrientation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPointStatementRule());
            					}
            					set(
            						current,
            						"orientation",
            						lv_orientation_8_0,
            						"de.cau.cs.kieler.railsl.RailSL.PointOrientation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getPointStatementAccess().getFullStopKeyword_6());
            		

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
    // InternalRailSL.g:545:1: entryRuleWaitStatement returns [EObject current=null] : iv_ruleWaitStatement= ruleWaitStatement EOF ;
    public final EObject entryRuleWaitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWaitStatement = null;


        try {
            // InternalRailSL.g:545:54: (iv_ruleWaitStatement= ruleWaitStatement EOF )
            // InternalRailSL.g:546:2: iv_ruleWaitStatement= ruleWaitStatement EOF
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
    // InternalRailSL.g:552:1: ruleWaitStatement returns [EObject current=null] : (this_TimeWaitStatement_0= ruleTimeWaitStatement | this_ContactWaitStatement_1= ruleContactWaitStatement ) ;
    public final EObject ruleWaitStatement() throws RecognitionException {
        EObject current = null;

        EObject this_TimeWaitStatement_0 = null;

        EObject this_ContactWaitStatement_1 = null;



        	enterRule();

        try {
            // InternalRailSL.g:558:2: ( (this_TimeWaitStatement_0= ruleTimeWaitStatement | this_ContactWaitStatement_1= ruleContactWaitStatement ) )
            // InternalRailSL.g:559:2: (this_TimeWaitStatement_0= ruleTimeWaitStatement | this_ContactWaitStatement_1= ruleContactWaitStatement )
            {
            // InternalRailSL.g:559:2: (this_TimeWaitStatement_0= ruleTimeWaitStatement | this_ContactWaitStatement_1= ruleContactWaitStatement )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=23 && LA13_0<=24)) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=55 && LA13_0<=58)) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalRailSL.g:560:3: this_TimeWaitStatement_0= ruleTimeWaitStatement
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
                    // InternalRailSL.g:569:3: this_ContactWaitStatement_1= ruleContactWaitStatement
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
    // InternalRailSL.g:581:1: entryRuleTimeWaitStatement returns [EObject current=null] : iv_ruleTimeWaitStatement= ruleTimeWaitStatement EOF ;
    public final EObject entryRuleTimeWaitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeWaitStatement = null;


        try {
            // InternalRailSL.g:581:58: (iv_ruleTimeWaitStatement= ruleTimeWaitStatement EOF )
            // InternalRailSL.g:582:2: iv_ruleTimeWaitStatement= ruleTimeWaitStatement EOF
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
    // InternalRailSL.g:588:1: ruleTimeWaitStatement returns [EObject current=null] : ( (otherlv_0= 'Wait' | otherlv_1= 'wait' ) (otherlv_2= 'for' )? ( (lv_time_3_0= RULE_INT ) ) (otherlv_4= 'seconds' | otherlv_5= 'second' ) otherlv_6= '.' ) ;
    public final EObject ruleTimeWaitStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_time_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalRailSL.g:594:2: ( ( (otherlv_0= 'Wait' | otherlv_1= 'wait' ) (otherlv_2= 'for' )? ( (lv_time_3_0= RULE_INT ) ) (otherlv_4= 'seconds' | otherlv_5= 'second' ) otherlv_6= '.' ) )
            // InternalRailSL.g:595:2: ( (otherlv_0= 'Wait' | otherlv_1= 'wait' ) (otherlv_2= 'for' )? ( (lv_time_3_0= RULE_INT ) ) (otherlv_4= 'seconds' | otherlv_5= 'second' ) otherlv_6= '.' )
            {
            // InternalRailSL.g:595:2: ( (otherlv_0= 'Wait' | otherlv_1= 'wait' ) (otherlv_2= 'for' )? ( (lv_time_3_0= RULE_INT ) ) (otherlv_4= 'seconds' | otherlv_5= 'second' ) otherlv_6= '.' )
            // InternalRailSL.g:596:3: (otherlv_0= 'Wait' | otherlv_1= 'wait' ) (otherlv_2= 'for' )? ( (lv_time_3_0= RULE_INT ) ) (otherlv_4= 'seconds' | otherlv_5= 'second' ) otherlv_6= '.'
            {
            // InternalRailSL.g:596:3: (otherlv_0= 'Wait' | otherlv_1= 'wait' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            else if ( (LA14_0==24) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalRailSL.g:597:4: otherlv_0= 'Wait'
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_15); 

                    				newLeafNode(otherlv_0, grammarAccess.getTimeWaitStatementAccess().getWaitKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:602:4: otherlv_1= 'wait'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_15); 

                    				newLeafNode(otherlv_1, grammarAccess.getTimeWaitStatementAccess().getWaitKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRailSL.g:607:3: (otherlv_2= 'for' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRailSL.g:608:4: otherlv_2= 'for'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_13); 

                    				newLeafNode(otherlv_2, grammarAccess.getTimeWaitStatementAccess().getForKeyword_1());
                    			

                    }
                    break;

            }

            // InternalRailSL.g:613:3: ( (lv_time_3_0= RULE_INT ) )
            // InternalRailSL.g:614:4: (lv_time_3_0= RULE_INT )
            {
            // InternalRailSL.g:614:4: (lv_time_3_0= RULE_INT )
            // InternalRailSL.g:615:5: lv_time_3_0= RULE_INT
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

            // InternalRailSL.g:631:3: (otherlv_4= 'seconds' | otherlv_5= 'second' )
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
                    // InternalRailSL.g:632:4: otherlv_4= 'seconds'
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getTimeWaitStatementAccess().getSecondsKeyword_3_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:637:4: otherlv_5= 'second'
                    {
                    otherlv_5=(Token)match(input,27,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getTimeWaitStatementAccess().getSecondKeyword_3_1());
                    			

                    }
                    break;

            }

            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getTimeWaitStatementAccess().getFullStopKeyword_4());
            		

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
    // InternalRailSL.g:650:1: entryRuleContactWaitStatement returns [EObject current=null] : iv_ruleContactWaitStatement= ruleContactWaitStatement EOF ;
    public final EObject entryRuleContactWaitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContactWaitStatement = null;


        try {
            // InternalRailSL.g:650:61: (iv_ruleContactWaitStatement= ruleContactWaitStatement EOF )
            // InternalRailSL.g:651:2: iv_ruleContactWaitStatement= ruleContactWaitStatement EOF
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
    // InternalRailSL.g:657:1: ruleContactWaitStatement returns [EObject current=null] : ( ( (lv_event_0_0= ruleContactEvent ) ) ( (lv_contact_1_0= ruleContactPosition ) ) otherlv_2= 'contact' (otherlv_3= 'of' )? ( (lv_segment_4_0= ruleRailSegment ) ) otherlv_5= '.' ) ;
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
            // InternalRailSL.g:663:2: ( ( ( (lv_event_0_0= ruleContactEvent ) ) ( (lv_contact_1_0= ruleContactPosition ) ) otherlv_2= 'contact' (otherlv_3= 'of' )? ( (lv_segment_4_0= ruleRailSegment ) ) otherlv_5= '.' ) )
            // InternalRailSL.g:664:2: ( ( (lv_event_0_0= ruleContactEvent ) ) ( (lv_contact_1_0= ruleContactPosition ) ) otherlv_2= 'contact' (otherlv_3= 'of' )? ( (lv_segment_4_0= ruleRailSegment ) ) otherlv_5= '.' )
            {
            // InternalRailSL.g:664:2: ( ( (lv_event_0_0= ruleContactEvent ) ) ( (lv_contact_1_0= ruleContactPosition ) ) otherlv_2= 'contact' (otherlv_3= 'of' )? ( (lv_segment_4_0= ruleRailSegment ) ) otherlv_5= '.' )
            // InternalRailSL.g:665:3: ( (lv_event_0_0= ruleContactEvent ) ) ( (lv_contact_1_0= ruleContactPosition ) ) otherlv_2= 'contact' (otherlv_3= 'of' )? ( (lv_segment_4_0= ruleRailSegment ) ) otherlv_5= '.'
            {
            // InternalRailSL.g:665:3: ( (lv_event_0_0= ruleContactEvent ) )
            // InternalRailSL.g:666:4: (lv_event_0_0= ruleContactEvent )
            {
            // InternalRailSL.g:666:4: (lv_event_0_0= ruleContactEvent )
            // InternalRailSL.g:667:5: lv_event_0_0= ruleContactEvent
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

            // InternalRailSL.g:684:3: ( (lv_contact_1_0= ruleContactPosition ) )
            // InternalRailSL.g:685:4: (lv_contact_1_0= ruleContactPosition )
            {
            // InternalRailSL.g:685:4: (lv_contact_1_0= ruleContactPosition )
            // InternalRailSL.g:686:5: lv_contact_1_0= ruleContactPosition
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

            otherlv_2=(Token)match(input,28,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getContactWaitStatementAccess().getContactKeyword_2());
            		
            // InternalRailSL.g:707:3: (otherlv_3= 'of' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRailSL.g:708:4: otherlv_3= 'of'
                    {
                    otherlv_3=(Token)match(input,29,FOLLOW_8); 

                    				newLeafNode(otherlv_3, grammarAccess.getContactWaitStatementAccess().getOfKeyword_3());
                    			

                    }
                    break;

            }

            // InternalRailSL.g:713:3: ( (lv_segment_4_0= ruleRailSegment ) )
            // InternalRailSL.g:714:4: (lv_segment_4_0= ruleRailSegment )
            {
            // InternalRailSL.g:714:4: (lv_segment_4_0= ruleRailSegment )
            // InternalRailSL.g:715:5: lv_segment_4_0= ruleRailSegment
            {

            					newCompositeNode(grammarAccess.getContactWaitStatementAccess().getSegmentRailSegmentEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
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

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

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
    // InternalRailSL.g:740:1: entryRuleOpStatement returns [EObject current=null] : iv_ruleOpStatement= ruleOpStatement EOF ;
    public final EObject entryRuleOpStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOpStatement = null;


        try {
            // InternalRailSL.g:740:52: (iv_ruleOpStatement= ruleOpStatement EOF )
            // InternalRailSL.g:741:2: iv_ruleOpStatement= ruleOpStatement EOF
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
    // InternalRailSL.g:747:1: ruleOpStatement returns [EObject current=null] : (this_CrossingStatement_0= ruleCrossingStatement | this_LightStatement_1= ruleLightStatement ) ;
    public final EObject ruleOpStatement() throws RecognitionException {
        EObject current = null;

        EObject this_CrossingStatement_0 = null;

        EObject this_LightStatement_1 = null;



        	enterRule();

        try {
            // InternalRailSL.g:753:2: ( (this_CrossingStatement_0= ruleCrossingStatement | this_LightStatement_1= ruleLightStatement ) )
            // InternalRailSL.g:754:2: (this_CrossingStatement_0= ruleCrossingStatement | this_LightStatement_1= ruleLightStatement )
            {
            // InternalRailSL.g:754:2: (this_CrossingStatement_0= ruleCrossingStatement | this_LightStatement_1= ruleLightStatement )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=59 && LA18_0<=62)) ) {
                alt18=1;
            }
            else if ( ((LA18_0>=31 && LA18_0<=32)) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalRailSL.g:755:3: this_CrossingStatement_0= ruleCrossingStatement
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
                    // InternalRailSL.g:764:3: this_LightStatement_1= ruleLightStatement
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
    // InternalRailSL.g:776:1: entryRuleCrossingStatement returns [EObject current=null] : iv_ruleCrossingStatement= ruleCrossingStatement EOF ;
    public final EObject entryRuleCrossingStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossingStatement = null;


        try {
            // InternalRailSL.g:776:58: (iv_ruleCrossingStatement= ruleCrossingStatement EOF )
            // InternalRailSL.g:777:2: iv_ruleCrossingStatement= ruleCrossingStatement EOF
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
    // InternalRailSL.g:783:1: ruleCrossingStatement returns [EObject current=null] : ( ( (lv_mode_0_0= ruleCrossingMode ) ) otherlv_1= 'crossing' otherlv_2= '.' ) ;
    public final EObject ruleCrossingStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Enumerator lv_mode_0_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:789:2: ( ( ( (lv_mode_0_0= ruleCrossingMode ) ) otherlv_1= 'crossing' otherlv_2= '.' ) )
            // InternalRailSL.g:790:2: ( ( (lv_mode_0_0= ruleCrossingMode ) ) otherlv_1= 'crossing' otherlv_2= '.' )
            {
            // InternalRailSL.g:790:2: ( ( (lv_mode_0_0= ruleCrossingMode ) ) otherlv_1= 'crossing' otherlv_2= '.' )
            // InternalRailSL.g:791:3: ( (lv_mode_0_0= ruleCrossingMode ) ) otherlv_1= 'crossing' otherlv_2= '.'
            {
            // InternalRailSL.g:791:3: ( (lv_mode_0_0= ruleCrossingMode ) )
            // InternalRailSL.g:792:4: (lv_mode_0_0= ruleCrossingMode )
            {
            // InternalRailSL.g:792:4: (lv_mode_0_0= ruleCrossingMode )
            // InternalRailSL.g:793:5: lv_mode_0_0= ruleCrossingMode
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

            otherlv_1=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getCrossingStatementAccess().getCrossingKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getCrossingStatementAccess().getFullStopKeyword_2());
            		

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
    // InternalRailSL.g:822:1: entryRuleLightStatement returns [EObject current=null] : iv_ruleLightStatement= ruleLightStatement EOF ;
    public final EObject entryRuleLightStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLightStatement = null;


        try {
            // InternalRailSL.g:822:55: (iv_ruleLightStatement= ruleLightStatement EOF )
            // InternalRailSL.g:823:2: iv_ruleLightStatement= ruleLightStatement EOF
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
    // InternalRailSL.g:829:1: ruleLightStatement returns [EObject current=null] : ( (otherlv_0= 'Turn' | otherlv_1= 'turn' ) otherlv_2= 'light' ( (lv_lights_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_lights_6_0= RULE_INT ) ) )* ( (lv_state_7_0= ruleLightMode ) ) otherlv_8= '.' ) ;
    public final EObject ruleLightStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_lights_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_lights_6_0=null;
        Token otherlv_8=null;
        Enumerator lv_state_7_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:835:2: ( ( (otherlv_0= 'Turn' | otherlv_1= 'turn' ) otherlv_2= 'light' ( (lv_lights_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_lights_6_0= RULE_INT ) ) )* ( (lv_state_7_0= ruleLightMode ) ) otherlv_8= '.' ) )
            // InternalRailSL.g:836:2: ( (otherlv_0= 'Turn' | otherlv_1= 'turn' ) otherlv_2= 'light' ( (lv_lights_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_lights_6_0= RULE_INT ) ) )* ( (lv_state_7_0= ruleLightMode ) ) otherlv_8= '.' )
            {
            // InternalRailSL.g:836:2: ( (otherlv_0= 'Turn' | otherlv_1= 'turn' ) otherlv_2= 'light' ( (lv_lights_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_lights_6_0= RULE_INT ) ) )* ( (lv_state_7_0= ruleLightMode ) ) otherlv_8= '.' )
            // InternalRailSL.g:837:3: (otherlv_0= 'Turn' | otherlv_1= 'turn' ) otherlv_2= 'light' ( (lv_lights_3_0= RULE_INT ) ) ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_lights_6_0= RULE_INT ) ) )* ( (lv_state_7_0= ruleLightMode ) ) otherlv_8= '.'
            {
            // InternalRailSL.g:837:3: (otherlv_0= 'Turn' | otherlv_1= 'turn' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            else if ( (LA19_0==32) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalRailSL.g:838:4: otherlv_0= 'Turn'
                    {
                    otherlv_0=(Token)match(input,31,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getLightStatementAccess().getTurnKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:843:4: otherlv_1= 'turn'
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_21); 

                    				newLeafNode(otherlv_1, grammarAccess.getLightStatementAccess().getTurnKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,33,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getLightStatementAccess().getLightKeyword_1());
            		
            // InternalRailSL.g:852:3: ( (lv_lights_3_0= RULE_INT ) )
            // InternalRailSL.g:853:4: (lv_lights_3_0= RULE_INT )
            {
            // InternalRailSL.g:853:4: (lv_lights_3_0= RULE_INT )
            // InternalRailSL.g:854:5: lv_lights_3_0= RULE_INT
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

            // InternalRailSL.g:870:3: ( (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_lights_6_0= RULE_INT ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=18 && LA21_0<=19)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalRailSL.g:871:4: (otherlv_4= ',' | otherlv_5= 'and' ) ( (lv_lights_6_0= RULE_INT ) )
            	    {
            	    // InternalRailSL.g:871:4: (otherlv_4= ',' | otherlv_5= 'and' )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==18) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==19) ) {
            	        alt20=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // InternalRailSL.g:872:5: otherlv_4= ','
            	            {
            	            otherlv_4=(Token)match(input,18,FOLLOW_13); 

            	            					newLeafNode(otherlv_4, grammarAccess.getLightStatementAccess().getCommaKeyword_3_0_0());
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalRailSL.g:877:5: otherlv_5= 'and'
            	            {
            	            otherlv_5=(Token)match(input,19,FOLLOW_13); 

            	            					newLeafNode(otherlv_5, grammarAccess.getLightStatementAccess().getAndKeyword_3_0_1());
            	            				

            	            }
            	            break;

            	    }

            	    // InternalRailSL.g:882:4: ( (lv_lights_6_0= RULE_INT ) )
            	    // InternalRailSL.g:883:5: (lv_lights_6_0= RULE_INT )
            	    {
            	    // InternalRailSL.g:883:5: (lv_lights_6_0= RULE_INT )
            	    // InternalRailSL.g:884:6: lv_lights_6_0= RULE_INT
            	    {
            	    lv_lights_6_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            	    						newLeafNode(lv_lights_6_0, grammarAccess.getLightStatementAccess().getLightsINTTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getLightStatementRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"lights",
            	    							lv_lights_6_0,
            	    							"org.eclipse.xtext.common.Terminals.INT");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalRailSL.g:901:3: ( (lv_state_7_0= ruleLightMode ) )
            // InternalRailSL.g:902:4: (lv_state_7_0= ruleLightMode )
            {
            // InternalRailSL.g:902:4: (lv_state_7_0= ruleLightMode )
            // InternalRailSL.g:903:5: lv_state_7_0= ruleLightMode
            {

            					newCompositeNode(grammarAccess.getLightStatementAccess().getStateLightModeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
            lv_state_7_0=ruleLightMode();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLightStatementRule());
            					}
            					set(
            						current,
            						"state",
            						lv_state_7_0,
            						"de.cau.cs.kieler.railsl.RailSL.LightMode");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getLightStatementAccess().getFullStopKeyword_5());
            		

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
    // InternalRailSL.g:928:1: entryRuleConditionalStatement returns [EObject current=null] : iv_ruleConditionalStatement= ruleConditionalStatement EOF ;
    public final EObject entryRuleConditionalStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalStatement = null;


        try {
            // InternalRailSL.g:928:61: (iv_ruleConditionalStatement= ruleConditionalStatement EOF )
            // InternalRailSL.g:929:2: iv_ruleConditionalStatement= ruleConditionalStatement EOF
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
    // InternalRailSL.g:935:1: ruleConditionalStatement returns [EObject current=null] : ( (otherlv_0= 'Branch' | otherlv_1= 'branch' | ( (otherlv_2= 'wait' | otherlv_3= 'Wait' ) otherlv_4= 'any' ) ) otherlv_5= ':' ( (lv_lines_6_0= ruleConditionalLine ) ) ( (lv_lines_7_0= ruleConditionalLine ) )+ ) ;
    public final EObject ruleConditionalStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_lines_6_0 = null;

        EObject lv_lines_7_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:941:2: ( ( (otherlv_0= 'Branch' | otherlv_1= 'branch' | ( (otherlv_2= 'wait' | otherlv_3= 'Wait' ) otherlv_4= 'any' ) ) otherlv_5= ':' ( (lv_lines_6_0= ruleConditionalLine ) ) ( (lv_lines_7_0= ruleConditionalLine ) )+ ) )
            // InternalRailSL.g:942:2: ( (otherlv_0= 'Branch' | otherlv_1= 'branch' | ( (otherlv_2= 'wait' | otherlv_3= 'Wait' ) otherlv_4= 'any' ) ) otherlv_5= ':' ( (lv_lines_6_0= ruleConditionalLine ) ) ( (lv_lines_7_0= ruleConditionalLine ) )+ )
            {
            // InternalRailSL.g:942:2: ( (otherlv_0= 'Branch' | otherlv_1= 'branch' | ( (otherlv_2= 'wait' | otherlv_3= 'Wait' ) otherlv_4= 'any' ) ) otherlv_5= ':' ( (lv_lines_6_0= ruleConditionalLine ) ) ( (lv_lines_7_0= ruleConditionalLine ) )+ )
            // InternalRailSL.g:943:3: (otherlv_0= 'Branch' | otherlv_1= 'branch' | ( (otherlv_2= 'wait' | otherlv_3= 'Wait' ) otherlv_4= 'any' ) ) otherlv_5= ':' ( (lv_lines_6_0= ruleConditionalLine ) ) ( (lv_lines_7_0= ruleConditionalLine ) )+
            {
            // InternalRailSL.g:943:3: (otherlv_0= 'Branch' | otherlv_1= 'branch' | ( (otherlv_2= 'wait' | otherlv_3= 'Wait' ) otherlv_4= 'any' ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt23=1;
                }
                break;
            case 35:
                {
                alt23=2;
                }
                break;
            case 23:
            case 24:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalRailSL.g:944:4: otherlv_0= 'Branch'
                    {
                    otherlv_0=(Token)match(input,34,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getConditionalStatementAccess().getBranchKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:949:4: otherlv_1= 'branch'
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getConditionalStatementAccess().getBranchKeyword_0_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalRailSL.g:954:4: ( (otherlv_2= 'wait' | otherlv_3= 'Wait' ) otherlv_4= 'any' )
                    {
                    // InternalRailSL.g:954:4: ( (otherlv_2= 'wait' | otherlv_3= 'Wait' ) otherlv_4= 'any' )
                    // InternalRailSL.g:955:5: (otherlv_2= 'wait' | otherlv_3= 'Wait' ) otherlv_4= 'any'
                    {
                    // InternalRailSL.g:955:5: (otherlv_2= 'wait' | otherlv_3= 'Wait' )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==24) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==23) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalRailSL.g:956:6: otherlv_2= 'wait'
                            {
                            otherlv_2=(Token)match(input,24,FOLLOW_23); 

                            						newLeafNode(otherlv_2, grammarAccess.getConditionalStatementAccess().getWaitKeyword_0_2_0_0());
                            					

                            }
                            break;
                        case 2 :
                            // InternalRailSL.g:961:6: otherlv_3= 'Wait'
                            {
                            otherlv_3=(Token)match(input,23,FOLLOW_23); 

                            						newLeafNode(otherlv_3, grammarAccess.getConditionalStatementAccess().getWaitKeyword_0_2_0_1());
                            					

                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,36,FOLLOW_3); 

                    					newLeafNode(otherlv_4, grammarAccess.getConditionalStatementAccess().getAnyKeyword_0_2_1());
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_24); 

            			newLeafNode(otherlv_5, grammarAccess.getConditionalStatementAccess().getColonKeyword_1());
            		
            // InternalRailSL.g:976:3: ( (lv_lines_6_0= ruleConditionalLine ) )
            // InternalRailSL.g:977:4: (lv_lines_6_0= ruleConditionalLine )
            {
            // InternalRailSL.g:977:4: (lv_lines_6_0= ruleConditionalLine )
            // InternalRailSL.g:978:5: lv_lines_6_0= ruleConditionalLine
            {

            					newCompositeNode(grammarAccess.getConditionalStatementAccess().getLinesConditionalLineParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_24);
            lv_lines_6_0=ruleConditionalLine();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionalStatementRule());
            					}
            					add(
            						current,
            						"lines",
            						lv_lines_6_0,
            						"de.cau.cs.kieler.railsl.RailSL.ConditionalLine");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRailSL.g:995:3: ( (lv_lines_7_0= ruleConditionalLine ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=37 && LA24_0<=38)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalRailSL.g:996:4: (lv_lines_7_0= ruleConditionalLine )
            	    {
            	    // InternalRailSL.g:996:4: (lv_lines_7_0= ruleConditionalLine )
            	    // InternalRailSL.g:997:5: lv_lines_7_0= ruleConditionalLine
            	    {

            	    					newCompositeNode(grammarAccess.getConditionalStatementAccess().getLinesConditionalLineParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_25);
            	    lv_lines_7_0=ruleConditionalLine();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConditionalStatementRule());
            	    					}
            	    					add(
            	    						current,
            	    						"lines",
            	    						lv_lines_7_0,
            	    						"de.cau.cs.kieler.railsl.RailSL.ConditionalLine");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
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
    // InternalRailSL.g:1018:1: entryRuleConditionalLine returns [EObject current=null] : iv_ruleConditionalLine= ruleConditionalLine EOF ;
    public final EObject entryRuleConditionalLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalLine = null;


        try {
            // InternalRailSL.g:1018:56: (iv_ruleConditionalLine= ruleConditionalLine EOF )
            // InternalRailSL.g:1019:2: iv_ruleConditionalLine= ruleConditionalLine EOF
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
    // InternalRailSL.g:1025:1: ruleConditionalLine returns [EObject current=null] : ( (otherlv_0= 'If' | otherlv_1= 'if' ) ( (lv_contact_2_0= ruleContactPosition ) ) otherlv_3= 'contact' (otherlv_4= 'of' )? ( (lv_segment_5_0= ruleRailSegment ) ) otherlv_6= 'is' otherlv_7= 'reached' otherlv_8= 'first' (otherlv_9= ',' )? otherlv_10= 'do' ( (lv_block_11_0= ruleBlock ) ) ) ;
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
            // InternalRailSL.g:1031:2: ( ( (otherlv_0= 'If' | otherlv_1= 'if' ) ( (lv_contact_2_0= ruleContactPosition ) ) otherlv_3= 'contact' (otherlv_4= 'of' )? ( (lv_segment_5_0= ruleRailSegment ) ) otherlv_6= 'is' otherlv_7= 'reached' otherlv_8= 'first' (otherlv_9= ',' )? otherlv_10= 'do' ( (lv_block_11_0= ruleBlock ) ) ) )
            // InternalRailSL.g:1032:2: ( (otherlv_0= 'If' | otherlv_1= 'if' ) ( (lv_contact_2_0= ruleContactPosition ) ) otherlv_3= 'contact' (otherlv_4= 'of' )? ( (lv_segment_5_0= ruleRailSegment ) ) otherlv_6= 'is' otherlv_7= 'reached' otherlv_8= 'first' (otherlv_9= ',' )? otherlv_10= 'do' ( (lv_block_11_0= ruleBlock ) ) )
            {
            // InternalRailSL.g:1032:2: ( (otherlv_0= 'If' | otherlv_1= 'if' ) ( (lv_contact_2_0= ruleContactPosition ) ) otherlv_3= 'contact' (otherlv_4= 'of' )? ( (lv_segment_5_0= ruleRailSegment ) ) otherlv_6= 'is' otherlv_7= 'reached' otherlv_8= 'first' (otherlv_9= ',' )? otherlv_10= 'do' ( (lv_block_11_0= ruleBlock ) ) )
            // InternalRailSL.g:1033:3: (otherlv_0= 'If' | otherlv_1= 'if' ) ( (lv_contact_2_0= ruleContactPosition ) ) otherlv_3= 'contact' (otherlv_4= 'of' )? ( (lv_segment_5_0= ruleRailSegment ) ) otherlv_6= 'is' otherlv_7= 'reached' otherlv_8= 'first' (otherlv_9= ',' )? otherlv_10= 'do' ( (lv_block_11_0= ruleBlock ) )
            {
            // InternalRailSL.g:1033:3: (otherlv_0= 'If' | otherlv_1= 'if' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==37) ) {
                alt25=1;
            }
            else if ( (LA25_0==38) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalRailSL.g:1034:4: otherlv_0= 'If'
                    {
                    otherlv_0=(Token)match(input,37,FOLLOW_17); 

                    				newLeafNode(otherlv_0, grammarAccess.getConditionalLineAccess().getIfKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1039:4: otherlv_1= 'if'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_17); 

                    				newLeafNode(otherlv_1, grammarAccess.getConditionalLineAccess().getIfKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalRailSL.g:1044:3: ( (lv_contact_2_0= ruleContactPosition ) )
            // InternalRailSL.g:1045:4: (lv_contact_2_0= ruleContactPosition )
            {
            // InternalRailSL.g:1045:4: (lv_contact_2_0= ruleContactPosition )
            // InternalRailSL.g:1046:5: lv_contact_2_0= ruleContactPosition
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

            otherlv_3=(Token)match(input,28,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getConditionalLineAccess().getContactKeyword_2());
            		
            // InternalRailSL.g:1067:3: (otherlv_4= 'of' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==29) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalRailSL.g:1068:4: otherlv_4= 'of'
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_8); 

                    				newLeafNode(otherlv_4, grammarAccess.getConditionalLineAccess().getOfKeyword_3());
                    			

                    }
                    break;

            }

            // InternalRailSL.g:1073:3: ( (lv_segment_5_0= ruleRailSegment ) )
            // InternalRailSL.g:1074:4: (lv_segment_5_0= ruleRailSegment )
            {
            // InternalRailSL.g:1074:4: (lv_segment_5_0= ruleRailSegment )
            // InternalRailSL.g:1075:5: lv_segment_5_0= ruleRailSegment
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

            otherlv_6=(Token)match(input,39,FOLLOW_27); 

            			newLeafNode(otherlv_6, grammarAccess.getConditionalLineAccess().getIsKeyword_5());
            		
            otherlv_7=(Token)match(input,40,FOLLOW_28); 

            			newLeafNode(otherlv_7, grammarAccess.getConditionalLineAccess().getReachedKeyword_6());
            		
            otherlv_8=(Token)match(input,41,FOLLOW_29); 

            			newLeafNode(otherlv_8, grammarAccess.getConditionalLineAccess().getFirstKeyword_7());
            		
            // InternalRailSL.g:1104:3: (otherlv_9= ',' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==18) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRailSL.g:1105:4: otherlv_9= ','
                    {
                    otherlv_9=(Token)match(input,18,FOLLOW_30); 

                    				newLeafNode(otherlv_9, grammarAccess.getConditionalLineAccess().getCommaKeyword_8());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,42,FOLLOW_4); 

            			newLeafNode(otherlv_10, grammarAccess.getConditionalLineAccess().getDoKeyword_9());
            		
            // InternalRailSL.g:1114:3: ( (lv_block_11_0= ruleBlock ) )
            // InternalRailSL.g:1115:4: (lv_block_11_0= ruleBlock )
            {
            // InternalRailSL.g:1115:4: (lv_block_11_0= ruleBlock )
            // InternalRailSL.g:1116:5: lv_block_11_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getConditionalLineAccess().getBlockBlockParserRuleCall_10_0());
            				
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
    // InternalRailSL.g:1137:1: entryRuleParallelStatement returns [EObject current=null] : iv_ruleParallelStatement= ruleParallelStatement EOF ;
    public final EObject entryRuleParallelStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParallelStatement = null;


        try {
            // InternalRailSL.g:1137:58: (iv_ruleParallelStatement= ruleParallelStatement EOF )
            // InternalRailSL.g:1138:2: iv_ruleParallelStatement= ruleParallelStatement EOF
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
    // InternalRailSL.g:1144:1: ruleParallelStatement returns [EObject current=null] : ( (otherlv_0= 'Parallel' | otherlv_1= 'parallel' ) otherlv_2= ':' ( (lv_blocks_3_0= ruleBlock ) ) ( (lv_blocks_4_0= ruleBlock ) )+ (otherlv_5= 'Join' | otherlv_6= 'join' ) otherlv_7= '.' ) ;
    public final EObject ruleParallelStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_blocks_3_0 = null;

        EObject lv_blocks_4_0 = null;



        	enterRule();

        try {
            // InternalRailSL.g:1150:2: ( ( (otherlv_0= 'Parallel' | otherlv_1= 'parallel' ) otherlv_2= ':' ( (lv_blocks_3_0= ruleBlock ) ) ( (lv_blocks_4_0= ruleBlock ) )+ (otherlv_5= 'Join' | otherlv_6= 'join' ) otherlv_7= '.' ) )
            // InternalRailSL.g:1151:2: ( (otherlv_0= 'Parallel' | otherlv_1= 'parallel' ) otherlv_2= ':' ( (lv_blocks_3_0= ruleBlock ) ) ( (lv_blocks_4_0= ruleBlock ) )+ (otherlv_5= 'Join' | otherlv_6= 'join' ) otherlv_7= '.' )
            {
            // InternalRailSL.g:1151:2: ( (otherlv_0= 'Parallel' | otherlv_1= 'parallel' ) otherlv_2= ':' ( (lv_blocks_3_0= ruleBlock ) ) ( (lv_blocks_4_0= ruleBlock ) )+ (otherlv_5= 'Join' | otherlv_6= 'join' ) otherlv_7= '.' )
            // InternalRailSL.g:1152:3: (otherlv_0= 'Parallel' | otherlv_1= 'parallel' ) otherlv_2= ':' ( (lv_blocks_3_0= ruleBlock ) ) ( (lv_blocks_4_0= ruleBlock ) )+ (otherlv_5= 'Join' | otherlv_6= 'join' ) otherlv_7= '.'
            {
            // InternalRailSL.g:1152:3: (otherlv_0= 'Parallel' | otherlv_1= 'parallel' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==43) ) {
                alt28=1;
            }
            else if ( (LA28_0==44) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalRailSL.g:1153:4: otherlv_0= 'Parallel'
                    {
                    otherlv_0=(Token)match(input,43,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getParallelStatementAccess().getParallelKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1158:4: otherlv_1= 'parallel'
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getParallelStatementAccess().getParallelKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getParallelStatementAccess().getColonKeyword_1());
            		
            // InternalRailSL.g:1167:3: ( (lv_blocks_3_0= ruleBlock ) )
            // InternalRailSL.g:1168:4: (lv_blocks_3_0= ruleBlock )
            {
            // InternalRailSL.g:1168:4: (lv_blocks_3_0= ruleBlock )
            // InternalRailSL.g:1169:5: lv_blocks_3_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getParallelStatementAccess().getBlocksBlockParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
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

            // InternalRailSL.g:1186:3: ( (lv_blocks_4_0= ruleBlock ) )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=11 && LA29_0<=12)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalRailSL.g:1187:4: (lv_blocks_4_0= ruleBlock )
            	    {
            	    // InternalRailSL.g:1187:4: (lv_blocks_4_0= ruleBlock )
            	    // InternalRailSL.g:1188:5: lv_blocks_4_0= ruleBlock
            	    {

            	    					newCompositeNode(grammarAccess.getParallelStatementAccess().getBlocksBlockParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_31);
            	    lv_blocks_4_0=ruleBlock();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getParallelStatementRule());
            	    					}
            	    					add(
            	    						current,
            	    						"blocks",
            	    						lv_blocks_4_0,
            	    						"de.cau.cs.kieler.railsl.RailSL.Block");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            // InternalRailSL.g:1205:3: (otherlv_5= 'Join' | otherlv_6= 'join' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==45) ) {
                alt30=1;
            }
            else if ( (LA30_0==46) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalRailSL.g:1206:4: otherlv_5= 'Join'
                    {
                    otherlv_5=(Token)match(input,45,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getParallelStatementAccess().getJoinKeyword_4_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1211:4: otherlv_6= 'join'
                    {
                    otherlv_6=(Token)match(input,46,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getParallelStatementAccess().getJoinKeyword_4_1());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getParallelStatementAccess().getFullStopKeyword_5());
            		

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
    // InternalRailSL.g:1224:1: ruleBlockEnd returns [Enumerator current=null] : ( (enumLiteral_0= 'End' ) | (enumLiteral_1= 'end' ) | (enumLiteral_2= 'Loop' ) | (enumLiteral_3= 'loop' ) ) ;
    public final Enumerator ruleBlockEnd() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRailSL.g:1230:2: ( ( (enumLiteral_0= 'End' ) | (enumLiteral_1= 'end' ) | (enumLiteral_2= 'Loop' ) | (enumLiteral_3= 'loop' ) ) )
            // InternalRailSL.g:1231:2: ( (enumLiteral_0= 'End' ) | (enumLiteral_1= 'end' ) | (enumLiteral_2= 'Loop' ) | (enumLiteral_3= 'loop' ) )
            {
            // InternalRailSL.g:1231:2: ( (enumLiteral_0= 'End' ) | (enumLiteral_1= 'end' ) | (enumLiteral_2= 'Loop' ) | (enumLiteral_3= 'loop' ) )
            int alt31=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt31=1;
                }
                break;
            case 48:
                {
                alt31=2;
                }
                break;
            case 49:
                {
                alt31=3;
                }
                break;
            case 50:
                {
                alt31=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalRailSL.g:1232:3: (enumLiteral_0= 'End' )
                    {
                    // InternalRailSL.g:1232:3: (enumLiteral_0= 'End' )
                    // InternalRailSL.g:1233:4: enumLiteral_0= 'End'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1240:3: (enumLiteral_1= 'end' )
                    {
                    // InternalRailSL.g:1240:3: (enumLiteral_1= 'end' )
                    // InternalRailSL.g:1241:4: enumLiteral_1= 'end'
                    {
                    enumLiteral_1=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBlockEndAccess().getENDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1248:3: (enumLiteral_2= 'Loop' )
                    {
                    // InternalRailSL.g:1248:3: (enumLiteral_2= 'Loop' )
                    // InternalRailSL.g:1249:4: enumLiteral_2= 'Loop'
                    {
                    enumLiteral_2=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getBlockEndAccess().getLOOPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBlockEndAccess().getLOOPEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1256:3: (enumLiteral_3= 'loop' )
                    {
                    // InternalRailSL.g:1256:3: (enumLiteral_3= 'loop' )
                    // InternalRailSL.g:1257:4: enumLiteral_3= 'loop'
                    {
                    enumLiteral_3=(Token)match(input,50,FOLLOW_2); 

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
    // InternalRailSL.g:1267:1: ruleTrackSpeedStop returns [Enumerator current=null] : (enumLiteral_0= 'stop' ) ;
    public final Enumerator ruleTrackSpeedStop() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalRailSL.g:1273:2: ( (enumLiteral_0= 'stop' ) )
            // InternalRailSL.g:1274:2: (enumLiteral_0= 'stop' )
            {
            // InternalRailSL.g:1274:2: (enumLiteral_0= 'stop' )
            // InternalRailSL.g:1275:3: enumLiteral_0= 'stop'
            {
            enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

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
    // InternalRailSL.g:1284:1: ruleTrackSpeedDrive returns [Enumerator current=null] : ( (enumLiteral_0= 'full' ) | (enumLiteral_1= 'slow' ) ) ;
    public final Enumerator ruleTrackSpeedDrive() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRailSL.g:1290:2: ( ( (enumLiteral_0= 'full' ) | (enumLiteral_1= 'slow' ) ) )
            // InternalRailSL.g:1291:2: ( (enumLiteral_0= 'full' ) | (enumLiteral_1= 'slow' ) )
            {
            // InternalRailSL.g:1291:2: ( (enumLiteral_0= 'full' ) | (enumLiteral_1= 'slow' ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==52) ) {
                alt32=1;
            }
            else if ( (LA32_0==53) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalRailSL.g:1292:3: (enumLiteral_0= 'full' )
                    {
                    // InternalRailSL.g:1292:3: (enumLiteral_0= 'full' )
                    // InternalRailSL.g:1293:4: enumLiteral_0= 'full'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getTrackSpeedDriveAccess().getFULLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getTrackSpeedDriveAccess().getFULLEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1300:3: (enumLiteral_1= 'slow' )
                    {
                    // InternalRailSL.g:1300:3: (enumLiteral_1= 'slow' )
                    // InternalRailSL.g:1301:4: enumLiteral_1= 'slow'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); 

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


    // $ANTLR start "rulePointOrientation"
    // InternalRailSL.g:1311:1: rulePointOrientation returns [Enumerator current=null] : ( (enumLiteral_0= 'straight' ) | (enumLiteral_1= 'branch' ) ) ;
    public final Enumerator rulePointOrientation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRailSL.g:1317:2: ( ( (enumLiteral_0= 'straight' ) | (enumLiteral_1= 'branch' ) ) )
            // InternalRailSL.g:1318:2: ( (enumLiteral_0= 'straight' ) | (enumLiteral_1= 'branch' ) )
            {
            // InternalRailSL.g:1318:2: ( (enumLiteral_0= 'straight' ) | (enumLiteral_1= 'branch' ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==54) ) {
                alt33=1;
            }
            else if ( (LA33_0==35) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalRailSL.g:1319:3: (enumLiteral_0= 'straight' )
                    {
                    // InternalRailSL.g:1319:3: (enumLiteral_0= 'straight' )
                    // InternalRailSL.g:1320:4: enumLiteral_0= 'straight'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getPointOrientationAccess().getSTRAIGHTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPointOrientationAccess().getSTRAIGHTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1327:3: (enumLiteral_1= 'branch' )
                    {
                    // InternalRailSL.g:1327:3: (enumLiteral_1= 'branch' )
                    // InternalRailSL.g:1328:4: enumLiteral_1= 'branch'
                    {
                    enumLiteral_1=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getPointOrientationAccess().getBRANCHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPointOrientationAccess().getBRANCHEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "rulePointOrientation"


    // $ANTLR start "ruleContactEvent"
    // InternalRailSL.g:1338:1: ruleContactEvent returns [Enumerator current=null] : ( (enumLiteral_0= 'Reach' ) | (enumLiteral_1= 'reach' ) | (enumLiteral_2= 'Pass' ) | (enumLiteral_3= 'pass' ) ) ;
    public final Enumerator ruleContactEvent() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRailSL.g:1344:2: ( ( (enumLiteral_0= 'Reach' ) | (enumLiteral_1= 'reach' ) | (enumLiteral_2= 'Pass' ) | (enumLiteral_3= 'pass' ) ) )
            // InternalRailSL.g:1345:2: ( (enumLiteral_0= 'Reach' ) | (enumLiteral_1= 'reach' ) | (enumLiteral_2= 'Pass' ) | (enumLiteral_3= 'pass' ) )
            {
            // InternalRailSL.g:1345:2: ( (enumLiteral_0= 'Reach' ) | (enumLiteral_1= 'reach' ) | (enumLiteral_2= 'Pass' ) | (enumLiteral_3= 'pass' ) )
            int alt34=4;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt34=1;
                }
                break;
            case 56:
                {
                alt34=2;
                }
                break;
            case 57:
                {
                alt34=3;
                }
                break;
            case 58:
                {
                alt34=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalRailSL.g:1346:3: (enumLiteral_0= 'Reach' )
                    {
                    // InternalRailSL.g:1346:3: (enumLiteral_0= 'Reach' )
                    // InternalRailSL.g:1347:4: enumLiteral_0= 'Reach'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1354:3: (enumLiteral_1= 'reach' )
                    {
                    // InternalRailSL.g:1354:3: (enumLiteral_1= 'reach' )
                    // InternalRailSL.g:1355:4: enumLiteral_1= 'reach'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getContactEventAccess().getREACHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1362:3: (enumLiteral_2= 'Pass' )
                    {
                    // InternalRailSL.g:1362:3: (enumLiteral_2= 'Pass' )
                    // InternalRailSL.g:1363:4: enumLiteral_2= 'Pass'
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getContactEventAccess().getPASSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getContactEventAccess().getPASSEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1370:3: (enumLiteral_3= 'pass' )
                    {
                    // InternalRailSL.g:1370:3: (enumLiteral_3= 'pass' )
                    // InternalRailSL.g:1371:4: enumLiteral_3= 'pass'
                    {
                    enumLiteral_3=(Token)match(input,58,FOLLOW_2); 

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
    // InternalRailSL.g:1381:1: ruleContactPosition returns [Enumerator current=null] : ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'second' ) ) ;
    public final Enumerator ruleContactPosition() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRailSL.g:1387:2: ( ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'second' ) ) )
            // InternalRailSL.g:1388:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'second' ) )
            {
            // InternalRailSL.g:1388:2: ( (enumLiteral_0= 'first' ) | (enumLiteral_1= 'second' ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==41) ) {
                alt35=1;
            }
            else if ( (LA35_0==27) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalRailSL.g:1389:3: (enumLiteral_0= 'first' )
                    {
                    // InternalRailSL.g:1389:3: (enumLiteral_0= 'first' )
                    // InternalRailSL.g:1390:4: enumLiteral_0= 'first'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getContactPositionAccess().getFIRSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getContactPositionAccess().getFIRSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1397:3: (enumLiteral_1= 'second' )
                    {
                    // InternalRailSL.g:1397:3: (enumLiteral_1= 'second' )
                    // InternalRailSL.g:1398:4: enumLiteral_1= 'second'
                    {
                    enumLiteral_1=(Token)match(input,27,FOLLOW_2); 

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
    // InternalRailSL.g:1408:1: ruleCrossingMode returns [Enumerator current=null] : ( (enumLiteral_0= 'Open' ) | (enumLiteral_1= 'open' ) | (enumLiteral_2= 'Close' ) | (enumLiteral_3= 'close' ) ) ;
    public final Enumerator ruleCrossingMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalRailSL.g:1414:2: ( ( (enumLiteral_0= 'Open' ) | (enumLiteral_1= 'open' ) | (enumLiteral_2= 'Close' ) | (enumLiteral_3= 'close' ) ) )
            // InternalRailSL.g:1415:2: ( (enumLiteral_0= 'Open' ) | (enumLiteral_1= 'open' ) | (enumLiteral_2= 'Close' ) | (enumLiteral_3= 'close' ) )
            {
            // InternalRailSL.g:1415:2: ( (enumLiteral_0= 'Open' ) | (enumLiteral_1= 'open' ) | (enumLiteral_2= 'Close' ) | (enumLiteral_3= 'close' ) )
            int alt36=4;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt36=1;
                }
                break;
            case 60:
                {
                alt36=2;
                }
                break;
            case 61:
                {
                alt36=3;
                }
                break;
            case 62:
                {
                alt36=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalRailSL.g:1416:3: (enumLiteral_0= 'Open' )
                    {
                    // InternalRailSL.g:1416:3: (enumLiteral_0= 'Open' )
                    // InternalRailSL.g:1417:4: enumLiteral_0= 'Open'
                    {
                    enumLiteral_0=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1424:3: (enumLiteral_1= 'open' )
                    {
                    // InternalRailSL.g:1424:3: (enumLiteral_1= 'open' )
                    // InternalRailSL.g:1425:4: enumLiteral_1= 'open'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCrossingModeAccess().getOPENEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1432:3: (enumLiteral_2= 'Close' )
                    {
                    // InternalRailSL.g:1432:3: (enumLiteral_2= 'Close' )
                    // InternalRailSL.g:1433:4: enumLiteral_2= 'Close'
                    {
                    enumLiteral_2=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getCrossingModeAccess().getCLOSEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCrossingModeAccess().getCLOSEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1440:3: (enumLiteral_3= 'close' )
                    {
                    // InternalRailSL.g:1440:3: (enumLiteral_3= 'close' )
                    // InternalRailSL.g:1441:4: enumLiteral_3= 'close'
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


    // $ANTLR start "ruleLightMode"
    // InternalRailSL.g:1451:1: ruleLightMode returns [Enumerator current=null] : ( (enumLiteral_0= 'on' ) | (enumLiteral_1= 'off' ) ) ;
    public final Enumerator ruleLightMode() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRailSL.g:1457:2: ( ( (enumLiteral_0= 'on' ) | (enumLiteral_1= 'off' ) ) )
            // InternalRailSL.g:1458:2: ( (enumLiteral_0= 'on' ) | (enumLiteral_1= 'off' ) )
            {
            // InternalRailSL.g:1458:2: ( (enumLiteral_0= 'on' ) | (enumLiteral_1= 'off' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==63) ) {
                alt37=1;
            }
            else if ( (LA37_0==64) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalRailSL.g:1459:3: (enumLiteral_0= 'on' )
                    {
                    // InternalRailSL.g:1459:3: (enumLiteral_0= 'on' )
                    // InternalRailSL.g:1460:4: enumLiteral_0= 'on'
                    {
                    enumLiteral_0=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getLightModeAccess().getONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLightModeAccess().getONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1467:3: (enumLiteral_1= 'off' )
                    {
                    // InternalRailSL.g:1467:3: (enumLiteral_1= 'off' )
                    // InternalRailSL.g:1468:4: enumLiteral_1= 'off'
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getLightModeAccess().getOFFEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLightModeAccess().getOFFEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleLightMode"


    // $ANTLR start "ruleRailSegment"
    // InternalRailSL.g:1478:1: ruleRailSegment returns [Enumerator current=null] : ( (enumLiteral_0= 'IC_JCT_0' ) | (enumLiteral_1= 'IC_LN_0' ) | (enumLiteral_2= 'IC_LN_1' ) | (enumLiteral_3= 'IC_LN_2' ) | (enumLiteral_4= 'IC_LN_3' ) | (enumLiteral_5= 'IC_LN_4' ) | (enumLiteral_6= 'IC_LN_5' ) | (enumLiteral_7= 'IC_ST_0' ) | (enumLiteral_8= 'IC_ST_1' ) | (enumLiteral_9= 'IC_ST_2' ) | (enumLiteral_10= 'IC_ST_3' ) | (enumLiteral_11= 'IC_ST_4' ) | (enumLiteral_12= 'IO_LN_0' ) | (enumLiteral_13= 'IO_LN_1' ) | (enumLiteral_14= 'IO_LN_2' ) | (enumLiteral_15= 'KH_LN_0' ) | (enumLiteral_16= 'KH_LN_1' ) | (enumLiteral_17= 'KH_LN_2' ) | (enumLiteral_18= 'KH_LN_3' ) | (enumLiteral_19= 'KH_LN_4' ) | (enumLiteral_20= 'KH_LN_5' ) | (enumLiteral_21= 'KH_LN_6' ) | (enumLiteral_22= 'KH_LN_7' ) | (enumLiteral_23= 'KH_LN_8' ) | (enumLiteral_24= 'KH_ST_0' ) | (enumLiteral_25= 'KH_ST_1' ) | (enumLiteral_26= 'KH_ST_2' ) | (enumLiteral_27= 'KH_ST_3' ) | (enumLiteral_28= 'KH_ST_4' ) | (enumLiteral_29= 'KH_ST_5' ) | (enumLiteral_30= 'KH_ST_6' ) | (enumLiteral_31= 'KIO_LN_0' ) | (enumLiteral_32= 'KIO_LN_1' ) | (enumLiteral_33= 'OC_JCT_0' ) | (enumLiteral_34= 'OC_LN_0' ) | (enumLiteral_35= 'OC_LN_1' ) | (enumLiteral_36= 'OC_LN_2' ) | (enumLiteral_37= 'OC_LN_3' ) | (enumLiteral_38= 'OC_LN_4' ) | (enumLiteral_39= 'OC_LN_5' ) | (enumLiteral_40= 'OC_ST_0' ) | (enumLiteral_41= 'OC_ST_1' ) | (enumLiteral_42= 'OC_ST_2' ) | (enumLiteral_43= 'OC_ST_3' ) | (enumLiteral_44= 'OC_ST_4' ) | (enumLiteral_45= 'OI_LN_0' ) | (enumLiteral_46= 'OI_LN_1' ) | (enumLiteral_47= 'OI_LN_2' ) ) ;
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
            // InternalRailSL.g:1484:2: ( ( (enumLiteral_0= 'IC_JCT_0' ) | (enumLiteral_1= 'IC_LN_0' ) | (enumLiteral_2= 'IC_LN_1' ) | (enumLiteral_3= 'IC_LN_2' ) | (enumLiteral_4= 'IC_LN_3' ) | (enumLiteral_5= 'IC_LN_4' ) | (enumLiteral_6= 'IC_LN_5' ) | (enumLiteral_7= 'IC_ST_0' ) | (enumLiteral_8= 'IC_ST_1' ) | (enumLiteral_9= 'IC_ST_2' ) | (enumLiteral_10= 'IC_ST_3' ) | (enumLiteral_11= 'IC_ST_4' ) | (enumLiteral_12= 'IO_LN_0' ) | (enumLiteral_13= 'IO_LN_1' ) | (enumLiteral_14= 'IO_LN_2' ) | (enumLiteral_15= 'KH_LN_0' ) | (enumLiteral_16= 'KH_LN_1' ) | (enumLiteral_17= 'KH_LN_2' ) | (enumLiteral_18= 'KH_LN_3' ) | (enumLiteral_19= 'KH_LN_4' ) | (enumLiteral_20= 'KH_LN_5' ) | (enumLiteral_21= 'KH_LN_6' ) | (enumLiteral_22= 'KH_LN_7' ) | (enumLiteral_23= 'KH_LN_8' ) | (enumLiteral_24= 'KH_ST_0' ) | (enumLiteral_25= 'KH_ST_1' ) | (enumLiteral_26= 'KH_ST_2' ) | (enumLiteral_27= 'KH_ST_3' ) | (enumLiteral_28= 'KH_ST_4' ) | (enumLiteral_29= 'KH_ST_5' ) | (enumLiteral_30= 'KH_ST_6' ) | (enumLiteral_31= 'KIO_LN_0' ) | (enumLiteral_32= 'KIO_LN_1' ) | (enumLiteral_33= 'OC_JCT_0' ) | (enumLiteral_34= 'OC_LN_0' ) | (enumLiteral_35= 'OC_LN_1' ) | (enumLiteral_36= 'OC_LN_2' ) | (enumLiteral_37= 'OC_LN_3' ) | (enumLiteral_38= 'OC_LN_4' ) | (enumLiteral_39= 'OC_LN_5' ) | (enumLiteral_40= 'OC_ST_0' ) | (enumLiteral_41= 'OC_ST_1' ) | (enumLiteral_42= 'OC_ST_2' ) | (enumLiteral_43= 'OC_ST_3' ) | (enumLiteral_44= 'OC_ST_4' ) | (enumLiteral_45= 'OI_LN_0' ) | (enumLiteral_46= 'OI_LN_1' ) | (enumLiteral_47= 'OI_LN_2' ) ) )
            // InternalRailSL.g:1485:2: ( (enumLiteral_0= 'IC_JCT_0' ) | (enumLiteral_1= 'IC_LN_0' ) | (enumLiteral_2= 'IC_LN_1' ) | (enumLiteral_3= 'IC_LN_2' ) | (enumLiteral_4= 'IC_LN_3' ) | (enumLiteral_5= 'IC_LN_4' ) | (enumLiteral_6= 'IC_LN_5' ) | (enumLiteral_7= 'IC_ST_0' ) | (enumLiteral_8= 'IC_ST_1' ) | (enumLiteral_9= 'IC_ST_2' ) | (enumLiteral_10= 'IC_ST_3' ) | (enumLiteral_11= 'IC_ST_4' ) | (enumLiteral_12= 'IO_LN_0' ) | (enumLiteral_13= 'IO_LN_1' ) | (enumLiteral_14= 'IO_LN_2' ) | (enumLiteral_15= 'KH_LN_0' ) | (enumLiteral_16= 'KH_LN_1' ) | (enumLiteral_17= 'KH_LN_2' ) | (enumLiteral_18= 'KH_LN_3' ) | (enumLiteral_19= 'KH_LN_4' ) | (enumLiteral_20= 'KH_LN_5' ) | (enumLiteral_21= 'KH_LN_6' ) | (enumLiteral_22= 'KH_LN_7' ) | (enumLiteral_23= 'KH_LN_8' ) | (enumLiteral_24= 'KH_ST_0' ) | (enumLiteral_25= 'KH_ST_1' ) | (enumLiteral_26= 'KH_ST_2' ) | (enumLiteral_27= 'KH_ST_3' ) | (enumLiteral_28= 'KH_ST_4' ) | (enumLiteral_29= 'KH_ST_5' ) | (enumLiteral_30= 'KH_ST_6' ) | (enumLiteral_31= 'KIO_LN_0' ) | (enumLiteral_32= 'KIO_LN_1' ) | (enumLiteral_33= 'OC_JCT_0' ) | (enumLiteral_34= 'OC_LN_0' ) | (enumLiteral_35= 'OC_LN_1' ) | (enumLiteral_36= 'OC_LN_2' ) | (enumLiteral_37= 'OC_LN_3' ) | (enumLiteral_38= 'OC_LN_4' ) | (enumLiteral_39= 'OC_LN_5' ) | (enumLiteral_40= 'OC_ST_0' ) | (enumLiteral_41= 'OC_ST_1' ) | (enumLiteral_42= 'OC_ST_2' ) | (enumLiteral_43= 'OC_ST_3' ) | (enumLiteral_44= 'OC_ST_4' ) | (enumLiteral_45= 'OI_LN_0' ) | (enumLiteral_46= 'OI_LN_1' ) | (enumLiteral_47= 'OI_LN_2' ) )
            {
            // InternalRailSL.g:1485:2: ( (enumLiteral_0= 'IC_JCT_0' ) | (enumLiteral_1= 'IC_LN_0' ) | (enumLiteral_2= 'IC_LN_1' ) | (enumLiteral_3= 'IC_LN_2' ) | (enumLiteral_4= 'IC_LN_3' ) | (enumLiteral_5= 'IC_LN_4' ) | (enumLiteral_6= 'IC_LN_5' ) | (enumLiteral_7= 'IC_ST_0' ) | (enumLiteral_8= 'IC_ST_1' ) | (enumLiteral_9= 'IC_ST_2' ) | (enumLiteral_10= 'IC_ST_3' ) | (enumLiteral_11= 'IC_ST_4' ) | (enumLiteral_12= 'IO_LN_0' ) | (enumLiteral_13= 'IO_LN_1' ) | (enumLiteral_14= 'IO_LN_2' ) | (enumLiteral_15= 'KH_LN_0' ) | (enumLiteral_16= 'KH_LN_1' ) | (enumLiteral_17= 'KH_LN_2' ) | (enumLiteral_18= 'KH_LN_3' ) | (enumLiteral_19= 'KH_LN_4' ) | (enumLiteral_20= 'KH_LN_5' ) | (enumLiteral_21= 'KH_LN_6' ) | (enumLiteral_22= 'KH_LN_7' ) | (enumLiteral_23= 'KH_LN_8' ) | (enumLiteral_24= 'KH_ST_0' ) | (enumLiteral_25= 'KH_ST_1' ) | (enumLiteral_26= 'KH_ST_2' ) | (enumLiteral_27= 'KH_ST_3' ) | (enumLiteral_28= 'KH_ST_4' ) | (enumLiteral_29= 'KH_ST_5' ) | (enumLiteral_30= 'KH_ST_6' ) | (enumLiteral_31= 'KIO_LN_0' ) | (enumLiteral_32= 'KIO_LN_1' ) | (enumLiteral_33= 'OC_JCT_0' ) | (enumLiteral_34= 'OC_LN_0' ) | (enumLiteral_35= 'OC_LN_1' ) | (enumLiteral_36= 'OC_LN_2' ) | (enumLiteral_37= 'OC_LN_3' ) | (enumLiteral_38= 'OC_LN_4' ) | (enumLiteral_39= 'OC_LN_5' ) | (enumLiteral_40= 'OC_ST_0' ) | (enumLiteral_41= 'OC_ST_1' ) | (enumLiteral_42= 'OC_ST_2' ) | (enumLiteral_43= 'OC_ST_3' ) | (enumLiteral_44= 'OC_ST_4' ) | (enumLiteral_45= 'OI_LN_0' ) | (enumLiteral_46= 'OI_LN_1' ) | (enumLiteral_47= 'OI_LN_2' ) )
            int alt38=48;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt38=1;
                }
                break;
            case 66:
                {
                alt38=2;
                }
                break;
            case 67:
                {
                alt38=3;
                }
                break;
            case 68:
                {
                alt38=4;
                }
                break;
            case 69:
                {
                alt38=5;
                }
                break;
            case 70:
                {
                alt38=6;
                }
                break;
            case 71:
                {
                alt38=7;
                }
                break;
            case 72:
                {
                alt38=8;
                }
                break;
            case 73:
                {
                alt38=9;
                }
                break;
            case 74:
                {
                alt38=10;
                }
                break;
            case 75:
                {
                alt38=11;
                }
                break;
            case 76:
                {
                alt38=12;
                }
                break;
            case 77:
                {
                alt38=13;
                }
                break;
            case 78:
                {
                alt38=14;
                }
                break;
            case 79:
                {
                alt38=15;
                }
                break;
            case 80:
                {
                alt38=16;
                }
                break;
            case 81:
                {
                alt38=17;
                }
                break;
            case 82:
                {
                alt38=18;
                }
                break;
            case 83:
                {
                alt38=19;
                }
                break;
            case 84:
                {
                alt38=20;
                }
                break;
            case 85:
                {
                alt38=21;
                }
                break;
            case 86:
                {
                alt38=22;
                }
                break;
            case 87:
                {
                alt38=23;
                }
                break;
            case 88:
                {
                alt38=24;
                }
                break;
            case 89:
                {
                alt38=25;
                }
                break;
            case 90:
                {
                alt38=26;
                }
                break;
            case 91:
                {
                alt38=27;
                }
                break;
            case 92:
                {
                alt38=28;
                }
                break;
            case 93:
                {
                alt38=29;
                }
                break;
            case 94:
                {
                alt38=30;
                }
                break;
            case 95:
                {
                alt38=31;
                }
                break;
            case 96:
                {
                alt38=32;
                }
                break;
            case 97:
                {
                alt38=33;
                }
                break;
            case 98:
                {
                alt38=34;
                }
                break;
            case 99:
                {
                alt38=35;
                }
                break;
            case 100:
                {
                alt38=36;
                }
                break;
            case 101:
                {
                alt38=37;
                }
                break;
            case 102:
                {
                alt38=38;
                }
                break;
            case 103:
                {
                alt38=39;
                }
                break;
            case 104:
                {
                alt38=40;
                }
                break;
            case 105:
                {
                alt38=41;
                }
                break;
            case 106:
                {
                alt38=42;
                }
                break;
            case 107:
                {
                alt38=43;
                }
                break;
            case 108:
                {
                alt38=44;
                }
                break;
            case 109:
                {
                alt38=45;
                }
                break;
            case 110:
                {
                alt38=46;
                }
                break;
            case 111:
                {
                alt38=47;
                }
                break;
            case 112:
                {
                alt38=48;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalRailSL.g:1486:3: (enumLiteral_0= 'IC_JCT_0' )
                    {
                    // InternalRailSL.g:1486:3: (enumLiteral_0= 'IC_JCT_0' )
                    // InternalRailSL.g:1487:4: enumLiteral_0= 'IC_JCT_0'
                    {
                    enumLiteral_0=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_JCT_0EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRailSegmentAccess().getIC_JCT_0EnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRailSL.g:1494:3: (enumLiteral_1= 'IC_LN_0' )
                    {
                    // InternalRailSL.g:1494:3: (enumLiteral_1= 'IC_LN_0' )
                    // InternalRailSL.g:1495:4: enumLiteral_1= 'IC_LN_0'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_0EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getRailSegmentAccess().getIC_LN_0EnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRailSL.g:1502:3: (enumLiteral_2= 'IC_LN_1' )
                    {
                    // InternalRailSL.g:1502:3: (enumLiteral_2= 'IC_LN_1' )
                    // InternalRailSL.g:1503:4: enumLiteral_2= 'IC_LN_1'
                    {
                    enumLiteral_2=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_1EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getRailSegmentAccess().getIC_LN_1EnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRailSL.g:1510:3: (enumLiteral_3= 'IC_LN_2' )
                    {
                    // InternalRailSL.g:1510:3: (enumLiteral_3= 'IC_LN_2' )
                    // InternalRailSL.g:1511:4: enumLiteral_3= 'IC_LN_2'
                    {
                    enumLiteral_3=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_2EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getRailSegmentAccess().getIC_LN_2EnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRailSL.g:1518:3: (enumLiteral_4= 'IC_LN_3' )
                    {
                    // InternalRailSL.g:1518:3: (enumLiteral_4= 'IC_LN_3' )
                    // InternalRailSL.g:1519:4: enumLiteral_4= 'IC_LN_3'
                    {
                    enumLiteral_4=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_3EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getRailSegmentAccess().getIC_LN_3EnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRailSL.g:1526:3: (enumLiteral_5= 'IC_LN_4' )
                    {
                    // InternalRailSL.g:1526:3: (enumLiteral_5= 'IC_LN_4' )
                    // InternalRailSL.g:1527:4: enumLiteral_5= 'IC_LN_4'
                    {
                    enumLiteral_5=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_4EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getRailSegmentAccess().getIC_LN_4EnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRailSL.g:1534:3: (enumLiteral_6= 'IC_LN_5' )
                    {
                    // InternalRailSL.g:1534:3: (enumLiteral_6= 'IC_LN_5' )
                    // InternalRailSL.g:1535:4: enumLiteral_6= 'IC_LN_5'
                    {
                    enumLiteral_6=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_LN_5EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getRailSegmentAccess().getIC_LN_5EnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalRailSL.g:1542:3: (enumLiteral_7= 'IC_ST_0' )
                    {
                    // InternalRailSL.g:1542:3: (enumLiteral_7= 'IC_ST_0' )
                    // InternalRailSL.g:1543:4: enumLiteral_7= 'IC_ST_0'
                    {
                    enumLiteral_7=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_ST_0EnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getRailSegmentAccess().getIC_ST_0EnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalRailSL.g:1550:3: (enumLiteral_8= 'IC_ST_1' )
                    {
                    // InternalRailSL.g:1550:3: (enumLiteral_8= 'IC_ST_1' )
                    // InternalRailSL.g:1551:4: enumLiteral_8= 'IC_ST_1'
                    {
                    enumLiteral_8=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_ST_1EnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getRailSegmentAccess().getIC_ST_1EnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalRailSL.g:1558:3: (enumLiteral_9= 'IC_ST_2' )
                    {
                    // InternalRailSL.g:1558:3: (enumLiteral_9= 'IC_ST_2' )
                    // InternalRailSL.g:1559:4: enumLiteral_9= 'IC_ST_2'
                    {
                    enumLiteral_9=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_ST_2EnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getRailSegmentAccess().getIC_ST_2EnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalRailSL.g:1566:3: (enumLiteral_10= 'IC_ST_3' )
                    {
                    // InternalRailSL.g:1566:3: (enumLiteral_10= 'IC_ST_3' )
                    // InternalRailSL.g:1567:4: enumLiteral_10= 'IC_ST_3'
                    {
                    enumLiteral_10=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_ST_3EnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getRailSegmentAccess().getIC_ST_3EnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalRailSL.g:1574:3: (enumLiteral_11= 'IC_ST_4' )
                    {
                    // InternalRailSL.g:1574:3: (enumLiteral_11= 'IC_ST_4' )
                    // InternalRailSL.g:1575:4: enumLiteral_11= 'IC_ST_4'
                    {
                    enumLiteral_11=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIC_ST_4EnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getRailSegmentAccess().getIC_ST_4EnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalRailSL.g:1582:3: (enumLiteral_12= 'IO_LN_0' )
                    {
                    // InternalRailSL.g:1582:3: (enumLiteral_12= 'IO_LN_0' )
                    // InternalRailSL.g:1583:4: enumLiteral_12= 'IO_LN_0'
                    {
                    enumLiteral_12=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIO_LN_0EnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getRailSegmentAccess().getIO_LN_0EnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalRailSL.g:1590:3: (enumLiteral_13= 'IO_LN_1' )
                    {
                    // InternalRailSL.g:1590:3: (enumLiteral_13= 'IO_LN_1' )
                    // InternalRailSL.g:1591:4: enumLiteral_13= 'IO_LN_1'
                    {
                    enumLiteral_13=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIO_LN_1EnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getRailSegmentAccess().getIO_LN_1EnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalRailSL.g:1598:3: (enumLiteral_14= 'IO_LN_2' )
                    {
                    // InternalRailSL.g:1598:3: (enumLiteral_14= 'IO_LN_2' )
                    // InternalRailSL.g:1599:4: enumLiteral_14= 'IO_LN_2'
                    {
                    enumLiteral_14=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getIO_LN_2EnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getRailSegmentAccess().getIO_LN_2EnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalRailSL.g:1606:3: (enumLiteral_15= 'KH_LN_0' )
                    {
                    // InternalRailSL.g:1606:3: (enumLiteral_15= 'KH_LN_0' )
                    // InternalRailSL.g:1607:4: enumLiteral_15= 'KH_LN_0'
                    {
                    enumLiteral_15=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_0EnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getRailSegmentAccess().getKH_LN_0EnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalRailSL.g:1614:3: (enumLiteral_16= 'KH_LN_1' )
                    {
                    // InternalRailSL.g:1614:3: (enumLiteral_16= 'KH_LN_1' )
                    // InternalRailSL.g:1615:4: enumLiteral_16= 'KH_LN_1'
                    {
                    enumLiteral_16=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_1EnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getRailSegmentAccess().getKH_LN_1EnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalRailSL.g:1622:3: (enumLiteral_17= 'KH_LN_2' )
                    {
                    // InternalRailSL.g:1622:3: (enumLiteral_17= 'KH_LN_2' )
                    // InternalRailSL.g:1623:4: enumLiteral_17= 'KH_LN_2'
                    {
                    enumLiteral_17=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_2EnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getRailSegmentAccess().getKH_LN_2EnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalRailSL.g:1630:3: (enumLiteral_18= 'KH_LN_3' )
                    {
                    // InternalRailSL.g:1630:3: (enumLiteral_18= 'KH_LN_3' )
                    // InternalRailSL.g:1631:4: enumLiteral_18= 'KH_LN_3'
                    {
                    enumLiteral_18=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_3EnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getRailSegmentAccess().getKH_LN_3EnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalRailSL.g:1638:3: (enumLiteral_19= 'KH_LN_4' )
                    {
                    // InternalRailSL.g:1638:3: (enumLiteral_19= 'KH_LN_4' )
                    // InternalRailSL.g:1639:4: enumLiteral_19= 'KH_LN_4'
                    {
                    enumLiteral_19=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_4EnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getRailSegmentAccess().getKH_LN_4EnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalRailSL.g:1646:3: (enumLiteral_20= 'KH_LN_5' )
                    {
                    // InternalRailSL.g:1646:3: (enumLiteral_20= 'KH_LN_5' )
                    // InternalRailSL.g:1647:4: enumLiteral_20= 'KH_LN_5'
                    {
                    enumLiteral_20=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_5EnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getRailSegmentAccess().getKH_LN_5EnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalRailSL.g:1654:3: (enumLiteral_21= 'KH_LN_6' )
                    {
                    // InternalRailSL.g:1654:3: (enumLiteral_21= 'KH_LN_6' )
                    // InternalRailSL.g:1655:4: enumLiteral_21= 'KH_LN_6'
                    {
                    enumLiteral_21=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_6EnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getRailSegmentAccess().getKH_LN_6EnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalRailSL.g:1662:3: (enumLiteral_22= 'KH_LN_7' )
                    {
                    // InternalRailSL.g:1662:3: (enumLiteral_22= 'KH_LN_7' )
                    // InternalRailSL.g:1663:4: enumLiteral_22= 'KH_LN_7'
                    {
                    enumLiteral_22=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_7EnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getRailSegmentAccess().getKH_LN_7EnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalRailSL.g:1670:3: (enumLiteral_23= 'KH_LN_8' )
                    {
                    // InternalRailSL.g:1670:3: (enumLiteral_23= 'KH_LN_8' )
                    // InternalRailSL.g:1671:4: enumLiteral_23= 'KH_LN_8'
                    {
                    enumLiteral_23=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_LN_8EnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getRailSegmentAccess().getKH_LN_8EnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalRailSL.g:1678:3: (enumLiteral_24= 'KH_ST_0' )
                    {
                    // InternalRailSL.g:1678:3: (enumLiteral_24= 'KH_ST_0' )
                    // InternalRailSL.g:1679:4: enumLiteral_24= 'KH_ST_0'
                    {
                    enumLiteral_24=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_0EnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getRailSegmentAccess().getKH_ST_0EnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalRailSL.g:1686:3: (enumLiteral_25= 'KH_ST_1' )
                    {
                    // InternalRailSL.g:1686:3: (enumLiteral_25= 'KH_ST_1' )
                    // InternalRailSL.g:1687:4: enumLiteral_25= 'KH_ST_1'
                    {
                    enumLiteral_25=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_1EnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getRailSegmentAccess().getKH_ST_1EnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;
                case 27 :
                    // InternalRailSL.g:1694:3: (enumLiteral_26= 'KH_ST_2' )
                    {
                    // InternalRailSL.g:1694:3: (enumLiteral_26= 'KH_ST_2' )
                    // InternalRailSL.g:1695:4: enumLiteral_26= 'KH_ST_2'
                    {
                    enumLiteral_26=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_2EnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_26, grammarAccess.getRailSegmentAccess().getKH_ST_2EnumLiteralDeclaration_26());
                    			

                    }


                    }
                    break;
                case 28 :
                    // InternalRailSL.g:1702:3: (enumLiteral_27= 'KH_ST_3' )
                    {
                    // InternalRailSL.g:1702:3: (enumLiteral_27= 'KH_ST_3' )
                    // InternalRailSL.g:1703:4: enumLiteral_27= 'KH_ST_3'
                    {
                    enumLiteral_27=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_3EnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_27, grammarAccess.getRailSegmentAccess().getKH_ST_3EnumLiteralDeclaration_27());
                    			

                    }


                    }
                    break;
                case 29 :
                    // InternalRailSL.g:1710:3: (enumLiteral_28= 'KH_ST_4' )
                    {
                    // InternalRailSL.g:1710:3: (enumLiteral_28= 'KH_ST_4' )
                    // InternalRailSL.g:1711:4: enumLiteral_28= 'KH_ST_4'
                    {
                    enumLiteral_28=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_4EnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_28, grammarAccess.getRailSegmentAccess().getKH_ST_4EnumLiteralDeclaration_28());
                    			

                    }


                    }
                    break;
                case 30 :
                    // InternalRailSL.g:1718:3: (enumLiteral_29= 'KH_ST_5' )
                    {
                    // InternalRailSL.g:1718:3: (enumLiteral_29= 'KH_ST_5' )
                    // InternalRailSL.g:1719:4: enumLiteral_29= 'KH_ST_5'
                    {
                    enumLiteral_29=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_5EnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_29, grammarAccess.getRailSegmentAccess().getKH_ST_5EnumLiteralDeclaration_29());
                    			

                    }


                    }
                    break;
                case 31 :
                    // InternalRailSL.g:1726:3: (enumLiteral_30= 'KH_ST_6' )
                    {
                    // InternalRailSL.g:1726:3: (enumLiteral_30= 'KH_ST_6' )
                    // InternalRailSL.g:1727:4: enumLiteral_30= 'KH_ST_6'
                    {
                    enumLiteral_30=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKH_ST_6EnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_30, grammarAccess.getRailSegmentAccess().getKH_ST_6EnumLiteralDeclaration_30());
                    			

                    }


                    }
                    break;
                case 32 :
                    // InternalRailSL.g:1734:3: (enumLiteral_31= 'KIO_LN_0' )
                    {
                    // InternalRailSL.g:1734:3: (enumLiteral_31= 'KIO_LN_0' )
                    // InternalRailSL.g:1735:4: enumLiteral_31= 'KIO_LN_0'
                    {
                    enumLiteral_31=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKIO_LN_0EnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_31, grammarAccess.getRailSegmentAccess().getKIO_LN_0EnumLiteralDeclaration_31());
                    			

                    }


                    }
                    break;
                case 33 :
                    // InternalRailSL.g:1742:3: (enumLiteral_32= 'KIO_LN_1' )
                    {
                    // InternalRailSL.g:1742:3: (enumLiteral_32= 'KIO_LN_1' )
                    // InternalRailSL.g:1743:4: enumLiteral_32= 'KIO_LN_1'
                    {
                    enumLiteral_32=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getKIO_LN_1EnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_32, grammarAccess.getRailSegmentAccess().getKIO_LN_1EnumLiteralDeclaration_32());
                    			

                    }


                    }
                    break;
                case 34 :
                    // InternalRailSL.g:1750:3: (enumLiteral_33= 'OC_JCT_0' )
                    {
                    // InternalRailSL.g:1750:3: (enumLiteral_33= 'OC_JCT_0' )
                    // InternalRailSL.g:1751:4: enumLiteral_33= 'OC_JCT_0'
                    {
                    enumLiteral_33=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_JCT_0EnumLiteralDeclaration_33().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_33, grammarAccess.getRailSegmentAccess().getOC_JCT_0EnumLiteralDeclaration_33());
                    			

                    }


                    }
                    break;
                case 35 :
                    // InternalRailSL.g:1758:3: (enumLiteral_34= 'OC_LN_0' )
                    {
                    // InternalRailSL.g:1758:3: (enumLiteral_34= 'OC_LN_0' )
                    // InternalRailSL.g:1759:4: enumLiteral_34= 'OC_LN_0'
                    {
                    enumLiteral_34=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_0EnumLiteralDeclaration_34().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_34, grammarAccess.getRailSegmentAccess().getOC_LN_0EnumLiteralDeclaration_34());
                    			

                    }


                    }
                    break;
                case 36 :
                    // InternalRailSL.g:1766:3: (enumLiteral_35= 'OC_LN_1' )
                    {
                    // InternalRailSL.g:1766:3: (enumLiteral_35= 'OC_LN_1' )
                    // InternalRailSL.g:1767:4: enumLiteral_35= 'OC_LN_1'
                    {
                    enumLiteral_35=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_1EnumLiteralDeclaration_35().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_35, grammarAccess.getRailSegmentAccess().getOC_LN_1EnumLiteralDeclaration_35());
                    			

                    }


                    }
                    break;
                case 37 :
                    // InternalRailSL.g:1774:3: (enumLiteral_36= 'OC_LN_2' )
                    {
                    // InternalRailSL.g:1774:3: (enumLiteral_36= 'OC_LN_2' )
                    // InternalRailSL.g:1775:4: enumLiteral_36= 'OC_LN_2'
                    {
                    enumLiteral_36=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_2EnumLiteralDeclaration_36().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_36, grammarAccess.getRailSegmentAccess().getOC_LN_2EnumLiteralDeclaration_36());
                    			

                    }


                    }
                    break;
                case 38 :
                    // InternalRailSL.g:1782:3: (enumLiteral_37= 'OC_LN_3' )
                    {
                    // InternalRailSL.g:1782:3: (enumLiteral_37= 'OC_LN_3' )
                    // InternalRailSL.g:1783:4: enumLiteral_37= 'OC_LN_3'
                    {
                    enumLiteral_37=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_3EnumLiteralDeclaration_37().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_37, grammarAccess.getRailSegmentAccess().getOC_LN_3EnumLiteralDeclaration_37());
                    			

                    }


                    }
                    break;
                case 39 :
                    // InternalRailSL.g:1790:3: (enumLiteral_38= 'OC_LN_4' )
                    {
                    // InternalRailSL.g:1790:3: (enumLiteral_38= 'OC_LN_4' )
                    // InternalRailSL.g:1791:4: enumLiteral_38= 'OC_LN_4'
                    {
                    enumLiteral_38=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_4EnumLiteralDeclaration_38().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_38, grammarAccess.getRailSegmentAccess().getOC_LN_4EnumLiteralDeclaration_38());
                    			

                    }


                    }
                    break;
                case 40 :
                    // InternalRailSL.g:1798:3: (enumLiteral_39= 'OC_LN_5' )
                    {
                    // InternalRailSL.g:1798:3: (enumLiteral_39= 'OC_LN_5' )
                    // InternalRailSL.g:1799:4: enumLiteral_39= 'OC_LN_5'
                    {
                    enumLiteral_39=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_LN_5EnumLiteralDeclaration_39().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_39, grammarAccess.getRailSegmentAccess().getOC_LN_5EnumLiteralDeclaration_39());
                    			

                    }


                    }
                    break;
                case 41 :
                    // InternalRailSL.g:1806:3: (enumLiteral_40= 'OC_ST_0' )
                    {
                    // InternalRailSL.g:1806:3: (enumLiteral_40= 'OC_ST_0' )
                    // InternalRailSL.g:1807:4: enumLiteral_40= 'OC_ST_0'
                    {
                    enumLiteral_40=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_ST_0EnumLiteralDeclaration_40().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_40, grammarAccess.getRailSegmentAccess().getOC_ST_0EnumLiteralDeclaration_40());
                    			

                    }


                    }
                    break;
                case 42 :
                    // InternalRailSL.g:1814:3: (enumLiteral_41= 'OC_ST_1' )
                    {
                    // InternalRailSL.g:1814:3: (enumLiteral_41= 'OC_ST_1' )
                    // InternalRailSL.g:1815:4: enumLiteral_41= 'OC_ST_1'
                    {
                    enumLiteral_41=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_ST_1EnumLiteralDeclaration_41().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_41, grammarAccess.getRailSegmentAccess().getOC_ST_1EnumLiteralDeclaration_41());
                    			

                    }


                    }
                    break;
                case 43 :
                    // InternalRailSL.g:1822:3: (enumLiteral_42= 'OC_ST_2' )
                    {
                    // InternalRailSL.g:1822:3: (enumLiteral_42= 'OC_ST_2' )
                    // InternalRailSL.g:1823:4: enumLiteral_42= 'OC_ST_2'
                    {
                    enumLiteral_42=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_ST_2EnumLiteralDeclaration_42().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_42, grammarAccess.getRailSegmentAccess().getOC_ST_2EnumLiteralDeclaration_42());
                    			

                    }


                    }
                    break;
                case 44 :
                    // InternalRailSL.g:1830:3: (enumLiteral_43= 'OC_ST_3' )
                    {
                    // InternalRailSL.g:1830:3: (enumLiteral_43= 'OC_ST_3' )
                    // InternalRailSL.g:1831:4: enumLiteral_43= 'OC_ST_3'
                    {
                    enumLiteral_43=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_ST_3EnumLiteralDeclaration_43().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_43, grammarAccess.getRailSegmentAccess().getOC_ST_3EnumLiteralDeclaration_43());
                    			

                    }


                    }
                    break;
                case 45 :
                    // InternalRailSL.g:1838:3: (enumLiteral_44= 'OC_ST_4' )
                    {
                    // InternalRailSL.g:1838:3: (enumLiteral_44= 'OC_ST_4' )
                    // InternalRailSL.g:1839:4: enumLiteral_44= 'OC_ST_4'
                    {
                    enumLiteral_44=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOC_ST_4EnumLiteralDeclaration_44().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_44, grammarAccess.getRailSegmentAccess().getOC_ST_4EnumLiteralDeclaration_44());
                    			

                    }


                    }
                    break;
                case 46 :
                    // InternalRailSL.g:1846:3: (enumLiteral_45= 'OI_LN_0' )
                    {
                    // InternalRailSL.g:1846:3: (enumLiteral_45= 'OI_LN_0' )
                    // InternalRailSL.g:1847:4: enumLiteral_45= 'OI_LN_0'
                    {
                    enumLiteral_45=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOI_LN_0EnumLiteralDeclaration_45().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_45, grammarAccess.getRailSegmentAccess().getOI_LN_0EnumLiteralDeclaration_45());
                    			

                    }


                    }
                    break;
                case 47 :
                    // InternalRailSL.g:1854:3: (enumLiteral_46= 'OI_LN_1' )
                    {
                    // InternalRailSL.g:1854:3: (enumLiteral_46= 'OI_LN_1' )
                    // InternalRailSL.g:1855:4: enumLiteral_46= 'OI_LN_1'
                    {
                    enumLiteral_46=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOI_LN_1EnumLiteralDeclaration_46().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_46, grammarAccess.getRailSegmentAccess().getOI_LN_1EnumLiteralDeclaration_46());
                    			

                    }


                    }
                    break;
                case 48 :
                    // InternalRailSL.g:1862:3: (enumLiteral_47= 'OI_LN_2' )
                    {
                    // InternalRailSL.g:1862:3: (enumLiteral_47= 'OI_LN_2' )
                    // InternalRailSL.g:1863:4: enumLiteral_47= 'OI_LN_2'
                    {
                    enumLiteral_47=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getRailSegmentAccess().getOI_LN_2EnumLiteralDeclaration_47().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_47, grammarAccess.getRailSegmentAccess().getOI_LN_2EnumLiteralDeclaration_47());
                    			

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x7F80180D81819800L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x7F87980D81819800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0001FFFFFFFFFFFEL});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0038000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000204000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0040000800000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000020008000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020000000L,0x0001FFFFFFFFFFFEL});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x80000000000C0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000040000040000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x7F80780D81819800L});

}