<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:element="localhost/labs/shema" version="2.0">
   <!-- Пункт №4 - указываем метода вывода - HTML -->
   <xsl:output method="html" encoding="UTF-8" version="5.2" indent="yes" />
   <xsl:template match="/">
      <html>
         <!--Пункт №1 - вызываем именованный шаблон -->
         <xsl:call-template name="head" />
         <body>
            <table class="result-table">
               <thead>
                  <tr>
                     <th>Номер</th>
                     <th>Идентификатор</th>
                     <th>Статус записи</th>
                     <th>Наименование</th>
                     <th>Статус в реестре</th>
                     <th>Дата создания</th>
                     <th>Коды ОКВЭД</th>
                     <th>Синхронизация с ФНС</th>
                  </tr>
               </thead>
               <tbody>
                  <!--Пункт №2 - использование цикла - for -->
                  <xsl:for-each select="element:businessEntityList/element:businessEntity">
                     <!--Пункт №3 - использование сортировки по убыванию и по полю status -->
                     <xsl:sort select="element:status" order="descending"/>
                     <tr>
                        <!--Пункт №3 - использование нумерации с помощью функции position() -->
                        <th><xsl:number value="position()" format="1"/></th>
                        <th><xsl:value-of select="element:id"/></th>
                        <th><xsl:value-of select="element:status"/></th>
                        <th><xsl:value-of select="element:businessEntityName"/></th>
                        <th><xsl:value-of select="element:businessEntityRegistryStatus"/></th>
                        <th><xsl:value-of select="element:createDate"/></th>
                        <th>
                           <xsl:for-each select="element:codeOkvedList/element:codeOkved">
                              <xsl:value-of select="element:code"/>;
                           </xsl:for-each>
                        </th>
                        <th>
                           <!--Пункт №2 - использование ветвления - choose -->
                           <xsl:choose>
                              <xsl:when test="element:status = 230">
                                 Да
                              </xsl:when>
                              <xsl:otherwise>
                                 Нет
                              </xsl:otherwise>
                           </xsl:choose>
                        </th>
                     </tr>
                  </xsl:for-each>
               </tbody>
               <tfoot>
                  <tr>
                     <td>Итого:</td>
                     <td colspan="7"><xsl:value-of select="count(element:businessEntityList/element:businessEntity)"/></td>
                  </tr>
               </tfoot>
            </table>
         </body>
      </html>
   </xsl:template>

   <!--Пункт №1 - объявляем именованный шаблон -->
   <xsl:template name="head">
      <head>
         <link rel="stylesheet" href="styles.css"/>
      </head>
   </xsl:template>
</xsl:stylesheet>
