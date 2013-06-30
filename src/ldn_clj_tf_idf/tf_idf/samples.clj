(ns ldn-clj-tf-idf.tf-idf.samples
  (:require [clojure.string :as str]))

(def raw-documents
  ["Dale Cregan has been told he will die in prison for the murders of two unarmed policewomen and a father and son. Cregan, 30, described by Greater Manchester police's chief constable, Sir Peter Fahy, as a \"scourge on our society\", was given a whole-life sentence at Preston crown court by Mr Justice Holroyde QC at the end of a trial which laid bare the sheer brutality of Manchester's underworld. Cregan was already on the run for the murders of David Short, 46, and son Mark, 23, when he killed policewomen Nicola Hughes, 23, and Fiona Bone, 32, in a horrifying gun and grenade attack. Sentencing Cregan, Holroyde said he had \"acted with premeditated savagery\" in the \"quite appalling\" murders. \"You, Cregan, drew those two officers into a calculated trap for the sole purpose of murdering them in cold blood,\" he said. The judge said he had no doubt Cregan had expected one or more unarmed officers to attend his false report of a crime. He said the two constables were performing their public duty when they responded to the call and that Cregan would have seen they were unarmed policewomen as they approached the front door. \"You opened fire with the advantage of surprise,\" he said, \"and opened fire before your victims had the chance to do anything to protect themselves.\" He added: \"You pursued them with a cold-blooded ruthlessness - determined to end their lives.\" Cregan was cleared of a charge of attempted murder involving a grenade attack on Sharon Hark, which he denied. But during his trial he had admitted the four murders and the attempted murders of three others, along with a count of causing an explosion with a hand-grenade. Nine other defendants faced trial alongside him on various charges linked to the deaths of the Shorts. Four of them were cleared. Cregan went on the run days before he killed David Short last August after he had gunned down Short's son, Mark, in a pub in Droylsden, Greater Manchester, three months earlier. The manhunt reached a ghastly conclusion on 18 September, when he lured the constables with a bogus 999 call to a house in Abbey Gardens in Hattersley. His last comment to the call handler as he was told officers were on the way was: \"I'll be waiting.\" He opened the front door as they walked up the front garden path and shot them in the chest with a Glock handgun. PC Hughes was hit eight times, including three strikes to the head as she lay on the ground. PC Bone was hit up to eight times after she managed to draw and fire her Taser at Cregan, who fired 32 bullets in total in barely half a minute. He then left his \"calling card\" of a military grenade, which he threw on to the path where the officers lay. The killer then dropped his gun and drove the short distance to Hyde police station, where he calmly walked up to the counter clerk and said: \"I'm wanted by the police and I've just done two coppers.\""
   "The US supreme court has ruled unanimously that natural human genes cannot be patented, a decision that scientists and civil rights campaigners said removed a major barrier to patient care and medical innovation. The court on Thursday held that human DNA was a \"product of nature\", a basic tool of scientific and technological work, thereby placing it beyond the domain of patent protection. It struck down patents held by Myriad Genetics Inc, a Utah company, on two genes linked to a higher risk of breast and ovarian cancer. But it also said that synthetic genetic material could be patented, in a mixed ruling for the biotechnology industry, which has argued that patents are necessary to recoup the billions of dollars it spends on research. Myriad carries out tests for BRCA genes, recently brought into the public eye when actor Angelina Jolie revealed she had a double mastectomy after learning she tested positive for one of the genes. The ruling represents a major shift in the law, overturning three decades of patent awards by the US government and could have a profound effect on the biotechnology and drug industry. Justice Clarence Thomas ruled that Myriad's assertion that the DNA it isolated from the human body for its tests were patentable had to be dismissed because it violated patent rules. The court said that laws of nature, natural phenomena and abstract ideas lay outside patent protection. \"We hold that a naturally occurring DNA segment is a product of nature and not patent eligible merely because it has been isolated,\" Thomas said. He said there would be \"considerable danger\" that without such an exception, the granting of patent would \"tie up\" the use of such tools and future innovation based on them. In a statement made after the ruling, Myriad Genetics stressed that the court had upheld its patents on complementary DNA and said that it retained \"strong intellectual protection\" for its BRCA test. Peter Meldrum, president and CEO of Myriad Genetics, said: \"We believe the court appropriately upheld our claims on cDNA and underscored the patent eligibility of our method claims, ensuring strong intellectual property protection for our BRACAnalysis test moving forward.\" Myriad said it still had more than 500 valid and enforceable claims in 24 different patents conferring strong patent protection for its BRCA test. Nabeela Rasheed, a lawyer with McAndrews Held and Malloy, who specialises in biotechnology, said that because the case did not involve method or application claims, Myriad could still be in a reasonable position to retain a monopoly on its BRCA test. \"Myriad's history is that it defends its patents\" said Rasheed. \"I don't see why if they have method claims why they wouldn't continue to enforce them.\" Opponents had argued that patent protection should not be granted to something within the human body. \"Today, the court struck down a major barrier to patient care and medical innovation,\" said Sandra Park, an attorney with the ACLU Women's Rights Project, which brought the case on behalf of scientists, cancer patients and medical associations. \"Myriad did not invent the BRCA genes and should not control them. Because of this ruling, patients will have greater access to genetic testing and scientists can engage in research on these genes without fear of being sued.\" Park said that Myriad would no longer have a monopoly on the BRCA tests because other geneticists could now use alternative methods of testing. The patents allowed Myriad to control access to the genes, known as BRCA1 and BRCA2, and gave the company the right to limit others from doing research or diagnostic testing of the genes. Women with a faulty gene have a three to seven times greater risk of developing breast cancer and also have a higher risk of ovarian cancer. Opponents of the patents argued that research and diagnostic testing from others is crucial for patients making important medical decisions. They also said that the patents allowed Myriad, which sells the only BRCA gene test, to set the cost and other parameters of tests, making it difficult for women to access alternate tests or get a comprehensive second opinion about their results."
   "The FBI has shrugged off growing congressional anxiety over its surveillance of US citizens, claiming such programs could have foiled the 9-11 terrorist attacks and would prevent \"another Boston\". The FBI director, Robert Mueller, also revealed that US authorities would be taking action against whistleblower Edward Snowden for revealing the extent of its activities, confirming that the FBI and department of justice were taking \"all necessary steps to hold the person responsible\". But Mueller's testimony before the House judicial oversight committee brought angry responses from many congressmen, who questioned whether such surveillance was lawful and demanded to know why it had failed to prevent the Boston bombing if it were so effective. In a frequently heated debate over balancing privacy and security, Mueller went further than other government officials in claiming that the collection of data on all American phone calls had become an essential part of counter-terrorism efforts and would make the US \"exceptionally vulnerable\" if watered down. He also rejected calls from technology companies such as Google to disclose the scale of the programs, saying even this information could help terrorists seeking to hide their communications. \"If you narrow [the scope of surveillance], you narrow the dots and that might be the dot that prevents the next Boston,\" said Mueller. He described how Khalid al-Midhar, one of the 9-11 hijackers, had called a Yemeni safe house from a phone in San Diego shortly before the attack – a phone call that would have been intercepted and acted upon, claimed Mueller, had today's surveillance system been in place. Not all committee members were convinced however, particularly in the light of acknowledged intelligence failures before the Boston attacks – when phone records were available. \"I am not persuaded that makes it OK to collect every phone call,\" said Democrat John Conyers. Others questioned whether the FBI had acted lawfully in seeking to use section 215 of the Patriot Act to target all calls made in the US on the basis that they \"might become relevant\" to future terrorism investigations. \"A dragnet subpoena for every telephone record makes a mockery of the relevance standard under [section] 215,\" said Democrat Jerrold Nadler. \"If everything in the world is relevant, then the word has no meaning.\" Jason Chaffetz, a Republican from Utah, questioned whether by collecting so-called \"metadata\" from call records, the FBI was contravening a recent legal test case that found that tracking a suspect's movements without a warrant infringed fourth amendment rights to privacy under the constitution. Mueller claimed basic telephone call records were not subject to fourth amendment protection under a 1979 Supreme court judgment, but declined to comment on whether they now included geo-location data, saying the \"question had not occurred\" to him and this \"may or may not\" amount to a form of call content. Republican Louis Gohmert also pushed back at the FBI, accusing it of over-classifying surveillance. But Mueller told him to \"ask that question in a classified briefing\" and said it would be dangerous to reveal the content of secret Fisa court judgments that approved such activities under section 215 of the Patriot Act. This brought an angry response from Jim Sensenbrenner, one of the authors of the Patriot Act, who said: \"My concern is there is no way for anyone whose records have been turned over to you to get the order quashed because they don't know about it.\" But Mueller insisted that any disclosures of the extent of its surveillance activities risked harming national security. \"Any tidbit of information that comes out\" about how authorities track communications means terrorists \"find ways around\", he said. \"Every time we have a leak like this and you follow it up and look at the intel afterwards [you find terrorists] are looking for ways around.. If we lose our ability to get their communications we are going to be exceptionally vulnerable\" The FBI director also claimed that such collection of electronic data had been a vital part of efforts track down Ibragim Todashev, a friend of the Boston bombers recently shot dead in Florida. He did not say whether phone or computer records used would have been available to the authorities without recourse to blanket collection of phone records, although it is highly likely a specific subpoena would have been granted in the wake of the attack, which killed three people."
   "Turkey's prime minister, Recep Tayyip Erdoğan, delivered a stark \"final warning\" on Thursday to thousands of defiant protesters still camped out in Istanbul's Gezi park, demanding that they end their occupation. Describing the protesters as troublemakers, Erdoğan said the government had reached the \"end of its patience\" over the continuing demonstrations against his leadership, in which five people have been killed since 31 May. Erdoğan had earlier issued a 24-hour deadline to clear Taksim Square and Gezi park. Erdoğan spoke as the latest person to die in the demonstrations was named as 26-year-old Ethem Sarısülük, who had been on life support for days. He was pronounced dead after he was hit in the head by a tear gas canister on 1 June during a protest in the capital, Ankara. The protests erupted after a violent police crackdown on 31 May following a sit-in by activists objecting to a development project that would involve cutting down the trees in Gezi Park and replacing them with a replica of an Ottoman-era barracks. Since then, protests have spread to dozens of cities and been transformed into a broader complaint over Erdoğan's style of government. ErdoganErdoğan also hit out at criticism by the European parliament of the force being used. The European parliament has voted to condemn the use of \"harsh measures\" against peaceful protesters and urged Erdoğan to take a unifying and conciliatory stance. \"We have arrived at the end of our patience,\" Erdoğan told local party leaders in a speech in Ankara yesterday. \"I am giving you my final warning.\" He urged parents with children at the park to convince them to pack up and go home. Erdoğan added that he had instructed police that \"we cannot allow lawbreakers to hang around freely in this square … We will clean the square\". Responding to a vote in the European parliament in Strasbourg, Erdoğan added: \"I won't recognise the decision that the European Union parliament is going to take about us … Who do you think you are by taking such a decision?\" Although there were no fresh clashes yesterday, many have interpreted Erdoğan's remarks as a clear signal that he will move soon to clear the park of protesters. A new poll of those occupying Gezi park suggests that almost 60% are protesting about Erdoğan's style of government, which opponents have criticised for its creeping authoritarianism. Despite the warnings, new protesters of all ages continued to arrive in the camp, insisting they would not be frightened away. Among them was Kerim Ozken, 63, a retired bank worker and writer. \"I think the police might attack again tonight,\" he said, reflecting the fears of many in the camp, which is surrounded in places by makeshift barricades. \"Tayyip [Erdoğan] said it will be over tonight. He thinks it is a war. It is idiotic. Really idiotic. He thinks he can change people's minds by force.\" So far during the protests, 5,000 protesters and 600 police have been reported injured. Erdoğan's defiant tone comes despite the floating of a proposal to have a popular referendum on the fate of the park. Pouring cold water on that notion, a senior judge insisted that the courts had already ruled on the development. Istanbul governor Hüseyin Avni Mutlu went on a nationally-televised talk show on Thursday and offered to meet with the demonstrators."
   "As he pulled a small black suitcase and carried a selection of laptop bags over his shoulders, no one would have paid much attention to Ed Snowden as he arrived at Hong Kong International Airport. But Snowden was not your average tourist or businessman. In all, he was carrying four computers that enabled him to gain access to some of the US government's most highly-classified secrets. Today, just over three weeks later, he is the world's most famous spy, whistleblower and fugitive, responsible for the biggest intelligence breach in recent US history. News organisations around the globe have described him as \"America's Most Wanted\". Members of Congress have denounced him as a \"defector\" whose actions amount to treason and have demanded he be punished to the fullest extent of the law. His supporters argue that his actions have opened up a much-needed debate on the balance between security and privacy in the modern world. So is he whistleblower or traitor? That debate is still raging. Snowden, aged 29, had flown to Hong Kong from Hawaii, where he had been working for the defence contractor Booz Allen Hamilton at the National Security Agency, the biggest spy surveillance organisation in the world. Since Monday morning, he has gone underground. Hong Kong-based journalists, joined by the international press, have been hunting for him. At the height of the search, reporters recruited Twitter followers to see if they could successfully identify the lighting and other hotel furnishings shown in the video in which he went public. They did: the $330-a-night Mira Hotel, on Nathan Road, the busy main shopping drag in Kowloon district. Knowing it was only a matter of time before he was found, Snowden checked out at lunchtime on Monday. It is thought he is now in a safe house. What happens now? The US is on the verge of pressing criminal charges against him and that would lead to extradition proceedings, with a view to bringing him back to the US for trial and eventually jail. If America is planning to jail for life Bradley Manning, who was behind the 2010 WikiLeaks release of tens of thousands of state department memos, what retribution lies in store for Snowden, who is guilty of leaking on a much bigger scale? The documents Manning released were merely \"classified\". Snowden's were not only \"Top Secret\", but circulation was extremely limited. For an American, the traditional home for the kind of story Snowden was planning to reveal would have been the New York Times. But during extensive interviews last week with a Guardian team, he recalled how dismayed he had been to discover the Times had a great scoop in election year 2004 – that the Bush administration, post 9/11, allowed the NSA to snoop on US citizens without warrants – but had sat on it for a year before publishing. Snowden said this was a turning point for him, confirming his belief that traditional media outlets could not be trusted. He looked around for alternative journalists, those who were both anti-establishment and at home with blogging and other social media. The member of this generation that he most trusted was the Guardian commentator Glenn Greenwald. In January, Snowden reached out to a documentary filmmaker and journalist, Laura Poitras, and they began to correspond. In mid-February, he sent an email to Greenwald, who lives in Brazil, suggesting he might want to set up a method for receiving and sending encrypted emails. He even made a YouTube video for Greenwald, to take him step-by-step through the process of encryption. Greenwald did not know the identity of the person offering the leaks and was unsure if they were genuine. He took no action. In March, in New York, he received a call from Poitras, who convinced him that he needed to take this more seriously. Greenwald and Snowden set up a secure communications system and the first of the documents arrived, dealing with the NSA's secret Prism programme, which gathers up information from the world's leading technology companies. Greenwald flew to New York to talk to Guardian editors on 31 May; the next day, he and Poitras flew to Hong Kong. (I met the two for the first time in the New York office, accompanied them to Hong Kong and joined them in interviewing Snowden over the best part of a week, and writing articles based on the leaked documents and the interviews). Neither Greenwald nor Poitras even knew what Snowden looked like. \"He had some elaborate scheme to meet,\" Greenwald said. Snowden told him to go to a specific location on the third floor of the hotel and ask loudly for directions to a restaurant. Greenwald assumed Snowden was lurking in the background, listening in. They went to a room that, Greenwald recalled, contained a large fake alligator. Snowden made himself known. He had told Greenwald that \"I would know it was him because he would be carrying a Rubik's Cube\". Both Greenwald and Poitras were shocked the first time they saw the 29-year-old. Greenwald said: I had expected a 60-year-old grizzled veteran, someone in the higher echelons of the intelligence service. I thought: 'This is going to be a wasted trip.' After an hour of listening to Snowden, Greenwald changed his mind. \"I completely believed him,\" he said. The interviews were conducted in Snowden's room, which overlooked Kowloon Park. Snowden and the journalists, complete with camera equipment, crammed into the tiny space. He had been there for two weeks, having meals sent up. He did not have much with him: some clothes, a book, four computers, that Rubik's Cube. He was becoming worried about the costs and especially the chance that his credit cards would be blocked. Even though he was well-versed in surveillance techniques, he would not have been hard to find – having signed in under his own name, using his own credit cards. The interviews, combined with the leaked documents, provided the Guardian with four scoops in quick succession, from the court order showing that the US government had forced the telecoms giant Verizon to hand over the phone records of millions of Americans, to the previously undisclosed programme, Prism. The Prism story was also published independently by the Washington Post after Poitras, a freelance journalist, had earlier approached the investigative reporter Barton Gellman, who took the story to the paper. Once on the ground working in Hong Kong, Poitras began worked with the Guardian team. On Sunday, the story shifted from the leaks to the leaker. Snowden had from the start decided against anonymity and Poitras filmed him being interviewed by Greenwald for a video that would announce his outing. Snowden's decision to go public has mystified many. Why come out? He had, he said, seen at first hand the impact on colleagues of leak inquiries involving anonymous sources and he did not want to put his colleagues through another ordeal."
   "The government's campaign to kickstart a shale gas revolution in Britain received a major boost on Thursday when Centrica joined in by promising to spend up to £160m on a key licence near Blackpool. The UK's biggest domestic energy supplier and parent of British Gas has paid what some in the City believed a \"surprisingly high\" price for its 25% stake in the Bowland basin held by smaller pioneers Cuadrilla Resources and AJ Lucas. It means Sam Laidlaw, the Centrica boss, and Lord Browne, a Cuadrilla director, two of the UK's most prominent businessmen and both with close links to ministers, are now spearheading a fracking industry that still faces significant hurdles in proving the extent of genuine reserves and reassuring the public over safety. Michael Fallon, the energy minister working with the Treasury on a new tax regime for fracking, said Centrica's expertise in the energy sector as an operator and developer was a big step forward for shale in Britain. \"Their investment is a vote of confidence in the significant efforts this government has made to create the right environment to accelerate the development of shale in a responsible way,\" he said. Centrica, which as recently as January played down hopes that Britain could replicate the dramatic reduction in gas prices seen over the past two years in America through shale, said it made sense to get involved now. \"With North Sea gas reserves declining and the UK becoming more dependent on imported gas, it is important that we look for opportunities to develop domestic gas resources, to provide affordable sources of gas to our customers, and to deliver broader economic benefits to the UK,\" said Mark Hanafin, managing director of Centrica's international exploration and production business. But equity analysts expressed surprise that Centrica had been willing to pay what amounted to $3,000 an acre at Bowland, compared with $5,000 for proven shale areas in the US. \"The involvement of Centrica is enough to raise the profile of the UK shale gas sector. But it is a surprisingly high price considering no shale gas is flowing yet in this country and only a few wells drilled. Either they know something we don't, or they are taking a major punt,\" said one top energy analyst who asked not to be named. Meanwhile, environmentalists warned that Centrica was taking \"a really big risk\" by throwing itself into a controversial fossil fuel sector that they believe will only make climate change worse. Jenny Banks, climate and energy specialist at WWF-UK, said: \"Centrica has already singled itself out as a target for Greenpeace and others for not taking climate change seriously in the investments it makes. But this also has economic risks around getting gas out of the ground and environmental risks around accidents.\" The Bowland licence is operated by Cuadrilla, with three exploration wells drilled to date. Centrica said data obtained from the drilling process had confirmed the presence of natural gas. The gas company added that initial work suggested there could be 200tn cubic feet of gas in place relating to the Bowland shale licence, although it warned: \"Further drilling will be required to establish whether the discovery is commercial.\" A report, Britain's Shale Gas Potential, published last month by the Institute of Directors, estimated that locally produced shale could reduce the proportion of gas the UK has to import in 2030 from 76% to 37%. UK-wide investment could reach £3.7bn a year, supporting 74,000 jobs across the industry and its supply chain, the report said. The discovery in the US of huge amounts of shale as a result of using new techniques such as horizontal drilling and \"fracking\" the rock using chemicals has led to a huge new shale industry that sent prices of natural gas plummeting from above $10 per million British thermal units to below $3 and turned the country from a gas importer to a potential exporter. Shale is also helping to revitalise a previously troubled manufacturing sector in the US by allowing cheap energy to drastically reduce the cost per unit of US factories, supporters claim. But Centrica insisted in January that shale gas was not \"the game-changer we've seen in North America\" and played down speculation that it might start drilling. Some have speculated that the change of heart is associated with Centrica fearing it could \"miss the boat\" if shale took off in this country but others question whether the company is deliberately currying favour with government. Last week IGas, a competitor of Cuadrilla, which had previously said it was sitting on 9tn cubic feet of shale gas reserves, said new estimates suggested the volume of \"gas initially in place\" could range from 15.1tn cubic feet to 172.3tn cubic feet. IGas is also talking to larger outside investors about selling a stake. The names of Shell, BG and Statoil have all been trailed by analysts as potential new shale entrants."])

(def bowie-lyrics
  ["It's a god-awful small affair To the girl with the mousy hair But her mummy is yelling \"No\" And her daddy has told her to go But her friend is nowhere to be seen Now she walks through her sunken dream To the seat with the clearest view And she's hooked to the silver screen  But the film is a saddening bore For she's lived it ten times or more She could spit in the eyes of fools As they ask her to focus on  Sailors fighting in the dance hall Oh man! look at those cavemen go It's the freakiest show  Take a look at the lawman Beating up the wrong guy Oh man! Wonder if he'll ever know He's in the best selling show Is there life on Mars?  It's on Amerika's tortured brow That Mickey Mouse has grown up a cow Now the workers have struck for fame 'Cause Lennon's on sale again  See the mice in their million hordes From Ibeza to the norfolk broads Rule Britannia is out of bounds To my mother, my dog, and clowns  But the film is a saddening bore 'Cause I wrote it ten times or more It's about to be writ again As I ask you to focus on  Sailors fighting in the dance hall Oh man! Look at those cavemen go It's the freakiest show  Take a look at the Lawman Beating up the wrong guy Oh man! Wonder if he'll ever know He's in the best selling show Is there life on Mars?"
"Didn't know what time it was and the lights were low I leaned back on my radio Some cat was layin' down some rock 'n' roll 'lotta soul,  he said  Then the loud sound did seem to fade Came back like a slow voice on a wave of phase That weren't no D.J. that was hazy cosmic jive  There's a starman waiting in the sky He'd like to come and meet us But he thinks he'd blow our minds There's a starman waiting in the sky He's told us not to blow it Cause he knows it's all worthwhile He told me: Let the children lose it Let the children use it Let all the children boogie  I had to phone someone so I picked on you Hey, that's far out so you heard him too! Switch on the TV  we may pick him up on channel two Look out your window I can see his light  If we can sparkle he may land tonight Don't tell your poppa or he'll get us locked up in fright   There's a starman waiting in the sky He'd like to come and meet us But he thinks he'd blow our minds There's a starman waiting in the sky He's told us not to blow it Cause he knows it's all worthwhile He told me: Let the children lose it Let the children use it Let all the children boogie  There's a starman waiting in the sky He'd like to come and meet us But he thinks he'd blow our minds There's a starman waiting in the sky He's told us not to blow it Cause he knows it's all worthwhile He told me: Let the children lose it Let the children use it Let all the children boogie"
"Pushing thru the market square, so many mothers sighing News had just come over, we had five years left to cry in News guy wept and told us, earth was really dying Cried so much his face was wet, then I knew he was not lying I heard telephones, opera house, favourite melodies I saw boys, toys electric irons and T.V.'s My brain hurt like a warehouse, it had no room to spare I had to cram so many things to store everything in there And all the fat-skinny people, and all the tall-short people And all the nobody people, and all the somebody people I never thought I'd need so many people  A girl my age went off her head, hit some tiny children If the black hadn't a-pulled her off, I think she would have killed them A soldier with a broken arm, fixed his stare to the wheels of a Cadillac A cop knelt and kissed the feet of a priest, and a queer threw up at the sight of that  I think I saw you in an ice-cream parlour, drinking milk shakes cold and long Smiling and waving and looking so fine, don't think  you knew you were in this song And it was cold and it rained so I felt like an actor And I thought of Ma and I wanted to get back there Your face, your race, the way that you talk I kiss you, you're beautiful, I want you to walk  We've got five years, stuck on my eyes Five years, what a surprise We've got five years, my brain hurts a lot Five years, that's all we've got We've got five years, what a surprise Five years, stuck on my eyes We've got five years, my brain hurts a lot Five years, that's all we've got We've got five years, stuck on my eyes Five years, what a surprise We've got five years, my brain hurts a lot Five years, that's all we've got We've got five years, what a surprise We've got five years, stuck on my eyes We've got five years, my brain hurts a lot Five years, that's all we've got Five years Five years Five years Five years"
"I was walking down the High Street When I heard footsteps behind me
And there was a little old man (Hello) In scarlet and grey, shuffling
away (laughter) Well he trotted back to my house And he sat beside the
telly (Oaah..) With his tiny hands on his tummy Chuckling away,
laughing all day (laughter) Oh, I ought to report you to the Gnome
office (Gnome Office) Yes (Hahahahaha) Ha ha ha, hee hee hee \"I'm a
laughing Gnome and you can't catch me\" Ha ha ha, hee hee hee \"I'm a
laughing Gnome and you can't catch me\" Said the laughing Gnome Well I
gave him roasted toadstools and a glass of dandelion wine (Burp,
pardon) Then I put him on a train to Eastbourne Carried his bag and
gave him a fag (Haven't you got a light boy?) \"Here, where do you
come from?\" (Gnome-man's land, hahihihi) \"Oh, really?\" In the
morning when I woke up He was sitting on the edge of my bed With his
brother whose name was Fred He'd bought him along to sing me a song
Right, let's hear it Here, what's that clicking noise? (That's Fred,
he's a \"metrognome\", haha) Ha ha ha, hee hee hee \"I'm a laughing
Gnome and you don't catch me\" Ha ha ha, hee hee hee \"I'm a laughing
Gnome and you can't catch me\" (Own up, I'm a gnome, ain't I right,
haha) \"Haven't you got a gnome to go to?\" (No, we're gnomads)
\"Didn't they teach you to get your hair cut at school? you look like
a rolling gnome.\" (No, not at the London School of Ecognomics) Now
they're staying up the chimney And we're living on caviar and
honey (hooray!) Cause they're earning me lots of money Writing comedy
prose for radio shows It's the-er (what?) It's the Gnome service of
course Ha ha ha, hee hee hee \"I'm a laughing Gnome and you don't
catch me\" Ha ha ha, oh, dear me (Ha ha ha, hee hee hee \"I'm a
laughing Gnome and you can't catch me\" Ha ha ha, hee hee hee \"I'm a
laughing Gnome and you can't catch me\")"])

(defn documents [raw-documents]
  (map-indexed (fn [idx s]
                 [(str "document:" idx) s])
               (map (comp (fn [s]
                            (str/replace s #"[^a-z\s]" ""))
                          str/lower-case)
                    raw-documents)))
