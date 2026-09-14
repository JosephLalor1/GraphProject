/*  ============================================================
     Project Name: Graph Application - Project CA3
     File Name: GraphProject.java
     Description: This project creates a graph of touristic sites in Carlow,
     stores them in arrays, and allows the user to navigate through with various methods.
     Authors: Joseph Lalor c00312883 Ismael Charaf Megrini c00313241
     Created: 01/12/2025
     Completed: 08/12/2025
     ============================================================ */

public class GraphProject 
    {
        //helper variable
        static final int count = 7;

        //name of sites array
        static String[] siteName = {"Courthouse", "Liberty Fountain", "SETU Campus", "Browneshill Dolmen",
        "Carlow Castle", "Graigecullen Pool", "Railway Station"};

        //x coordinates array
        static int[] xCoord = {0, 1, 4, 6, 3, 3, 7};

        //y coordinates array
        static int[] yCoord = {0, 2, 2, 7, 5, 6, 3};

        //adjacency matrix for distances
        static int[][] sites = {
            {0, 1, 3, 4, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 5},
            {3, 0, 0, 0, 3, 0, 0},
            {4, 0, 0, 0, 2, 3, 4},
            {0, 0, 3, 2, 0, 2, 0},
            {0, 0, 0, 3, 2, 0, 0},
            {0, 5, 0, 4, 0, 0, 0}
        };

        //search function, takes a site name and outputs its coordinates
        public static String Search(String site)
            {
                String result = "";
                for (int i = 0; i < count; i++)
                    {
                        if(site.equals(siteName[i]))
                            {
                                result = siteName[i] + "\nX coordinate: " + xCoord[i] + "\nY coordinate: " + yCoord[i];
                            }
                    }
                return result;
            }
        
        //inserts a new connection between two specified sites
        public static void Insert(String site1, String site2, int weight)
            {
                int i = 0;
                while ((i < count) && !site1.equals(siteName[i]))
                    {
                        i++;
                    }

                int j = 0;
                while ((j < count) && !site2.equals(siteName[j]))
                    {
                        j++;
                    }

                sites[i][j] = weight;
                sites[j][i] = weight;
                System.out.println("New edge inserted between " + siteName[i] + " and " + siteName[j] + " with weight " + weight);
            }
        
        //outputs names of all connected sites to a specified site    
        public static String AllCons(String site)
            {
                String connections = "";
                int i = 0;
                while ((i < count) && !site.equals(siteName[i]))
                    {
                        i++;
                    }
                
                for (int j = 0; j < count; j++)
                        {
                            if(sites[i][j] > 0)
                                {
                                    connections = connections + "\n" + siteName[j];
                                }
                        }
                return "Sites connected to " + site + " are:" + connections;
            }
        
        //finds closest connected site to a specified site
        public static String Closest(String site) 
            {
                String closest = "";
                int closestVal = 1000;
                int i = 0;
                while ((i < count) && !site.equals(siteName[i]))
                    {
                        i++;
                    }

                for (int j = 0; j < count; j++)
                        {
                            if(sites[i][j] < closestVal && sites[i][j] > 0)
                                {
                                    closestVal = sites[i][j];
                                    closest = siteName[j];
                                }
                        }

                return "The closest site to " + site + " is " + closest;
            }
        public static void main(String[] args) 
            {
                System.out.println(Search("Railway Station"));
                System.out.println(Closest("Graigecullen Pool"));
                Insert("Railway Station", "Graigecullen Pool", 1);
                System.out.println(Closest("Graigecullen Pool"));
                System.out.println(AllCons("Browneshill Dolmen"));
            }
        
    }
