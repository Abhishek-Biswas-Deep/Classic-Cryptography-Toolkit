<img src="https://github.com/user-attachments/assets/2ad86f70-12b4-4500-997d-9f8c1874a9b5" alt="Dal logo" width="80"/>
<h1>Associated with Dalhousie University</h1>

### CSCI4174
### Classic Cryptography Toolkit

This repository contains Java implementations of two classic ciphers: the Matrix Transposition Cipher and the Playfair Substitution Cipher. It also includes a text file for testing purposes.

#### Files in this Repository

1. MatrixTranspositionCipher.java: Implementation of the Matrix Transposition Cipher
2. PlayfairSubstitutionCipher.java: Implementation of the Playfair Substitution Cipher
3. textfile.txt: Sample text file for testing the ciphers

#### MatrixTranspositionCipher.java
This file implements the Matrix Transposition Cipher, which rearranges the characters in the plaintext according to a numeric key.

##### Features:
- Encryption of plaintext messages
- Decryption of ciphertext messages
- Handling of spaces by replacing them with '%'
- Reading input from a file

##### Usage:
The program will read from textfile.txt, encrypt a hardcoded plaintext, and then decrypt it.

#### PlayfairSubstitutionCipher.java
This file implements the Playfair Substitution Cipher, which uses a 5x5 grid of letters for substitution.

##### Features:

- Generation of the key matrix from a secret key
- Encryption of plaintext messages
- Decryption of ciphertext messages
- Reading input from a file

##### Usage:
The program will prompt for a secret key, read from textfile.txt, encrypt a hardcoded plaintext, and then decrypt it.

#### textfile.txt
This file contains sample text for testing the ciphers. It includes:
- A short message: "COME QUICKLY WE NEED HELP"
- A message with '%' instead of spaces: "meet%at%military%house"
- A longer paragraph about a Pokemon game

#### Notes
- Both cipher implementations are for educational purposes and may not be cryptographically secure for real-world applications.
- The file paths in the Java programs are hardcoded and may need to be adjusted to match the local file system.
- The Playfair cipher implementation replaces 'J' with 'I' in the key matrix, which is a common practice for this cipher.

#### Sample input and output
```
Sample inputs

COME QUICKLY WE NEED HELP

meet%at%military%house

POKEMON TOWER DEFENSE YOUR MISSION IN THIS FUN STRATEGY TOWER DEFENSE GAME IS TO HELP PROFESSOR OAK TO STOP ATTACKS OF WILD RATTATA. SET OUT ON YOUR OWN POKEMON JOURNEY, TO CATCH AND TRAIN ALL POKEMON AND TRY TO SOLVE THE MYSTERY BEHIND THESE ATTACKS. YOU MUST PLACE POKEMON CHARACTERS STRATEGICALLY ON THE BATTLEFIELD SO THAT THEY STOP ALL WAVES OF ENEMY ATTACKER DURING THE BATTLE YOU WILL LEVEL UP AND EVOLVE YOUR POKEMON. YOU CAN ALSO CAPTURE OTHER POKEMON DURING THE BATTLE AND ADD THEM TO YOUR TEAM. USE YOUR MOUSE TO PLAY THE GAME. GOOD LUCK


Sample outputs

Plaintext: POKEMON TOWER DEFENSE YOUR MISSION IN THIS FUN STRATEGY TOWER DEFENSE GAME IS TO HELP PROFESSOR OAK TO STOP ATTACKS OF WILD RATTATA. SET OUT ON YOUR OWN POKEMON JOURNEY, TO CATCH AND TRAIN ALL POKEMON AND TRY TO SOLVE THE MYSTERY BEHIND THESE ATTACKS. YOU MUST PLACE POKEMON CHARACTERS STRATEGICALLY ON THE BATTLEFIELD SO THAT THEY STOP ALL WAVES OF ENEMY ATTACKER DURING THE BATTLE YOU WILL LEVEL UP AND EVOLVE YOUR POKEMON. YOU CAN ALSO CAPTURE OTHER POKEMON DURING THE BATTLE AND ADD THEM TO YOUR TEAM. USE YOUR MOUSE TO PLAY THE GAME. GOOD LUCK
Ciphertext: LPPKNPLQWMXDYYEAKALVAZUMZYYLFWWFPOUFLQVGFWALQOARSYBSBKQYWMXDYYEAKALVAZFBPBUFRAWMQFAPLZLZLIAXWLYYLDFZWMARWMLZBSSBEHRALIUSFOAUAFVVBSFAARBXULYWULLQUMZYULVOZLPIBPPOYYWDQLBZYYWMQABSHNAFOCYSAFHOAFMMZLPIBPPOAFOCYSYQYSLUWLNSAZVGAZTBTVAZQYCAIKOCYSKCXAAFVVBDFXYYUMZYOYTVZLSFDAZLPIBPPOQAFCAFBVAZRATVAFXBHKDBMMQYPOYSKCYABSSMAKKDOAARLUVGBSYSKCQYTVPLAFMMUSCSAXULLACPBPQYBSSBEHAZUAZYHOFYVGAZCBVVPAYQWDUSFOSAPAXCSAZOAFOCZAWNNSAZUMZYZLPIBPPOYYUMZYDBLQFSWLQAELWYZAULVGAZZLPIBPPOUAZYHOFYVGAZCBVVPAAFOCAFEEYSKCLYWMYQWDYYXBBLYYRWAZUMZYYLWDXAYSLULMBRYSKCYFBLAZYFPPAUOREH
Decrypted Text: POKEMONRTOWERRDEFENSERYOURRMISSIONRINRTHISRFUNRSTRATEGYRTOWERRDEFENSERGAMERISRTORHELPRPROFESSORROAKRTORSTOPRATTACKSROFRWILDRRATTATARRSETROUTRONRYOURROWNRPOKEMONRROURNEYRRTORCATCHRANDRTRAINRALLRPOKEMONRANDRTRYRTORSOLVERTHERMYSTERYRBEHINDRTHESERATTACKSRRYOURMUSTRPLACERPOKEMONRCHARACTERSRSTRATEGICALLYRONRTHERBATTLEFIELDRSORTHATRTHEYRSTOPRALLRWAVESROFRENEMYRATTACKERRDURINGRTHERBATTLERYOURWILLRLEVELRUPRANDREVOLVERYOURRPOKEMONRRYOURCANRALSORCAPTUREROTHERRPOKEMONRDURINGRTHERBATTLERANDRADDRTHEMRTORYOURRTEAMRRUSERYOURRMOUSERTORPLAYRTHERGAMERRGOODRLUCK

Process finished with exit code 0

Plaintext: POKEMON TOWER DEFENSE YOUR MISSION IN THIS FUN STRATEGY TOWER DEFENSE GAME IS TO HELP PROFESSOR OAK TO STOP ATTACKS OF WILD RATTATA. SET OUT ON YOUR OWN POKEMON JOURNEY, TO CATCH AND TRAIN ALL POKEMON AND TRY TO SOLVE THE MYSTERY BEHIND THESE ATTACKS. YOU MUST PLACE POKEMON CHARACTERS STRATEGICALLY ON THE BATTLEFIELD SO THAT THEY STOP ALL WAVES OF ENEMY ATTACKER DURING THE BATTLE YOU WILL LEVEL UP AND EVOLVE YOUR POKEMON. YOU CAN ALSO CAPTURE OTHER POKEMON DURING THE BATTLE AND ADD THEM TO YOUR TEAM. USE YOUR MOUSE TO PLAY THE GAME. GOOD LUCK
Ciphertext: POKEMON%TOWER%DEFENSE%YOUR%MISSION%IN%THIS%FUN%STRATEGY%TOWER%DEFENSE%GAME%IS%TO%HELP%PROFESSOR%OAK%TO%STOP%ATTACKS%OF%WILD%RATTATA.%SET%OUT%ON%YOUR%OWN%POKEMON%JOURNEY,%TO%CATCH%AND%TRAIN%ALL%POKEMON%AND%TRY%TO%SOLVE%THE%MYSTERY%BEHIND%THESE%ATTACKS.%YOU%MUST%PLACE%POKEMON%CHARACTERS%STRATEGICALLY%ON%THE%BATTLEFIELD%SO%THAT%THEY%STOP%ALL%WAVES%OF%ENEMY%ATTACKER%DURING%THE%BATTLE%YOU%WILL%LEVEL%UP%AND%EVOLVE%YOUR%POKEMON.%YOU%CAN%ALSO%CAPTURE%OTHER%POKEMON%DURING%THE%BATTLE%AND%ADD%THEM%TO%YOUR%TEAM.%USE%YOUR%MOUSE%TO%PLAY%THE%GAME.%GOOD%LUCK
Decrypted: O P UCOYTHKO AEUORMRNAO  CNPYT OOETKUROERSWM  EOOSRNWT .NRD  AEYPTFOOEEUKGN EISCMCEAOA NNLY  LOAJYULO RSUO ORNM N ICETSAYHSP,EIT  OUTBNROA E TI CTNOAL TTETHCFHEHIIR ES AL PNDFOD UK SNETO MR SOATTNIHR NAAD TTUA ERLTGILHYN E GPYT O OTKSWHETEEMOR OP BN DA AETALFTNLELD NE WS TAEARV NYEGD SA T MAOOED F DS I OESTLN HVETEEMOM Y  T HTHAEOETL  TPYMA OYCPUSKRRTEO ERFTR EEYDSA USMBRO.EIR HN UIGOSN AEDTK  H YTETOH OUEB RSAS ETTM TOOALPUTE ST AEAYT COTTKUAOS C .WKP ISLYL AOLOYU F  L TMEWHUVIESEL TLDG   APURMLPAEA T.CAT ENAG DTOP AOOE.DKV  EOSLMLEUOVTCNE K

Process finished with exit code 0
```

