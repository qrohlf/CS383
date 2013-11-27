package a7;
import static org.junit.Assert.*;
import org.junit.Test;
import static edu.princeton.cs.introcs.StdRandom.*;
import a7.GridPath;

public class A7Test {

	public static final boolean D = GridPath.DOWN;

	public static final boolean R = GridPath.RIGHT;
	
	@Test
	public void testGridPathEasy() {
		boolean[] correct = { R, D };
		GridPath solver = new GridPath(new int[][] {
			{ 1, 2 },
			{ 3, 4 }});
		for (int i = 0; i < correct.length; i++) {
			assertEquals(correct[i], solver.path(i));
		}
	}

	@Test
	public void testGridPathMedium() {
		boolean[] correct = { R, R, D, D };
		GridPath solver = new GridPath(new int[][] {
			{ 0, 4, 1 },
			{ 3, 8, 1 },
			{ 5, 1, 1 }});
		for (int i = 0; i < correct.length; i++) {
			assertEquals(correct[i], solver.path(i));
		}
	}
	
	@Test
	public void testGridPathHard() {
		boolean[] correct = {D, R, R, R, D, D, R, D, R, R, D, D, R, R, D, D, R, D, R, R, R, D, D, R, R, R, R, D, D, R, R, D, R, R, D, R, R, R, D, D, D, D, R, R, D, D, R, R, R, R, D, R, R, R, R, R, D, D, D, R, R, D, R, D, D, R, R, R, D, R, D, R, R, R, D, R, R, D, D, D, D, D, D, D, D, D, R, R, D, D, D, D, D, D, D, D, D, R};
		GridPath solver = new GridPath(new int[][] {
				{ 76, 725, 411, 609, 535, 262, 502, 222, 864, 490, 743, 224, 405, 455, 25, 652, 784, 198, 11, 832, 747, 962, 621, 874, 583, 199, 798, 498, 390, 820, 792, 765, 705, 38, 141, 712, 819, 827, 835, 981, 844, 392, 466, 869, 137, 7, 711, 154, 729, 313 },
				{ 489, 415, 411, 204, 752, 935, 787, 993, 741, 983, 51, 396, 909, 945, 742, 585, 39, 102, 600, 896, 605, 607, 441, 972, 895, 687, 608, 973, 762, 905, 420, 40, 984, 961, 510, 152, 673, 226, 770, 996, 424, 860, 580, 21, 640, 543, 960, 377, 685, 992 },
				{ 266, 569, 319, 799, 555, 923, 704, 67, 309, 725, 967, 922, 790, 831, 245, 569, 392, 83, 893, 517, 769, 556, 385, 931, 198, 480, 39, 522, 370, 652, 218, 987, 812, 675, 405, 218, 615, 89, 258, 900, 900, 354, 793, 660, 202, 130, 452, 60, 261, 553 },
				{ 903, 780, 851, 301, 69, 714, 907, 492, 853, 711, 505, 884, 739, 586, 788, 969, 587, 291, 321, 587, 977, 86, 952, 392, 884, 905, 668, 693, 953, 60, 793, 725, 427, 596, 669, 923, 680, 876, 760, 426, 862, 306, 784, 991, 76, 321, 981, 871, 238, 279 },
				{ 636, 642, 545, 357, 79, 700, 60, 926, 585, 780, 351, 750, 424, 555, 109, 25, 907, 986, 421, 950, 306, 584, 647, 582, 796, 199, 1, 612, 691, 322, 729, 290, 261, 949, 469, 805, 508, 529, 942, 31, 773, 267, 235, 647, 470, 135, 562, 175, 119, 174 },
				{ 257, 194, 395, 849, 635, 992, 833, 921, 574, 887, 522, 5, 57, 495, 999, 439, 370, 602, 987, 980, 5, 423, 91, 221, 721, 450, 455, 190, 909, 753, 144, 43, 464, 805, 641, 410, 806, 355, 282, 129, 694, 198, 575, 693, 96, 835, 199, 52, 84, 89 },
				{ 136, 631, 150, 419, 824, 808, 229, 3, 159, 604, 450, 908, 376, 268, 814, 980, 526, 286, 341, 492, 163, 899, 262, 158, 452, 181, 796, 386, 440, 39, 143, 685, 239, 289, 587, 70, 231, 654, 427, 838, 858, 580, 654, 460, 324, 863, 679, 434, 464, 978 },
				{ 258, 303, 337, 459, 306, 426, 374, 474, 352, 272, 55, 262, 551, 114, 260, 828, 170, 446, 461, 492, 110, 535, 948, 890, 324, 12, 439, 366, 526, 371, 265, 793, 779, 288, 152, 477, 718, 814, 641, 559, 9, 720, 79, 75, 567, 284, 523, 156, 166, 204 },
				{ 333, 319, 491, 555, 929, 514, 616, 345, 165, 7, 745, 907, 95, 663, 676, 866, 651, 541, 310, 886, 73, 544, 450, 830, 797, 339, 972, 887, 208, 461, 180, 295, 948, 417, 534, 236, 773, 793, 542, 318, 971, 708, 97, 238, 244, 569, 511, 674, 742, 302 },
				{ 477, 934, 986, 626, 575, 24, 420, 299, 170, 527, 455, 36, 167, 945, 998, 719, 939, 32, 949, 899, 603, 537, 541, 546, 565, 81, 446, 522, 410, 475, 463, 982, 72, 746, 89, 120, 388, 960, 249, 413, 460, 641, 340, 573, 411, 663, 662, 509, 933, 794 },
				{ 475, 411, 498, 411, 302, 757, 704, 38, 600, 383, 768, 698, 255, 311, 699, 343, 840, 30, 750, 842, 376, 302, 224, 999, 404, 202, 428, 940, 96, 223, 602, 942, 340, 749, 263, 211, 523, 249, 205, 891, 981, 235, 30, 475, 941, 710, 810, 375, 748, 921 },
				{ 240, 324, 868, 570, 272, 119, 865, 658, 183, 669, 673, 648, 132, 208, 5, 582, 487, 99, 575, 610, 921, 331, 331, 666, 927, 122, 754, 256, 576, 272, 706, 733, 998, 368, 497, 572, 41, 140, 816, 654, 638, 502, 53, 110, 543, 37, 744, 513, 61, 752 },
				{ 991, 268, 32, 42, 69, 889, 79, 362, 189, 895, 914, 397, 444, 252, 972, 602, 188, 362, 559, 314, 677, 916, 920, 387, 303, 460, 929, 375, 10, 674, 845, 725, 166, 906, 86, 804, 574, 707, 242, 935, 327, 256, 468, 178, 791, 69, 327, 280, 825, 391 },
				{ 885, 614, 517, 775, 214, 527, 611, 293, 988, 68, 352, 486, 923, 640, 209, 978, 126, 69, 412, 860, 732, 527, 151, 719, 82, 731, 696, 993, 538, 724, 667, 222, 625, 58, 874, 948, 710, 686, 638, 847, 374, 935, 924, 504, 588, 226, 307, 118, 453, 322 },
				{ 970, 329, 146, 796, 983, 375, 840, 45, 585, 318, 129, 498, 183, 821, 37, 644, 969, 887, 259, 862, 460, 244, 568, 564, 804, 13, 339, 786, 257, 660, 303, 614, 580, 14, 495, 139, 499, 182, 521, 475, 72, 616, 41, 895, 544, 86, 502, 750, 951, 122 },
				{ 201, 241, 208, 721, 929, 327, 370, 944, 428, 154, 87, 46, 32, 772, 462, 966, 456, 367, 696, 831, 218, 208, 175, 649, 805, 551, 315, 670, 767, 206, 638, 371, 973, 996, 655, 834, 428, 868, 940, 838, 68, 191, 432, 105, 52, 250, 556, 109, 568, 949 },
				{ 898, 109, 959, 170, 484, 480, 945, 142, 379, 690, 142, 719, 492, 390, 577, 842, 324, 363, 980, 112, 372, 722, 885, 316, 248, 761, 974, 532, 306, 400, 547, 577, 836, 742, 308, 892, 354, 510, 129, 95, 653, 716, 693, 430, 483, 589, 380, 952, 772, 200 },
				{ 646, 742, 688, 960, 229, 270, 796, 363, 619, 292, 852, 178, 69, 294, 826, 716, 860, 754, 932, 137, 306, 679, 628, 17, 817, 717, 249, 239, 631, 874, 578, 509, 710, 553, 235, 797, 832, 625, 552, 688, 119, 951, 526, 367, 738, 193, 793, 333, 420, 265 },
				{ 520, 397, 887, 514, 165, 76, 278, 426, 440, 349, 208, 451, 563, 646, 872, 575, 584, 572, 728, 224, 223, 687, 534, 146, 884, 52, 991, 838, 21, 147, 16, 763, 217, 860, 916, 867, 651, 715, 672, 567, 302, 981, 322, 512, 66, 702, 839, 763, 741, 337 },
				{ 75, 208, 918, 131, 971, 888, 858, 420, 239, 848, 825, 339, 116, 630, 794, 773, 878, 911, 467, 377, 898, 162, 445, 587, 201, 389, 636, 331, 512, 818, 429, 793, 868, 485, 360, 56, 868, 237, 148, 620, 191, 396, 770, 865, 700, 397, 265, 249, 656, 761 },
				{ 872, 482, 57, 430, 315, 826, 913, 373, 357, 207, 975, 166, 44, 679, 376, 82, 201, 65, 67, 13, 326, 871, 409, 438, 803, 441, 459, 180, 561, 606, 22, 886, 439, 593, 873, 359, 739, 310, 175, 357, 472, 112, 192, 421, 685, 24, 10, 780, 439, 180 },
				{ 173, 836, 829, 825, 107, 97, 824, 311, 558, 551, 22, 104, 516, 298, 612, 243, 318, 274, 520, 692, 766, 537, 889, 776, 934, 57, 390, 15, 614, 143, 811, 843, 125, 278, 363, 311, 529, 378, 639, 846, 889, 898, 348, 522, 135, 705, 458, 277, 467, 593 },
				{ 712, 807, 395, 60, 389, 996, 231, 976, 962, 913, 600, 534, 180, 11, 977, 568, 205, 157, 101, 85, 578, 228, 760, 58, 894, 448, 426, 206, 661, 313, 134, 18, 150, 163, 0, 963, 768, 32, 805, 301, 597, 641, 277, 662, 363, 920, 539, 645, 263, 381 },
				{ 589, 125, 565, 603, 486, 841, 194, 807, 617, 542, 538, 748, 689, 423, 446, 61, 211, 361, 685, 456, 517, 397, 347, 475, 8, 219, 367, 175, 248, 65, 678, 709, 476, 911, 149, 89, 305, 893, 467, 282, 745, 532, 701, 858, 888, 478, 948, 776, 944, 748 },
				{ 985, 584, 146, 714, 192, 356, 45, 752, 418, 274, 347, 720, 780, 633, 182, 606, 973, 896, 779, 625, 61, 93, 700, 181, 97, 679, 1, 267, 267, 489, 209, 62, 423, 764, 50, 633, 896, 943, 784, 578, 984, 589, 658, 238, 350, 908, 456, 304, 978, 541 },
				{ 344, 593, 476, 373, 265, 565, 51, 527, 598, 984, 369, 35, 548, 123, 739, 63, 935, 175, 415, 649, 862, 685, 70, 6, 367, 15, 345, 306, 469, 214, 871, 237, 942, 362, 20, 837, 313, 383, 918, 814, 525, 642, 873, 883, 132, 232, 155, 831, 214, 367 },
				{ 849, 413, 970, 100, 264, 896, 871, 464, 583, 744, 329, 87, 145, 770, 79, 934, 401, 242, 586, 945, 799, 39, 288, 846, 271, 44, 197, 665, 432, 471, 883, 653, 186, 863, 400, 884, 49, 703, 822, 707, 542, 369, 241, 821, 956, 401, 857, 786, 544, 471 },
				{ 390, 516, 329, 136, 107, 926, 711, 914, 740, 818, 369, 258, 977, 309, 998, 108, 773, 768, 589, 382, 688, 678, 400, 266, 839, 829, 843, 413, 438, 523, 155, 129, 940, 759, 897, 635, 796, 152, 693, 938, 244, 934, 623, 93, 206, 83, 281, 559, 140, 774 },
				{ 889, 987, 56, 772, 619, 877, 417, 187, 131, 924, 2, 20, 55, 115, 733, 284, 810, 598, 293, 183, 629, 255, 913, 794, 553, 461, 692, 716, 80, 557, 161, 63, 129, 48, 859, 793, 809, 401, 379, 234, 407, 697, 907, 305, 256, 985, 335, 423, 649, 899 },
				{ 91, 416, 315, 286, 751, 209, 33, 268, 120, 514, 477, 561, 120, 538, 912, 218, 341, 921, 560, 784, 583, 151, 219, 568, 43, 110, 210, 200, 437, 942, 290, 279, 794, 277, 675, 665, 91, 184, 763, 543, 525, 219, 909, 439, 310, 481, 211, 5, 2, 561 },
				{ 851, 510, 979, 557, 724, 876, 335, 680, 754, 843, 611, 11, 335, 326, 790, 187, 362, 455, 856, 899, 732, 826, 489, 218, 548, 436, 550, 553, 757, 821, 414, 507, 589, 175, 954, 921, 198, 450, 675, 729, 922, 358, 462, 258, 167, 588, 706, 583, 626, 178 },
				{ 442, 454, 807, 193, 678, 811, 303, 180, 724, 414, 778, 662, 236, 813, 332, 200, 441, 639, 388, 951, 291, 831, 407, 518, 57, 249, 284, 677, 51, 124, 992, 486, 278, 804, 377, 735, 441, 10, 240, 721, 621, 859, 944, 804, 401, 42, 67, 501, 795, 34 },
				{ 435, 229, 554, 837, 998, 463, 408, 34, 842, 429, 917, 686, 664, 711, 239, 458, 638, 82, 398, 148, 36, 265, 507, 549, 648, 299, 681, 206, 645, 184, 204, 32, 278, 529, 685, 23, 193, 451, 639, 729, 206, 368, 164, 593, 327, 930, 209, 291, 761, 317 },
				{ 841, 427, 88, 576, 293, 823, 641, 967, 592, 869, 112, 744, 504, 930, 154, 759, 672, 497, 157, 153, 147, 756, 916, 97, 556, 449, 327, 435, 793, 844, 767, 587, 965, 413, 294, 425, 956, 758, 677, 835, 865, 284, 791, 86, 243, 911, 243, 11, 959, 47 },
				{ 663, 642, 799, 29, 855, 294, 376, 451, 957, 901, 705, 145, 979, 761, 79, 981, 268, 480, 398, 846, 584, 189, 481, 157, 326, 120, 618, 569, 35, 97, 294, 421, 497, 644, 776, 888, 244, 569, 461, 297, 414, 260, 951, 829, 833, 772, 235, 447, 156, 66 },
				{ 654, 490, 7, 471, 396, 694, 313, 66, 768, 733, 745, 685, 880, 48, 977, 963, 152, 91, 182, 752, 303, 177, 556, 84, 343, 917, 511, 174, 429, 511, 892, 770, 136, 791, 429, 222, 422, 858, 996, 319, 666, 942, 23, 690, 266, 371, 569, 25, 773, 591 },
				{ 554, 165, 514, 462, 52, 970, 971, 941, 86, 820, 96, 81, 110, 628, 352, 777, 7, 983, 843, 77, 499, 747, 643, 561, 185, 734, 256, 146, 327, 565, 810, 227, 411, 437, 825, 532, 507, 322, 785, 192, 101, 858, 602, 858, 680, 157, 355, 164, 497, 692 },
				{ 142, 411, 234, 186, 639, 626, 340, 203, 782, 353, 726, 352, 76, 705, 734, 12, 930, 87, 787, 895, 188, 155, 885, 548, 541, 797, 420, 200, 76, 451, 934, 242, 636, 512, 733, 777, 258, 956, 668, 511, 447, 788, 553, 424, 557, 974, 486, 838, 431, 756 },
				{ 338, 389, 672, 818, 421, 646, 630, 741, 728, 34, 279, 362, 298, 173, 865, 289, 656, 388, 80, 540, 364, 180, 864, 959, 726, 713, 467, 126, 216, 943, 116, 893, 874, 209, 954, 112, 950, 68, 0, 880, 223, 990, 585, 271, 803, 280, 129, 528, 631, 878 },
				{ 782, 478, 385, 663, 421, 495, 392, 869, 50, 508, 615, 411, 287, 512, 529, 102, 605, 346, 775, 953, 601, 313, 765, 577, 205, 500, 754, 313, 711, 171, 510, 915, 679, 549, 982, 396, 954, 447, 906, 795, 420, 373, 496, 782, 738, 568, 82, 432, 485, 892 },
				{ 746, 419, 835, 261, 605, 174, 359, 725, 229, 339, 561, 725, 569, 224, 208, 46, 23, 231, 683, 978, 210, 948, 759, 492, 782, 499, 707, 209, 176, 628, 911, 737, 939, 876, 363, 862, 37, 521, 516, 664, 896, 385, 585, 906, 364, 272, 235, 285, 234, 700 },
				{ 811, 782, 315, 830, 718, 847, 46, 952, 99, 551, 273, 965, 734, 942, 199, 762, 845, 138, 232, 191, 70, 631, 422, 457, 347, 254, 235, 263, 366, 917, 272, 63, 743, 583, 193, 189, 53, 855, 580, 631, 985, 62, 512, 768, 806, 383, 690, 535, 84, 131 },
				{ 338, 91, 92, 615, 260, 285, 917, 30, 114, 458, 373, 627, 88, 188, 443, 15, 944, 340, 65, 755, 251, 757, 144, 603, 328, 0, 3, 383, 263, 72, 285, 47, 359, 361, 207, 403, 493, 994, 577, 676, 38, 92, 914, 978, 51, 918, 691, 59, 435, 31 },
				{ 965, 221, 191, 319, 507, 944, 799, 34, 930, 819, 58, 641, 132, 553, 882, 598, 852, 280, 62, 205, 453, 734, 553, 34, 387, 352, 720, 163, 18, 384, 744, 547, 589, 658, 142, 463, 847, 3, 792, 936, 942, 463, 456, 326, 557, 558, 113, 766, 16, 833 },
				{ 978, 696, 419, 855, 832, 983, 115, 87, 137, 469, 430, 537, 714, 523, 798, 213, 345, 122, 352, 679, 735, 105, 91, 38, 205, 907, 164, 800, 343, 548, 46, 868, 174, 864, 687, 267, 792, 224, 726, 83, 2, 546, 673, 218, 501, 947, 275, 515, 918, 284 },
				{ 449, 408, 840, 710, 94, 333, 604, 612, 44, 916, 856, 628, 955, 539, 678, 441, 791, 46, 803, 640, 1, 593, 976, 636, 128, 583, 109, 520, 312, 192, 825, 33, 872, 602, 407, 790, 569, 375, 682, 548, 67, 783, 608, 410, 618, 538, 13, 598, 125, 132 },
				{ 63, 507, 719, 117, 366, 304, 654, 332, 798, 549, 585, 56, 509, 756, 23, 522, 231, 498, 658, 90, 554, 433, 627, 572, 523, 723, 751, 910, 55, 725, 598, 618, 14, 550, 684, 267, 137, 890, 169, 533, 836, 559, 915, 14, 599, 659, 475, 442, 278, 656 },
				{ 93, 240, 185, 518, 688, 679, 750, 907, 614, 747, 745, 825, 134, 906, 317, 252, 933, 902, 413, 742, 547, 879, 124, 377, 481, 54, 154, 201, 176, 16, 215, 515, 868, 205, 386, 758, 696, 236, 107, 293, 788, 389, 87, 349, 281, 258, 873, 657, 284, 531 },
				{ 189, 288, 185, 381, 808, 288, 319, 366, 803, 81, 433, 759, 622, 112, 909, 878, 754, 478, 901, 215, 439, 605, 83, 391, 356, 951, 786, 613, 148, 666, 263, 37, 597, 644, 590, 35, 125, 71, 809, 768, 605, 208, 908, 195, 655, 490, 627, 855, 12, 739 },
				{ 788, 397, 342, 215, 234, 942, 948, 665, 518, 279, 748, 59, 474, 562, 434, 189, 944, 741, 583, 698, 204, 465, 101, 915, 787, 832, 975, 862, 939, 988, 829, 567, 745, 408, 556, 321, 306, 566, 28, 312, 537, 421, 860, 126, 287, 467, 776, 145, 433, 79 },
		});
		for (int i = 0; i < correct.length; i++) {
			assertEquals(correct[i], solver.path(i));
		}
	}
	
	@Test
	public void testArraySortEasy() {
		int[][] rows = {{8, 6, 7, 5, 3, 0, 9},
				{4, 8, 15, 16, 23, 42},
				{0, 1, 1, 2, 3, 5, 8, 13},
				{4, 8, 15, 16, 23},
				{8, 6, 2, 5, 3, 0, 9}};
		ArraySort.sort(rows);
		assertEquals("[[0, 1, 1, 2, 3, 5, 8, 13], [4, 8, 15, 16, 23], [4, 8, 15, 16, 23, 42], [8, 6, 2, 5, 3, 0, 9], [8, 6, 7, 5, 3, 0, 9]]", java.util.Arrays.deepToString(rows));
	}

	@Test
	public void testArraySortHard() {
		int[][] rows = new int[1000][1000];
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[i].length; j++) {
				rows[i][j] = uniform(100);
			}
		}
		ArraySort.sort(rows);
		for (int i = 0; i < rows.length - 1; i++) {
			int[] a = rows[i];
			int[] b = rows[i + 1];
			for (int j = 0; j < a.length; j++) {
				if (a[j] < b[j]) {
					break;
				}
				assertTrue(a[j] == b[j]);
			}
		}		
	}

	@Test
	public void testIndex() {
		Index index = new Index("tale.txt");
		assertEquals("3766 4872 4883 5359 9439 9456 9702 10896 12049 14484 ", index.get("building").toString());
		assertEquals("7112 10805 11387 12120 ", index.get("food").toString());
		assertNull(index.get("sex"));
	}

}